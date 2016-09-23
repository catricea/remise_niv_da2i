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
    
    private Pacman P; 
    private Cellule C;
    
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
        Cellule C1 = new Cellule(0,0, false, false);
        Pacman P = new Pacman(C1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDead method, of class Pacman.
     */
    @Test
    public void testGetDead() {
        P.setDead(true);
        System.out.println("getDead");
        boolean expResult = false;
        boolean result = P.getDead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Le resultat attendu était : false.");
    }

    /**
     * Test of setDead method, of class Pacman.
     */
    @Test
    public void testSetDead() {
        System.out.println("setDead");
        
        boolean a = false;
        P.setDead(a);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(a, P.getDead());
        fail("Erreur.");
    }

    /**
     * Test of getPosition method, of class Pacman.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        
        Cellule expResult = C;
        Cellule result = P.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Position différente.");
    }

    /**
     * Test of getScore method, of class Pacman.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        int expResult = 0;
        int result = P.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Score différent");
    }

    /**
     * Test of getGhostScore method, of class Pacman.
     */
    @Test
    public void testGetGhostScore() {
        System.out.println("getGhostScore");
        
        int expResult = 0;
        int result = P.getGhostScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Score de fantome différent");
    }

    /**
     * Test of getScoreFinal method, of class Pacman.
     */
    @Test
    public void testGetScoreFinal() {
        System.out.println("getScoreFinal");
        
        int expResult = P.getGhostScore() + P.getScore();
        int result = P.getScoreFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Score final different du résultat attendu");
    }

    /**
     * Test of getOrientation method, of class Pacman.
     */
    @Test
    public void testGetOrientation() {
        System.out.println("getOrientation");
        
        Orientation expResult = Orientation.UP;
        Orientation result = P.getOrientation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Orientation différente");
    }

    /**
     * Test of setPosition method, of class Pacman.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int x = 5;
        int y = 10;
        
        P.setPosition(x, y);
        
        assertEquals(x, C.getX());
        assertEquals(y, C.getY());
        
        // TODO review the generated test code and remove the default call to fail.
        fail("Coordonnées différentes.");
    }

    /**
     * Test of setOrientation method, of class Pacman.
     */
    @Test
    public void testSetOrientation() {
        System.out.println("setOrientation");
        Orientation orientation = Orientation.DOWN;
       
        P.setOrientation(orientation);
        assertEquals(Orientation.DOWN, P.getOrientation());
        // TODO review the generated test code and remove the default call to fail.
        fail("Orientation différente.");
    }

    /**
     * Test of setScore method, of class Pacman.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 45;
        
        P.setScore(score);
        assertEquals(score, P.getScore());
        // TODO review the generated test code and remove the default call to fail.
        fail("Score différent.");
    }

    /**
     * Test of setGhostScore method, of class Pacman.
     */
    @Test
    public void testSetGhostScore() {
        System.out.println("setGhostScore");
        int score = 89;
        
        P.setGhostScore(score);
        assertEquals(score, P.getGhostScore());
        // TODO review the generated test code and remove the default call to fail.
        fail("score différent.");
    }
    
}
