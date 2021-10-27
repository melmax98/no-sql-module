package org.example.service;

import org.example.model.Event;
import org.example.model.Ticket;
import org.example.model.TicketCategory;
import org.example.model.User;

import java.util.List;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    Ticket bookTicket(String userId, String eventId, int place, TicketCategory category);

    List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);

    List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);

    boolean cancelTicket(String ticketId);

    Ticket getTicketById(String ticketId);

}
