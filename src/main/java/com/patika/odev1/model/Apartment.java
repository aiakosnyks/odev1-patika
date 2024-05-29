package com.patika.odev1.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Apartment extends Property {
    public Apartment(int id, String title, int bathroom, int bedroom, int lotSize, BigDecimal price) {
        super(id, title, bathroom, bedroom, lotSize, price);
    }


}
