package com.kodilla.stream.sand;

import java.math.BigDecimal;

public class Europe implements SandStorage{
    @Override
    public BigDecimal getSandBeansQuantity() {
            BigDecimal sandBeansQuantity = new BigDecimal("12345678901234567890");
            return sandBeansQuantity;
    }
}
