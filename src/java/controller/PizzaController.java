/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PizzaManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Pizza;

/**
 *
 * @author GasCan
 */


@Named(value = "pizzaController")
@RequestScoped
public class PizzaController {

    @Inject
    PizzaManager pm;
    
    private int id;
    private String name;
    private Double price;
    private String description;
    private List<Pizza> allPizzas;
    
    
    /**
     * Creates a new instance of PizzaController
     */
    public PizzaController() {
    }
    @PostConstruct
    public void fillArray(){
        allPizzas = pm.getAllPizzas();
    }
    
    public List<Pizza> showAllPizzas(){
        return pm.getAllPizzas();
    }
    public void delete(int id){
        pm.deletePizza(id);
        allPizzas = pm.getAllPizzas();
    }
    
    public void submit(){
        Pizza p = new Pizza(name, price, description);
        pm.addPizza(p);
        allPizzas = pm.getAllPizzas();
    }

    public PizzaManager getPm() {
        return pm;
    }
    
    public String update(){
        // Dumdumb...
//        pm.updatePizza(new Pizza(name, price, description));
        
        // Corrected (But not working..)
        Pizza p = pm.readPizza(id);
        if (p != null) {
            p.setName(name);
            p.setDescription(description);
            p.setPrice(price);
            pm.updatePizza(p);
        }
        
        allPizzas = pm.getAllPizzas();
        return "index.xhtml";
    }

    public void setPm(PizzaManager pm) {
        this.pm = pm;
    }

    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pizza> getAllPizzas() {
        return allPizzas;
    }

    public void setAllPizzas(List<Pizza> allPizzas) {
        this.allPizzas = allPizzas;
    }
    
    
}
