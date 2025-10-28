package com.alexlee.stock_tracker.controller;

import com.alexlee.stock_tracker.dto.DailyStockResponse;
import com.alexlee.stock_tracker.dto.StockOverviewResponse;
import com.alexlee.stock_tracker.dto.StockResponse;
import com.alexlee.stock_tracker.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(final StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{stockSymbol}")
    public StockResponse getStock(@PathVariable String stockSymbol) {
        return stockService.getStockForSymbol(stockSymbol.toUpperCase());
    }

    @GetMapping("/{stockSymbol}/overview")
    public StockOverviewResponse getStockOverview(@PathVariable String stockSymbol) {
        return stockService.getStockOverviewForSymbol(stockSymbol.toUpperCase());
    }

    @GetMapping("/{symbol}/history")
    public List<DailyStockResponse> getStockHistory(
            @PathVariable String symbol,
            @RequestParam(defaultValue = "30") int days
    ) {
        return stockService.getHistory(symbol.toUpperCase(), days);
    }

}
