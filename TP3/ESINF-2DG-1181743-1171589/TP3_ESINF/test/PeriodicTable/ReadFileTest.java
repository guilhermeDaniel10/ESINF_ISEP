/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeriodicTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherme
 */
public class ReadFileTest {
    
    public ReadFileTest() {
    }


    /**
     * Test of getElementsList method, of class ReadFile.
     */
    @Test
    public void testGetElementsList() throws IOException {
        System.out.println("getElementsList");
        ReadFile instance = new ReadFile();
        List<Element> expResult = new ArrayList<>();
        // Teste para um excerto de 10 elementos
        Element a = new Element(1,"Hydrogen","H",1.00794,1.008,1,1,"gas","0","Nonmetal",0.012,0.79,2.2,13.5984,0.00008988,14.175,20.28,3,"Cavendish",1766,14.304,"1s1",1,1);
        Element b = new Element(2,"Helium","He",4.002602,4.0026,1,18,"gas","0","Noble Gas",0,0.49,0,24.5874,0.0001785,0,4.22,5,"Janssen",1868,5.193,"1s2",1,18);
        Element c = new Element(3,"Lithium","Li",6.941,7,2,1,"solid","bcc","Alkali Metal",0.76,2.1,0.98,5.3917,0.534,453.85,1615,5,"Arfvedson",1817,3.582,"[He] 2s1",2,1);
        Element d = new Element(4,"Beryllium","Be",9.012182,9.012183,2,2,"solid","hex","Alkaline Earth Metal",0.35,1.4,1.57,9.3227,1.85,1560.15,2742,6,"Vaulquelin",1798,1.825,"[He] 2s2",2,2);
        Element e = new Element(5,"Boron","B",10.811,10.81,2,13,"solid","rho","Metalloid",0.23,1.2,2.04,8.298,2.34,2573.15,4200,6,"Gay-Lussac",1808,1.026,"[He] 2s2 2p1",2,13);
        Element f = new Element(6,"Carbon","C",12.0107,12.011,2,14,"solid","hex","Nonmetal",0,0.91,2.55,11.2603,2.267,3948.15,4300,7,"Prehistoric",0,0.709,"[He] 2s2 2p2",2,14);
        Element g = new Element(7,"Nitrogen","N",14.0067,14.007,2,15,"gas","0","Nonmetal",0.13,0.75,3.04,14.5341,0.0012506,63.29,77.36,8,"Rutherford",1772,1.04,"[He] 2s2 2p3",2,15);
        Element h = new Element(8,"Oxygen","O",15.9994,15.999,2,16,"gas","0","Nonmetal",1.4,0.65,3.44,13.6181,0.001429,50.5,90.2,8,"Priestley/Scheele",1774,0.918,"[He] 2s2 2p4",2,16);
        Element i = new Element(9,"Fluorine","F",18.9984032,18.99840316,2,17,"gas","0","Halogen",1.3,0.57,3.98,17.4228,0.001696,53.63,85.03,6,"Moissan",1886,0.824,"[He] 2s2 2p5",2,17);
        Element j = new Element(10,"Neon","Ne",20.1797,20.18,2,18,"gas","0","Noble Gas",0,0.51,0,21.5645,0.0008999,24.703,27.07,8,"Ramsay and Travers",1898,1.03,"[He] 2s2 2p6",2,18);
        expResult.add(a);
        expResult.add(b);
        expResult.add(c);
        expResult.add(d);
        expResult.add(e);
        expResult.add(f);
        expResult.add(g);
        expResult.add(h);
        expResult.add(i);
        expResult.add(j);
        instance.readElements("Periodic Table of Elements.csv");
        System.out.println(expResult);
        
        List<Element> result = instance.getElementsList();
        List<Element> excerto = new ArrayList<>();
        int count = 0;
        for(Element ele : result){
            if(count == 10)
                break;
            excerto.add(ele);
            count++;
        }
        assertEquals(expResult, excerto);

    }

