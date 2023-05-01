package com.cagri.satelliteinterface.sat.connectat11.tc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TC {
  private byte id; // signed 256 bit
  private byte length; // signed 256 bit
  private byte[] data;

  public TC(String bytesStr) {
    init(bytesStr);
  }

  private void init(String input) {
    //String input = "0xCC – 0x04 – 0x01 – 0x02 – 0x03 – 0x04";
    String[] hexValues = input.split(" - ");
    byte[] bytes = new byte[hexValues.length];
    for (int i = 0; i < hexValues.length; i++) {
      bytes[i] = (byte) Integer.parseInt(hexValues[i].substring(2), 16);
    }

    System.out.println(1);

    //byte[] payloadBytes = bytes.getBytes(StandardCharsets.ISO_8859_1);
    id = bytes[0];
    length = (bytes[1]);
    data = new byte[length];
    System.arraycopy(bytes, 2, data, 0, length);
  }

  public byte getId() {
    return id;
  }

  public byte getLength() {
    return length;
  }

  public byte[] getData() {
    return data;
  }
}
