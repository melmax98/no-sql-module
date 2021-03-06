package org.example.storage.repository;

import org.example.model.Event;
import org.example.model.Ticket;
import org.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    Page<Ticket> findByUser(User user, Pageable pageable);

    Page<Ticket> findByEvent(Event event, Pageable pageable);
}
