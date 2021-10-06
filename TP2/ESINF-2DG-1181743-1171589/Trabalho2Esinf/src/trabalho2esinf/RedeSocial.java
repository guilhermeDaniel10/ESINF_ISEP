/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2esinf;

import graphbase.AdjacencyGraphAlgorithms;
import graphbase.AdjacencyMatrixGraph;
import graphbase.Graph;
import graphbase.GraphAlgorithms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RedeSocial {

    /**
     * String é o vértice que corresponde à capital e o Integer é o peso que
     * corresponde à distância entre as capitais cujo país faz fronteira com
     * outro
     */
    Graph<String, Integer> citiesCon;

    /**
     * Lista que contém todos os países lidos do ficheiro de texto (utilizado
     * apenas para problemas triviais)
     */
    List<Country> countriesList = new ArrayList<>();
    /**
     * Lista que contém todas as fronteiras lidas do ficheiro de texto
     * (utilizado apenas para problemas triviais)
     */
    List<Border> bordersList = new ArrayList<>();

    /**
     * Grafo da matriz de adjacências
     */
    AdjacencyMatrixGraph<User, Double> relations;
    /**
     * Lista dos Users
     */
    List<User> usersList = new ArrayList<>();
    /**
     * Lista das relações entre users
     */
    List<Relation> usersRela = new ArrayList<>();

    /**
     * Construtor que define o grafo CitiesConnections como não direcionado
     */
    public RedeSocial() {
        citiesCon = new Graph<>(false);
        relations = new AdjacencyMatrixGraph<User, Double>();
    }

    //-----------------------------------------------------------------------------------
    //----------------------    EXERCICIO 1     -----------------------------------------
    /**
     * Método que lê informação de um ficheiro de texto para uma lista
     *
     * @param filename ficheiro de texto a ser lido
     * @return lista do tipo String com dados de um ficheiro de texto
     * @throws java.io.IOException
     */
    private List<String> readFromFile(String filename) throws IOException {
        List<String> information = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                line.trim();
                information.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return information;
    }

    /**
     * Método intermediário da leitura de um ficheiro com a inserção de dados
     * dos países
     *
     * @param filename nome do ficheiro a ser lido
     * @throws IOException
     */
    public void readFromFileCountries(String filename) throws IOException {
        List<String> information = readFromFile(filename);
        addCountries(information);
        addAllCities(countriesList);
    }

    public void readFromFileBorders(String filename) throws IOException {
        List<String> information = readFromFile(filename);
        bordersList = insertConnections(information);
        addConnection(bordersList);
    }

    /**
     * Método que adiciona um vértice ao grafo
     *
     * @param a vértice a ser adicionado, neste caso, uma cidade
     */
    private boolean addCity(String a) {
        return citiesCon.insertVertex(a);
    }

    /**
     * Adiciona a uma lista todos os países que estão contidos no ficheiro de
     * texto
     *
     * @param countryInfo Lista de informação lida para o sistema
     */
    private void addCountries(List<String> countryInfo) {

        for (String s : countryInfo) {
            String data[] = s.split(",");
            data[0] = data[0].replaceAll("\\s+", "");
            data[1] = data[1].replaceAll("\\s+", "");
            data[2] = data[2].replaceAll("\\s+", "");
            data[3] = data[3].replaceAll("\\s+", "");
            data[4] = data[4].replaceAll("\\s+", "");
            data[5] = data[5].replaceAll("\\s+", "");
            Country c = new Country(data[0], data[1], Double.parseDouble(data[2]), data[3], Double.parseDouble(data[4]), Double.parseDouble(data[5]));
            countriesList.add(c);
        }

    }

    private List<Border> insertConnections(List<String> bordersInfo) {
        List<Border> borders = new ArrayList<>();

        for (String s : bordersInfo) {

            String data[] = s.split(",");
            data[1] = data[1].replaceAll("\\s+", "");
            Border b = new Border(data[0], data[1]);
            borders.add(b);
        }

        return borders;
    }

    /**
     * Adiciona todas as cidades contidas no ficheiro de texto para o grafo
     * CitiesConnections, para os vértices
     *
     * @param countriesList lista de países que estão contidos no sistema
     * @throws IOException
     */
    private void addAllCities(List<Country> countriesList) throws IOException {
        for (Country c : countriesList) {
            addCity(c.getCapital());
        }
    }

    /**
     * Calcula a distância entre coordenadas de duas cidades
     *
     * @param lat1 latitude da cidade 1
     * @param lat2 latitude da cidade 2
     * @param lon1 longitude da cidade 1
     * @param lon2 longitude da cidade 2
     * @return distância entre duas cidades
     */
    private double distanceFormula(double lat1, double lat2, double lon1, double lon2) {
        double r = 6371 * Math.pow(10, 3);
        double p1 = lat1 * Math.PI / 180;
        double p2 = lat2 * Math.PI / 180;
        double deltP = (lat2 - lat1) * Math.PI / 180;
        double deltL = (lon2 - lon1) * Math.PI / 180;

        double a = Math.sin(deltP / 2) * Math.sin(deltP / 2)
                + Math.cos(p1) * Math.cos(p2)
                * Math.sin(deltL / 2) * Math.sin(deltL / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = r * c;

        return d * Math.pow(10, -3);
    }

    /**
     * Retorna a distância entre duas cidades
     *
     * @param a país A
     * @param b país B
     * @return distância entre duas cidades
     */
    protected double calculateDistance(Country a, Country b) {

        return distanceFormula(a.getLatitude(), b.getLatitude(), a.getLongitude(), b.getLongitude());
    }

    /**
     * Adiciona uma ligação entre dois países
     *
     * @param borders
     */
    private void addConnection(List<Border> borders) {
        Country a = null;
        Country b = null;
        int incr = 0;
        for (Border bor : borders) {

            for (Country c : countriesList) {
                if (c.getCountry().equals(bor.getCountryA())) {
                    a = c;
                }
                if (c.getCountry().equals(bor.getCountryB())) {
                    b = c;
                }
            }
            citiesCon.insertEdge(a.getCapital(), b.getCapital(), incr, calculateDistance(a, b));
            incr++;
        }
    }

    /**
     * Lê um ficheiro com informações de Users e adiciona ao grafo
     *
     * @param filename nome do ficheiro
     * @throws IOException
     */
    public void readFromFileUsers(String filename) throws IOException {
        List<String> information = readFromFile(filename);
        insertUsers(information);
        addAllUsers(usersList);
    }

    /**
     * Lê um ficheiro com informações de relações e adiciona ao grafo
     *
     * @param filename
     * @throws IOException
     */
    public void readFromFileRelations(String filename) throws IOException {
        List<String> information = readFromFile(filename);
        insertRelation(information);
        addAllRelations(usersRela);
    }

    /**
     * Adiciona à lista de utilizadores todos os users lidos do ficheiro de
     * texto
     *
     * @param userInfo informações provenientes de users do ficheiro de texto
     */
    private void insertUsers(List<String> userInfo) {

        for (String s : userInfo) {
            String data[] = s.split(",");
            User u = new User(data[0], Integer.parseInt(data[1]), data[2]);
            usersList.add(u);
        }
    }

    /**
     * Adiciona à lista de relações todas as relações lidas do ficheiro de texto
     *
     * @param relationInfo informações provenientes das relações do ficheiro de
     * texto
     */
    private void insertRelation(List<String> relationInfo) {
        for (String s : relationInfo) {
            String data[] = s.split(",");
            data[0] = data[0].replaceAll("\\s+", "");
            data[1] = data[1].replaceAll("\\s+", "");
            User u1 = getUserById(data[0]);
            User u2 = getUserById(data[1]);
            Relation r = new Relation(u1, u2);
            usersRela.add(r);

        }
    }

    /**
     * Adiciona o vértice de user
     *
     * @param u user
     * @return verdadeiro se for adicionado
     */
    private boolean addUser(User u) {
        return relations.insertVertex(u);
    }

    /**
     * Adiciona a relação entre dois vértices
     *
     * @param u1 vértice 1
     * @param u2 vértice 2
     * @return verdadeiro se for adicionado
     */
    private boolean addRelation(User u1, User u2) {
        return relations.insertEdge(u1, u2, 1.0);
    }

    /**
     * Adiciona todos os vértices ao grafo
     *
     * @param userList lista de todos os utilizadores
     */
    private void addAllUsers(List<User> userList) {
        for (User u : userList) {
            addUser(u);
        }
    }

    /**
     * Adiciona todas as relações aos grafos
     *
     * @param relaList lista de todas as relações entre utilizadores
     */
    private void addAllRelations(List<Relation> relaList) {
        int i = 0;
        for (Relation r : relaList) {
            if (r.getU1() != null && r.getU2() != null) {
                addRelation(r.getU1(), r.getU2());
            }
        }
    }

    /**
     * Obtém o utilizador pelo seu id
     *
     * @param id id do utilizador
     * @return utilizador com o respetivo id
     */
    protected User getUserById(String id) {
        User us = null;
        for (User u : usersList) {
            if (u.getUser().equals(id)) {
                us = u;
            }
        }
        return us;
    }

    //--------------------------------------------------------------------------------------------
    //--------------------------    EXERCICIO 2 --------------------------------------------------
    /**
     * Devolve os amigos em comum entre os n utilizadores mais populares da rede
     *
     * @param qtdPopulares numero de utilizadores mais populares a ser retornado
     * @return amigos em comum entre os n utilizadores mais populares
     */
    public List<User> amigosComuns(int qtdPopulares) {

        if ((!(relations.numVertices() >= qtdPopulares)) || qtdPopulares <= 0) {
            return null;
        }

        List<User> usersMaisPopulares = utlzMaisPopulares(qtdPopulares);
        List<User> amigosComum = new ArrayList<>();
        List<User> amigosARemover = new ArrayList<>();

        for (User popular : usersMaisPopulares) {
            for (User amigo : relations.directConnections(popular)) {
                if (!amigosComum.contains(amigo)) {
                    amigosComum.add(amigo);
                }
            }
        }

        for (User popular : usersMaisPopulares) {
            for (User amigo : amigosComum) {
                if (relations.getEdge(popular, amigo) == null) {
                    amigosARemover.add(amigo);
                }
            }
        }

        for (User u : amigosARemover) {
            amigosComum.remove(u);
        }

        return amigosComum;
    }

    /**
     * Devolve a lista dos n utilizadores mais populares
     *
     * @param qtdPopulares numero de utilizadores mais populares a ser retornado
     * @return n utilizadores mais populares
     */
    protected List<User> utlzMaisPopulares(int qtdPopulares) {

        int numPopulares = qtdPopulares;
        List<User> usersMaisPopu = new ArrayList<>();
        LinkedHashMap< User, Integer> utlznumAmigos = new LinkedHashMap<>();

        for (User u : relations.vertices()) {
            utlznumAmigos.put(u, relations.outDegree(u));
        }

        LinkedHashMap utlznumAmgOrde = sortMap(utlznumAmigos);

        for (Object u : utlznumAmgOrde.keySet()) {
            if (numPopulares == 0) {
                break;
            }
            numPopulares--;
            usersMaisPopu.add(((User) u));
        }

        return usersMaisPopu;
    }

    //--------------------------------------------------------------------------
    //------------------- EXERCICIO 3 ------------------------------------------
    /**
     * Verifica se o grafo de matriz de adjacências é conectado
     *
     * @return true se for e false se não for
     */
    protected boolean isConnected() {
        User firstVertex = usersList.get(0);

        List<User> path = AdjacencyGraphAlgorithms.DFS(relations, firstVertex);

        if (path.size() == relations.numVertices()) {
            return true;
        }
        return false;
    }

    /**
     * Algoritmo que determina o número mínimo de ligações que um vértice
     * precisa para chegar a outro qualquer vértice, que servirá para determinar
     * a maior ligacao de todas de todos os vértices
     *
     * @return maior ligacao entre dois vértices da matriz determinada pelo
     * algortimo
     */
    public Double minConncectionsToReachAllUsers() {
        Double maxConnection = 0.0;

        if (!isConnected()) {
            return 0.0;
        }

        int V = relations.numVertices();
        Double dist[][] = new Double[V][V];
        int iC = 0, jC = 0, kC = 0;

        for (User i : relations.vertices()) {
            jC = 0;
            for (User j : relations.vertices()) {
                dist[iC][jC] = relations.getEdge(i, j);
                jC++;
            }
            iC++;
        }

        AdjacencyMatrixGraph copy = relations;
        iC = 0;
        jC = 0;

        for (User k : relations.vertices()) {
            iC = 0;
            for (User i : relations.vertices()) {
                jC = 0;
                for (User j : relations.vertices()) {
                    if (i == j) {
                        dist[iC][jC] = 0.0;
                    }
                    if (dist[iC][kC] != null && dist[kC][jC] != null && dist[iC][jC] != null) {
                        if (dist[iC][kC] + dist[kC][jC] < dist[iC][jC]) {
                            dist[iC][jC] = dist[iC][kC] + dist[kC][jC];
                        }
                    }
                    if (dist[iC][jC] == null && dist[iC][kC] != null && dist[kC][jC] != null) {
                        dist[iC][jC] = dist[iC][kC] + dist[kC][jC];
                    }
                    jC++;
                }
                iC++;
            }
            kC++;
        }

        // Descobre qual o maior número de ligacoes de um utilizador para outro utilizador
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] > maxConnection) {
                    maxConnection = dist[i][j];
                }
            }
        }

        return maxConnection;
    }

    //--------------------------------------------------------------------------
    //------------------------ EXERCICIO 4 -------------------------------------
    /**
     * Devolve os amigos que se encontram nas proximidades de um utilizador
     *
     * @param principal user a serem devolvidos os amigos nas suas proximidades
     * @param numFronteiras numero de fronteiras
     * @return amigos que se encontram nas proximidades de um utilizador
     */
    public LinkedHashMap<String, String> amigosNasProximidades(User principal, int numFronteiras) {

        if (numFronteiras < 0 || !this.relations.checkVertex(principal)) {
            return null;
        }

        LinkedHashMap<String, String> utlzPorCidade = new LinkedHashMap<>();
        String cityPrincipal = principal.getCity();
        int dist[];

        dist = shortestPathEdges(cityPrincipal);

        for (String city : this.citiesCon.vertices()) {
            for (User u : relations.directConnections(principal)) {
                if (city.contains(u.getCity()) && dist[citiesCon.getKey(city)] <= numFronteiras) {
                    utlzPorCidade.put(u.getUser(), city);
                }
            }
        }
        return utlzPorCidade;
    }

    /**
     * Devolve todos os edges mais curtos para chegar a cada um dos outros
     * vértices
     *
     * @param vOrig vértice a serem devolvidos todos os edges mais curtoes
     * @return edges mais curtoes para chegar a cada um dos outros vértices
     */
    private int[] shortestPathEdges(String vOrig) {

        String orig;
        int dist[] = new int[citiesCon.numVertices()];
        LinkedList<String> queueAux = new LinkedList<>();

        for (String vertices : citiesCon.vertices()) {
            dist[citiesCon.getKey(vertices)] = Integer.MAX_VALUE;
        }

        queueAux.add(vOrig);
        dist[citiesCon.getKey(vOrig)] = 0;

        while (!(queueAux.isEmpty())) {
            orig = queueAux.pop();
            for (String vAdj : citiesCon.adjVertices(orig)) {
                if (dist[citiesCon.getKey(vAdj)] == Integer.MAX_VALUE) {
                    dist[citiesCon.getKey(vAdj)] = dist[citiesCon.getKey(orig)] + 1;
                    queueAux.add(vAdj);
                }
            }
        }

        return dist;
    }

    //--------------------------------------------------------------------------
    //-------------------- EXERICICIO 5 ----------------------------------------
    /**
     * Cidades com maior centralidade
     *
     * @param nPopular n cidades com maior centralidade a ser devolvidas
     * @return cidades com maior centralidade
     */
    public List<String> citiesWithMoreCentrality(int nPopular, double pLeast) {
        Map<String, Double> cities = new HashMap<>();
        Map<String, Double> citiesCopy = new HashMap<>();

        List<String> s = new ArrayList<>();

        ArrayList<LinkedList<String>> paths = new ArrayList<>();
        ArrayList<Double> dists = new ArrayList<>();

        for (String capital : citiesCon.vertices()) {
            double sum = 0;
            GraphAlgorithms.shortestPaths(citiesCon, capital, paths, dists);
            for (int i = 0; i < dists.size(); i++) {
                if (dists.get(i) != Double.MAX_VALUE) {     // se o valor for superior ao máximo quer dizer que os vértices não têm nenhuma ligacao possivel com o vertice em consideracao
                    sum += dists.get(i);
                }
            }

            cities.put(capital, sum / citiesCon.numVertices());
        }

        Iterator<Map.Entry<String, Double>> iter = cities.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Double> entry = iter.next();
            if (relativeFrequencyUsersPerCity(entry.getKey()) < pLeast) {
                iter.remove();
            }
        }

        Map sortedMap = sortByValue(cities);

        int cnt = 0;
        for (Object key : sortedMap.keySet()) {
            if (cnt == nPopular) {
                break;
            }
            citiesCopy.put((String) key, (Double) sortedMap.get(key));
            cnt++;
        }
        Map sorted = sortByValue(citiesCopy);
        List<String> returnedList = new ArrayList<>(sorted.keySet());

        return returnedList;
    }

    /**
     * Devolve a percetagem relativa de utilizadores de uma cidade
     *
     * @param city cidade a devolver a frequência relativa
     * @return Map percentagem relativa de utilizadores de uma cidade
     */
    protected double relativeFrequencyUsersPerCity(String city) {
        double cityFreq = 0;
        for (String c : citiesCon.vertices()) {
            int countUsers = 0;
            if (c.equals(city)) {
                for (User us : relations.vertices()) {
                    if (us.getCity().equals(c)) {
                        countUsers++;
                    }
                }

                cityFreq = countUsers / (double) relations.numVertices();
            }
        }
        return cityFreq * 100;
    }

    /**
     * Devolve o país pela sua capital
     *
     * @param city capital do país a ser devolvido
     * @return país com a respetiva capital
     */
    public Country getCountryByCity(String city) {
        Country co = null;
        for (Country c : countriesList) {
            if (c.getCapital().equals(city)) {
                co = c;
            }
        }
        return co;
    }

    //-------------------------------------------------------------------------
    //------------------------ EXERCICIO 6 ------------------------------------
    /**
     * Devolve o caminho terrestre mais curto entre dois utilizadores passando
     * por cidades intermédias
     *
     * @param u1 utilizador 1 (vertice origem do caminho)
     * @param u2 utilizador 2 (vertice final do caminho)
     * @param intermediate cidades intermedias entre as cidades em que os dois
     * utilizadores estão registados
     * @param n n cidades intermedias que corresponde às cidades que possuem o
     * maior número de amigos dos utilizadores
     * @return caminho mais curto entre o vértice origem, passando por todos os
     * vértices intermédios, com destino ao vértice final. Será retornado no
     * tipo de nested map para ser possível demonstrar cada caminho entre um
     * vertice (origem ou intermediario) e o seu vertice (intermediario ou
     * destino)
     *
     */
    public Map<Integer, LinkedHashMap<String, Double>> shortestPathWithIntermediateVertexs(User u1, User u2, LinkedList<String> intermediate, int n) {

        if (intermediate.isEmpty()) { //so para efeitos de testes unitarios
            intermediate = intermidiateVertices(u1, u2, n);
        }

        Iterator<String> iter = intermediate.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            if (str.equals(u1.getCity()) || str.equals(u2.getCity())) {
                iter.remove();
            }
        }

        intermediate.addFirst(u1.getCity());
        intermediate.addLast(u2.getCity());

        Map<Integer, LinkedHashMap<String, Double>> paths = new HashMap<>();

        for (int i = 1; i < intermediate.size(); i++) {
            LinkedHashMap<String, Double> map2 = new LinkedHashMap<>();
            LinkedList<String> info = new LinkedList<>();
            GraphAlgorithms.shortestPath(citiesCon, intermediate.get(i - 1), intermediate.get(i), info);

            LinkedList<String> copyCity = new LinkedList<>();

            //insere os vertices ao map 2
            for (int b = 0; b < info.size(); b++) {

                copyCity.add(info.get(b));
                map2.put(info.get(b), 0.0);

            }

            //insere a distancia entre os vertices para o map a ser retornado
            for (int cc = 0; cc < copyCity.size(); cc++) {
                if (cc > 0) {
                    for (String mm : map2.keySet()) {
                        if (copyCity.get(cc).equals(mm)) {
                            Country a = getCountryByCity(copyCity.get(cc - 1));
                            Country b = getCountryByCity(copyCity.get(cc));
                            Double distance = calculateDistance(a, b);
                            map2.put(mm, distance);
                        }
                    }
                }
            }

            paths.put(i, map2);
        }

        for (Integer j : paths.keySet()) {
            if (paths.get(j).isEmpty()) {
                return null;
            }
        }

        return paths;

    }

    /**
     * Retorna os vértices intermédios entre os dois utilizadores
     *
     * @param u1 utilizador 1 (vertice origem do caminho)
     * @param u2 utilizador 2 (vertice destino do camino)
     * @param n n cidades intermedias onde cada utilizador tem o maior número de
     * amigos
     * @return cidades intermedias entre os dois utilizadores
     */
    private LinkedList<String> intermidiateVertices(User u1, User u2, int n) {
        LinkedList<String> l1 = userCitiesWithMoreFriends(u1, n);
        LinkedList<String> l2 = userCitiesWithMoreFriends(u2, n);
        LinkedList<String> mergedLists = mergeLists(l1, l2);

        return mergedLists;
    }

    /**
     * Junta duas listas, removendo os valores repetidos
     *
     * @param l1 lista 1
     * @param l2 lista 2
     * @return junção das duas listas
     */
    private LinkedList<String> mergeLists(List<String> l1, List<String> l2) {
        List<String> l1u = l1;
        List<String> l2u = l2;

        List<String> mergeList = new ArrayList<>();

        for (String s : l1u) {
            mergeList.add(s);
        }
        for (String s : l2u) {
            mergeList.add(s);
        }
        LinkedList<String> noDuplicates = new LinkedList<>();
        for (String s : mergeList) {
            if (!noDuplicates.contains(s)) {
                noDuplicates.add(s);
            }
        }

        return noDuplicates;
    }

    /**
     * Devolve as n cidades em que o utilizador tem mais amigos
     *
     * @param us utilizador a serem verificadas as cidades em que tem mais
     * amigos
     * @param n n cidades em que o utilizador tem mais amigos
     * @return n cidades em que o utilizador tem mais camigos
     */
    public LinkedList<String> userCitiesWithMoreFriends(User us, int n) {
        Map<String, Integer> mapCountries = new HashMap<>();

        LinkedList<String> friendsCities = new LinkedList<>();
        LinkedList<String> returnedCities = new LinkedList<String>();

        if (!usersList.contains(us)) {
            return null;
        }

        //ligacoes diretas do user, ou seja, os seus amigos
        for (User u : relations.directConnections(us)) {
            friendsCities.add(u.getCity());
        }
        //conta a frequencia de cada cidade nos amigos do utilizador us
        for (String s : friendsCities) {
            LinkedList<String> shortPath = new LinkedList<>();
            double shortestPath = GraphAlgorithms.shortestPath(citiesCon, s, us.getCity(), shortPath);

            if (shortestPath != 0) { // ha cidades em que nao ha caminho terrestre possivel, e preciso ter isso em conta
                mapCountries.put(s, Collections.frequency(friendsCities, s));
            }

        }

        Map order = sortByValue(mapCountries);
        int count = 0;
        Iterator<Map.Entry<String, Integer>> iter = order.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Integer> entry = iter.next();
            if (count >= n) {
                break;
            }
            returnedCities.add(entry.getKey());
            count++;
        }

        return returnedCities;
    }

    /**
     * Ordena um map
     *
     * @param utlznumAmigos mapa a ser ordenado
     * @return mapa ordenado
     */
    private static LinkedHashMap<User, Integer> sortMap(LinkedHashMap<User, Integer> utlznumAmigos) {
        List<Map.Entry<User, Integer>> lista = new LinkedList<>(utlznumAmigos.entrySet());

        Collections.sort(lista, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<User, Integer> resultado = new LinkedHashMap<>();
        for (Map.Entry<User, Integer> entry : lista) {
            resultado.put(entry.getKey(), entry.getValue());
        }
        return resultado;
    }

    //Fonte: https://mkyong.com/java/how-to-sort-a-map-in-java/
    /**
     * Ordena um map pelos seus valores
     *
     * @param <K> tipo do mapa
     * @param <V> tipo do mapa
     * @param unsortMap map a ser ordenado
     * @return map ordenado pelo seu valor
     */
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {

        List<Map.Entry<K, V>> list
                = new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return -1 * (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;

    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValueAscending(Map<K, V> unsortMap) {

        List<Map.Entry<K, V>> list
                = new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;

    }

}
