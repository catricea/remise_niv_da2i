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
        C = new Cellule(0,0, false, false);
        P = new Pacman(C);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDead method, of class Pacman.
     */
    @Test
    public void testGetDead() {
        boolean a = true;
        P.setDead(a);
        System.out.println("getDead");
        boolean expResult = a;
        boolean result = P.getDead();
        assertEquals("Le resultat attendu était : true.", expResult, result);
        
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
        assertEquals("Erreur.", a, P.getDead());
        
    }

    /**
     * Test of getPosition method, of class Pacman.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        
        Cellule expResult = C;
        Cellule result = P.getPosition();
        assertEquals("Position différente.", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getScore method, of class Pacman.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        int expResult = 0;
        int result = P.getScore();
        assertEquals("Score différent",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getGhostScore method, of class Pacman.
     */
    @Test
    public void testGetGhostScore() {
        System.out.println("getGhostScore");
        
        int expResult = 0;
        int result = P.getGhostScore();
        assertEquals("Score de fantome différent", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getScoreFinal method, of class Pacman.
     */
    @Test
    public void testGetScoreFinal() {
        System.out.println("getScoreFinal");
        
        int expResult = P.getGhostScore() + P.getScore();
        int result = P.getScoreFinal();
        assertEquals("Score final different du résultat attendu", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getOrientation method, of class Pacman.
     */
    @Test
    public void testGetOrientation() {
        System.out.println("getOrientation");
        
        Orientation expResult = Orientation.UP;
        Orientation result = P.getOrientation();
        assertEquals("Orientation différente", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
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
        
        assertEquals("Coordonnées x différentes.", x, C.getX());
        assertEquals("Coordonnées y différentes.", y, C.getY());
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setOrientation method, of class Pacman.
     */
    @Test
    public void testSetOrientation() {
        System.out.println("setOrientation");
        Orientation orientation = Orientation.DOWN;
       
        P.setOrientation(orientation);
        assertEquals("Orientation différente.", Orientation.DOWN, P.getOrientation());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setScore method, of class Pacman.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 45;
        
        P.setScore(score);
        assertEquals("Score différent.", score, P.getScore());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setGhostScore method, of class Pacman.
     */
    @Test
    public void testSetGhostScore() {
        System.out.println("setGhostScore");
        int score = 89;
        
        P.setGhostScore(score);
        assertEquals("score différent.", score, P.getGhostScore());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
