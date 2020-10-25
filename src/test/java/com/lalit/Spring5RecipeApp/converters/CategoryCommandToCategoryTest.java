package com.lalit.Spring5RecipeApp.converters;

import com.lalit.Spring5RecipeApp.commands.CategoryCommand;
import com.lalit.Spring5RecipeApp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryCommandToCategoryTest {

    private static final Long ID = Long.valueOf(1L);
    private static final String DESCRIPTION = "description";

    private CategoryCommandToCategory categoryCommandToCategory;

    @BeforeEach
    void setUp() {
        categoryCommandToCategory = new CategoryCommandToCategory();
    }

    @Test
    void testNullParameter() {
        assertNull(categoryCommandToCategory.convert(null));
    }

    @Test
    void TestEmptyObject() {
        assertNotNull(categoryCommandToCategory.convert(new CategoryCommand()));
    }

    @Test
    public void convert(){
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = categoryCommandToCategory.convert(categoryCommand);

        //then
        assertEquals(ID, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}
