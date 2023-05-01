package com.cagri.satelliteinterface.sat;

import com.cagri.satelliteinterface.sat.connectat11.tc.TCDto;
import com.cagri.satelliteinterface.sat.connectat11.tm.TMDto;
import org.springframework.stereotype.Component;

@Component
public interface SatService {
  void receiveTCFromGround(String payload);

  void createBeaconMessage();

  void sendTMToGround(TMDto tmDto);
}
