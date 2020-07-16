package com.lalit.Spring5RecipeApp.controllers;

import com.lalit.Spring5RecipeApp.domain.Category;
import com.lalit.Spring5RecipeApp.domain.UnitOfMeasure;
import com.lalit.Spring5RecipeApp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model){
        log.debug("Inside the Index Controller");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
