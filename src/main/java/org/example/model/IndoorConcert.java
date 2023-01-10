package org.example.model;

import java.math.BigDecimal;
import java.util.List;

public class IndoorConcert extends Concert{
    private static final int INDOOR_CAPACITY = 3000;
    private static final double INDOOR_DURATION = 1.5;
    private static final BigDecimal INDOOR_BEER_PRICE = BigDecimal.valueOf(600);
    public IndoorConcert(Band mainBand, List<Band> warmupBands, BigDecimal ticketPrice) {
        super(mainBand, warmupBands, INDOOR_CAPACITY, INDOOR_DURATION, ticketPrice, INDOOR_BEER_PRICE);
    }
}
