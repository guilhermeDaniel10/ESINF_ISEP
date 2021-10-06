/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeriodicTable;

import Tree.AVL;
import Tree.BST;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Guilherme
 */
public class TreeElectronConfiguration extends AVL<EletronicConfigurationAssembler> {

    /**
     * Lista de elementos
     */
    private List<Element> elementsList = new ArrayList<>();

    /**
     * Construtor da classe que instância o atributo que contém a lista dos
     * elementos
     *
     * @param list
     */
    public TreeElectronConfiguration(List<Element> list) {
        elementsList = list;

    }

    /**
     * Constutor de omissão para efeitos de completeTreeWithSingleEletronicConfigurations
     */
    public TreeElectronConfiguration() {

    }

    /**
     * Limpa a árvore para não existir confusão entre alíneas
     */
    public void cleanTree() {
        root = null;
    }

    /**
     * Cria uma árvore apenas pela configuração eletrónica, não sendo necessário
     * ter em conta o número de repetições
     */
    public void createTree() {
        cleanTree();
        for (Element e : elementsList) {
            if (e.getElectronConfiguration() != "0") {
                String text = e.getElectronConfiguration();

                EletronicConfigurationAssembler eca = new EletronicConfigurationAssembler(text, 1);
                insert(eca);
            }
        }
    }
    
    /**
     * Cria uma nova árvore principal através de uma recebida por parâmetro
     *
     * @param tree nova arvore principal que se vai subrepor há existente
     */
    private void secondTree(AVL<EletronicConfigurationAssembler> tree){
        copyTree(this, tree, tree.root());
    }
    
    /**
     * Método auxiliar que transforma 
     * 
     * @param returned árvore copia de tree
     * @param tree árvore já contruida que vai ser copiada
     * @param node root da tree
     */
    private void copyTree(AVL<EletronicConfigurationAssembler> returned, AVL<EletronicConfigurationAssembler> tree, Node<EletronicConfigurationAssembler> node) {
        if(node == null){
            return;
        }

        returned.insert(node.getElement());        
        
        if(node.getLeft() != null){
            copyTree(returned,tree, node.getLeft());
        } 
        if(node.getRight() != null) {
           copyTree(returned,tree, node.getRight());
        }       
    }

    // --------------------- EXERCICIO 2 ALINEA A -------------------------------
    /**
     * Insere uma nova configuração eletrónica e incrementa o seu valor de
     * ocorrências.
     *
     * @param element
     */
    public void insertWithIncrement(EletronicConfigurationAssembler element) {

        root = insertWithIncrement(element, root);
    }

    protected Node<EletronicConfigurationAssembler> insertWithIncrement(EletronicConfigurationAssembler element, Node<EletronicConfigurationAssembler> node) {
        if (node == null) {
            return new Node(element, null, null);
        }

        if (node.getElement().compareTo(element) < 0) {
            node.setRight(insertWithIncrement(element, node.getRight()));
            return node;
        }

        if (node.getElement().compareTo(element) > 0) {
            node.setLeft(insertWithIncrement(element, node.getLeft()));
            return node;
        }

        node.getElement().incOcorrences();
        return node;
    }

    /**
     * Cria uma árvore apenas com os valores da configuração eletrónica dos
     * elementos, tendo em conta o espaço existente entre cada fração da
     * configuração eletrónica Trata-se de uma árvore binária temporária, pois
     * no enunciado é especificado que é necessário recorrer apenas a árvores
     * AVL para a sua resolução Foi decidido tornar private e não incluir nos
     * testes, pois o output da árvore é bastante complexo, tendo em conta que
     * uma árvore criada desta forma terá mais nós que a árvore criada
     * normalmente
     */
    private void createTreeWithSpacesInsideConfiguration() {
        cleanTree();
        Iterator<Element> it = elementsList.iterator();
        while (it.hasNext()) {
            Element current = it.next();
            String splitter[] = current.getElectronConfiguration().split("\\s+");

            String previousValues = "";
            for (int i = 0; i < splitter.length; i++) {
                if (i == 0) {
                    previousValues = splitter[i];
                    if (splitter[i] != "0") {
                        insertWithIncrement(new EletronicConfigurationAssembler(splitter[i], 1));
                    }
                } else {
                    if (splitter[i] != "0") {
                        previousValues += " " + splitter[i];
                    }
                    insertWithIncrement(new EletronicConfigurationAssembler(previousValues, 1));
                }
            }
        }

    }

