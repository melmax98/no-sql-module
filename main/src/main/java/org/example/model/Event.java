package org.example.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.util.DateUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@XmlType(propOrder = {"eventId", "title", "date", "ticketPrice"})
@EqualsAndHashCode
@Document(collection = "event")
public class Event implements Serializable {

    private static final long serialVersionUID = -1409930502963795321L;

    public Event(String title, Date date, double ticketPrice) {
        this.title = title;
        this.date = date;
        this.ticketPrice = ticketPrice;
    }

    @Id
    private String eventId;
    private String title;
    private Date date;
    private Double ticketPrice;

    @Override
    public String toString() {
        return eventId + " " + title + " " + DateUtils.getInstance().getSimpleDateFormat().format(date);
    }
}
