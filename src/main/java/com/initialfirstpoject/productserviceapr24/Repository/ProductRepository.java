package com.initialfirstpoject.productserviceapr24.Repository;

import com.initialfirstpoject.productserviceapr24.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

        Product save(Product product);
        List<Product> findAllBy();
        Product findProductById(Integer id);
}
