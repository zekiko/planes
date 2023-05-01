package com.cagri.satelliteinterface.sat.connectat11;

import com.cagri.satelliteinterface.sat.SatService;
import com.cagri.satelliteinterface.sat.connectat11.factory.StrategyFactory;
import com.cagri.satelliteinterface.sat.connectat11.feign.TMServiceClient;
import com.cagri.satelliteinterface.sat.connectat11.tc.TC;
import com.cagri.satelliteinterface.sat.connectat11.tm.ConnectaT11BeaconTM;
import com.cagri.satelliteinterface.sat.connectat11.tm.TMDto;
import com.cagri.satelliteinterface.sat.connectat11.util.TMFormatter;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConnectaT11Service implements SatService {
  private final StrategyFactory strategyFactory;
  private final TMServiceClient tmServiceClient;

  private final TMFormatter tmFormatter;
  private static final long BEACON_DELAY = 30000;
  private static final long CONNECTION_OPEN_DELAY = 60000;

  private List<ConnectaT11BeaconTM> beacons = new ArrayList<>();

  @Override
  @Scheduled(fixedDelay = BEACON_DELAY)
  public void createBeaconMessage() {
    ConnectaT11BeaconTM beacon =
        ConnectaT11BeaconTM.builder()
            .uptimeInSeconds(100)
            .batterVoltage(50)
            .temperature(0)
            .totalTxMessageCount(20)
            .totalRXMessageCount(21)
            .build();
    beacons.add(beacon);

    log.info(beacon.toString());
    log.info(beacons.toString());
  }

  @Scheduled(fixedDelay = CONNECTION_OPEN_DELAY)
  public void sendBeaconMessages() {
    log.info("girdi");
    // send beacon to tm service here
    beacons.forEach(
        b -> {
          tmServiceClient.receive(b.toString());
        });
    beacons.clear(); // clear beacon list after sent
  }

  @Override
  public void sendTMToGround(TMDto tmDto) {
    tmServiceClient.receive(tmDto.getPayload());
  }

  public void receiveTCFromGround(String payload) {
    TC tc = new TC(payload);
    TMDto tmDto = strategyFactory.generateResponse(tc);
    sendTMToGround(tmDto);
  }
}
