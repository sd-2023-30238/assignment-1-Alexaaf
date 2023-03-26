package com.example.dreamcatch.factory;

import com.example.dreamcatch.service.DreamService;

import java.util.List;

public interface Chart {
    List<Integer> generate(DreamService service);
}
