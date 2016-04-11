/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ELEGANT
 */
public class CoinChangeTest {
    
    public CoinChangeTest() {
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
     * Test of greedy method, of class CoinChange.
     */
    @Test
    public void testGreedy() {
        System.out.println("greedy");
        int amount = 6;
        int expResult = 2;
        int result = CoinChange.greedy(amount);
        assertEquals(expResult, result);
    }

    /**
     * Test of dynamic method, of class CoinChange.
     */
    @Test
    public void testDynamic() {
        System.out.println("dynamic");
        int n = 6;
        int[] C = {1,5,10,25};
        int expResult = 2;
        int result = CoinChange.dynamic(n, C);
        assertEquals(expResult, result);
    }
}
