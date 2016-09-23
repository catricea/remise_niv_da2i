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
public class PacmanTest {
    
    public PacmanTest() {
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
     * Test of getDead method, of class Pacman.
     */
    @Test
    public void testGetDead() {
        System.out.println("getDead");
        Pacman instance = null;
        boolean expResult = false;
        boolean result = instance.getDead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDead method, of class Pacman.
     */
    @Test
    public void testSetDead() {
        System.out.println("setDead");
        boolean a = false;
        Pacman instance = null;
        instance.setDead(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Pacman.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Pacman instance = null;
        Cellule expResult = null;
        Cellule result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class Pacman.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Pacman instance = null;
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGhostScore method, of class Pacman.
     */
    @Test
    public void testGetGhostScore() {
        System.out.println("getGhostScore");
        Pacman instance = null;
        int expResult = 0;
        int result = instance.getGhostScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScoreFinal method, of class Pacman.
     */
    @Test
    public void testGetScoreFinal() {
        System.out.println("getScoreFinal");
        Pacman instance = null;
        int expResult = 0;
        int result = instance.getScoreFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrientation method, of class Pacman.
     */
    @Test
    public void testGetOrientation() {
        System.out.println("getOrientation");
        Pacman instance = null;
        Orientation expResult = null;
        Orientation result = instance.getOrientation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Pacman.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int x = 0;
        int y = 0;
        Pacman instance = null;
        instance.setPosition(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrientation method, of class Pacman.
     */
    @Test
    public void testSetOrientation() {
        System.out.println("setOrientation");
        Orientation orientation = null;
        Pacman instance = null;
        instance.setOrientation(orientation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScore method, of class Pacman.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 0;
        Pacman instance = null;
        instance.setScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGhostScore method, of class Pacman.
     */
    @Test
    public void testSetGhostScore() {
        System.out.println("setGhostScore");
        int score = 0;
        Pacman instance = null;
        instance.setGhostScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
