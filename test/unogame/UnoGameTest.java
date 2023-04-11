/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package unogame;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dell
 */
public class UnoGameTest {
    
    public UnoGameTest() {
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
     * Test of isGameEnd method, of class UnoGame.
     */
//    @Test
//    public void testIsGameEnd() {
//        System.out.println("isGameEnd");
//        UnoGame instance = new UnoGame();
//        boolean expResult = false;
//        boolean result = instance.isGameEnd();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       // fail("The test case is a prototype.");
//    }
@Test
public void testIsGameEndGood() {
    System.out.println("IsGameEnd Good");

    UnoGame instance = new UnoGame();
    boolean result = instance.isGameEnd();
    assertFalse(result); // game should not end initially
}

@Test
public void testIsGameEndBad() {
    System.out.println("IsGameEnd Bad");

    try {
        UnoGame instance = null;
        boolean result = instance.isGameEnd();
        fail("Expected NullPointerException to be thrown");
    } catch (NullPointerException e) {
        // expected exception thrown, test passed
    }
}

@Test
public void testIsGameEndBoundary() {
    System.out.println("IsGameEnd boundary");

    UnoGame instance = new UnoGame();
    for (int i = 0; i < 500; i++) {
        assertFalse(instance.isGameEnd()); // game should not end initially
        instance.play(); // play until game ends
    }
    assertTrue(instance.isGameEnd()); // game should end after a while
}

    /**
     * Test of hasPlayer method, of class UnoGame.
     */
//    @Test
//    public void testHasPlayer() {
//        System.out.println("hasPlayer");
//        Player player = null;
//        UnoGame instance = new UnoGame();
//        boolean expResult = false;
//        boolean result = instance.hasPlayer(player);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    @Test
    public void testHasPlayerBoundary() {
    System.out.println("hasPlayer boundary");
    Player player1 = new Player("Alice");
    UnoGame instance = new UnoGame();
    instance.addPlayer(player1);
    boolean expResult = true;
    boolean result = instance.hasPlayer(player1);
    assertEquals(expResult, result);
}
    @Test
    public void testHasPlayerBad() {
    System.out.println("hasPlayer bad");
    Player player1 = new Player("Alice");
    Player player2 = new Player("Bob");
    UnoGame instance = new UnoGame();
    instance.addPlayer(player1);
    boolean expResult = false;
    boolean result = instance.hasPlayer(player2);
    assertEquals(expResult, result);
}
    @Test
    public void testHasPlayerGood() {
    System.out.println("hasPlayer good");
    Player player = new Player("Alice");
    UnoGame instance = new UnoGame();
    instance.addPlayer(player);
    boolean expResult = true;
    boolean result = instance.hasPlayer(player);
    assertEquals(expResult, result);
}


    /**
     * Test of canPlay method, of class UnoGame.
     */
    @Test
public void testCanPlayGood() {
    Player player = new Player("John");
    player.addCard(new Card("red", 5));
    player.addCard(new Card("blue", 7));
    UnoGame instance = new UnoGame();
    boolean result = instance.canPlay(player);
    assertTrue(result);
    System.out.println("testCanPlayGood: PASSED");
}
@Test
public void testCanPlayBoundary() {
    Player player = new Player("John");
    player.addCard(new Card("red", 5));
    UnoGame instance = new UnoGame();
    boolean result = instance.canPlay(player);
    assertTrue(result);
    System.out.println("testCanPlayBoundary: PASSED");
}
@Test
public void testCanPlayBad() {
    Player player = new Player("John");
    UnoGame instance = new UnoGame();
    boolean result = instance.canPlay(player);
    assertFalse(result);
    System.out.println("testCanPlayBad: PASSED");
}


    /**
     * Test of addPlayer method, of class UnoGame.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player player = null;
        UnoGame instance = new UnoGame();
        instance.addPlayer(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startGame method, of class UnoGame.
     */
    @Test
    public void testStartGame() {
        System.out.println("startGame");
        UnoGame instance = new UnoGame();
        instance.startGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class UnoGame.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        UnoGame.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getPlayers method, of class UnoGame.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        UnoGame instance = new UnoGame();
        List<Player> expResult = null;
        List<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
