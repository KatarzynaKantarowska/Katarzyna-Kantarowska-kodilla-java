package com.kodilla.patterns.en.hotel;

import java.math.BigDecimal;

public enum Season {
    LOW(new BigDecimal(250), new BigDecimal(350)),
    HIGH(new BigDecimal(320), new BigDecimal(400)),
    HOLIDAY(new BigDecimal(400), new BigDecimal(500));

    private BigDecimal singleBedPrice;
    private BigDecimal doubleBedPrice;
    Season(BigDecimal singleBedPrice, BigDecimal doubleBedPrice) {
        this.singleBedPrice = singleBedPrice;
        this.doubleBedPrice = doubleBedPrice;
    }

    public BigDecimal getSingleBedPrice() {
            return singleBedPrice;
        }
    public BigDecimal getDoubleBedPrice() {
        return doubleBedPrice;
    }
}