    /**
     * Método que devolve a árvore binária de pesquisa por ordem decrescente de
     * configurações eletrónicas
     *
     * @return
     */
    public TreeMap<Integer, LinkedList<String>> orderedTreeMapByEletronicConfigurationRepetition() {
        createTreeWithSpacesInsideConfiguration();
        TreeMap<Integer, LinkedList<String>> tree = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, List<EletronicConfigurationAssembler>> nodes = nodesByLevel();

        for (Integer i : nodes.keySet()) {
            for (EletronicConfigurationAssembler e : nodes.get(i)) {
                if (e.getOcorrences() > 1 && e.getEletronicConfiguration() != "0") {
                    tree.put(e.getOcorrences(), null);
                }

            }

        }

        for (Integer i : tree.keySet()) {
            LinkedList<String> it = new LinkedList<>();
            for (Integer j : nodes.keySet()) {
                for (EletronicConfigurationAssembler e : nodes.get(j)) {
                    if (e.getOcorrences() == i) {
                        it.add(e.getEletronicConfiguration());
                    }
                }
            }
            Collections.sort(it);
            tree.put(i, it);
        }
        cleanTree();
        return tree;
    }

    // ------------------ EXERCICIO 2 ALINEA B ------------------
    /**
     * Constrói uma nova AVL inserindo por ordem decrescente as configurações
     * electrónicas com repetição acima de 2 obtidas na alínea anterior
     */
    public AVL<EletronicConfigurationAssembler> createAVLDescendingOrder() {
        AVL<EletronicConfigurationAssembler> eletronicAVL = new AVL();
        BST<EletronicConfigurationAssembler> copy = new BST();
        List<EletronicConfigurationAssembler> list = new ArrayList<>();

        TreeMap<Integer, LinkedList<String>> tree = orderedTreeMapByEletronicConfigurationRepetition();

        for (Integer i : tree.keySet()) {

            if (i > 2) {
                for (String e : tree.get(i)) {
                    EletronicConfigurationAssembler eca = new EletronicConfigurationAssembler(e, i);
                    list.add(eca);

                }
            }
        }
        for (EletronicConfigurationAssembler e : list) {
            eletronicAVL.insert(e);
        }
        return eletronicAVL;

    }

      // ------------------ EXERCICIO 2 ALINEA C ------------------
    /**
     * Método que devolve os valores das duas configurações electrónicas mais
     * distantes na árvore e a respectiva distância.
     *
     * @param tree árvore de pesquisa dos valores das duas configurações electrónicas mais distantes
     * @return a primera coluna da tabela de distancia entre folhas na árvore tree ordenada por distância em ordem desecendente
     */
    public Map.Entry<Integer, List<EletronicConfigurationAssembler>> getMaxDistance(AVL<EletronicConfigurationAssembler> tree){
        secondTree(tree);
        return getTwoEletronicConfigurationMaxDistance();
    }
    
    /**
     * Método auxiliar ao getMaxDistance 
     * 
     * @return a primera coluna da tabela de distancia entre folhas na árvore tree ordenada por distância em ordem desecendente 
     */
    private Map.Entry<Integer, List<EletronicConfigurationAssembler>> getTwoEletronicConfigurationMaxDistance() {
        List<EletronicConfigurationAssembler> listOfLeafs = new ArrayList<>();
        TreeMap<Integer, List<EletronicConfigurationAssembler>> allPathsSizesBetweenLeafs = new TreeMap<>(Collections.reverseOrder());
        getAllLeafs(root(), listOfLeafs);

        for (int i = 0; i < listOfLeafs.size() - 1; i++) {
            for (int j = i + 1; j < listOfLeafs.size(); j++) {
                int distance = findDistance(root(), listOfLeafs.get(i), listOfLeafs.get(j));
                List<EletronicConfigurationAssembler> twoElements = new ArrayList<>();
                twoElements.add(listOfLeafs.get(i));
                twoElements.add(listOfLeafs.get(j));
                allPathsSizesBetweenLeafs.put(distance, twoElements);
            }
        }
        return allPathsSizesBetweenLeafs.firstEntry();
    }
    
