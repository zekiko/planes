package com.cagri.telecommandservice.service;

import com.cagri.telecommandservice.enums.TCId;
import com.cagri.telecommandservice.model.TC;
import com.cagri.telecommandservice.repository.TCRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TCService {
  private final TCRepository tcRepository;

  public void save(TC tc) throws Exception {
    boolean validated = validate(tc);
    if (!validated) throw new Exception("Bad format for TC, try something like: 0xAA or 0xCC ");
    tcRepository.save(tc);
  }

  public List<TC> fetchAllTCs() {
    List<TC> all = tcRepository.findAll();
    return all;
  }

  private boolean validate(TC tc) {
    if (tc.getPayload().startsWith(TCId.Ping.getId())) return true;
    if (tc.getPayload().startsWith(TCId.Loopback.getId())) return true;

    return false;
  }
}
