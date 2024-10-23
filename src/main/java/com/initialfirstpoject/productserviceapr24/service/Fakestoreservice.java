package com.initialfirstpoject.productserviceapr24.service;

import com.initialfirstpoject.productserviceapr24.Exception.CategoryNotFoundException;
import com.initialfirstpoject.productserviceapr24.Exception.ProductAlreadyExistsException;
import com.initialfirstpoject.productserviceapr24.Exception.ProductNotFoundException;
import com.initialfirstpoject.productserviceapr24.Models.Product;
import com.initialfirstpoject.productserviceapr24.dto.FakestoreResponsedto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreservice")
public class Fakestoreservice implements ProductService{

    private RestTemplate restTemplate;

    public Fakestoreservice(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getproductbyId(Integer id) {
         ResponseEntity<FakestoreResponsedto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakestoreResponsedto.class);
        FakestoreResponsedto fakestoreResponsedto=response.getBody();
        return fakestoreResponsedto.toproduct();
    }
    @Override
    public List<Product> getallproducts(){
        List<Product> products=new ArrayList<>();
        //call the fakestore api
        FakestoreResponsedto[] response= restTemplate.getForObject("https://fakestoreapi.com/products" ,
                FakestoreResponsedto[].class);
        //convert to reponse
            for(FakestoreResponsedto dto: response){
                products.add(dto.toproduct());
            }
        return products;
    }
        @Override
    public Product createproduct(String title, String description, Double price, String image,String category){
        FakestoreResponsedto requestbody=new FakestoreResponsedto();
        requestbody.setTitle(title);
        requestbody.setDescription(description);
        requestbody.setImage(image);
        requestbody.setPrice(String.valueOf(price));
        FakestoreResponsedto response= restTemplate.postForObject("https://fakestoreapi.com/products", requestbody,
                FakestoreResponsedto.class);
        return response.toproduct();
        }

    @Override
    public Page<Product> getpaginatedproduct(Integer pageno, Integer pagesize) {
        return null;
    }

    @Override
    public String[] getAllCategories() {
        String[] categories = restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);
        return categories;
    }

    @Override
    public List<Product> getInCategory(String category) throws CategoryNotFoundException {
        FakestoreResponsedto[] response = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category,
                FakestoreResponsedto[].class);
        List<Product> products = new ArrayList<>();
        for(FakestoreResponsedto dto : response){
            products.add(dto.toproduct());
        }
        return products;
    }

    @Override
    public Product deleteProduct(Integer id) throws ProductNotFoundException {
        ResponseEntity<FakestoreResponsedto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakestoreResponsedto.class);
        FakestoreResponsedto frDTO = response.getBody();
        return frDTO.toproduct();
    }




}
