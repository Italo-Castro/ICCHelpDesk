package com.icchelpdesk.sistema.view;

import javax.swing.JDesktopPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Italo
 */
public class PrincipalTest {
    
    public PrincipalTest() {
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
     * Test of getInstance method, of class Principal.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Principal expResult = null;
        Principal result = Principal.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDesktopPane method, of class Principal.
     */
    @Test
    public void testGetDesktopPane() {
        System.out.println("getDesktopPane");
        Principal instance = new Principal();
        JDesktopPane expResult = null;
        JDesktopPane result = instance.getDesktopPane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
