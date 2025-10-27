package com.alexlee.stock_tracker.dto;

import lombok.Builder;
import org.apache.tomcat.util.json.JSONParser;

@Builder
public record StockResponse(
        String symbol,
        double price,
        String lastUpdated
) {}
