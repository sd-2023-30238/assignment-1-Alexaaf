package com.example.dreamcatch.strategy;

import com.example.dreamcatch.model.Dream;
import com.example.dreamcatch.service.DreamService;

import java.util.List;

public interface ChartStrategy {
    List<Dream> getData(DreamService service);
}
