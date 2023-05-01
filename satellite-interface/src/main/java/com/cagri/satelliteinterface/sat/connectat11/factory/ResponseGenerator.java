package com.cagri.satelliteinterface.sat.connectat11.factory;

import com.cagri.satelliteinterface.sat.connectat11.tc.TC;
import com.cagri.satelliteinterface.sat.connectat11.tm.TMDto;

public interface ResponseGenerator {
  TMDto generateResponse(TC tc);

  boolean supports(TC tc);

}
