package com.example.dreamcatch.factory;

import com.example.dreamcatch.service.DreamService;
import com.example.dreamcatch.strategy.ChartStrategy;

import java.text.ParseException;
import java.util.List;


public interface Chart {
    public ChartStrategy getStrategy();
    public void setStrategy(ChartStrategy strategy);
    List<Results> generate(DreamService service) throws ParseException;
}
