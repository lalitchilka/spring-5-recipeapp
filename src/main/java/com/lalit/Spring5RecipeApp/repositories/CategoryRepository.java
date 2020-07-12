package com.lalit.Spring5RecipeApp.repositories;

import com.lalit.Spring5RecipeApp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
