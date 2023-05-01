package com.cagri.satelliteinterface.sat.connectat11.factory;

import com.cagri.satelliteinterface.sat.connectat11.tc.TC;
import com.cagri.satelliteinterface.sat.connectat11.tm.TM;
import com.cagri.satelliteinterface.sat.connectat11.tm.TMDto;
import com.cagri.satelliteinterface.sat.connectat11.util.TMFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoopbackResponseGenerator implements ResponseGenerator {
  private final TMFormatter tmFormatter;

  @Override
  public TMDto generateResponse(TC tc) {
    byte id = -35; // 0xDD
    TM tm = TM.builder().id(id).length(tc.getLength()).data(tc.getData()).build();

    String payload = tmFormatter.formatPayload(tm);
    TMDto tmDto = TMDto.builder().payload(payload).build();
    //satService.sendTMToGround(tmDto);
    return tmDto;
  }

  @Override
  public boolean supports(TC tc) {
    return tc.getId() == -52; // 0xCC
  }
}
