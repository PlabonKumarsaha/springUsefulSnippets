package com.pks.springdataredis.controller;

import com.pks.springdataredis.entity.Product;
import com.pks.springdataredis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@EnableCaching
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    public static final String HASH_KEY = "Product";



    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = HASH_KEY,unless = "#result.price > 1000")
    public Product findProduct(@PathVariable int id) {
        return productRepository.findProductById(id);
    }
    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = HASH_KEY)
    public String remove(@PathVariable int id)   {
        return productRepository.deleteProduct(id);
    }
}
