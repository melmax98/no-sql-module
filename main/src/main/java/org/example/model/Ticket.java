package org.example.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType(propOrder = {"ticketId", "event", "user", "category", "placeNumber"})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1846226795597524566L;

    public Ticket(Event event, User user, TicketCategory category, int placeNumber) {
        this.event = event;
        this.user = user;
        this.category = category;
        this.placeNumber = placeNumber;
    }

    @Id
    private Long ticketId;

    private Event event;

    private User user;

    private TicketCategory category;

    private int placeNumber;

    @XmlElement(name = "ticketId")
    public Long getTicketId() {
        return ticketId;
    }

    @XmlElement(name = "event")
    public Event getEvent() {
        return event;
    }

    @XmlElement(name = "user")
    public User getUser() {
        return user;
    }

    public TicketCategory getCategory() {
        return category;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    @Override
    public String toString() {
        return "Ticket = " + ticketId +
                ", event = " + event +
                ", user = " + user +
                ", category = " + category +
                ", place = " + placeNumber;
    }
}
