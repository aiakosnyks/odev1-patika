package com.patika.odev1.service;

import com.patika.odev1.model.Apartment;
import com.patika.odev1.model.House;
import com.patika.odev1.model.Summerhouse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationService {

    private final List<House> houseList;
    private final List<Apartment> apartmentList;
    private final List<Summerhouse> summerhouseList;

    public ApplicationService(Seed seed) {
        houseList = seed.getHouseList();
        summerhouseList = seed.getSummerhouseList();
        apartmentList = seed.getApartmentList();
    }

    public double getHouseAverageLotSize() {
        if (houseList.isEmpty()) {
            return 0;
        }
        return houseList.stream()
                .mapToDouble(House::getLotSize)
                .average()
                .orElse(0);
    }

    public double getApartmentAverageLotSize() {
        if (apartmentList.isEmpty()) {
            return 0;
        }
        return apartmentList.stream()
                .mapToDouble(Apartment::getLotSize)
                .average()
                .orElse(0);
    }

    public double getSummerhouseAverageLotSize() {
        if (summerhouseList.isEmpty()) {
            return 0;
        }
        return summerhouseList.stream()
                .mapToDouble(Summerhouse::getLotSize)
                .average()
                .orElse(0);
    }

    public double getHouseAllLotSize() {
        return houseList.stream()
                .mapToDouble(house -> house.getLotSize().doubleValue())
                .sum();
    }

    public double getApartmentAllLotSize() {
        return apartmentList.stream()
                .mapToDouble(apartment -> apartment.getLotSize().doubleValue())
                .sum();
    }

    public double getSummerhouseAllLotSize() {
        return summerhouseList.stream()
                .mapToDouble(summerhouse -> summerhouse.getLotSize().doubleValue())
                .sum();
    }

    public double getAllLotSize() {
        return getApartmentAllLotSize() + getSummerhouseAllLotSize() + getHouseAllLotSize();
    }

    public double getAllAverageLotSize() {
        return getAllLotSize() / (summerhouseList.size() + houseList.size() + apartmentList.size());
    }

    public BigDecimal getApartmentAllPrice() {
        return apartmentList.stream().map(Apartment::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getHouseAllPrice() {
        return houseList.stream().map(House::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSummerhouseAllPrice() {
        return summerhouseList.stream().map(Summerhouse::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getAllPrice() {
        return getApartmentAllPrice().add(getHouseAllPrice()).add(getSummerhouseAllPrice());
    }

    public BigDecimal getHouseAveragePrice() {
        if (houseList.isEmpty()) {
            return BigDecimal.ZERO;
        }

        return getHouseAllPrice().divide(BigDecimal.valueOf(houseList.size()), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getApartmentAveragePrice() {
        if (apartmentList.isEmpty()) {
            return BigDecimal.ZERO;
        }

       return getApartmentAllPrice().divide(BigDecimal.valueOf(houseList.size()), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getSummerhouseAveragePrice() {
        if (summerhouseList.isEmpty()) {
            return BigDecimal.ZERO;
        }


        return getSummerhouseAllPrice().divide(BigDecimal.valueOf(houseList.size()), 2, RoundingMode.HALF_UP);
    }


    public BigDecimal getAllAveragePrice() {
        return  getAllPrice().divide
                (new BigDecimal(
                houseList.size() + summerhouseList.size() + apartmentList.size()));

    }


    public List<Object> getPropertyByRoom(int bathroom, int bedroom) {
        List<Object> filteredPropertyList = new ArrayList<>();

        filteredPropertyList.addAll(houseList.stream()
                .filter(e -> e.getBathroom() == bathroom && e.getBedroom() == bedroom)
                .collect(Collectors.toList()));

        filteredPropertyList.addAll(apartmentList.stream()
                .filter(e -> e.getBathroom() == bathroom && e.getBedroom() == bedroom)
                .collect(Collectors.toList()));

        filteredPropertyList.addAll(summerhouseList.stream()
                .filter(e -> e.getBathroom() == bathroom && e.getBedroom() == bedroom)
                .collect(Collectors.toList()));

        return filteredPropertyList;
    }


    public void print() {
            System.out.println("Apartman toplam fiyat: " + getApartmentAllPrice() +
                    "\nVilla toplam fiyat: " + getHouseAllPrice() +
                    "\nYazlık toplam fiyat: " + getSummerhouseAllPrice() +
                    "\nTüm evler toplam fiyat: " + getAllPrice() +
                    "\nApartman ortalama boyut: " + getApartmentAverageLotSize() +
                    "\nVilla ortalama boyut: " + getHouseAverageLotSize() +
                    "\nYazlık ortalama boyut: " + getSummerhouseAverageLotSize() +
                    "\nTüm evler ortalama boyut: " + getAllAverageLotSize() +
                    "\nTüm evler toplam boyut: " + getAllLotSize() +
                    "\nEvleri oda sayısına göre filtrele: {3 banyo 2 yatak odası}" +
                    getPropertyByRoom(3, 2));
        }


}


