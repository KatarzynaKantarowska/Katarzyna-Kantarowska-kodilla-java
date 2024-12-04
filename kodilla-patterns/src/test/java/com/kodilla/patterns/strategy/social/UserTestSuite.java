package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies(){

        //Given
        User john = new Millenials("John");
        User mary = new YGeneration("Mary");
        User kate = new ZGeneration("Kate");

        //When
        String johnShares = john.sharePost();
        String maryShares = mary.sharePost();
        String kateShares = kate.sharePost();

        //Then
        Assertions.assertEquals("Sharing post on Facebook", johnShares);
        Assertions.assertEquals("Sharing post on Twitter", maryShares);
        Assertions.assertEquals("Sharing post on Snapchat", kateShares);
    }

    @Test
    void testIndividualSharingStrategy(){
        //Given
        User john = new Millenials("John");

        //When
        String johnShares = john.sharePost();
        john.setSocialPublisher(new TwitterPublisher());
        String johnSharesAfterChange = john.sharePost();

        //Then
        Assertions.assertEquals("Sharing post on Facebook", johnShares);
        Assertions.assertEquals("Sharing post on Twitter", johnSharesAfterChange);
    }
}
