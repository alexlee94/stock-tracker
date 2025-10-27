package com.alexlee.stock_tracker.service;

import com.alexlee.stock_tracker.client.StockClient;
import com.alexlee.stock_tracker.dto.AlphaVantageResponse;
import com.alexlee.stock_tracker.dto.StockOverviewResponse;
import com.alexlee.stock_tracker.dto.StockResponse;
import org.springframework.stereotype.Service;


@Service
public class StockService {

    private StockClient stockClient;

    public StockService(final StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public StockResponse getStockForSymbol(final String stockSymbol) {
        final AlphaVantageResponse response = stockClient.getStockQuote(stockSymbol);

        return StockResponse.builder()
                .symbol(response.globalQuote().symbol())
                .price(Double.parseDouble(response.globalQuote().price()))
                .lastUpdated(response.globalQuote().lastTradingDay())
                .build();
    }

    public StockOverviewResponse getStockOverviewForSymbol(final String symbol) {
        return stockClient.getStockOverview(symbol);

    }
}