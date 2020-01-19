package net.shopxx.shopxxhr.service.impl;

import net.shopxx.shopxxhr.model.Nation;
import net.shopxx.shopxxhr.repository.NationRepository;
import net.shopxx.shopxxhr.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {

    @Autowired
    NationRepository nationRepository;

    @Override
    public List<Nation> getAllNations() {
        return nationRepository.findAll();
    }

}
