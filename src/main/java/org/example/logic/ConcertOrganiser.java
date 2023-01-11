package org.example.logic;

import org.example.model.Concert;

import java.math.BigDecimal;
import java.util.Set;

public class ConcertOrganiser {
    private static final double TICKET_PROFIT_PERCENT = 0.4;
    private Set<Concert> concertSet;

    public ConcertOrganiser(Set<Concert> concertSet) {
        this.concertSet = concertSet;
    }

    public void addConcert(Concert concert) {
        concertSet.add(concert);
    }

    public BigDecimal calculateProfit() {
        BigDecimal ticketProfit = concertSet
                .stream()
                .map(Concert::calculateTicketIncome)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .multiply(BigDecimal.valueOf(TICKET_PROFIT_PERCENT));
        BigDecimal beerProfit = concertSet
                .stream()
                .map(Concert::calculateBeerIncome)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        return ticketProfit.add(beerProfit);
    }
}
