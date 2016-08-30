package controller;

import dao.DAO;
import model.Model;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Generic Controller.
 * @author renantdesouza.
 * @since 15/08/2016.
 */
public abstract class ControllerImpl<T extends Model> implements Controller<T> {

    private DAO<T> dao;

    public ControllerImpl(Class<T> clazz) {
        dao = new DAO<>(clazz);
    }

    @POST
    @Path("insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(T entity) {
        dao.create(entity);
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public T find(@PathParam("id") String id) {
        return dao.findById(id);
    }

    @GET
    @Path("find-all}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> find() {
        return dao.findAll();
    }

    // TODO CRIAR ESQUEMA PARA PASSAR LISTA DE FILTROS E BUSCAR POR ELES
    @GET
    @Path("filter")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<T> findByFilters() {
        return null;
    }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(T entity) {
        dao.update(entity);
    }

    @DELETE
    @Path("delete/{id}")
    public void delete(@PathParam("id") String id) {
        dao.delete("_id", id);
    }

    @DELETE
    @Path("delete")
    public void delete(T entity) {
        dao.delete(entity);
    }

    // TODO CRIAR ESQUEMA PARA PASSAR LISTA DE FILTROS E BUSCAR POR ELES
    @DELETE
    @Path("delete-by-filters")
    public void deleteByFilters() {
    }

}
