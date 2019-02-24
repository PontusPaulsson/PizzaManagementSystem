/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.PizzaController;
import dao.PizzaManager;
import dao.PizzaManagerMock;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import model.Pizza;

/**
 *
 * @author GasCan
 */
public class PizzaControllerTest {
    
    PizzaController pc;
    PizzaManagerMock pmm;
    
    @Before
    public void setUp() {
        pc = new PizzaController();
        pmm = new PizzaManagerMock();
        
        pc.setPm(pmm);
        pc.setDescription("Test description");
        pc.setId(0);
        pc.setPrice(100.0);
        pc.setName("Test pizza");
    }
    
    @Test
    public void testSubmit(){
        pc.submit();
        assertEquals(1, pc.getAllPizzas().size());
    }
    
    @Test
    public void testUpdate(){
        pc.submit(); //submits a pizza with description "Test description".
        pc.setDescription("New test pizza");
        pc.update(); // changes pizza with id = 0 description to "New test pizza".
        assertEquals("New test pizza", pc.getAllPizzas().get(0).getDescription());
        assertNotEquals("Test description", pc.getAllPizzas().get(0).getDescription());
    }
    
    @Test
    public void testShowAllPizzas(){
        assertEquals(pc.showAllPizzas(), pmm.getAllPizzas());
        assertNotNull(pc.showAllPizzas());
    }
    
    @Test
    public void testFillArray(){
        pc.fillArray();
        assertEquals(pc.getAllPizzas(), pmm.getAllPizzas());
        assertNotNull(pc.getAllPizzas());
    }
    
    @Test
    public void testDelete(){
        pc.submit();
        pc.delete(0);
        assertEquals(0, pc.getAllPizzas().size());
    }
    
    @Test
    public void testGetters(){
            assertEquals("Test description", pc.getDescription());
            assertEquals("Test pizza", pc.getName());
            assertEquals(0, pc.getId());
            assertEquals(100.0, pc.getPrice(), 0.001);
            assertEquals(pmm, pc.getPm());
    }
    
}
