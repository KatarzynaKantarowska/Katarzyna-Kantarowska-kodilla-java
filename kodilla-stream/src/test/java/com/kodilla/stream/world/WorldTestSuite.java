package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

    World world = new World();

    @BeforeEach
          public void setUp(){
        world = new World();
    }
    Continent europe = new Continent();
    Continent asia = new Continent();


        @Test
    void testGetPeopleQuantity() {
        //Given
        europe.addCountry(new Country(new BigDecimal("40000000")));
        europe.addCountry(new Country(new BigDecimal("11000000")));
        europe.addCountry(new Country(new BigDecimal("49000000")));
        europe.addCountry(new Country(new BigDecimal("83000000")));
        europe.addCountry(new Country(new BigDecimal("68000000")));

        asia.addCountry(new Country(new BigDecimal("1400000000")));
        asia.addCountry(new Country(new BigDecimal("1400000000")));

        world.addContinent(europe);
        world.addContinent(asia);

        //When
        BigDecimal expectedWorldPopulation = new BigDecimal("3051000000");
        BigDecimal actualWorldPopulation = world.getPeopleQuantity();

        //Then
            Assertions.assertEquals(expectedWorldPopulation, actualWorldPopulation);
    }
}