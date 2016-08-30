package controller;

import model.Model;

import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Generic Controller.
 * @author renantdesouza.
 * @since 15/08/2016.
 */
public interface Controller<T extends Model> {

    void insert(T entity);

    T find(@PathParam("id") String id);

    List<T> find();

    List<T> findByFilters();// TODO CRIAR ESQUEMA PARA PASSAR LISTA DE FILTROS E BUSCAR POR ELES

    void update(T entity);

    void delete(@PathParam("id") String id);

    void delete(T entity);

    void deleteByFilters(); // TODO CRIAR ESQUEMA PARA PASSAR LISTA DE FILTROS E BUSCAR POR ELES

}
