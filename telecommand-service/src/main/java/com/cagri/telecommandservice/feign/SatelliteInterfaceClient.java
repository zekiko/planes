package com.cagri.telecommandservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(value = "${sat-service-name}")
// @LoadBalancerClient(name = "${tc-service-name}", configuration = LoadBalancerConfig.class)
public interface SatelliteInterfaceClient {
  @GetMapping("${sat-service-path}")
  String receiveTC(String payload);
}