    /**
     * Preenche a Lista listOfLeafs com todas as folhas da árvore
     * 
     * @param node root da árvore principal
     * @param listOfLeafs lista a ser preenchida com todas as folhas da árvore
     */
    private void getAllLeafs(Node<EletronicConfigurationAssembler> node, List<EletronicConfigurationAssembler> listOfLeafs) {
        if (node == null) {
            return;
        }
        if ((node.getLeft() == null && node.getRight() == null) && !listOfLeafs.contains(node.getElement())) {
            listOfLeafs.add(node.getElement());
        }
        getAllLeafs(node.getLeft(), listOfLeafs);
        getAllLeafs(node.getRight(), listOfLeafs);
    }

    /**
     * Método que calcula a distância entre dois elementos
     * 
     * @param node root da árvore
     * @param elementA elemento onde inicia a travessia da árvore
     * @param elementB elemento onde termina a travessia da árvore
     * 
     * @return a distância entre os dois elementos
     */
    private static int findDistance(Node node, EletronicConfigurationAssembler elementA, EletronicConfigurationAssembler elementB) {
        Node lca = lowestCommonAncestor(node, elementA, elementB);
        int d1 = findLevel(lca, elementA, 0);
        int d2 = findLevel(lca, elementB, 0);
        return d1 + d2;
    }
    
    /**
     * Método encontra o primeiro node que os dois elementos partilham 
     * 
     * @param node root da árvore
     * @param elementA elemento onde inicia a travessia da árvore
     * @param elementB elemento onde termina a travessia da árvore
     * 
     * @return o node que os elementos partilham
     */
    private static Node lowestCommonAncestor(Node node, EletronicConfigurationAssembler elementA, EletronicConfigurationAssembler elementB) {
        if (node == null) {
            return node;
        }
        if (node.getElement().equals(elementA) || node.getElement().equals(elementB)) {
            return node;
        }
        
        Node left = lowestCommonAncestor(node.getLeft(), elementA, elementB);
        Node right = lowestCommonAncestor(node.getRight(), elementA, elementB);
        
        if (left != null && right != null) {
            return node;
        }
        if (left == null && right == null) {
            return null;
        }
        if (left != null) {
            return lowestCommonAncestor(node.getLeft(), elementA, elementB);
        }
        return lowestCommonAncestor(node.getRight(), elementA, elementB);
    }

    /**
     * Método encontra a distancia entre um node e um elemento da árvore
     * 
     * @param node nodulo que contem o elemento element
     * @param element elemento contido num ramo do node
     * @param level distancia do node ao element
     * 
     * @return a distância entre o node e o element
     */
    private static int findLevel(Node node, EletronicConfigurationAssembler element, int level) {
        if (node == null) {
            return -1;
        }
        if (node.getElement().equals(element)) {
            return level;
        }
        int left = findLevel(node.getLeft(), element, level + 1);
        if (left == -1) {
            return findLevel(node.getRight(), element, level + 1);
        }
        return left;
    }
    
    // ----------------- EXERCICIO 2 ALINEA D ---------------------
    // Foram feitas duas alternativas para esta alínea, nesta é criada uma árvore binária completa como é pedido no enunciado,
    // apenas inserindo configurações eletrónicas únicas
    // PRIMEIRA ALTERNATIVA
    /**
     * Método principal para a tentativa de completar uma árvore binária
     *
     * @return
     */
    public AVL<EletronicConfigurationAssembler> completeTheTree() {
        AVL<EletronicConfigurationAssembler> incompleteTree = createAVLDescendingOrder();
        int height = incompleteTree.height();

        createTree();


        completeTreeWithSingleEletronicConfigurations(incompleteTree, incompleteTree.root(), height);




        return incompleteTree;

    }

    private List<EletronicConfigurationAssembler> list(AVL<EletronicConfigurationAssembler> incompleteTree) {
        List<EletronicConfigurationAssembler> list = new ArrayList<>();

        for (EletronicConfigurationAssembler b : incompleteTree.inOrder()) {
            list.add(b);
        }

        return list;
    }

