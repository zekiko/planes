package com.cagri.telemetryservice.controller;

import com.cagri.telemetryservice.TM;
import com.cagri.telemetryservice.TMService;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tm")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TMController {
  private final TMService tmService;

  @Hidden
  @PostMapping("/receive")
  public void receive(@RequestBody String payload) {
    tmService.save(TM.builder().payload(payload).build());
  }

  @GetMapping("/telemetries")
  public ResponseEntity<List<TM>> getAllTelemtries() {
    List<TM> tms = tmService.fetchAllTelemtries();
    return new ResponseEntity<>(tms, HttpStatus.OK);
  }
}
