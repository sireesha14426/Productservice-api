package com.initialfirstpoject.productserviceapr24.service;

import com.initialfirstpoject.productserviceapr24.Exception.CategoryNotFoundException;
import com.initialfirstpoject.productserviceapr24.Exception.CategoryNotFoundException;
import com.initialfirstpoject.productserviceapr24.Exception.ProductAlreadyExistsException;
import com.initialfirstpoject.productserviceapr24.Exception.ProductNotFoundException;
import com.initialfirstpoject.productserviceapr24.Models.Product;
import com.initialfirstpoject.productserviceapr24.dto.CreateProductresponsedto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
public interface ProductService {
    Product getproductbyId(Integer id);

    List<Product> getallproducts();

    Product createproduct(String title, String description, Double price,
                          String image, String category) throws CategoryNotFoundException;

    Page<Product> getpaginatedproduct(Integer pageno, Integer pagesize);

    public String[] getAllCategories();

    public List<Product> getInCategory(String category) throws CategoryNotFoundException;

    public Product deleteProduct(Integer id) throws ProductNotFoundException;
}
