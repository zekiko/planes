package com.cagri.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

public class Config {
  public RouteLocator routeLocator(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route(
            r ->
                r.path("/telemetry-service/v3/api-docs")
                    .and()
                    .method(HttpMethod.GET)
                    .uri("lb://telemetry-service"))
        .route(
            r ->
                r.path("/telecommand-service/v3/api-docs")
                    .and()
                    .method(HttpMethod.GET)
                    .uri("lb://telecommand-service"))
        .build();
  }
}
