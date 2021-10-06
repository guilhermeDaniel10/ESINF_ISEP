/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_esinf;

import java.util.Objects;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guilhermedaniel
 */
public class CountryTest {
    
    Country instance = new Country("PRT", "Europe", "Portugal", 10196707, 21.502, 127.842, 9.85, 16.3, 30, 3.39, 82.05);

    public CountryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of toString method, of class Country.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Country{" + "isoCode=" + "PRT" + ", continent=" + "Europe" + ", name=" + "Portugal" + ", population=" + 10196707 + ", aged65Older=" + 21.502 + ", cardiovascularDeathRate=" + 127.842 + ", diabetesPrevelance=" + 9.85 + ", femaleSmokers=" + 16.3 + ", maleSmokers=30.0" + ", hospitalThousand=" + 3.39 + ", lifeExpectancy=" + 82.05 + '}';
        String result = instance.toString();
        System.out.println("exp: " + expResult);
        System.out.println("rs: " + result);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getName method, of class Country.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Portugal";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsoCode method, of class Country.
     */
    @Test
    public void testGetIsoCode() {
        System.out.println("getIsoCode");
        String expResult = "PRT";
        String result = instance.getIsoCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPopulation method, of class Country.
     */
    @Test
    public void testGetPopulation() {
        System.out.println("getPopulation");
        int expResult = 10196707;
        int result = instance.getPopulation();
        assertEquals(expResult, result);

    }

    /**
     * Test of getContinent method, of class Country.
     */
    @Test
    public void testGetContinent() {
        System.out.println("getContinent");
        String expResult = "Europe";
        String result = instance.getContinent();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAged65Older method, of class Country.
     */
    @Test
    public void testGetAged65Older() {
        System.out.println("getAged65Older");
        double expResult = 21.502;
        double result = instance.getAged65Older();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getHospitalThousand method, of class Country.
     */
    @Test
    public void testGetHospitalThousand() {
        System.out.println("getHospitalThousand");
        double expResult = 3.39;
        double result = instance.getHospitalThousand();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getCardiovascularDeathRate method, of class Country.
     */
    @Test
    public void testGetCardiovascularDeathRate() {
        System.out.println("getCardiovascularDeathRate");
        double expResult = 127.842;
        double result = instance.getCardiovascularDeathRate();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getDiabetesPrevelance method, of class Country.
     */
    @Test
    public void testGetDiabetesPrevelance() {
        System.out.println("getDiabetesPrevelance");
        double expResult = 9.85;
        double result = instance.getDiabetesPrevelance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFemaleSmokers method, of class Country.
     */
    @Test
    public void testGetFemaleSmokers() {
        System.out.println("getFemaleSmokers");
        double expResult = 16.3;
        double result = instance.getFemaleSmokers();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMaleSmokers method, of class Country.
     */
    @Test
    public void testGetMaleSmokers() {
        System.out.println("getMaleSmokers");
        double expResult = 30.0;
        double result = instance.getMaleSmokers();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getLifeExpectancy method, of class Country.
     */
    @Test
    public void testGetLifeExpectancy() {
        System.out.println("getLifeExpectancy");
        double expResult = 82.05;
        double result = instance.getLifeExpectancy();
        assertEquals(expResult, result, 0.0);
    }


    /**
     * Test of hashCode method, of class Country.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int hash = 29 * 3 + Objects.hashCode("PRT");
        int expResult = hash;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Country.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Country("PRT", "Europe", "Portugal", 10196707, 21.502, 127.842, 9.85, 16.3, 30, 3.39, 82.05);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);

    }
    
}
