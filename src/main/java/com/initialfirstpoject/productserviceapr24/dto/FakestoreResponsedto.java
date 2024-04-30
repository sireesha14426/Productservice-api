package com.initialfirstpoject.productserviceapr24.dto;

import com.initialfirstpoject.productserviceapr24.Models.Category;
import com.initialfirstpoject.productserviceapr24.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreResponsedto {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

    public Product toproduct(){
        Product p = new Product();
        p.setId(id);
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageURL(image);

        Category c = new Category();
        c.setName(category);
        p.setCategory(c);
        return p;
    }
}
