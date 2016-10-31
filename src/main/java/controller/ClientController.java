package controller;

import model.Client;
import javax.ws.rs.Path;

/**
 *  Controller for client
 *
 * @author renantdesouza.
 * @since 31/10/2016.
 */
@Path("client")
public class ClientController extends ControllerImpl<Client> {

    public ClientController() {
        super(Client.class);
    }

}
