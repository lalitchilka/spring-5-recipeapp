package com.lalit.Spring5RecipeApp.bootstrap;

import com.lalit.Spring5RecipeApp.domain.*;
import com.lalit.Spring5RecipeApp.repositories.CategoryRepository;
import com.lalit.Spring5RecipeApp.repositories.RecipeRepository;
import com.lalit.Spring5RecipeApp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class BootStrapStartUp implements ApplicationListener<ContextRefreshedEvent> {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;

    public BootStrapStartUp(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("Inside onApplicationEvent method");
        recipeRepository.saveAll(loadData());
    }

    public List<Recipe> loadData(){
        log.debug("Inside loadData method and loading data...");
        List<Recipe> recipies = new ArrayList<>();

        //get UOM
        Optional<UnitOfMeasure> eachUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUnitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> teaspoonUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaspoonUnitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> tablespoonUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tablespoonUnitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> cupUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");
        if(!cupUnitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> pintUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUnitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> dashUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUnitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        //get optionals
        UnitOfMeasure eachUOM = eachUnitOfMeasureOptional.get();
        UnitOfMeasure teaspoonUOM = teaspoonUnitOfMeasureOptional.get();
        UnitOfMeasure tablespoonUOM = tablespoonUnitOfMeasureOptional.get();
        UnitOfMeasure cupUOM = cupUnitOfMeasureOptional.get();
        UnitOfMeasure dashUOM = dashUnitOfMeasureOptional.get();
        UnitOfMeasure pintUOM = pintUnitOfMeasureOptional.get();

        //get Category

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()) throw new RuntimeException("Category not present");
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()) throw new RuntimeException("Category not present");

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        //Spicy Guacamole
        Recipe spicy_guacamole_recipe = new Recipe();
        spicy_guacamole_recipe.setPrepTime(10);
        spicy_guacamole_recipe.setCookTime(0);
        spicy_guacamole_recipe.setServings(3);
        spicy_guacamole_recipe.setDescription("Perfect Guacamole");
        spicy_guacamole_recipe.setDifficulty(Difficulty.EASY);
        spicy_guacamole_recipe.setDirection("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. Place in a bowl.\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown. Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness. Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste. Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");

        Notes guacaNotes = new Notes();
        guacaNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        spicy_guacamole_recipe.setNotes(guacaNotes);

        spicy_guacamole_recipe.getIngredients().add(new Ingredients("ripe avocados", new BigDecimal(2), eachUOM));
        spicy_guacamole_recipe.getIngredients().add(new Ingredients("Kosher salt", new BigDecimal(0.5), teaspoonUOM));
        spicy_guacamole_recipe.getIngredients().add(new Ingredients("fresh lime juice or lemon juice", new BigDecimal(2), tablespoonUOM));
        spicy_guacamole_recipe.getIngredients().add(new Ingredients("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoonUOM));
        spicy_guacamole_recipe.getIngredients().add(new Ingredients("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUOM));
        spicy_guacamole_recipe.getIngredients().add(new Ingredients("Cilantro", new BigDecimal(2), tablespoonUOM));
        spicy_guacamole_recipe.getIngredients().add(new Ingredients("freshly grated black pepper", new BigDecimal(2), dashUOM));
        spicy_guacamole_recipe.getIngredients().add(new Ingredients("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), eachUOM));

        spicy_guacamole_recipe.setSource("Simply Recipes");
        spicy_guacamole_recipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        spicy_guacamole_recipe.getCategories().add(americanCategory);
        spicy_guacamole_recipe.getCategories().add(mexicanCategory);

        recipies.add(spicy_guacamole_recipe);

        //Yummy Tacos

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        tacosRecipe.setServings(1);
        tacosRecipe.setSource("Simply Recipes");
        tacosRecipe.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        tacosRecipe.setDirection("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        tacosRecipe.setNotes(tacoNotes);


        tacosRecipe.getIngredients().add(new Ingredients("Ancho Chili Powder", new BigDecimal(2), tablespoonUOM));
        tacosRecipe.getIngredients().add(new Ingredients("Dried Oregano", new BigDecimal(1), teaspoonUOM));
        tacosRecipe.getIngredients().add(new Ingredients("Dried Cumin", new BigDecimal(1), teaspoonUOM));
        tacosRecipe.getIngredients().add(new Ingredients("Sugar", new BigDecimal(1), teaspoonUOM));
        tacosRecipe.getIngredients().add(new Ingredients("Salt", new BigDecimal(".5"), teaspoonUOM));
        tacosRecipe.getIngredients().add(new Ingredients("Clove of Garlic, Choppedr", new BigDecimal(1), eachUOM));
        tacosRecipe.getIngredients().add(new Ingredients("finely grated orange zestr", new BigDecimal(1), tablespoonUOM));
        tacosRecipe.getIngredients().add(new Ingredients("fresh-squeezed orange juice", new BigDecimal(3), tablespoonUOM));
        tacosRecipe.getIngredients().add(new Ingredients("Olive Oil", new BigDecimal(2), tablespoonUOM));
        tacosRecipe.getIngredients().add(new Ingredients("boneless chicken thighs", new BigDecimal(4), tablespoonUOM));
        tacosRecipe.getIngredients().add(new Ingredients("small corn tortillasr", new BigDecimal(8), eachUOM));
        tacosRecipe.getIngredients().add(new Ingredients("packed baby arugula", new BigDecimal(3), cupUOM));
        tacosRecipe.getIngredients().add(new Ingredients("medium ripe avocados, slic", new BigDecimal(2), eachUOM));
        tacosRecipe.getIngredients().add(new Ingredients("radishes, thinly sliced", new BigDecimal(4), eachUOM));
        tacosRecipe.getIngredients().add(new Ingredients("cherry tomatoes, halved", new BigDecimal(".5"), pintUOM));
        tacosRecipe.getIngredients().add(new Ingredients("red onion, thinly sliced", new BigDecimal(".25"), eachUOM));
        tacosRecipe.getIngredients().add(new Ingredients("Roughly chopped cilantro", new BigDecimal(4), eachUOM));
        tacosRecipe.getIngredients().add(new Ingredients("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupUOM));
        tacosRecipe.getIngredients().add(new Ingredients("lime, cut into wedges", new BigDecimal(4), eachUOM));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);

        recipies.add(tacosRecipe);
        return recipies;
    }

}
