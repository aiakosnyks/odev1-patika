package com.patika.odev1.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class House extends Property {
    public House(int id, String title, int bathroom, int bedroom, Integer lotSize, BigDecimal price) {
        super(id, title, bathroom, bedroom, lotSize, price);
    }
}
