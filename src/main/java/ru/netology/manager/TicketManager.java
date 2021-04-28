package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void addTicket(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];

        if (from == null || from.isEmpty()) {
            System.out.println("[findAll]: Error: 'from' parameter is empty!");
            return result;
        }

        if (to == null || to.isEmpty()) {
            System.out.println("[findAll]: Error: 'to' parameter is empty!");
            return result;
        }

        for (Ticket ticket : repository.findAll()) {
            if (from.equalsIgnoreCase(ticket.getFrom()) &&
                    to.equalsIgnoreCase(ticket.getTo())) {
                //Нашли билет по запросу - добавляем в массив результатов
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }

        Arrays.sort(result);

        return result;
    }


    public TicketRepository getRepository() {
        return repository;
    }

    public void setRepository(TicketRepository repository) {
        this.repository = repository;
    }
}
