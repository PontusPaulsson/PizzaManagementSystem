/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.PizzaController;
import dao.PizzaManager;
import model.Pizza;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author GasCan
 */
public class testPizzaManager {

    PizzaManager pm;

    @Before
    public void setUp() {
        pm = mock(PizzaManager.class);
        when(pm.getAllPizzas()).thenReturn(new ArrayList<Pizza>());
    }

    @Test
    public void testAddPizza() {
        Pizza p = new Pizza();
        pm.addPizza(p);
        verify(pm, times(1)).addPizza(p);
    }

    @Test
    public void testGetAllPizzas() {
        List<Pizza> pizzaList;
        pizzaList = pm.getAllPizzas();
        assertEquals(new ArrayList<Pizza>(), pizzaList);
    }

    @Test
    public void testDeletePizza() {
        pm.deletePizza(1);
        verify(pm, times(1)).deletePizza(1);
    }

    @Test
    public void testReadPizza() {
        pm.readPizza(1);
        verify(pm, times(1)).readPizza(1);
    }

    @Test
    public void testUpdatePizza() {
        Pizza p = new Pizza();
        pm.updatePizza(p);
        verify(pm, times(1)).updatePizza(p);
    }
}
