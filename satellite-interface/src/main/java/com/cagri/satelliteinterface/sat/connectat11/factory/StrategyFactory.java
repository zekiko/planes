package com.cagri.satelliteinterface.sat.connectat11.factory;

import com.cagri.satelliteinterface.sat.connectat11.tc.TC;
import com.cagri.satelliteinterface.sat.connectat11.tm.TMDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StrategyFactory {
  @Autowired private List<ResponseGenerator> responseGenerators;

  public TMDto generateResponse(TC tc) {
        for (ResponseGenerator responseGenerator : responseGenerators) {
            if (responseGenerator.supports(tc)) {
                return responseGenerator.generateResponse(tc);
            }
        }
        return null;
    }
}
