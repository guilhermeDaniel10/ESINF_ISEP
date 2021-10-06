/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_esinf;

import java.time.LocalDate;
import java.time.Month;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guilhermedaniel
 */
public class DataTest {
    
    Data instance = new Data("2020-09-10", 101, 100, 102, 103, 104, 105);
    public DataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getDate method, of class Data.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        
        LocalDate expResult = LocalDate.of(2020, Month.SEPTEMBER, 10);
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTotalCases method, of class Data.
     */
    @Test
    public void testGetTotalCases() {
        System.out.println("getTotalCases");
        int expResult = 101;
        int result = instance.getTotalCases();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNewCases method, of class Data.
     */
    @Test
    public void testGetNewCases() {
        System.out.println("getNewCases");
        int expResult = 100;
        int result = instance.getNewCases();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalDeaths method, of class Data.
     */
    @Test
    public void testGetTotalDeaths() {
        System.out.println("getTotalDeaths");
        int expResult = 102;
        int result = instance.getTotalDeaths();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNewDeaths method, of class Data.
     */
    @Test
    public void testGetNewDeaths() {
        System.out.println("getNewDeaths");
        int expResult = 103;
        int result = instance.getNewDeaths();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNewTests method, of class Data.
     */
    @Test
    public void testGetNewTests() {
        System.out.println("getNewTests");
        int expResult = 104;
        int result = instance.getNewTests();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTotalTests method, of class Data.
     */
    @Test
    public void testGetTotalTests() {
        System.out.println("getTotalTests");
        int expResult = 105;
        int result = instance.getTotalTests();
        assertEquals(expResult, result);

    }

  

    /**
     * Test of equals method, of class Data.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Data("2020-09-10", 101, 100, 102, 103, 104, 105);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Data.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Data{" + "date=" + "2020-09-10" + ", totalCases=" + 101 + ", newCases=" + 100 + ", totalDeaths=" + 102 + ", newDeaths=" + 103 + ", newTests=" + 104 + ", totalTests=" + 105 + '}' + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of compareTo method, of class Data.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Data o = new Data("2020-09-15", 101, 100, 102, 103, 104, 105);
        int expResult = -5;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
 
    }
    
}
