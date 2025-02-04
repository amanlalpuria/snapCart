package com.mps.snapCart.services;


import com.mps.snapCart.entities.Liquor;
import com.mps.snapCart.repositories.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Liquor getInventoryBySku(String sku) {
        return inventoryRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Transactional
    public void updateStock(String sku, int quantitySold) {
        Liquor liquor = inventoryRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        if (liquor.getQuantity() < quantitySold) {
            throw new RuntimeException("Insufficient stock");
        }

        liquor.setQuantity(liquor.getQuantity() - quantitySold);
        inventoryRepository.save(liquor);
    }

    @Transactional
    public void restockItem(String sku, int quantityAdded) {
        Liquor liquor = inventoryRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        liquor.setQuantity(liquor.getQuantity() + quantityAdded);
        inventoryRepository.save(liquor);
    }


    public List<Liquor> getLowStockItems() {
        return inventoryRepository.findAll()
                .stream()
                .filter(liquor -> liquor.getQuantity() <= liquor.getThreshold())
                .toList();
    }
}
