package com.cagri.telecommandservice.enums;

import lombok.Getter;

@Getter
public enum TCId {
  Ping("0xAA"),
  Loopback("0xCC");

  private String id;

  TCId(String id) {
    this.id = id;
  }
}
