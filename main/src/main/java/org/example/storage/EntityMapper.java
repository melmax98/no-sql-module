package org.example.storage;

import org.example.model.Event;
import org.example.model.Ticket;
import org.example.model.User;
import org.example.model.UserAccount;
import org.example.model.dto.EventSQL;
import org.example.model.dto.TicketSQL;
import org.example.model.dto.UserAccountSQL;
import org.example.model.dto.UserSQL;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public Event map(EventSQL eventSQL) {
        return new Event(eventSQL.getTitle(), eventSQL.getDate(), eventSQL.getTicketPrice());
    }

    public User map(UserSQL userSQL) {
        return new User(userSQL.getName(), userSQL.getEmail());
    }

    public UserAccount map(UserAccountSQL userAccountSQL) {
        return new UserAccount(map(userAccountSQL.getUser()), userAccountSQL.getBalance());
    }

    public Ticket map(TicketSQL ticketSQL) {
        return new Ticket(
                map(ticketSQL.getEvent()),
                map(ticketSQL.getUser()),
                ticketSQL.getCategory(),
                ticketSQL.getPlaceNumber()
        );
    }
}
