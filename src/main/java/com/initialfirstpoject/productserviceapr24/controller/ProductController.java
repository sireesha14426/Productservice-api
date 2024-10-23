package com.initialfirstpoject.productserviceapr24.controller;

import com.initialfirstpoject.productserviceapr24.Exception.CategoryNotFoundException;
import com.initialfirstpoject.productserviceapr24.Exception.ProductNotFoundException;
import com.initialfirstpoject.productserviceapr24.Models.Product;
import com.initialfirstpoject.productserviceapr24.dto.CreateProductresponsedto;
import com.initialfirstpoject.productserviceapr24.dto.ErrorDTO;
import com.initialfirstpoject.productserviceapr24.dto.ProductResponsedto;
import org.apache.catalina.WebResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.initialfirstpoject.productserviceapr24.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productservice;
public ProductController(@Qualifier("Selfproductservice")ProductService productservice){
        this.productservice = productservice;
    }


    @GetMapping("/products/{id}")
    public ProductResponsedto getproductbyId(@PathVariable("id")  Integer id) throws ProductNotFoundException {
        Product product = productservice.getproductbyId(id);
        if(product==null){
            throw new ProductNotFoundException("some error occured");
        }
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
    public Product createproduct(@RequestBody CreateProductresponsedto dto) throws CategoryNotFoundException {
            Product p = productservice.createproduct(dto.getTitle(), dto.getDescription(),
                    dto.getPrice(), dto.getImage(), dto.getCategory());
                return p;
    }

    @GetMapping("/products/{pageno}/{pagesize}")
    public ResponseEntity<ProductResponsedto> getpaginatedproduct(@PathVariable("pageno") Integer pageno,
                                                                  @PathVariable("pagesize") Integer pagesize){

        Page<Product> proudctpage= productservice.getpaginatedproduct(pageno, pagesize);
        System.out.println("Productpage: "+proudctpage);
        return ResponseEntity.ok((ProductResponsedto) proudctpage.getContent());
    }

    @GetMapping("/products/category/{category}")
    public List<ProductResponsedto> getInCategory(@PathVariable("category") String category) throws CategoryNotFoundException {
        List<Product> products = productservice.getInCategory(category);
        List<ProductResponsedto> prDTO = new ArrayList<>();
        for(Product p : products){
            prDTO.add(ConvertProducttoResponsedto(p));
        }
        return prDTO;
    }
    @DeleteMapping("/products/{id}")
    public ProductResponsedto deleteProduct(@PathVariable("id") Integer id) throws ProductNotFoundException {
        Product product = productservice.deleteProduct(id);
        return ConvertProducttoResponsedto(product);
    }

}
