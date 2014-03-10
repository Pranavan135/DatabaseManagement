/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.entity;

import java.util.Date;
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
public class CoachTest {
    
    public CoachTest() {
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
     * Test of getRegNo method, of class Coach.
     */
    @Test
    public void testGetRegNo() {
        System.out.println("getRegNo");
        Coach instance = new Coach();
        int expResult = 0;
        int result = instance.getRegNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegNo method, of class Coach.
     */
    @Test
    public void testSetRegNo() {
        System.out.println("setRegNo");
        int regNo = 0;
        Coach instance = new Coach();
        instance.setRegNo(regNo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCapacity method, of class Coach.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Coach instance = new Coach();
        int expResult = 0;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCapacity method, of class Coach.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int capacity = 0;
        Coach instance = new Coach();
        instance.setCapacity(capacity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastServiceDate method, of class Coach.
     */
    @Test
    public void testGetLastServiceDate() {
        System.out.println("getLastServiceDate");
        Coach instance = new Coach();
        Date expResult = null;
        Date result = instance.getLastServiceDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastServiceDate method, of class Coach.
     */
    @Test
    public void testSetLastServiceDate() {
        System.out.println("setLastServiceDate");
        Date lastServiceDate = null;
        Coach instance = new Coach();
        instance.setLastServiceDate(lastServiceDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastServiceMileage method, of class Coach.
     */
    @Test
    public void testGetLastServiceMileage() {
        System.out.println("getLastServiceMileage");
        Coach instance = new Coach();
        Double expResult = null;
        Double result = instance.getLastServiceMileage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastServiceMileage method, of class Coach.
     */
    @Test
    public void testSetLastServiceMileage() {
        System.out.println("setLastServiceMileage");
        Double lastServiceMileage = null;
        Coach instance = new Coach();
        instance.setLastServiceMileage(lastServiceMileage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTours method, of class Coach.
     */
    @Test
    public void testGetTours() {
        System.out.println("getTours");
        Coach instance = new Coach();
        Set expResult = null;
        Set result = instance.getTours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTours method, of class Coach.
     */
    @Test
    public void testSetTours() {
        System.out.println("setTours");
        Set tours = null;
        Coach instance = new Coach();
        instance.setTours(tours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
