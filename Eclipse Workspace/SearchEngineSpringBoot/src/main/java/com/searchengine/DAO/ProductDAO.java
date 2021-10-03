package com.searchengine.DAO;

import org.springframework.data.repository.CrudRepository;

import com.searchengine.Models.Product;


public interface ProductDAO extends CrudRepository<Product, Integer> {
	
}
