package com.cagri.satelliteinterface.sat.connectat11.tm;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TM {
  private byte id;
  private byte length;
  private byte[] data;
}
