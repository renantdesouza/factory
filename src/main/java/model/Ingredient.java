package model;

import enumerations.Measure;

import java.util.Date;

/**
 * Represents an product.
 *
 * @author renantdesouza.
 * @since 03/08/2016.
 */
public class Ingredient implements Model {

    private String id;
    private String description;
    private Measure measure;
    private Date maturity;

    public Ingredient() {
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

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

}
