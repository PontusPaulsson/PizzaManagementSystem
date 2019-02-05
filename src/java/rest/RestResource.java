/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dao.PizzaManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import model.Pizza;

/**
 * REST Web Service
 *
 * @author paulssonp
 */
@Stateless
@Path("")
public class RestResource extends PizzaManager {

    @Override
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/add/")
    public void addPizza(Pizza p) {
        super.addPizza(p);
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/addAll/")
    public void allPizzas(List<Pizza> pizzaList) {
        for (Pizza p : pizzaList) {
            super.addPizza(p);
        }

    }

    @Override
    @DELETE
    @Path("/delete/{id}")
    public void deletePizza(@PathParam("id") int id) {
        super.deletePizza(id);
    }

    @Override
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/update/")
    public void updatePizza(Pizza p) {
        Pizza updatePizza = super.readPizza(p.getId());
        updatePizza.setDescription(p.getDescription());
        updatePizza.setPrice(p.getPrice());
        updatePizza.setName(p.getName());
        //super.updatePizza(updatePizza);
    }

    @Override
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/show/{id}")
    public Pizza readPizza(@PathParam("id") int id) {
        return super.readPizza(id);
    }

    @Override
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/show/allpizzas")
    public List<Pizza> getAllPizzas() {
        return super.getAllPizzas();
    }

}
