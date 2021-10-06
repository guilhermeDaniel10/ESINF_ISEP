package PeriodicTable;

import Tree.AVL;
import Tree.BST;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//---------------------- EXERCÍCIO 1 ALÍNEA A ------------------------------
/**
 *
 * @author Guilherme
 */
public class TreesPesquisaPorCampos extends AVL<Element> {

    /**
     * Lista de elementos
     */
    List<Element> elementsList = new ArrayList<>();

    /**
     * Construtor da classe que instância o atributo que contém a lista dos
     * elementos
     *
     * @param list
     */
    public TreesPesquisaPorCampos(List<Element> list) {
        elementsList = list;
    }

    /**
     * Construtor vazio apenas para efeitos de testes unitários
     */
    public TreesPesquisaPorCampos() {

    }

    public void cleanTree() {
        root = null;
    }

    /**
     * Insere valores a uma árvore pelo seu número atómico
     */
    protected void insertByAtomicNumber() {
        cleanTree();
        List<ElementAtomicNumber> l = new ArrayList<>();
        for (Element e : elementsList) {
            ElementAtomicNumber at = new ElementAtomicNumber(e);
            l.add(at);
        }
        for (ElementAtomicNumber r : l) {
            insert(r);
        }
    }

    /**
     * Insere valores a uma árvore pelo seu nome
     */
    protected void insertByElementName() {
        cleanTree();
        List<ElementName> l = new ArrayList<>();
        for (Element e : elementsList) {
            ElementName en = new ElementName(e);
            l.add(en);
        }
        for (ElementName en : l) {
            insert(en);
        }
    }

    /**
     * Insere valores a uma árvore pelo seu símbolo
     */
    protected void insertByElementSymbol() {
        cleanTree();
        List<ElementSymbol> l = new ArrayList<>();
        for (Element e : elementsList) {
            ElementSymbol es = new ElementSymbol(e);
            l.add(es);
        }
        for (ElementSymbol es : l) {
            insert(es);
        }
    }

    /**
     * Insere valores a uma árvore pelo seu número atómico
     */
    protected void insertByAtomicMass() {
        cleanTree();
        List<ElementAtomicMass> l = new ArrayList<>();
        for (Element e : elementsList) {
            ElementAtomicMass am = new ElementAtomicMass(e);
            l.add(am);
        }
        for (ElementAtomicMass r : l) {
            insert(r);
        }
    }

    /**
     * Faz uma pesquisa pelo número atómico
     *
     * @param e
     * @return
     */
    public Node<Element> searchAtomicNumber(int atomicNumber) {
        insertByAtomicNumber();
        return findNodeByAtomicNumber(root, atomicNumber);
    }

    /**
     * Faz uma pesquisa pelo nome do elemento
     *
     * @param e
     * @return
     */
    public Node<Element> searchElementName(String e) {
        insertByElementName();
        return findNodeByName(root, e);
    }

    /**
     * Faz uma pesquisa pelo símbolo do elemento
     *
     * @param e
     * @return
     */
    public Node<Element> searchSymbol(String e) {
        insertByElementSymbol();
        return findNodeBySymbol(root, e);
    }

    /**
     * Faz uma pesquisa pela massa atómica do elemento
     *
     * @param e
     * @return
     */
    public Node<Element> searchAtomicMass(double e) {
        insertByAtomicMass();
        return findNodeByAtomicMass(root, e);
    }

    /**
     * Faz uma busca tendo em conta que irá pesquisar o nó com o respetivo
     * número atómico do elemento
     *
     * @param node
     * @param value
     * @param field
     * @return
     */
    private Node<Element> findNodeByAtomicNumber(Node<Element> node, int value) {
        if (node == null) {
            return null;
        }

        if (node.getElement().getAtomicNumber() == value) {
            return node;
        }

        if (node.getElement().getAtomicNumber() > value) {
            return findNodeByAtomicNumber(node.getLeft(), value);
        }

        return findNodeByAtomicNumber(node.getRight(), value);

    }

    /**
     * Faz uma busca tendo em conta que terá que pesquisar pelo nó com o
     * respetivo nome do elemento
     *
     * @param node
     * @param name
     * @return
     */
    private Node<Element> findNodeByName(Node<Element> node, String name) {
        if (node == null) {
            return null;
        }

        if (node.getElement().getElementName().equalsIgnoreCase(name)) {
            return node;
        }

        if (node.getElement().getElementName().compareTo(name) > 0) {
            return findNodeByName(node.getLeft(), name);
        }

        return findNodeByName(node.getRight(), name);
    }

