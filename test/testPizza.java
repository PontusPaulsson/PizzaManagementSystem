/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Pizza;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GasCan
 */
public class testPizza {

    public testPizza() {
    }

    Pizza pizza;

    @Before
    public void setUp() {
        pizza = new Pizza();
    }

    @Test
    public void testGettersAndSetters() {
        pizza.setId(1);
        pizza.setName("testPizza");
        pizza.setPrice(30);
        pizza.setDescription("testPizzaDescription");

        assertEquals(1, pizza.getId());
        assertEquals("testPizza", pizza.getName());
        assertEquals("testPizzaDescription", pizza.getDescription());
        assertEquals(30, pizza.getPrice(), 0.001);

    }

    @Test
    public void testEquals() {
        Pizza newPizza = new Pizza();
        pizza.setId(1);
        newPizza.setId(1);
        assertTrue(newPizza.equals(pizza));
    }

    @Test
    public void testHashCode() {
        pizza.setId(1);
        assertEquals(1, pizza.hashCode());
    }

    @Test
    public void testToString() {
        pizza.setId(1);
        pizza.setName("testPizza");
        pizza.setPrice(30);
        pizza.setDescription("testPizzaDescription");

        System.out.println(pizza.toString());
        assertEquals("Pizza{id=1, name=testPizza, price=30.0, description=testPizzaDescription}", pizza.toString());

    }
}