    public void completeTreeWithSingleEletronicConfigurations(AVL<EletronicConfigurationAssembler> incompleteTree, Node<EletronicConfigurationAssembler> node, int height) {
        if (node == null) {
            return;
        }

        if (node.getLeft() == null && node.getRight() == null && nodeDepth(node, incompleteTree) < height) {
            if (esquerda(incompleteTree, node.getElement()) != null) {
                incompleteTree.insert(esquerda(incompleteTree, node.getElement()));
            }
            if (direita(incompleteTree, node.getElement()) != null) {
                incompleteTree.insert(direita(incompleteTree, node.getElement()));
            } else {
                
            }
        }

        if (node.getLeft() == null && nodeDepth(node, incompleteTree) < height) {

            if (esquerda(incompleteTree, node.getElement()) != null) {
                incompleteTree.insert(esquerda(incompleteTree, node.getElement()));
            }
        }
        if (node.getRight() == null && nodeDepth(node, incompleteTree) < height) {

            if (direita(incompleteTree, node.getElement()) != null) {
                incompleteTree.insert(direita(incompleteTree, node.getElement()));
            }

        }
        if (node.getLeft() != null) {
            completeTreeWithSingleEletronicConfigurations(incompleteTree, node.getLeft(), height);
        }

        completeTreeWithSingleEletronicConfigurations(incompleteTree, node.getRight(), height);

    }

    
    
