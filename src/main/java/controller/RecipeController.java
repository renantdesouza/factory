package controller;

import model.Recipe;

import javax.ws.rs.Path;

/**
 *  Controller for recipe
 *
 * @author renantdesouza.
 * @since 31/10/2016.
 */
@Path("recipe")
public class RecipeController extends ControllerImpl<Recipe> {

    public RecipeController() {
        super(Recipe.class);
    }

}
