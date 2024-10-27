package com.kodilla.testing.weather.stub;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecast {
    private final Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1);
        }
        return resultMap;
    }

    public double getAverageTemperature() {
        Collection<Double> values = temperatures.getTemperatures().values();
        Double sum = 0.0;
        for (Double temperature : values) {
            sum += temperature;
        }
        return sum / values.size();
    }

    public double getMedianTemperature() {
        Collection<Double> values = temperatures.getTemperatures().values();
        List<Double> sorted = values.stream().sorted().toList();
        return calculateMedian(sorted);
    }

    public static double calculateMedian(List<Double> list) {
        int n = list.size();
        if (n % 2 == 1) {
            return list.get(n / 2);
        } else {
            return ((list.get(n / 2 - 1) + list.get(n / 2)) / 2);
        }
    }
}
