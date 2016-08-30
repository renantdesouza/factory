package model;

import java.math.BigDecimal;

/**
 * Represents a stock.
 *
 * @author renantdesouza.
 * @since 03/08/2016.
 */
public class Stock implements Model {

    private String id;
    private Ingredient ingredient;
    private BigDecimal amount;

    public Stock() {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
