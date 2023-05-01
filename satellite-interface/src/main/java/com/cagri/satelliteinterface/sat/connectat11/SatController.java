package com.cagri.satelliteinterface.sat.connectat11;

import com.cagri.satelliteinterface.sat.SatService;
import com.cagri.satelliteinterface.sat.connectat11.tc.TCDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sat")
@RequiredArgsConstructor
public class SatController {
  private final SatService satService;

  @PostMapping("/receive-tc")
  public void receiveTC(@RequestBody String payload) {
    satService.receiveTCFromGround(payload);
  }
}
