package model;

/**
 * Represents a recipe to be selled to a client
 *
 * @author renantdesouza.
 * @since 04/08/2016.
 */
public class ClientRecipe implements Model {

    private String id;
    private Client client;
    private Recipe recipe;

    public ClientRecipe() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
