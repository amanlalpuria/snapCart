package com.mps.snapCart.repositories;

import com.mps.snapCart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
