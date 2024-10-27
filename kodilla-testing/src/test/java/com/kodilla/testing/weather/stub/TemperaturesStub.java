package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperatures {
    @Override
    public Map<String, Double> getTemperatures() {
        Map<String, Double> stubResult = new HashMap<>();

        stubResult.put("Rzeszów",25.5);
        stubResult.put("Wrocław",26.5);
        stubResult.put("Smolec",24.8);
        stubResult.put("Tychy",23.5);
        stubResult.put("Katowice",22.9);

        return stubResult;
    }
}
