package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    /* Стоимость билета */
    private int price;
    /* Аэропорт вылета (IATA-код) */
    private String from;
    /* Аэропорт прилета (IATA-код) */
    private String to;
    /* Время в пути */
    private int duration;

    public Ticket() {
    }

    public Ticket(int id, int price, String from, String to, int duration) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                price == ticket.price &&
                duration == ticket.duration &&
                Objects.equals(from, ticket.from) &&
                Objects.equals(to, ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, from, to, duration);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }
}
