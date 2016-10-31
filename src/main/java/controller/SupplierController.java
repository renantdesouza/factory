package controller;

import model.Supplier;

import javax.ws.rs.Path;


/**
 *  Controller for supplier
 *
 * @author renantdesouza.
 * @since 31/10/2016.
 */
@Path("supplier")
public class SupplierController extends ControllerImpl<Supplier> {

    public SupplierController() {
        super(Supplier.class);
    }

}
