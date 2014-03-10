/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.entity;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pranavan
 */
public class DriverTest {
    
    public DriverTest() {
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
     * Test of getId method, of class Driver.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Driver instance = new Driver();
        DriverId expResult = null;
        DriverId result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Driver.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        DriverId id = null;
        Driver instance = new Driver();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Driver.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Driver instance = new Driver();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Driver.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Driver instance = new Driver();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTpNo method, of class Driver.
     */
    @Test
    public void testGetTpNo() {
        System.out.println("getTpNo");
        Driver instance = new Driver();
        String expResult = "";
        String result = instance.getTpNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTpNo method, of class Driver.
     */
    @Test
    public void testSetTpNo() {
        System.out.println("setTpNo");
        String tpNo = "";
        Driver instance = new Driver();
        instance.setTpNo(tpNo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDriverRoutes method, of class Driver.
     */
    @Test
    public void testGetDriverRoutes() {
        System.out.println("getDriverRoutes");
        Driver instance = new Driver();
        Set expResult = null;
        Set result = instance.getDriverRoutes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDriverRoutes method, of class Driver.
     */
    @Test
    public void testSetDriverRoutes() {
        System.out.println("setDriverRoutes");
        Set driverRoutes = null;
        Driver instance = new Driver();
        instance.setDriverRoutes(driverRoutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTours method, of class Driver.
     */
    @Test
    public void testGetTours() {
        System.out.println("getTours");
        Driver instance = new Driver();
        Set expResult = null;
        Set result = instance.getTours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTours method, of class Driver.
     */
    @Test
    public void testSetTours() {
        System.out.println("setTours");
        Set tours = null;
        Driver instance = new Driver();
        instance.setTours(tours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
