package com.initialfirstpoject.productserviceapr24.service;

import com.initialfirstpoject.productserviceapr24.Models.Product;
import com.initialfirstpoject.productserviceapr24.dto.CreateProductresponsedto;

import java.util.List;

public interface ProductService {
    Product getproductbyId(Integer id);
    List<Product> getallproducts();
    Product createproduct(String title, String description, Double price, String image);

}
