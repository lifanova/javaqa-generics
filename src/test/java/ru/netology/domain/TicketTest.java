package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TicketTest {
    @Test
    public void shouldCompareTheSame(){
        Ticket ticket = new Ticket(1, 200, "MOV", "LED", 120);

        assertEquals(ticket, ticket);
    }

    @Test
    public void shouldCompareObjects() {
        Ticket first = new Ticket(1, 200, "MOV", "LED", 120);
        Ticket second = new Ticket(1, 200, "MOV", "LED", 120);

        assertEquals(first, second);
    }

    @Test
    public void shouldCompareObjectWithDifferentId() {
        Ticket first = new Ticket(1, 200, "MOV", "LED", 120);
        Ticket second = new Ticket(2, 200, "MOV", "LED", 120);

        assertNotEquals(first, second);
    }

    @Test
    public void shouldCompareObjectWithDifferentPrices() {
        Ticket first = new Ticket(1, 200, "MOV", "LED", 120);
        Ticket second = new Ticket(2, 300, "MOV", "LED", 150);

        assertNotEquals(first, second);
    }
}
