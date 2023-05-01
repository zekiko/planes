package com.cagri.telemetryservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;import java.util.List;

@Service
@RequiredArgsConstructor
public class TMService {
    private final TMRepository tmRepository;
    public void save(TM tm){
        tmRepository.save(tm);
    }

  public List<TM> fetchAllTelemtries() {
        List<TM> all = tmRepository.findAll();
        return all;
    }
}
