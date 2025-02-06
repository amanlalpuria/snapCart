package com.mps.snapCart.controllers;

import com.mps.snapCart.entities.Liquor;
import com.mps.snapCart.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{sku}")
    public ResponseEntity<Liquor> getInventory(@PathVariable String sku) {
        return ResponseEntity.ok(inventoryService.getInventoryBySku(sku));
    }

    @PutMapping("/reduce")
    public ResponseEntity<String> reduceStock(@RequestParam String sku, @RequestParam int quantity) {
        inventoryService.updateStock(sku, quantity);
        return ResponseEntity.ok("Stock updated successfully.");
    }

    @PutMapping("/restock")
    public ResponseEntity<String> restockItem(@RequestParam String sku, @RequestParam int quantity) {
        inventoryService.restockItem(sku, quantity);
        return ResponseEntity.ok("Stock restocked successfully.");
    }

    @GetMapping("/lowstock")
    public ResponseEntity<List<Liquor>> getLowStockItems() {
        return ResponseEntity.ok(inventoryService.getLowStockItems());
    }

}
