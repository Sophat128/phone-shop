package com.piseth.java.school.phoneshop.repository;

import com.piseth.java.school.phoneshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
