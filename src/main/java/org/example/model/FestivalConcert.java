package org.example.model;

import java.math.BigDecimal;
import java.util.List;

public class FestivalConcert extends Concert{
    private static final int FESTIVAL_CAPACITY = 8000;
    private static final double FESTIVAL_DURATION = 6.0;
    private static final BigDecimal FESTIVAL_BEER_PRICE = BigDecimal.valueOf(1000);
    public FestivalConcert(Band mainBand, List<Band> warmupBands, BigDecimal ticketPrice) {
        super(mainBand, warmupBands, FESTIVAL_CAPACITY, FESTIVAL_DURATION, ticketPrice, FESTIVAL_BEER_PRICE);
    }
}
