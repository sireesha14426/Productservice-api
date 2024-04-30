package com.initialfirstpoject.productserviceapr24.dto;

import com.initialfirstpoject.productserviceapr24.Models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponsedto {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageURL;
    private Category category;
}
