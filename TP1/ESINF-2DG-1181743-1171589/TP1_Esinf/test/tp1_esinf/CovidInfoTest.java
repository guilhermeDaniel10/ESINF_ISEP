/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_esinf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guilhermedaniel
 */
public class CovidInfoTest {

    LinkedHashMap<Country, Set<Data>> m;
    public CovidInfoTest() throws FileNotFoundException, IOException, Exception {
         m = new LinkedHashMap();
        CovidInfo covid = new CovidInfo();
        BufferedReader reader = new BufferedReader(new FileReader("owid-covid-data.csv"));
        List<String> l = new ArrayList<>();

        reader.readLine();
        String line1 = null;

        CovidInfo instance = new CovidInfo();
        instance = new CovidInfo();

        while ((line1 = reader.readLine()) != null) {
            l.add(line1);
        }
        covid.readCountries(l);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of readCountries method, of class CovidInfo.
     */
    @Test
    public void testReadCountries() throws Exception {
        System.out.println("readCountries");

        LinkedHashMap<Country, Set<Data>> map = new LinkedHashMap();
        String cvsName = "testReadCountries.csv";
        CovidInfo result = new CovidInfo();

        result.readCountries(ReadCSVtoString(cvsName));
        
        Country af = new Country("\"AFG\"","\"Asia\"","\"Afghanistan\"",38928341,2.581,597.029,9.59,0,0,0.5,64.83);
        Data d1 = new Data("2020-01-01",0,0,0,0,0,0);
        Data d2 = new Data("2020-01-02",0,0,0,0,0,0);
        
        TreeSet d = new TreeSet();
        d.add(d1);
        d.add(d2);
        
        LinkedHashMap<Country, Set<Data>> expected = new LinkedHashMap();
        expected.put(af, d);
        
        
        assertEquals(result.m, expected);  
    }

    /**
     * Test of ordem50Mil method, of class CovidInfo.
     */
    @Test
    public void testOrdem50Mil() throws IOException, Exception {
        System.out.println("ordem50Mil");
        CovidInfo instance = new CovidInfo();
        String cvsName = "testOrdem50Mil.csv"; 
        LocalDate first = LocalDate.of(2020, Month.JANUARY, 1);
        
        instance.readCountries(ReadCSVtoString(cvsName));
        							
        Country chn = new Country("CHN","Asia","China",1439323774,10.641,261.899,9.74,1.9,48.4,4.34,76.91);
        Data dchn = new Data("2020-02-13",59865,15141,1368,254,0,0);
        					
        Country fra = new Country("FRA","Europe","France",65273512,19.718,86.06,4.77,30.1,35.6,5.98,82.66);
        Data dfra = new Data("2020-04-01",52128,7578,3523,499,0,0);
        
        Country usa = new Country("USA","North America","United States",331002647,15.413,151.089,10.79,19.1,24.6,2.77,78.86);
        Data dusa = new Data("2020-03-25",55231,8789,801,211,101391,683028);
        
        CovidInfo.Sorter s1 = instance.new Sorter(chn,dchn,(int) Duration.between(first.atStartOfDay(), dchn.getDate().atStartOfDay()).toDays());
        CovidInfo.Sorter s2 = instance.new Sorter(usa,dusa,(int) Duration.between(first.atStartOfDay(), dusa.getDate().atStartOfDay()).toDays());
        CovidInfo.Sorter s3 = instance.new Sorter(fra,dfra,(int) Duration.between(first.atStartOfDay(), dfra.getDate().atStartOfDay()).toDays());
        
        List<CovidInfo.Sorter> expResult = new ArrayList<>();
        
        expResult.add(s1);
        expResult.add(s2);
        expResult.add(s3);
        
        List<CovidInfo.Sorter> result = instance.ordem50Mil();
        assertEquals(expResult, result);
    }

    /**
     * Test of continenteMes method, of class CovidInfo.
     */
    @Test
    public void testContinenteMes() throws IOException, Exception {
        System.out.println("continenteMes");
        CovidInfo instance = new CovidInfo();
        String cvsName = "testContinenteMes.csv"; 
        
        instance.readCountries(ReadCSVtoString(cvsName));
        
        String africa = "Africa";
//        String asia = "Asia";
//        String europe = "Europe";
        
        Map<String, Map<Integer, Data>> expResult = new LinkedHashMap<>();
        
        Data data1 = new Data(LocalDate.now().toString(),0,0);
        Data data2 = new Data(LocalDate.now().toString(),1,0);
        Data data3 = new Data(LocalDate.now().toString(),583,35);
        Data data4 = new Data(LocalDate.now().toString(),3264,409);
        Data data5 = new Data(LocalDate.now().toString(),5419,202);
        Data data6 = new Data(LocalDate.now().toString(),4304,259);
        Data data7 = new Data(LocalDate.now().toString(),16260,295);
        Data data8 = new Data(LocalDate.now().toString(),14315,301);
        Data data9 = new Data(LocalDate.now().toString(),7067,218);
        
        
        expResult.put(africa, new LinkedHashMap());
            expResult.get(africa).put(1, data1);
            expResult.get(africa).put(2, data2);
            expResult.get(africa).put(3, data3);
            expResult.get(africa).put(4, data4);
            expResult.get(africa).put(5, data5);
            expResult.get(africa).put(6, data6);
            expResult.get(africa).put(7, data7);
            expResult.get(africa).put(8, data8);
            expResult.get(africa).put(9, data9);
        
        Map<String, Map<Integer, Data>> result = instance.continenteMes();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of novosCasos method, of class CovidInfo.
     */
    @Test
    public void testNovosCasos() throws IOException, Exception {
        System.out.println("novosCasos");
        int month = 9;
        String continent = "Europe";
        String cvsName = "testNovosCasos.csv"; 
        CovidInfo instance = new CovidInfo();
        
        instance.readCountries(ReadCSVtoString(cvsName));
        
        Map<Integer, LinkedHashMap<String, Integer>> expResult = new LinkedHashMap<>();     
        expResult.put(1, new LinkedHashMap());
            expResult.get(1).put("Spain", 8115);
            expResult.get(1).put("France", 3082);
        expResult.put(2, new LinkedHashMap());
            expResult.get(2).put("Spain", 8581);
            expResult.get(2).put("France", 4982);
        expResult.put(3, new LinkedHashMap());
            expResult.get(3).put("Spain", 8959);
            expResult.get(3).put("France", 7017);
        expResult.put(4, new LinkedHashMap());
            expResult.get(4).put("Spain", 10476);
            expResult.get(4).put("France", 7157);
        expResult.put(5, new LinkedHashMap()); 
            expResult.get(5).put("France", 8975);
            expResult.get(5).put("Spain", 0);
        expResult.put(6, new LinkedHashMap());
            expResult.get(6).put("France", 8550);
            expResult.get(6).put("Spain", 0);
        expResult.put(7, new LinkedHashMap());
            expResult.get(7).put("Spain", 26560);
            expResult.get(7).put("France", 7071);
        expResult.put(8, new LinkedHashMap());
            expResult.get(8).put("Spain", 8964);
            expResult.get(8).put("France", 4203);
        expResult.put(9, new LinkedHashMap());
            expResult.get(9).put("Spain", 8866);
            expResult.get(9).put("France", 6544);
        expResult.put(10, new LinkedHashMap());
            expResult.get(10).put("Spain", 10764);
            expResult.get(10).put("France", 8577);
        expResult.put(11, new LinkedHashMap());
            expResult.get(11).put("Spain", 12183);
            expResult.get(11).put("France", 9843);
        expResult.put(12, new LinkedHashMap());
            expResult.get(12).put("France", 9406);
            expResult.get(12).put("Spain", 0);
        expResult.put(13, new LinkedHashMap());
            expResult.get(13).put("France", 10561);
            expResult.get(13).put("Spain", 0);
        expResult.put(14, new LinkedHashMap());
            expResult.get(14).put("Spain", 27404);
            expResult.get(14).put("France", 7183);
        expResult.put(15, new LinkedHashMap());
            expResult.get(15).put("Spain", 9437);
            expResult.get(15).put("France", 6158);
        expResult.put(16, new LinkedHashMap());
            expResult.get(16).put("Spain", 11193);
            expResult.get(16).put("France", 7852);
        expResult.put(17, new LinkedHashMap());
            expResult.get(17).put("Spain", 11291);
            expResult.get(17).put("France", 9784);
        expResult.put(18, new LinkedHashMap());
            expResult.get(18).put("Spain", 14389);
            expResult.get(18).put("France", 10593);
        expResult.put(19, new LinkedHashMap());
            expResult.get(19).put("France", 13215);
            expResult.get(19).put("Spain", 0);
        expResult.put(20, new LinkedHashMap());
            expResult.get(20).put("France", 13498);
            expResult.get(20).put("Spain", 0);
        expResult.put(21, new LinkedHashMap());
            expResult.get(21).put("Spain", 31428);
            expResult.get(21).put("France", 11569);
        expResult.put(22, new LinkedHashMap());
            expResult.get(22).put("Spain", 10799);
            expResult.get(22).put("France", 4298);
        expResult.put(23, new LinkedHashMap());
            expResult.get(23).put("Spain", 11289);
            expResult.get(23).put("France", 10008);
        expResult.put(24, new LinkedHashMap());
            expResult.get(24).put("France", 13072);
            expResult.get(24).put("Spain", 10653);
        expResult.put(25, new LinkedHashMap());
            expResult.get(25).put("France", 16096);
            expResult.get(25).put("Spain", 12272);
        expResult.put(26, new LinkedHashMap());
            expResult.get(26).put("France", 15797);
            expResult.get(26).put("Spain", 0);
        expResult.put(27, new LinkedHashMap());
            expResult.get(27).put("France", 14412);
            expResult.get(27).put("Spain", 0);
        expResult.put(28, new LinkedHashMap());
            expResult.get(28).put("Spain", 31785);
            expResult.get(28).put("France", 11123);
        expResult.put(29, new LinkedHashMap());
            expResult.get(29).put("France", 4070);
            
        Map<Integer, LinkedHashMap<String, Integer>> result = instance.novosCasos(month, continent);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of novasMortes method, of class CovidInfo.
     */
    @Test
    public void testNovasMortes() throws IOException, Exception {
        System.out.println("novasMortes");
        String cvsName = "testNovasMortes.csv"; 
        CovidInfo instance = new CovidInfo();
        
        instance.readCountries(ReadCSVtoString(cvsName));

        
        String chile = "Chile";
        double fumC = 75.7;
        int mortesC = 12698;
        
        CovidInfo.SortNewDeaths sC =  instance.new SortNewDeaths(chile, fumC, mortesC);
        
        String bulgaria = "Bulgaria";
        double fumB = 74.5;
        int mortesB = 807;
        
        CovidInfo.SortNewDeaths sB =  instance.new SortNewDeaths(bulgaria, fumB, mortesB);

        String greece = "Greece";
        double fumG = 87.3;
        int mortesG = 383;
        
        CovidInfo.SortNewDeaths sG =  instance.new SortNewDeaths(greece, fumG, mortesG);
        
        List<CovidInfo.SortNewDeaths> expResult = new ArrayList<>() ;
        
        expResult.add(sC);
        expResult.add(sB);
        expResult.add(sG);
        
        List<CovidInfo.SortNewDeaths> result = instance.novasMortes();
        
        assertEquals(expResult, result);
        
        
        
    }

    public List<String> ReadCSVtoString(String cvsName) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cvsName));
        List<String> l = new ArrayList<>();

        reader.readLine();
        String line1 = null;
        while ((line1 = reader.readLine()) != null) {
            l.add(line1);
        } 
        return l;
    }

}
