package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.TicketCategory;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType(propOrder = {"ticketId", "event", "user", "category", "placeNumber"})
@Entity
@Table(name = "ticket")
public class TicketSQL implements Serializable {

    private static final long serialVersionUID = 1846226795597524566L;

    public TicketSQL(EventSQL event, UserSQL user, TicketCategory category, int placeNumber) {
        this.event = event;
        this.user = user;
        this.category = category;
        this.placeNumber = placeNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @OneToOne
    @JoinColumn(name = "event_id")
    private EventSQL event;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserSQL user;

    @Enumerated(EnumType.STRING)
    private TicketCategory category;

    private int placeNumber;

    @XmlElement(name = "ticketId")
    public Long getTicketId() {
        return ticketId;
    }

    @XmlElement(name = "event")
    public EventSQL getEvent() {
        return event;
    }

    @XmlElement(name = "user")
    public UserSQL getUser() {
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
