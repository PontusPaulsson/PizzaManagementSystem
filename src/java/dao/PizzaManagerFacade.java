/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author paulssonp
 */
public interface PizzaManagerFacade<T> {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    void addPizza(T p);

    void deletePizza(int id);

    List<T> getAllPizzas();

    T readPizza(int id);

    void updatePizza(T p);
    
}
