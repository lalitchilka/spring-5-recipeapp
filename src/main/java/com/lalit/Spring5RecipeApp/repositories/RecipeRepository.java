package com.lalit.Spring5RecipeApp.repositories;

import com.lalit.Spring5RecipeApp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
