package com.initialfirstpoject.productserviceapr24.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageURL;
    private Category category;

    //private is called access modifier
}
