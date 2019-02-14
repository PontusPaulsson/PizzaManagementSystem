/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Pizza;

/**
 *
 * @author GasCan
 */
public class PizzaManager implements PizzaManagerFacade<Pizza> {
    
    @PersistenceContext
    private EntityManager em;
  
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void addPizza(Pizza p){
        em.persist(p);
    }
    @Override
    public void deletePizza(int id){
        em.remove(em.find(Pizza.class, id));
    }
    @Override
    public void updatePizza(Pizza p){
        em.merge(p);
    }
    @Override
    public Pizza readPizza(int id){
        return em.find(Pizza.class, id);
    }
    
    @Override
    public List<Pizza> getAllPizzas() {
        return em.createQuery("Select P from Pizza P").getResultList();
    }

}