    /**
     * Faz uma busca tendo em conta que terá que pesquisar pelo nó com o
     * respetivo símbolo do elemento
     * 
     * @param node
     * @param symbol
     * @return 
     */
    private Node<Element> findNodeBySymbol(Node<Element> node, String symbol) {
        if (node == null) {
            return null;
        }

        if (node.getElement().getSymbol().equalsIgnoreCase(symbol)) {
            return node;
        }
        
        if (node.getElement().getSymbol().compareTo(symbol) > 0) {
            return findNodeBySymbol(node.getLeft(), symbol);
        }
        

        return findNodeBySymbol(node.getRight(), symbol);
    }

    /**
     * Faz uma busca tendo em conta que terá que pesquisar pelo nó com a
     * respetiva massa atómica
     * 
     * @param node
     * @param value
     * @return 
     */
    private Node<Element> findNodeByAtomicMass(Node<Element> node, double value) {
        if (node == null) {
            return null;
        }

        if (node.getElement().getAtomicMass() == value) {
            return node;
        }

        if (node.getElement().getAtomicMass() > value) {
            return findNodeByAtomicMass(node.getLeft(), value);
        }

        return findNodeByAtomicMass(node.getRight(), value);
    }
    
    /**
     * Faz uma pesquisa pelo intervalo desejado
     *
     * @param min valor mínimo do Intervalo
     * @param max valor máximo do Intervalo
     * 
     * @return Lista de elementos dentro do intervalo de atomic mass 
     * desejado ordenada por Discoverer e Year of Discovery (cresc./decres.)
     */
    public List<Element> searchByRange(int min, int max) {
        insertByAtomicMass();
        List<Element> shorterElementsList = new ArrayList<>();
        TreeInRange(root(), min, max, shorterElementsList);
        if (shorterElementsList.isEmpty()) {
            return null;
        }
        Collections.sort(shorterElementsList, new compareByDiscovererAndYearOfDiscovery());
        return shorterElementsList;
    }

    /**
     * Faz uma pesquisa na arvore ordenada pela sua massa atómica de valores compreendidos entre um intervalo
     *
     * @param node root da arvore
     * @param min valor mínimo do Intervalo
     * @param max valor máximo do Intervalo
     * @param ShorterElementsList nova lista de elementos compreendidos no intervalo desejado
     * 
     */
    private static void TreeInRange(Node<Element> node, int min, int max, List<Element> ShorterElementsList) {
        if (node == null) {
            return;
        }

        if (node.getElement().getAtomicMass() >= min && node.getElement().getAtomicMass() <= max) {
            if (!ShorterElementsList.contains(node.getElement())) {
                ShorterElementsList.add(node.getElement());
            }
            TreeInRange(node.getLeft(), min, max, ShorterElementsList);
        }
        if (node.getElement().getAtomicMass() > min) {
            TreeInRange(node.getLeft(), min, max, ShorterElementsList);
        }
        if (node.getElement().getAtomicMass() < max) {
            TreeInRange(node.getRight(), min, max, ShorterElementsList);
        }

    }

    /**
     * Retorna um sumário do número de elementos agrupados por Type e Phase
     *
     * @param shorterElementsList lista de elementos compreendidos no intervalo desejado
     * @return um LinkedHashMap de elementos agrupados por Type e Phase
     */
    public Map<String, Map<String, Integer>> summaryListByTypeAndPhase(List<Element> shorterElementsList) {

        Map<String, Map<String, Integer>> summary = new LinkedHashMap<>();
        int total = 1;
        for (Element e : shorterElementsList) {

            if (!summary.containsKey(e.getType())) {
                summary.put(e.getType(), new LinkedHashMap<>());
            }
        }

        for (String type : summary.keySet()) {
            for (Element elem : shorterElementsList) {
                if (elem.getType().equals(type)) {
                    if (!summary.get(type).containsKey(elem.getPhase())) {
                        summary.get(type).put(elem.getPhase(), total);
                    } else {
                        int newTotal = summary.get(type).get(elem.getPhase());
                        summary.get(type).put(elem.getPhase(), newTotal + 1);
                    }
                }
            }
        }

        return summary;
    }

    private class compareByDiscovererAndYearOfDiscovery implements Comparator<Element> {

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
