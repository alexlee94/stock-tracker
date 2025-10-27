package com.alexlee.stock_tracker.service;

import com.alexlee.stock_tracker.client.StockClient;
import com.alexlee.stock_tracker.dto.StockResponse;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private StockClient stockClient;

    public StockService(final StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public StockResponse getStockForSymbol(final String stockSymbol) {
        stockClient.getStockQuote(stockSymbol);

        return new StockResponse();
    }
}
