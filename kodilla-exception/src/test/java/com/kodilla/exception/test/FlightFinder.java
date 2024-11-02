package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
public boolean findFlight(Flight flight) throws RouteNotFoundException{
    Map<String, Boolean> airports = new HashMap<>();
    airports.put("Wrocław",true);
    airports.put("Katowice",true);
    airports.put("Kraków",true);
    airports.put("Warszawa",false);
    airports.put("Gdańsk",false);
    airports.put("Radom",false);

    String arrivalAirport = flight.getArrivalAirport();

    if (!airports.containsKey(arrivalAirport)) {
        throw new RouteNotFoundException("Route to airport " + arrivalAirport + "not found.");
    }
    return airports.get(arrivalAirport);
    }
}
