package org.example.model.dto;

import lombok.Data;
import org.example.model.TicketCategory;
import org.springframework.data.annotation.Id;

@Data
public class CategoryPriceAggregation {

    @Id
    private TicketCategory ticketCategory;
    private Double totalPrice;
    private Integer quantity;
}
