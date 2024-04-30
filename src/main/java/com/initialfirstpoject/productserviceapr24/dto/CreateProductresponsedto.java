package com.initialfirstpoject.productserviceapr24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*                   title: 'test product',
                    price: 13.5,
                    description: 'lorem ipsum set',
                    image: 'https://i.pravatar.cc',
                    category: 'electronic'*/

@Data
@NoArgsConstructor

public class CreateProductresponsedto {
    String title;
    String description;
    Double price;
    String image;
    String category;
}