    /**
     * Test of readElements method, of class ReadFile.
     */
    @Test
    public void testReadElements() throws Exception {
        System.out.println("readElements");
        String filename = "Periodic Table of Elements.csv";
        ReadFile instance = new ReadFile();
        instance.readElements(filename);
        
        // Teste para os 10 primeiros elementos lidos (para não fazer um teste exaustivo)
        List<Element> excertList = new ArrayList<>();
        int count = 0;
        for(Element e : instance.getElementsList()){
            if(count == 10)
                break;
            excertList.add(e);
            count++;
        }
        
        List<Element> expResults = new ArrayList<>();
        Element a = new Element(1,"Hydrogen","H",1.00794,1.008,1,1,"gas","0","Nonmetal",0.012,0.79,2.2,13.5984,0.00008988,14.175,20.28,3,"Cavendish",1766,14.304,"1s1",1,1);
        Element b = new Element(2,"Helium","He",4.002602,4.0026,1,18,"gas","0","Noble Gas",0,0.49,0,24.5874,0.0001785,0,4.22,5,"Janssen",1868,5.193,"1s2",1,18);
        Element c = new Element(3,"Lithium","Li",6.941,7,2,1,"solid","bcc","Alkali Metal",0.76,2.1,0.98,5.3917,0.534,453.85,1615,5,"Arfvedson",1817,3.582,"[He] 2s1",2,1);
        Element d = new Element(4,"Beryllium","Be",9.012182,9.012183,2,2,"solid","hex","Alkaline Earth Metal",0.35,1.4,1.57,9.3227,1.85,1560.15,2742,6,"Vaulquelin",1798,1.825,"[He] 2s2",2,2);
        Element e = new Element(5,"Boron","B",10.811,10.81,2,13,"solid","rho","Metalloid",0.23,1.2,2.04,8.298,2.34,2573.15,4200,6,"Gay-Lussac",1808,1.026,"[He] 2s2 2p1",2,13);
        Element f = new Element(6,"Carbon","C",12.0107,12.011,2,14,"solid","hex","Nonmetal",0,0.91,2.55,11.2603,2.267,3948.15,4300,7,"Prehistoric",0,0.709,"[He] 2s2 2p2",2,14);
        Element g = new Element(7,"Nitrogen","N",14.0067,14.007,2,15,"gas","0","Nonmetal",0.13,0.75,3.04,14.5341,0.0012506,63.29,77.36,8,"Rutherford",1772,1.04,"[He] 2s2 2p3",2,15);
        Element h = new Element(8,"Oxygen","O",15.9994,15.999,2,16,"gas","0","Nonmetal",1.4,0.65,3.44,13.6181,0.001429,50.5,90.2,8,"Priestley/Scheele",1774,0.918,"[He] 2s2 2p4",2,16);
        Element i = new Element(9,"Fluorine","F",18.9984032,18.99840316,2,17,"gas","0","Halogen",1.3,0.57,3.98,17.4228,0.001696,53.63,85.03,6,"Moissan",1886,0.824,"[He] 2s2 2p5",2,17);
        Element j = new Element(10,"Neon","Ne",20.1797,20.18,2,18,"gas","0","Noble Gas",0,0.51,0,21.5645,0.0008999,24.703,27.07,8,"Ramsay and Travers",1898,1.03,"[He] 2s2 2p6",2,18);
        expResults.add(a);
        expResults.add(b);
        expResults.add(c);
        expResults.add(d);
        expResults.add(e);
        expResults.add(f);
        expResults.add(g);
        expResults.add(h);
        expResults.add(i);
        expResults.add(j);
        
        assertEquals(excertList, expResults);
        
        //caso o ficheiro seja inválido
        filename = "abcdef";
        instance = new ReadFile();
        instance.readElements(filename);
        
        assertEquals(new ArrayList<>(),instance.getElementsList());
    }
    
}
