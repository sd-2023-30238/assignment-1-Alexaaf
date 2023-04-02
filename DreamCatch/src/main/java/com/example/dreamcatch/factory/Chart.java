package com.example.dreamcatch.factory;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;

import java.util.List;

public interface Chart {
    List<Results> generate(DreamService service, int userId);
}
