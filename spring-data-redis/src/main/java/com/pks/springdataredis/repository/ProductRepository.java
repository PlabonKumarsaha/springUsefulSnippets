package com.pks.springdataredis.repository;

import com.pks.springdataredis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Configuration
public class ProductRepository {

    // has key was mentioned in entity class
    public static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate template;


    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }


}
