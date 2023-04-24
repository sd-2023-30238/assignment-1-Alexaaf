package com.example.dreamcatch.factory;

import com.example.dreamcatch.service.DreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Component
public class ChartGenerator {

    @Autowired
    DreamService dreamService;
    public Chart generateChart(String channel){
        if (channel == null || channel.isEmpty())
            return null;
        switch (channel) {
            case "DURATION":
                return new DurationChart();
            case "ENERGY":
                return new EnergyChart();
            case "STRESS":
                return new StressChart();
            case "CATEGORY":
                return new CategoryChart();
            default:
                throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}
