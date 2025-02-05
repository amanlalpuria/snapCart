package com.mps.snapCart.repositories;

import com.mps.snapCart.entities.Liquor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository <Liquor,Long> {

    Optional<Liquor> findBySku(String sku);
    List<Liquor> findByLocation(String location);
}
