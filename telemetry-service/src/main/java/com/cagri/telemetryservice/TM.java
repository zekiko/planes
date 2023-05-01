package com.cagri.telemetryservice;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("telemetry")
@Builder
@Data
public class TM {
    private String payload;
}
