package model;

import java.util.List;

/**
 * Represents a recipe.
 *
 * @author renantdesouza.
 * @since 03/08/2016.
 */
public class Recipe implements Model {

    private String id;
    private String description;
    private List<Ingredient> ingredients;

    public Recipe() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
