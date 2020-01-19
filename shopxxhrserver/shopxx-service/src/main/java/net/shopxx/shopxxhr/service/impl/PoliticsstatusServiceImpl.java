package net.shopxx.shopxxhr.service.impl;

import net.shopxx.shopxxhr.model.Politicsstatus;
import net.shopxx.shopxxhr.repository.PoliticsstatusRepository;
import net.shopxx.shopxxhr.service.PoliticsstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsstatusServiceImpl implements PoliticsstatusService {

    @Autowired
    PoliticsstatusRepository politicsstatusRepository;

    @Override
    public List<Politicsstatus> getAllPoliticsstatuses() {
        return politicsstatusRepository.findAll();
    }

}
