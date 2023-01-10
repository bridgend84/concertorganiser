package org.example.logic;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ConcertOrganiserTest {
    IndoorConcert indoorConcert = new IndoorConcert(
            new Band("Metallica", Style.ROCK),
            List.of(new Band("Iron Maiden", Style.ROCK)),
            BigDecimal.valueOf(10000));
    OutdoorConcert outdoorConcert = new OutdoorConcert(
            new Band("Backstreet Boys", Style.POP),
            List.of(new Band("N'Sync", Style.POP)),
            BigDecimal.valueOf(15000));
    FestivalConcert festivalConcert = new FestivalConcert(
            new Band("Jean-Luc Ponty", Style.JAZZ),
            List.of(new Band("Herbie Hancock", Style.JAZZ)),
            BigDecimal.valueOf(20000));
    @Test
    void calculateProfit() {
        indoorConcert.sellTickets(4000);
        outdoorConcert.sellTickets(3000);
        festivalConcert.sellTickets(3000);
        ConcertOrganiser concertOrganiser = new ConcertOrganiser(Set.of(indoorConcert, outdoorConcert, festivalConcert));
        BigDecimal ticketIncome = BigDecimal.valueOf(3000).multiply(BigDecimal.valueOf(45000).multiply(BigDecimal.valueOf(0.4)));
        BigDecimal beerForOneIndoor = BigDecimal.valueOf(3).multiply(BigDecimal.valueOf(600));
        BigDecimal beerForOneOutDoor = BigDecimal.valueOf(4).multiply(BigDecimal.valueOf(800));
        BigDecimal beerForOneFestival = BigDecimal.valueOf(12).multiply(BigDecimal.valueOf(1000));
        BigDecimal beerIncome = BigDecimal.valueOf(3000).multiply(beerForOneIndoor.add(beerForOneOutDoor).add(beerForOneFestival));
        // I don't want to use BigDecimal on PA :)
        assertEquals(ticketIncome.add(beerIncome), concertOrganiser.calculateProfit());
    }
}