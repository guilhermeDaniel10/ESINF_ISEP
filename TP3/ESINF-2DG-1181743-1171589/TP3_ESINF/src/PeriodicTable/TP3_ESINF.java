package PeriodicTable;

import Tree.BST;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Guilherme
 */
public class TP3_ESINF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ReadFile r = new ReadFile();
        r.readElements("Periodic Table of Elements.csv");

        TreesPesquisaPorCampos tree = new TreesPesquisaPorCampos(r.getElementsList());

        
        TreeElectronConfiguration ece = new TreeElectronConfiguration(r.getElementsList());

        System.out.println("--------- EXERCICIO 1) A) ---------");
        //EXERCICIO 1) A)
        int atomicN = 40;
        String symbol = "Cu";
        String name = "Lutetium";
        double atomicM = 186.21;
        System.out.println("ATOMIC NUMBER SEARCH: " + atomicN);
        System.out.println("ELEMENT:");
        System.out.println(tree.searchAtomicNumber(atomicN).getElement());
        System.out.println("-----------------------------");
        System.out.println("ELEMENT NAME SEARCH: " + name);
        System.out.println("ELEMENT: ");
        System.out.println(tree.searchElementName(name).getElement());
        System.out.println("-----------------------------");
        System.out.println("SYMBOL SEARCH: " + symbol);
        System.out.println("ELEMENT: ");
        System.out.println(tree.searchSymbol(symbol).getElement());
        System.out.println("-----------------------------");
        System.out.println("ATOMIC MASS SEARCH: " + atomicM);
        System.out.println("ELEMENT: ");
        System.out.println(tree.searchAtomicMass(atomicM).getElement());
        
        System.out.println(" ");
        System.out.println("--------- EXERCICIO 1) B) ---------");
        
        System.out.println("");
        //EXERCICIO 1) B)
        List<Element> lstElements = tree.searchByRange(20,65);
        transformOutput(lstElements);
        System.out.println("\n  \n");
        Map<String, Map<String, Integer>> summary = tree.summaryListByTypeAndPhase(lstElements);
        transformSummaryOutput(summary);
        
        System.out.println("\n--------- EXERCICIO 2) A) ---------\n");
        
        //EXERCICIO 2)A)
        TreeMap<Integer, LinkedList<String>> map = ece.orderedTreeMapByEletronicConfigurationRepetition();
        for(Integer i : map.keySet()){
            System.out.println(i + " " + map.get(i));
        }
        
        //EXERCICIO 2)B)
        System.out.println("\n--------- EXERCICIO 2) B) ---------\n");
        System.out.println(ece.createAVLDescendingOrder());

        
        //EXERCICIO 2)C)
        
        System.out.println("\n--------- EXERCICIO 2) C) ---------\n");
        
        Map.Entry<Integer, List<EletronicConfigurationAssembler>> eletronicConfigurationMaxDistance  = ece.getMaxDistance(ece.createAVLDescendingOrder());
        transformGetMaxDistance(eletronicConfigurationMaxDistance);
        
        //EXERCICIO 2)D)
        
        System.out.println("\n--------- EXERCICIO 2) D) ---------\n");
        System.out.println("(A árvore não é possível de tornar completa, contudo foram adicionados o máximo de valores\n"
                + "para que isso acontecesse)");
        
        System.out.println(ece.completeTheTree());
        
//          System.out.println(ece.completeTheTree());
    }

    
    /**
     * Transforma uma lista no Output do enunciado
     *
     * @param lstElements lista de elementos que desejamos mostrar
     */
    public static void transformOutput(List<Element> lstElements){            
        String str = String.format("%s%8s%13s%17s%9s%20s%30s%20s", "Atomic Number", "Element", "Symbol", "Atomic Mass", "Phase", "Type", "Discoverer", "Year Discovery");
        for (Element e : lstElements) {
            if (e.getYearOfDiscovery() == 0) {
                str = str + "\n" + String.format("%7s%15s%11s%17s%10s%25s%25s", e.getAtomicNumber(), e.getElementName(), e.getSymbol(),  e.getAtomicMass(), e.getPhase(), e.getType(), e.getDiscoverer());
            }else {
                str = str + "\n" + String.format("%7s%15s%11s%17s%10s%25s%25s%15s", e.getAtomicNumber(), e.getElementName(), e.getSymbol(),  e.getAtomicMass(), e.getPhase(), e.getType(), e.getDiscoverer(), e.getYearOfDiscovery());
            }         
        }
        System.out.println(str);
    }
    
      /**
     * Transforma uma lista no Output do enunciado
     *
     * @param summary tabela que desejamos mostrar
     */
    public static void transformSummaryOutput(Map<String, Map<String, Integer>> summary){            
        String str = "";
        int total = 0;
        for (String types : summary.keySet()) {
            total = 0;
            str = str + String.format("Type: %s ->", types);
            for (String phase : summary.get(types).keySet()) {
                    total = summary.get(types).get(phase) + total;
                    str = str + String.format(" | Phase:%s  quantity:%s ", phase,summary.get(types).get(phase));
            }
            str = str + String.format(" | Total:%s | \n", total);
        }
        System.out.println(str);
    }
    
    
    /**
     * Transforma uma linha de uma tabela no Output do enunciado
     *
     * @param eletronicConfigurationMaxDistance linha da tabela que desejamos mostrar
     */
    public static void transformGetMaxDistance(Map.Entry<Integer, List<EletronicConfigurationAssembler>> eletronicConfigurationMaxDistance){            
        String str = "D(";
        int i = 0;
        for (EletronicConfigurationAssembler element : eletronicConfigurationMaxDistance.getValue()) {
            i++;
            if (i == 1) {
                str = str + String.format("%s ;",element);
            } else {
                str = str + String.format(" %s",element);
            }
            
        }
        str = str + String.format(")= %s ",eletronicConfigurationMaxDistance.getKey());
        System.out.println(str);
    }
}


