package org.example.model;

import java.math.BigDecimal;
import java.util.List;

public class OutdoorConcert extends Concert{
    private static final int OUTDOOR_CAPACITY = 5000;
    private static final double OUTDOOR_DURATION = 2.0;
    private static final BigDecimal OUTDOOR_BEER_PRICE = BigDecimal.valueOf(800);
    public OutdoorConcert(Band mainBand, List<Band> warmupBands, BigDecimal ticketPrice) {
        super(mainBand, warmupBands, OUTDOOR_CAPACITY, OUTDOOR_DURATION, ticketPrice, OUTDOOR_BEER_PRICE);
    }
}
