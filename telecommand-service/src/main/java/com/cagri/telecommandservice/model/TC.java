package com.cagri.telecommandservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("telecommand")
@Builder
@Data
public class TC {
    private String payload;

}
