package org.example.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public abstract class Concert {
    private Band mainBand;
    private List<Band> warmupBands;
    private int capacity;
    private int soldTickets;
    private double durationHours;
    private BigDecimal ticketPrice;
    private BigDecimal beerPrice;

    public Concert(Band mainBand, List<Band> warmupBands, int capacity, double durationHours, BigDecimal ticketPrice, BigDecimal beerPrice) {
        this.mainBand = mainBand;
        this.warmupBands = warmupBands;
        this.capacity = capacity;
        this.soldTickets = 0;
        this.durationHours = durationHours;
        this.ticketPrice = ticketPrice;
        this.beerPrice = beerPrice;
    }

    public void addBand(Band band) {
        warmupBands.add(band);
        // there is no implementation for warmup band style match
    }

    public void sellTickets(int soldTickets) {
        if (this.soldTickets + soldTickets > capacity) {
            this.soldTickets = capacity;
        } else {
            this.soldTickets += soldTickets;
        }
    }

    public BigDecimal calculateTicketIncome() {
        return ticketPrice.multiply(BigDecimal.valueOf(soldTickets));
    }

    public BigDecimal calculateBeerIncome() {
        BigDecimal incomePerSoldTicket = beerPrice.multiply(BigDecimal.valueOf(durationHours / 0.5));
        return incomePerSoldTicket.multiply(BigDecimal.valueOf(soldTickets));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return capacity == concert.capacity && Double.compare(concert.durationHours, durationHours) == 0 && Objects.equals(mainBand, concert.mainBand) && Objects.equals(warmupBands, concert.warmupBands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainBand, warmupBands, capacity, durationHours);
    }
}
