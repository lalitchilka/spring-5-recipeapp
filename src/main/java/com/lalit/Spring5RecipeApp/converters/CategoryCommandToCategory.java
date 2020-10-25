package com.lalit.Spring5RecipeApp.converters;

import com.lalit.Spring5RecipeApp.commands.CategoryCommand;
import com.lalit.Spring5RecipeApp.domain.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Override
    public Category convert(CategoryCommand source) {
        return null;
    }
}
