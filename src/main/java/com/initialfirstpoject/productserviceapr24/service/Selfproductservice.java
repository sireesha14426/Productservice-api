package com.initialfirstpoject.productserviceapr24.service;

import com.initialfirstpoject.productserviceapr24.Exception.CategoryNotFoundException;
import com.initialfirstpoject.productserviceapr24.Exception.CategoryNotFoundException;
import com.initialfirstpoject.productserviceapr24.Exception.ProductAlreadyExistsException;
import com.initialfirstpoject.productserviceapr24.Exception.ProductNotFoundException;
import com.initialfirstpoject.productserviceapr24.Models.Category;
import com.initialfirstpoject.productserviceapr24.Models.Product;
import com.initialfirstpoject.productserviceapr24.Repository.CategoryRepository;
import com.initialfirstpoject.productserviceapr24.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;


@Service("Selfproductservice")
public class Selfproductservice implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public Selfproductservice(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getproductbyId(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> getallproducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createproduct(String title, String description, Double price, String image,String category) throws CategoryNotFoundException, CategoryNotFoundException {
        Product producttobesaved = new Product();

        Category fetchedcategory = categoryRepository.findByName(category);
        if (fetchedcategory == null) {
            throw new CategoryNotFoundException("Category does not exist");
        }
        producttobesaved.setTitle(title);
        producttobesaved.setDescription(description);
        producttobesaved.setImageURL(image);
        producttobesaved.setPrice(String.valueOf(price));
        producttobesaved.setCategory(fetchedcategory);

        Product updatedproducttobesaved = productRepository.save(producttobesaved);
        return updatedproducttobesaved;
    }

    @Override
    public Page<Product> getpaginatedproduct(Integer pageno, Integer pagesize) {
        PageRequest pageable =  PageRequest.of(pageno,pagesize);
        //PageRequest.of(pageno,pagesize,Sort.Direction.ASC);

        Page<Product> product =productRepository.findAll(pageable);


        return product;
    }

    @Override
    public String[] getAllCategories() {
        return new String[0];
    }

    @Override
    public List<Product> getInCategory(String category) throws CategoryNotFoundException {
        return List.of();
    }

    @Override
    public Product deleteProduct(Integer id) throws ProductNotFoundException {
        return null;
    }


}
