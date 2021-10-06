/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeriodicTable;

import Tree.AVL;
import Tree.BST;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
public class TreeElectronConfigurationTest {

    ReadFile r = new ReadFile();

    public TreeElectronConfigurationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws IOException {

        r.readElements("Periodic Table of Elements.csv");
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of cleanTree method, of class TreeElectronConfiguration.
     */
    @Test
    public void testCleanTree() {
        System.out.println("cleanTree");

        Element a = new Element(1, "Hydrogen", "H", 1.00794, 1.008, 1, 1, "gas", "0", "Nonmetal", 0.012, 0.79, 2.2, 13.5984, 0.00008988, 14.175, 20.28, 3, "Cavendish", 1766, 14.304, "1s1", 1, 1);
        Element b = new Element(2, "Helium", "He", 4.002602, 4.0026, 1, 18, "gas", "0", "Noble Gas", 0, 0.49, 0, 24.5874, 0.0001785, 0, 4.22, 5, "Janssen", 1868, 5.193, "1s2", 1, 18);
        Element c = new Element(3, "Lithium", "Li", 6.941, 7, 2, 1, "solid", "bcc", "Alkali Metal", 0.76, 2.1, 0.98, 5.3917, 0.534, 453.85, 1615, 5, "Arfvedson", 1817, 3.582, "[He] 2s1", 2, 1);
        List<Element> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        TreeElectronConfiguration instance = new TreeElectronConfiguration(list);
        instance.cleanTree();

        assertEquals(null, instance.root);

    }

    /**
     * Test of createTree method, of class TreeElectronConfiguration.
     */
    @Test
    public void testCreateTree() throws IOException {
        System.out.println("createTree");
        TreeElectronConfiguration instance = new TreeElectronConfiguration(r.getElementsList());
        instance.createTree();

        // Verifica se o tamanho da árvore é igual ao número de elementos- existem 95 elementos com configurações
        // eletrónicas válidas
        assertEquals(95, instance.size());

        // Para um excerto de 4 elementos
        List<Element> list = new ArrayList<>();
        Element a = new Element(1, "Hydrogen", "H", 1.00794, 1.008, 1, 1, "gas", "0", "Nonmetal", 0.012, 0.79, 2.2, 13.5984, 0.00008988, 14.175, 20.28, 3, "Cavendish", 1766, 14.304, "1s1", 1, 1);
        Element b = new Element(2, "Helium", "He", 4.002602, 4.0026, 1, 18, "gas", "0", "Noble Gas", 0, 0.49, 0, 24.5874, 0.0001785, 0, 4.22, 5, "Janssen", 1868, 5.193, "1s2", 1, 18);
        Element c = new Element(3, "Lithium", "Li", 6.941, 7, 2, 1, "solid", "bcc", "Alkali Metal", 0.76, 2.1, 0.98, 5.3917, 0.534, 453.85, 1615, 5, "Arfvedson", 1817, 3.582, "[He] 2s1", 2, 1);
        Element d = new Element(4, "Beryllium", "Be", 9.012182, 9.012183, 2, 2, "solid", "hex", "Alkaline Earth Metal", 0.35, 1.4, 1.57, 9.3227, 1.85, 1560.15, 2742, 6, "Vaulquelin", 1798, 1.825, "[He] 2s2", 2, 2);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        TreeElectronConfiguration instance2 = new TreeElectronConfiguration(list);
        instance2.createTree();

        // Todas as configurações dos 4 elementos são válidas
        assertEquals(4, instance2.size());

        // Lista sem valores
        TreeElectronConfiguration instance3 = new TreeElectronConfiguration(new ArrayList<>());
        instance3.createTree();
        assertEquals(0, instance3.size());
    }

    /**
     * Test of insertWithIncrement method, of class TreeElectronConfiguration.
     */
    @Test
    public void testInsertWithIncrement_EletronicConfigurationAssembler() {
        System.out.println("insertWithIncrement");
        EletronicConfigurationAssembler a = new EletronicConfigurationAssembler("a", 1);
        EletronicConfigurationAssembler b1 = new EletronicConfigurationAssembler("b", 1);
        EletronicConfigurationAssembler b2 = new EletronicConfigurationAssembler("b", 1);
        EletronicConfigurationAssembler c1 = new EletronicConfigurationAssembler("c", 1);
        EletronicConfigurationAssembler c2 = new EletronicConfigurationAssembler("c", 1);
        EletronicConfigurationAssembler c3 = new EletronicConfigurationAssembler("c", 1);

        TreeElectronConfiguration instance = new TreeElectronConfiguration();
        instance.insertWithIncrement(a);
        instance.insertWithIncrement(b1);
        instance.insertWithIncrement(b2);
        instance.insertWithIncrement(c1);
        instance.insertWithIncrement(c2);
        instance.insertWithIncrement(c3);

        // Como se pode ver em cima, o elemento b1 e b2 têm a mesma configuração eletrónica (corresponde ao primeiro
        // parâmetro da instânciação) "b"
        // o elemento c1, c2 e c3 têm a mesma configuração eletrónica "c"
        // logo, o tamanho da árvore tem que ser 3, por haver apenas 3 configurações eletrónicas distintas
        assertEquals(3, instance.size());

        // Adicionar a um map a configuração eletrónica e a ocorrência dos respetivos
        Map<String, Integer> ocorrences = new HashMap<>();
        for (EletronicConfigurationAssembler eca : instance.inOrder()) {
            ocorrences.put(eca.getEletronicConfiguration(), eca.getOcorrences());
        }
        Map<String, Integer> expOcorrences = new HashMap<>();
        expOcorrences.put("a", 1);
        // Há duas ocorrências do elemento b ao criar a árvore
        expOcorrences.put("b", 2);
        // Há três ocorrências do elemento c ao criar a árvore
        expOcorrences.put("c", 3);

        assertEquals(expOcorrences, ocorrences);
    }

    /**
     * Test of orderedTreeMapByEletronicConfigurationRepetition method, of class
     * TreeElectronConfiguration.
     */
    @Test
    public void testorderedTreeMapByEletronicConfigurationRepetition() {
        System.out.println("orderedTreeMapEletronicConfiguration");
//      Resultado esperado na alínea a do Exercício 2
//          32 [[Xe]]
//          18 [[Ar], [Kr]]
//          17 [[Xe] 4f14]
//          9 [[Kr] 4d10, [Rn]]
//          8 [[Ar] 3d10, [He], [Ne], [Xe] 4f14 5d10]
//          7 [[Ar] 3d10 4s2, [He] 2s2, [Kr] 4d10 5s2, [Ne] 3s2, [Xe] 4f14 5d10 6s2]
//          2 [[Ar] 3d5, [Kr] 4d5, [Xe] 4f7]
// Será criada um TreeMap com uma LinkedList com estes resultados esperados, sendo a key o número de repetições 
// e a lista com as configurações os valores do TreeMap
// 
        TreeMap<Integer, LinkedList<String>> expResult = new TreeMap<>();
        LinkedList<String> n32 = new LinkedList<>();
        LinkedList<String> n18 = new LinkedList<>();
        LinkedList<String> n17 = new LinkedList<>();
        LinkedList<String> n9 = new LinkedList<>();
        LinkedList<String> n8 = new LinkedList<>();
        LinkedList<String> n7 = new LinkedList<>();
        LinkedList<String> n2 = new LinkedList<>();
        // 32
        n32.add("[Xe]");
        expResult.put(32, n32);
        // 18
        n18.add("[Ar]");
        n18.add("[Kr]");
        expResult.put(18, n18);
        // 17
        n17.add("[Xe] 4f14");
        expResult.put(17, n17);
        // 9
        n9.add("[Kr] 4d10");
        n9.add("[Rn]");
        expResult.put(9, n9);
        // 8
        n8.add("[Ar] 3d10");
        n8.add("[He]");
        n8.add("[Ne]");
        n8.add("[Xe] 4f14 5d10");
        expResult.put(8, n8);
        // 7
        n7.add("[Ar] 3d10 4s2");
        n7.add("[He] 2s2");
        n7.add("[Kr] 4d10 5s2");
        n7.add("[Ne] 3s2");
        n7.add("[Xe] 4f14 5d10 6s2");
        expResult.put(7, n7);
        // 2
        n2.add("[Ar] 3d5");
        n2.add("[Kr] 4d5");
        n2.add("[Xe] 4f7");
        expResult.put(2, n2);
        
        TreeElectronConfiguration instance = new TreeElectronConfiguration(r.getElementsList());
        
        TreeMap<Integer, LinkedList<String>> result = instance.orderedTreeMapByEletronicConfigurationRepetition();
        assertEquals(expResult, result);

    }

    /**
     * Test of createAVLDescendingOrder method, of class TreeElectronConfiguration.
     */
    @Test
    public void testCreateAVLDescendingOrder() {
        System.out.println("createAVLDescendingOrder");
//          Resultado esperado na alínea a do Exercício 2
        //32 [[Xe]]
        //18 [[Ar], [Kr]]
        //17 [[Xe] 4f14]
        //9 [[Kr] 4d10, [Rn]]
        //8 [[Ar] 3d10, [He], [Ne], [Xe] 4f14 5d10]
        //7 [[Ar] 3d10 4s2, [He] 2s2, [Kr] 4d10 5s2, [Ne] 3s2, [Xe] 4f14 5d10 6s2]
        //2 [[Ar] 3d5, [Kr] 4d5, [Xe] 4f7]
//      Esta árvore deverá ser criada com os valores inseridos por ordem decrescente e com repetições superiores a 2,
//      logo, os valores da última linha não deverão contar

            //Valores por ordem decrescente
            EletronicConfigurationAssembler a = new EletronicConfigurationAssembler("[Xe]", 32);
            EletronicConfigurationAssembler b = new EletronicConfigurationAssembler("[Ar]", 18);
            EletronicConfigurationAssembler c = new EletronicConfigurationAssembler("[Kr]", 18);
            EletronicConfigurationAssembler d = new EletronicConfigurationAssembler("[Xe] 4f14", 17);
            EletronicConfigurationAssembler e = new EletronicConfigurationAssembler("[Kr] 4d10", 9);
            EletronicConfigurationAssembler f = new EletronicConfigurationAssembler("[Rn]", 9);
            EletronicConfigurationAssembler g = new EletronicConfigurationAssembler("[Ar] 3d10", 8);
            EletronicConfigurationAssembler h = new EletronicConfigurationAssembler("[He]", 8);
            EletronicConfigurationAssembler i = new EletronicConfigurationAssembler("[Ne]", 8);
            EletronicConfigurationAssembler j = new EletronicConfigurationAssembler("[Xe] 4f14 5d10", 8);
            EletronicConfigurationAssembler k = new EletronicConfigurationAssembler("[Ar] 3d10 4s2", 7);
            EletronicConfigurationAssembler l = new EletronicConfigurationAssembler("[He] 2s2", 7);
            EletronicConfigurationAssembler m = new EletronicConfigurationAssembler("[Kr] 4d10 5s2", 7);
            EletronicConfigurationAssembler n = new EletronicConfigurationAssembler("[Ne] 3s2", 7);
            EletronicConfigurationAssembler o = new EletronicConfigurationAssembler("[Xe] 4f14 5d10 6s2", 7);


        TreeElectronConfiguration instance = new TreeElectronConfiguration(r.getElementsList());
        
        AVL<EletronicConfigurationAssembler> expResult = new AVL();
        expResult.insert(a);
        expResult.insert(b);
        expResult.insert(c);
        expResult.insert(d);
        expResult.insert(e);
        expResult.insert(f);
        expResult.insert(g);
        expResult.insert(h);
        expResult.insert(i);
        expResult.insert(j);
        expResult.insert(k);
        expResult.insert(l);
        expResult.insert(m);
        expResult.insert(n);
        
        expResult.insert(o);
        
        AVL<EletronicConfigurationAssembler> result = instance.createAVLDescendingOrder();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of getMaxDistance method, of class TreeElectronConfiguration.
     */
    @Test
    public void testGetMaxDistance() {
        System.out.println("getMaxDistance");
        
        EletronicConfigurationAssembler elementA = new EletronicConfigurationAssembler("[Kr] 4d4 5s1",1);
        EletronicConfigurationAssembler elementB = new EletronicConfigurationAssembler("[Xe] 4f9 6s2",1);
        
        List<EletronicConfigurationAssembler> lst = new ArrayList<>();
        
        lst.add(elementA);
        lst.add(elementB);
        TreeMap<Integer, List<EletronicConfigurationAssembler>> exp = new TreeMap<>();
        exp.put(13, lst);
        
        Map.Entry<Integer, List<EletronicConfigurationAssembler>> expResult = exp.firstEntry();
        
        TreeElectronConfiguration instance = new TreeElectronConfiguration(r.getElementsList());
        instance.createTree();
        
        Map.Entry<Integer, List<EletronicConfigurationAssembler>> result = instance.getMaxDistance(instance);
        assertEquals(expResult.getKey(), result.getKey());
        
        Iterator<EletronicConfigurationAssembler> itResult = result.getValue().iterator();
        Iterator<EletronicConfigurationAssembler> itExpected = expResult.getValue().iterator();
        
        while(itResult.hasNext() && itExpected.hasNext()){
            int resultado = itResult.next().compareTo(itExpected.next());
            assertEquals(resultado, 0);
        }
    }

    /**
     * Test of completeTheTree method, of class TreeElectronConfiguration.
     */
    @Test
    public void testCompleteTheTree() throws IOException {
        System.out.println("completeTheTree");
        // A árvore é impossível de tornar completa, por isso serão adicionados alguns valores que façam com que a árvore se torne completa
        TreeElectronConfiguration instance = new TreeElectronConfiguration(r.getElementsList());
        
        boolean expResult = false;
        AVL<EletronicConfigurationAssembler> resultTree = instance.completeTheTree();
        boolean result = instance.isComplete(resultTree.root(), 0, resultTree.size());
        assertEquals(expResult, result);
        
    }

   

}
