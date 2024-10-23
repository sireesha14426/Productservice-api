package com.initialfirstpoject.productserviceapr24.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Category extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;
}
