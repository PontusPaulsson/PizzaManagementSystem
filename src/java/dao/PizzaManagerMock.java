/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Pizza;

/**
 *
 * @author GasCan
 */
public class PizzaManagerMock extends PizzaManager implements PizzaManagerFacade<Pizza> {

    List<Pizza> pizzaList = new ArrayList<Pizza>();
    
    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaList;
    }

    @Override
    public Pizza readPizza(int id) {
        for(Pizza p : pizzaList){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void updatePizza(Pizza p) {
        for(Pizza pizza : pizzaList){
            if(p.equals(pizza)){
                pizza = p;
            }
        }
    }

    @Override
    public void deletePizza(int id) {
        Iterator<Pizza> i = pizzaList.iterator();
        while(i.hasNext()){
            if(i.next().getId() == id){
                i.remove();
            }
        }
    }

    @Override
    public void addPizza(Pizza p) {
        pizzaList.add(p);
    }
    
    
    
}
