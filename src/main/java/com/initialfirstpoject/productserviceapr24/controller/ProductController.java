package com.initialfirstpoject.productserviceapr24.controller;

import com.initialfirstpoject.productserviceapr24.Models.Product;
import com.initialfirstpoject.productserviceapr24.dto.CreateProductresponsedto;
import com.initialfirstpoject.productserviceapr24.dto.ProductResponsedto;
import org.springframework.web.bind.annotation.*;
import com.initialfirstpoject.productserviceapr24.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    public ProductService productservice;

    public ProductController(ProductService productservice){
        this.productservice = productservice;
    }


    @GetMapping("/products/{id}")
    public ProductResponsedto getproductbyId(@PathVariable("id")  Integer id){
        Product product = productservice.getproductbyId(id);
        return ConvertProducttoResponsedto(product);
    }

    public ProductResponsedto ConvertProducttoResponsedto(Product product){
        ProductResponsedto dto = new ProductResponsedto();
        dto.setCategory(product.getCategory());
        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setImageURL(product.getImageURL());
        return dto;
    }
    @GetMapping("/products")
    public List<ProductResponsedto> getallproduts(){
        List<ProductResponsedto> dtolist = new ArrayList<>();
   List<Product> products = productservice.getallproducts();
    for(Product product : products){
            dtolist.add(ConvertProducttoResponsedto(product));
    }
    return dtolist;
        //throw new RuntimeException();
    }

    @PostMapping("/products")
    public Product createproduct(@RequestBody CreateProductresponsedto dto){
            Product p = productservice.createproduct(dto.getTitle(), dto.getDescription(), dto.getPrice(), dto.getImage());
                return p;
    }


}
