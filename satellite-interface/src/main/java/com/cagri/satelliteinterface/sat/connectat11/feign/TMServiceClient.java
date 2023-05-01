package com.cagri.satelliteinterface.sat.connectat11.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "${tm-service-name}")
public interface TMServiceClient {
  @GetMapping("${tm-service-path}")
  String receive(String payload);
}