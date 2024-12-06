package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigmacTestSuite {
    @Test
    void testBigmacNew() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun("with seaseam")
                .sauce("standard")
                .burgersAmount(3)
                .ingredient("letuce")
                .ingredient("cucumber")
                .ingredient("onion")
                .ingredient("prawns")
                .ingredient("mushrooms")
                .ingredient("chilli peppers")
                .ingredient("cheese")
                .build();
        System.out.println(bigMac);
        //When
        int howManyIngredients = bigMac.getIngredients().size();

        //Then
        Assertions.assertEquals(howManyIngredients, 7);
    }
}
