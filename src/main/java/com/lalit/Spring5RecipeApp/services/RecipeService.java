package com.lalit.Spring5RecipeApp.services;

import com.lalit.Spring5RecipeApp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
