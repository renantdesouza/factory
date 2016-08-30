package controller;

import model.Ingredient;

import javax.ws.rs.Path;

/**
 * Controller for ingredients.
 *
 * @author renantdesouza.
 * @since 15/08/2016.
 */
@Path("ingredient")
public class IngredientController extends ControllerImpl<Ingredient> {

    public IngredientController() {
        super(Ingredient.class);
    }

}
