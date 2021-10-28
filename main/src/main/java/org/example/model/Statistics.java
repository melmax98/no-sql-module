package org.example.model;

import lombok.Data;
import org.example.model.dto.CategoryPriceAggregation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "statistics")
public class Statistics {
    @Id
    private String id;
    private List<CategoryPriceAggregation> statisticsByCategory;
    private Date timestamp;

    public Statistics() {
        this.timestamp = new Date();
    }
}
