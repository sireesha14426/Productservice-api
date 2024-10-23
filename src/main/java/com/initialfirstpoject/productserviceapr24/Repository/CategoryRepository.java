package com.initialfirstpoject.productserviceapr24.Repository;

import com.initialfirstpoject.productserviceapr24.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

        Category findByName(String name);
}
