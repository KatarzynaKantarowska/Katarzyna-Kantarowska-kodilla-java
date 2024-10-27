package com.kodilla.testing.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.TemperaturesStub;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static Temperatures temperaturesMock;

    private static WeatherForecast weatherForecast;

    @BeforeAll
    static void beforeAll() {
        //Given
        temperaturesMock = Mockito.mock(Temperatures.class);
        TemperaturesStub temperaturesStub = new TemperaturesStub();
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesStub.getTemperatures());
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateForecastWithMock() {
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    public void testCalculateAverageTemperature() {
        double averageTemperature = weatherForecast.getAverageTemperature();
        double roundedValue = Math.round(averageTemperature * 100.0) / 100.0;
        Assertions.assertEquals(24.64, roundedValue);

    }

    @Test
    public void testCalculateMedianTemperature() {
        double medianTemperature = weatherForecast.getMedianTemperature();

        Assertions.assertEquals(24.8, medianTemperature);
    }
}
