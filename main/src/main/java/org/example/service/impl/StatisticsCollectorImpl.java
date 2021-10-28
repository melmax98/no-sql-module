package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Statistics;
import org.example.model.Ticket;
import org.example.model.dto.CategoryPriceAggregation;
import org.example.service.StatisticsCollector;
import org.example.storage.repository.StatisticsRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Service
@RequiredArgsConstructor
public class StatisticsCollectorImpl implements StatisticsCollector {

    private final MongoTemplate mongoTemplate;
    private final StatisticsRepository statisticsRepository;

    @Override
    public Statistics collectStatistics() {
        GroupOperation groupByCategory = group("category")
                .count().as("quantity")
                .sum("event.ticketPrice").as("totalPrice");

        Aggregation aggregation = newAggregation(groupByCategory);

        List<CategoryPriceAggregation> aggregationResults = mongoTemplate
                .aggregate(aggregation,
                        Ticket.class.getSimpleName().toLowerCase(),
                        CategoryPriceAggregation.class
                )
                .getMappedResults();

        Statistics statistics = new Statistics();
        statistics.setStatisticsByCategory(aggregationResults);

        return statisticsRepository.save(statistics);
    }
}
