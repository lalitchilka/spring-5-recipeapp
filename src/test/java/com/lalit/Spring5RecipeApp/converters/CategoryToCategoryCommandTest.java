package com.lalit.Spring5RecipeApp.converters;

import com.lalit.Spring5RecipeApp.commands.CategoryCommand;
import com.lalit.Spring5RecipeApp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryToCategoryCommandTest {

    private static final Long ID = Long.valueOf(1L);
    private static final String DESCRIPTION = "description";

    private CategoryToCategoryCommand categoryToCategoryCommand;

    @BeforeEach
    void setUp() {
        categoryToCategoryCommand = new CategoryToCategoryCommand();
    }

    @Test
    void testNullParameter() {
        assertNull(categoryToCategoryCommand.convert(null));
    }

    @Test
    void TestEmptyObject() {
        assertNotNull(categoryToCategoryCommand.convert(new Category()));
    }

    @Test
    public void convert(){
        //given
        Category category = new Category();
        category.setId(ID);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = categoryToCategoryCommand.convert(category);

        //then
        assertEquals(ID, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }
}
