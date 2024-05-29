package com.patika.odev1.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Summerhouse extends Property{
    public Summerhouse(int id, String title, int bathroom, int bedroom, Integer lotSize, BigDecimal price) {
        super(id, title, bathroom, bedroom, lotSize, price);
    }
}
