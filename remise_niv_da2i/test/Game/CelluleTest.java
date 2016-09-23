/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class CelluleTest {
    
    public CelluleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getWall method, of class Cellule.
     */
    @Test
    public void testGetWall() {
        System.out.println("getWall");
        Cellule instance = null;
        boolean expResult = false;
        boolean result = instance.getWall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassed method, of class Cellule.
     */
    @Test
    public void testGetPassed() {
        System.out.println("getPassed");
        Cellule instance = null;
        boolean expResult = false;
        boolean result = instance.getPassed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Cellule.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Cellule instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Cellule.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Cellule instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Cellule.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Cellule instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Cellule.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Cellule instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassed method, of class Cellule.
     */
    @Test
    public void testSetPassed() {
        System.out.println("setPassed");
        boolean passed = false;
        Cellule instance = null;
        instance.setPassed(passed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVitamined method, of class Cellule.
     */
    @Test
    public void testGetVitamined() {
        System.out.println("getVitamined");
        Cellule instance = null;
        boolean expResult = false;
        boolean result = instance.getVitamined();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVitamined method, of class Cellule.
     */
    @Test
    public void testSetVitamined() {
        System.out.println("setVitamined");
        boolean vit = false;
        Cellule instance = null;
        instance.setVitamined(vit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
