package com.alexlee.stock_tracker.repository;

import com.alexlee.stock_tracker.entity.FavoriteStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteStockRepository extends JpaRepository<FavoriteStock, Long> {

    boolean existsBySymbol(String symbol);
}
