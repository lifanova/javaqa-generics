package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketComparator;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {
    TicketRepository repository;
    TicketManager manager;
    Ticket[] tickets;

    @BeforeEach
    public void PrepareData() {
        repository = new TicketRepository();
        manager = new TicketManager(repository);
    }

    @Test
    public void shouldSetRepository() {
        manager.setRepository(repository);

        assertNotNull(manager.getRepository());
    }

    @Test
    public void shouldAddTicket() {
        Ticket ticket = new Ticket(1, 200, "MOV", "LED", 120);
        manager.addTicket(ticket);

        assertEquals(ticket, manager.getRepository().findById(ticket.getId()));
    }

    @Test
    public void shouldSearchTwoTickets() {
        String from = "MOV";
        String to = "LED";

        tickets = new Ticket[5];
        tickets[0] = new Ticket(1, 3000, "MOV", "LED", 120);
        tickets[1] = new Ticket(2, 1200, "MOV", "GOJ", 90);
        tickets[2] = new Ticket(3, 1500, "MOV", "KUF", 100);
        tickets[3] = new Ticket(4, 4000, "MOV", "OGZ", 130);
        tickets[4] = new Ticket(5, 2000, "MOV", "LED", 120);


        Ticket[] expected = {tickets[4], tickets[0]};

        manager.addTicket(tickets[0]);
        manager.addTicket(tickets[1]);
        manager.addTicket(tickets[2]);
        manager.addTicket(tickets[3]);
        manager.addTicket(tickets[4]);

        Ticket[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortTickets() {
        String from = "MOV";
        String to = "LED";

        tickets = new Ticket[5];
        tickets[0] = new Ticket(1, 3000, "MOV", "LED", 120);
        tickets[1] = new Ticket(2, 1200, "MOV", "LED", 90);
        tickets[2] = new Ticket(3, 1500, "MOV", "LED", 100);
        tickets[3] = new Ticket(4, 4000, "MOV", "LED", 130);
        tickets[4] = new Ticket(5, 2000, "MOV", "LED", 120);


        Ticket[] expected = {tickets[1], tickets[2], tickets[4], tickets[0], tickets[3]};

        manager.addTicket(tickets[0]);
        manager.addTicket(tickets[1]);
        manager.addTicket(tickets[2]);
        manager.addTicket(tickets[3]);
        manager.addTicket(tickets[4]);

        Ticket[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithNullFromParam() {
        String from = null;
        String to = "LED";
        Ticket ticket = new Ticket(1, 200, "MOV", "LED", 120);
        manager.addTicket(ticket);
        Ticket[] expected = {};

        Ticket[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithNullToParam() {
        String from = "LED";
        String to = null;
        Ticket ticket = new Ticket(1, 200, "MOV", "LED", 120);
        manager.addTicket(ticket);
        Ticket[] expected = {};

        Ticket[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    /**
     * Поиск по параметрам и сортировка по времени полета
     */
    @Test
    public void shouldSortTicketsByDuration() {
        String from = "MOV";
        String to = "LED";

        tickets = new Ticket[5];
        tickets[0] = new Ticket(1, 3000, "MOV", "LED", 120);
        tickets[1] = new Ticket(2, 1200, "MOV", "LED", 90);
        tickets[2] = new Ticket(3, 1500, "MOV", "LED", 100);
        tickets[3] = new Ticket(4, 4000, "MOV", "LED", 130);
        tickets[4] = new Ticket(5, 2000, "MOV", "LED", 125);


        Ticket[] expected = {tickets[1], tickets[2], tickets[0], tickets[4], tickets[3]};

        manager.addTicket(tickets[0]);
        manager.addTicket(tickets[1]);
        manager.addTicket(tickets[2]);
        manager.addTicket(tickets[3]);
        manager.addTicket(tickets[4]);

        Ticket[] actual = manager.findAll(from, to, new TicketComparator());

        assertArrayEquals(expected, actual);
    }


}
