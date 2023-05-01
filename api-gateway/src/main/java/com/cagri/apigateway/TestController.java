package com.cagri.apigateway;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @Hidden
  @GetMapping("/test")
  public String test() {
        return "test";
    }
}