    /**
     * Descobre possíveis nós para adicionar à esquerda de um nó
     * @param incompleteTree
     * @param ele
     * @return 
     */
    private EletronicConfigurationAssembler direita(AVL<EletronicConfigurationAssembler> incompleteTree,
            EletronicConfigurationAssembler ele) {
        List<EletronicConfigurationAssembler> list = list(incompleteTree);

        if (incompleteTree.smallestElement().equals(ele)) {
            List<EletronicConfigurationAssembler> l = sendPossibleValues(this, incompleteTree);
            for (EletronicConfigurationAssembler k : l) {
                if (k.getEletronicConfiguration().compareTo(ele.getEletronicConfiguration()) > 0 && !list.contains(k)) {
                    return k;
                }
            }
        }
        if (biggestElement(incompleteTree).equals(ele)) {

            List<EletronicConfigurationAssembler> l = sendPossibleValues(this, incompleteTree);
            for (EletronicConfigurationAssembler k : l) {
                if (k.getEletronicConfiguration().compareTo(ele.getEletronicConfiguration()) > 0 && !list.contains(k)) {
                    return k;
                }
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (ele.getEletronicConfiguration().equals(list.get(i).getEletronicConfiguration())) {
                List<EletronicConfigurationAssembler> l = sendPossibleValues(this, incompleteTree);
                for (EletronicConfigurationAssembler k : l) {

                    if (k.getEletronicConfiguration().compareTo(ele.getEletronicConfiguration()) > 0) {
                        if (k.getEletronicConfiguration().compareTo(list.get(i + 1).getEletronicConfiguration()) < 0 && !list.contains(k)) {
                            return k;
                        }
                    }

                }

            }
        }

        return null;
    }

    /**
     * Descobre possíveis nós para adicionar à direita de um nó
     * @param incompleteTree
     * @param ele
     * @return 
     */
    private EletronicConfigurationAssembler esquerda(AVL<EletronicConfigurationAssembler> incompleteTree,
            EletronicConfigurationAssembler ele
    ) {
        List<EletronicConfigurationAssembler> list = list(incompleteTree);

        if (incompleteTree.smallestElement().equals(ele)) {

            List<EletronicConfigurationAssembler> l = sendPossibleValues(this, incompleteTree);
            for (EletronicConfigurationAssembler k : l) {
                if (k.getEletronicConfiguration().compareTo(ele.getEletronicConfiguration()) < 0 && !list.contains(k)) {
                    return k;
                }
            }
        }

        if (biggestElement(incompleteTree).equals(ele)) {
            List<EletronicConfigurationAssembler> l = sendPossibleValues(this, incompleteTree);
            for (EletronicConfigurationAssembler k : l) {
                if (k.getEletronicConfiguration().compareTo(ele.getEletronicConfiguration()) < 0 && !list.contains(k)) {
                    return k;
                }
            }
        }

        for (int i = 1; i < list.size(); i++) {
            if (ele.getEletronicConfiguration().equals(list.get(i).getEletronicConfiguration())) {
                List<EletronicConfigurationAssembler> l = sendPossibleValues(this, incompleteTree);
                for (EletronicConfigurationAssembler k : l) {
                    if (k.getEletronicConfiguration().compareTo(ele.getEletronicConfiguration()) < 0) {
                        if (k.getEletronicConfiguration().compareTo(list.get(i - 1).getEletronicConfiguration()) > 0 && !list.contains(k)) {
                            return k;
                        }
                    }
                }
            }
        }

        return null;
    }

    private EletronicConfigurationAssembler biggestElement(AVL<EletronicConfigurationAssembler> incompleteTree) {
        return biggestElement(incompleteTree.root());
    }

    private EletronicConfigurationAssembler biggestElement(Node<EletronicConfigurationAssembler> node) {
        if (node.getRight() == null) {
            return node.getElement();
        }
        return biggestElement(node.getRight());
    }

   

    
    /**
     * Envia valores da árvore principal que são possíveis de adicionar à árvore
     * incompleta para a tornar completa
     *
     * @param incompleteTree
     * @param node
     */
    private List<EletronicConfigurationAssembler> sendPossibleValues(AVL<EletronicConfigurationAssembler> tree,
            AVL<EletronicConfigurationAssembler> incompleteTree) {
        List<EletronicConfigurationAssembler> l = new ArrayList<>();
        for (EletronicConfigurationAssembler e : tree.preOrder()) {
            if (!hasElement(incompleteTree, e.getEletronicConfiguration())) {
                l.add(e);
            }
        }
        return l;
    }

  

    /**
     * Devolve o nível do nó
     *
     * @param node
     * @param incompleteTree
     * @return
     */
    private int nodeDepth(Node<EletronicConfigurationAssembler> node, AVL<EletronicConfigurationAssembler> incompleteTree) {
        if (parent(node.getElement().getEletronicConfiguration(), incompleteTree.root()) != null) {
            return 1 + nodeDepth(parent(node.getElement().getEletronicConfiguration(), incompleteTree.root()), incompleteTree);
        }
        return 0;
    }

    /**
     * Verifica se um nó é leaf ou não
     *
     * @param incompleteTree
     * @param element
     * @return
     */
    private boolean isLeaf(AVL<EletronicConfigurationAssembler> incompleteTree, EletronicConfigurationAssembler element) {
        if (element == null) {
            return false;
        }

        Node<EletronicConfigurationAssembler> node = incompleteTree.find(incompleteTree.root(), element);

        if (node == null) {
            return false;
        }

        return (node.getLeft() == null && node.getRight() == null);
    }


    /**
     * Devolve o nó pai de um nó
     *
     * @param elec
     * @param node
     * @return
     */
    private Node<EletronicConfigurationAssembler> parent(String elec, Node<EletronicConfigurationAssembler> node) {
        return findParent(elec, node, null);
    }

    private Node<EletronicConfigurationAssembler> findParent(String elec, Node<EletronicConfigurationAssembler> node, Node<EletronicConfigurationAssembler> parent) {
        if (node == null) {
            return null;
        } else if (!node.getElement().getEletronicConfiguration().equals(elec)) {

            parent = findParent(elec, node.getLeft(), node);
            if (parent == null) {

                parent = findParent(elec, node.getRight(), node);
            }
        }
        return parent;
    }


    /**
     * Verifica se a árvore contém algum nó com uma determiada configuração
     *
     * @param incompleteTree
     * @param eletronic
     * @return
     */
    private boolean hasElement(AVL<EletronicConfigurationAssembler> incompleteTree, String eletronic) {
        if (eletronic == null) {
            return true;
        }
        for (EletronicConfigurationAssembler et : incompleteTree.inOrder()) {
            if (et.getEletronicConfiguration().equals(eletronic)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se a árvore está completa (apenas para os testes unitários)
     *
     * @param node
     * @param index
     * @param number_nodes
     * @return
     */
    public boolean isComplete(Node node, int index, int number_nodes) {
        // Uma árvore vazia é completa
        if (node == null) {
            return true;
        }

        if (index >= number_nodes) {
            return false;
        }

        return (isComplete(node.getLeft(), 2 * index + 1, number_nodes)
                && isComplete(node.getRight(), 2 * index + 2, number_nodes));

    }

}
