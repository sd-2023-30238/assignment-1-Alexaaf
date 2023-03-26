package com.example.dreamcatch.factory;

public class ChartGenerator {
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
            default:
                throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}
