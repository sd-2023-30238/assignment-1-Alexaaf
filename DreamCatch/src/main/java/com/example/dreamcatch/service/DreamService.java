package com.example.dreamcatch.service;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.repository.DreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DreamService {
    @Autowired
    DreamRepository dreamRepository;
    public List<Dream> findAll(){return dreamRepository.findAll();}
    public Dream saveDream(Dream dream){return  dreamRepository.save(dream);}

    public List<Dream> findDreamsByDateAfterAndUser_id(Date s, int id) {
        return dreamRepository.findDreamsByDateAfterAndUid(s,id);
    }
}
