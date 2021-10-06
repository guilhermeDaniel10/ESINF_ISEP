/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeriodicTable;

import Tree.BST;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public class TreesPesquisaPorCamposTest {

    ReadFile r = new ReadFile();

    public TreesPesquisaPorCamposTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        r.readElements("Periodic Table of Elements.csv");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of cleanTree method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testCleanTree() {
        System.out.println("cleanTree");
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        instance.cleanTree();
        TreesPesquisaPorCampos empty = new TreesPesquisaPorCampos();
        assertEquals(empty, instance);
    }

    /**
     * Test of insertByAtomicNumber method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testInsertByAtomicNumber() {
        System.out.println("insertByAtomicNumber");
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        instance.insertByAtomicNumber();

        // Teste para o tamanho da árvore
        assertEquals(118, instance.size());

        //copia o inOrder para uma lista
        List<Element> list = new ArrayList<>();
        instance.inOrder().iterator().forEachRemaining(list::add);

        // Teste para o elemento mais à esquerda que deverá ser o hidrogénio com número atómico 1
        //tendo em conta que é o elemento com menor
        // número atómico, e sabe-se que na travessia inOrder, o primeiro elemento é o menor de todos
        assertEquals(1, list.get(0).getAtomicNumber());

        // Teste para o elemento mais à direita que deverá ser o Ununoctium com númeor atómico 118
        assertEquals(118, list.get(list.size() - 1).getAtomicNumber());

    }

    /**
     * Test of insertByElementName method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testInsertByElementName() {
        System.out.println("insertByElementName");
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        instance.insertByAtomicNumber();

        // Teste para o tamanho da árvore
        assertEquals(118, instance.size());

        //copia o inOrder para uma lista
        List<Element> list = new ArrayList<>();
        instance.inOrder().iterator().forEachRemaining(list::add);

        // Teste para o elemento mais à esquerda que deverá ser o hidrogénio
        //tendo em conta que é o elemento com menor
        // número atómico, e sabe-se que na travessia inOrder, o primeiro elemento é o menor de todos
        assertEquals("Hydrogen", list.get(0).getElementName());

        // Teste para o elemento mais à direita que deverá ser o Ununoctium com nome Ununoctioum
        assertEquals("Ununoctium ", list.get(list.size() - 1).getElementName());
    }

    /**
     * Test of insertByElementSymbol method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testInsertByElementSymbol() {
        System.out.println("insertByElementSymbol");
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        instance.insertByAtomicNumber();

        // Teste para o tamanho da árvore
        assertEquals(118, instance.size());

        //copia o inOrder para uma lista
        List<Element> list = new ArrayList<>();
        instance.inOrder().iterator().forEachRemaining(list::add);

        // Teste para o elemento mais à esquerda que deverá ser o hidrogénio com símbolo H
        //tendo em conta que é o elemento com menor
        // número atómico, e sabe-se que na travessia inOrder, o primeiro elemento é o menor de todos
        assertEquals("H", list.get(0).getSymbol());

        // Teste para o elemento mais à direita que deverá ser o Ununoctium com símbolo Uuo
        assertEquals("Uuo ", list.get(list.size() - 1).getSymbol());
    }

    /**
     * Test of insertByAtomicMass method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testInsertByAtomicMass() {
        System.out.println("insertByAtomicMass");
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        instance.insertByAtomicNumber();

        // Teste para o tamanho da árvore
        assertEquals(118, instance.size());

        //copia o inOrder para uma lista
        List<Element> list = new ArrayList<>();
        instance.inOrder().iterator().forEachRemaining(list::add);

        // Teste para o elemento mais à esquerda que deverá ser o hidrogénio com mass atómica 1.008
        //tendo em conta que é o elemento com menor
        // número atómico, e sabe-se que na travessia inOrder, o primeiro elemento é o menor de todos
        assertEquals(1.008, list.get(0).getAtomicMass(), 0.02);

        // Teste para o elemento mais à direita que deverá ser o Ununoctium com massa atómica 294.214
        assertEquals(294.214, list.get(list.size() - 1).getAtomicMass(), 0.02);
    }

    /**
     * Test of searchAtomicNumber method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testSearchAtomicNumber() {
        System.out.println("searchAtomicNumber");
        //Nickel
        int atomicNumber = 28;
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        BST.Node<Element> node1 = instance.searchAtomicNumber(atomicNumber);
        
        assertEquals("Nickel", node1.getElement().getElementName());
        
        //Strontium
        atomicNumber = 38;
        BST.Node<Element> node2 = instance.searchAtomicNumber(atomicNumber);
        
        assertEquals("Strontium", node2.getElement().getElementName());
        
        //null
        atomicNumber = 0;
        BST.Node<Element> node3 = instance.searchAtomicNumber(atomicNumber);
        assertEquals(null, node3);
    }

    /**
     * Test of searchElementName method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testSearchElementName() {
        System.out.println("searchElementName");
       
        String elementname = "Copper";
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        BST.Node<Element> node1 = instance.searchElementName(elementname);
        
        assertEquals("Copper", node1.getElement().getElementName());
        

        elementname = "Praseodymium";
        BST.Node<Element> node2 = instance.searchElementName(elementname);
        
        assertEquals("Praseodymium", node2.getElement().getElementName());
        
        //null
        elementname = "";
        BST.Node<Element> node3 = instance.searchElementName(elementname);
        assertEquals(null, node3);

    }

    /**
     * Test of searchSymbol method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testSearchSymbol() {
        System.out.println("searchSymbol");
        //Cobalt
        String elementSymbol = "Co";
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        BST.Node<Element> node1 = instance.searchSymbol(elementSymbol);
        assertEquals("Cobalt", node1.getElement().getElementName());
        
        //Gadolinium
        elementSymbol = "Gd";
        BST.Node<Element> node2 = instance.searchSymbol(elementSymbol);
        assertEquals("Gadolinium", node2.getElement().getElementName());
        
        //null
        elementSymbol = "";
        BST.Node<Element> node3 = instance.searchSymbol(elementSymbol);
        assertEquals(null, node3);
    }

    /**
     * Test of searchAtomicMass method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testSearchAtomicMass() {
        System.out.println("searchAtomicMass");
        //Calcium
        double atomicMass = 40.08;
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        BST.Node<Element> node1 = instance.searchAtomicMass(atomicMass);
        assertEquals("Calcium", node1.getElement().getElementName());
        
        //Cadmium
        atomicMass = 112.41;
        BST.Node<Element> node2 = instance.searchAtomicMass(atomicMass);
        assertEquals("Cadmium", node2.getElement().getElementName());
        
        //null
        atomicMass = 0;
        BST.Node<Element> node3 = instance.searchAtomicMass(atomicMass);
        assertEquals(null, node3);
    }
    
      /**
     * Test of searchByRange method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testSearchByRange() throws IOException {
        System.out.println("searchByRange");
        
        ReadFile r = new ReadFile();
        r.readElements("Testes Unitarios All.csv");
        
        ReadFile teste = new ReadFile();
        teste.readElements("Testes Unitarios.csv");
        
        int min = 20;
        int max = 65;
        
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        List<Element> expResult = teste.getElementsList();
        Collections.sort(expResult, new compareByDiscovererAndYearOfDiscovery());
            
        List<Element> result = instance.searchByRange(min, max);
        
        Iterator<Element> itResult = result.iterator();
        
        Iterator<Element> itExpected = expResult.iterator();

        while(itResult.hasNext() && itExpected.hasNext()){
            int resultado = itResult.next().compareTo(itExpected.next());
            assertEquals(resultado, 0);
        }
    }

    /**
     * Test of summaryListByTypeAndPhase method, of class TreesPesquisaPorCampos.
     */
    @Test
    public void testSummaryListByTypeAndPhase() throws IOException {
        System.out.println("summaryListByTypeAndPhase");
        
        ReadFile r = new ReadFile();
        r.readElements("Periodic Table of Elements.csv");
        
        ReadFile teste = new ReadFile();
        teste.readElements("Testes Unitarios.csv");
        
        int min = 20;
        int max = 65;
        
        TreesPesquisaPorCampos instance = new TreesPesquisaPorCampos(r.getElementsList());
        
        List<Element> suporter = teste.getElementsList();
        Collections.sort(suporter, new compareByDiscovererAndYearOfDiscovery());
        Map<String, Map<String, Integer>> expResult = new LinkedHashMap<>();
        
        expResult.put("Transition Metal", new LinkedHashMap<>());
        expResult.get("Transition Metal").put("solid", 9);
        
        expResult.put("Metalloid", new LinkedHashMap<>());
        expResult.get("Metalloid").put("solid", 1);
         
        expResult.put("Alkaline Earth Metal", new LinkedHashMap<>());
        expResult.get("Alkaline Earth Metal").put("solid", 2);
        
        expResult.put("Nonmetal", new LinkedHashMap<>());
        expResult.get("Nonmetal").put("solid", 2);
        
        expResult.put("Alkali Metal", new LinkedHashMap<>());
        expResult.get("Alkali Metal").put("solid", 2);
        
        expResult.put("Noble Gas", new LinkedHashMap<>());
        expResult.get("Noble Gas").put("gas", 2);
        
        expResult.put("Halogen", new LinkedHashMap<>());
        expResult.get("Halogen").put("gas", 1);
        
        expResult.put("Metal", new LinkedHashMap<>());
        expResult.get("Metal").put("solid", 1);
        
        List<Element> shorterElementsList = instance.searchByRange(min, max);
        
        Map<String, Map<String, Integer>> result = instance.summaryListByTypeAndPhase(shorterElementsList);
        
        assertEquals(expResult, result);
    }
    
    public class compareByDiscovererAndYearOfDiscovery implements Comparator<Element> {

        @Override
        public int compare(Element e1, Element e2) {
            if (e1.getDiscoverer().compareTo(e2.getDiscoverer()) == 0) {
                if (e1.getYearOfDiscovery() < e2.getYearOfDiscovery()) {
                    return 1;
                }
                if (e1.getYearOfDiscovery() > e2.getYearOfDiscovery()) {
                    return -1;
                }
                return 0;
            }
            return e1.getDiscoverer().compareTo(e2.getDiscoverer());
        }
    }

   

}
