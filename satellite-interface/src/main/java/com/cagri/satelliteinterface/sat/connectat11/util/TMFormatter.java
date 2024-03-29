package com.cagri.satelliteinterface.sat.connectat11.util;

import com.cagri.satelliteinterface.sat.connectat11.tm.TM;
import org.springframework.stereotype.Component;

@Component
public class TMFormatter {
  public String formatPayload(TM tm) {
    String payload =
        "0x" + String.format("%02X", tm.getId()) + " – 0x" + String.format("%02X", tm.getLength());

    for (byte b : tm.getData()) {
      payload += " – 0x" + String.format("%02X", b);
    }
    return payload;
  }
}
