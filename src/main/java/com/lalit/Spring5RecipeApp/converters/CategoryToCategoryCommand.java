package com.lalit.Spring5RecipeApp.converters;

import com.lalit.Spring5RecipeApp.commands.CategoryCommand;
import com.lalit.Spring5RecipeApp.domain.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Override
    public CategoryCommand convert(Category source) {
        return null;
    }
}
