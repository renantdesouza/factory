package model;

import java.math.BigDecimal;

/**
 * Represents a ingredient used in a recipe.
 *
 * @author renantdesouza
 * @since 03/08/2016.
 */
public class IngredientRecipe implements Model {

    private String id;
    private Ingredient ingredient;
    private Recipe recipe;
    private BigDecimal amount;

    public IngredientRecipe() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
