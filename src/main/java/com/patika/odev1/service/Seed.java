package com.patika.odev1.service;

import com.patika.odev1.model.Apartment;
import com.patika.odev1.model.House;
import com.patika.odev1.model.Summerhouse;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Seed {
        List<Apartment> apartments = Arrays.asList(
                new Apartment(1, "Ev 1", 2, 1, 100, new BigDecimal(500000)),
                new Apartment(2, "Ev 2", 3, 1, 120, new BigDecimal(700000)),
                new Apartment(3, "Ev 3", 4, 1, 150, new BigDecimal(1000000))
        );
       List<Summerhouse> summerhouses = Arrays.asList(
                new Summerhouse(7, "Ev 7", 2, 1, 100, new BigDecimal(500000)),
                new Summerhouse(8, "Ev 8", 3, 1, 120, new BigDecimal(700000)),
                new Summerhouse(9, "Ev 9", 4, 1, 150, new BigDecimal(1000000))
        );
        List<House> houses = Arrays.asList(
                new House(4, "Ev 4", 2, 1, 100, new BigDecimal(500000)),
                new House(5, "Ev 5", 3, 1, 120, new BigDecimal(700000)),
                new House(6, "Ev 6", 4, 1, 150, new BigDecimal(1000000))
        );

    public List<Apartment> getApartmentList() {
        return apartments;
    }

    public List<House> getHouseList() {
        return houses;
    }

    public List<Summerhouse> getSummerhouseList() {
        return summerhouses;
    }
}
