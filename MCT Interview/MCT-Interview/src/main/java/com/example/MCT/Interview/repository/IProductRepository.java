package com.example.MCT.Interview.repository;

import com.example.MCT.Interview.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
