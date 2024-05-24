package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
