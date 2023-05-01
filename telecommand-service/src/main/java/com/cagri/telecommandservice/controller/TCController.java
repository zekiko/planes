package com.cagri.telecommandservice.controller;

import com.cagri.telecommandservice.feign.SatelliteInterfaceClient;
import com.cagri.telecommandservice.model.TC;
import com.cagri.telecommandservice.service.TCService;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tc")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
public class TCController {
  private final Environment environment;
  private final SatelliteInterfaceClient satelliteInterfaceClient;
  private final TCService tcService;

  @Hidden
  @GetMapping("/test")
  public String test() {
    String serverPort = environment.getProperty("local.server.port");
    log.info("serverPort {} ", serverPort);
    return "hello from test tc, port: " + serverPort;
  }

  @PostMapping("/send-tc")
  public ResponseEntity<String> sendTC(@RequestBody String payload) {
    String serverPort = environment.getProperty("local.server.port");
    log.info("serverPort {} ", serverPort);
    try {
      tcService.save(TC.builder().payload(payload).build());
      satelliteInterfaceClient.receiveTC(payload);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/telecommands")
  public ResponseEntity<List<TC>> getAllTCs() {
    String serverPort = environment.getProperty("local.server.port");
    log.info("serverPort {} ", serverPort);
    List<TC> tcs = tcService.fetchAllTCs();
    return new ResponseEntity<>(tcs, HttpStatus.OK);
  }
}
