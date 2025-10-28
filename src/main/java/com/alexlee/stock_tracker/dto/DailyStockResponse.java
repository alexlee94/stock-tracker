package com.alexlee.stock_tracker.dto;

public record DailyStockResponse(
        String data,
        double open,
        double close,
        double high,
        double low,
        long volume
) {
}
