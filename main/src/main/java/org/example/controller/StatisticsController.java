package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Statistics;
import org.example.service.StatisticsCollector;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsCollector statisticsCollector;

    @PostMapping
    public Statistics collectStatistics() {
        return statisticsCollector.collectStatistics();
    }
}
