package com.lalit.Spring5RecipeApp.repositories;

import com.lalit.Spring5RecipeApp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
