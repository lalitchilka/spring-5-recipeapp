package com.lalit.Spring5RecipeApp.repositories;

import com.lalit.Spring5RecipeApp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
