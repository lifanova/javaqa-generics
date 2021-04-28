package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository;


    @BeforeEach
    public void PrepareData() {
        repository = new TicketRepository();
    }

    @Test
    public void shouldSaveOneItem() {
        Ticket ticket = new Ticket(1,200, "MOV", "LED", 120);
        repository.save(ticket);

        Ticket[] expected = new Ticket[]{ticket};

        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Ticket ticket = new Ticket(1, 200, "MOV", "LED", 120);
        repository.save(ticket);

        assertEquals(ticket, repository.findById(ticket.getId()));
    }

    @Test
    public void shouldFindByNonExistingId() {
        Ticket ticket = new Ticket(1, 200, "MOV", "LED", 120);
        repository.save(ticket);

        assertNull(repository.findById(2));
    }

    @Test
    public void shouldRemoveById() {
        Ticket first = new Ticket(1, 200, "MOV", "LED", 120);
        Ticket second = new Ticket(2, 200, "MOV", "LED", 120);
        repository.save(first);
        repository.save(second);

        repository.removeById(second.getId());

        assertEquals(null, repository.findById(second.getId()));
    }
}
