/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2esinf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class RedeSocialTest {

    RedeSocial small = new RedeSocial();
    RedeSocial big = new RedeSocial();

    public RedeSocialTest() {

    }

    @Before
    public void setUpClass() {

        small.citiesCon.insertVertex("buenosaires");
        small.citiesCon.insertVertex("lapaz");
        small.citiesCon.insertVertex("brasilia");
        small.citiesCon.insertVertex("santiago");
        small.citiesCon.insertVertex("bogota");
        small.citiesCon.insertVertex("quito");
        small.citiesCon.insertVertex("georgetwon");
        small.citiesCon.insertVertex("caiena");
        small.citiesCon.insertVertex("assuncao");
        small.citiesCon.insertVertex("lima");
        small.citiesCon.insertVertex("paramaribo");
        small.citiesCon.insertVertex("caracas");
        small.citiesCon.insertVertex("montevideu");

        small.citiesCon.insertEdge("buenosaires", "lapaz", 0, 2236.888589685118);
        small.citiesCon.insertEdge("buenosaires", "brasilia", 1, 2339.523505993238);
        small.citiesCon.insertEdge("buenosaires", "santiago", 2, 1137.3016992976368);
        small.citiesCon.insertEdge("buenosaires", "assuncao", 3, 1037.9507527442136);
        small.citiesCon.insertEdge("buenosaires", "montevideu", 4, 202.56109880836252);

        small.citiesCon.insertEdge("lapaz", "brasilia", 5, 2160.3656330397453);
        small.citiesCon.insertEdge("lapaz", "santiago", 6, 1902.0640070438697);
        small.citiesCon.insertEdge("lapaz", "assuncao", 7, 1465.164839309348);
        small.citiesCon.insertEdge("lapaz", "lima", 8, 1077.1716751458634);

        small.citiesCon.insertEdge("brasilia", "bogota", 9, 3663.8133295540165);
        small.citiesCon.insertEdge("brasilia", "georgetwon", 10, 2752.1388548410937);
        small.citiesCon.insertEdge("brasilia", "caiena", 11, 2353.640751803721);
        small.citiesCon.insertEdge("brasilia", "assuncao", 12, 1462.3956303204711);
        small.citiesCon.insertEdge("brasilia", "lima", 13, 3165.426184239328);
        small.citiesCon.insertEdge("brasilia", "paramaribo", 14, 2535.399554891958);
        small.citiesCon.insertEdge("brasilia", "montevideu", 15, 2280.2572602614);
        small.citiesCon.insertEdge("brasilia", "caracas", 16, 3589.2943300614215);

        small.citiesCon.insertEdge("santiago", "lima", 17, 2467.779768526306);

        small.citiesCon.insertEdge("bogota", "quito", 18, 730.1939078767555);
        small.citiesCon.insertEdge("bogota", "lima", 19, 1880.1557314559245);
        small.citiesCon.insertEdge("bogota", "caracas", 20, 1028.1034189987058);

        small.citiesCon.insertEdge("quito", "lima", 21, 1323.9257733436225);

        small.citiesCon.insertEdge("georgetwon", "paramaribo", 22, 346.34830638623976);
        small.citiesCon.insertEdge("georgetwon", "caracas", 23, 1042.6532129134248);

        small.citiesCon.insertEdge("caiena", "paramaribo", 24, 330.3809145922913);

        User u1 = new User("u1", 27, "brasilia");
        User u2 = new User("u2", 18, "lapaz");
        User u3 = new User("u3", 20, "quito");
        User u4 = new User("u4", 47, "paramaribo");
        User u5 = new User("u5", 59, "quito");
        User u6 = new User("u6", 51, "paramaribo");
        User u7 = new User("u7", 13, "montevideu");
        User u9 = new User("u9", 12, "lapaz");
        User u10 = new User("u10", 47, "georgetwon");
        User u14 = new User("u14", 22, "paramaribo");
        User u15 = new User("u15", 29, "bogota");
        User u16 = new User("u16", 53, "assuncao");
        User u19 = new User("u19", 31, "bogota");
        User u20 = new User("u20", 20, "brasilia");
        User u21 = new User("u21", 22, "assuncao");
        User u23 = new User("u23", 28, "bogota");
        User u24 = new User("u24", 13, "lima");
        User u25 = new User("u25", 17, "brasilia");
        User u26 = new User("u26", 44, "georgetwon");
        User u27 = new User("u27", 24, "paramaribo");
        User u28 = new User("u28", 29, "caracas");
        User u29 = new User("u29", 13, "santiago");
        User u30 = new User("u30", 34, "santiago");
        User u31 = new User("u31", 52, "buenosaires");
        User u32 = new User("u32", 55, "brasilia");
        User u33 = new User("u33", 48, "brasilia");

        small.relations.insertVertex(u1);
        small.relations.insertVertex(u2);
        small.relations.insertVertex(u3);
        small.relations.insertVertex(u4);
        small.relations.insertVertex(u5);
        small.relations.insertVertex(u6);
        small.relations.insertVertex(u7);
        small.relations.insertVertex(u9);
        small.relations.insertVertex(u10);
        small.relations.insertVertex(u14);
        small.relations.insertVertex(u15);
        small.relations.insertVertex(u16);
        small.relations.insertVertex(u19);
        small.relations.insertVertex(u20);
        small.relations.insertVertex(u21);
        small.relations.insertVertex(u23);
        small.relations.insertVertex(u24);
        small.relations.insertVertex(u25);
        small.relations.insertVertex(u26);
        small.relations.insertVertex(u27);
        small.relations.insertVertex(u28);
        small.relations.insertVertex(u29);
        small.relations.insertVertex(u30);
        small.relations.insertVertex(u31);
        small.relations.insertVertex(u32);
        small.relations.insertVertex(u33);

        small.relations.insertEdge(u2, u1, 1.0);
        small.relations.insertEdge(u3, u1, 1.0);
        small.relations.insertEdge(u4, u1, 1.0);
        small.relations.insertEdge(u5, u1, 1.0);
        small.relations.insertEdge(u6, u1, 1.0);
        small.relations.insertEdge(u7, u1, 1.0);
        small.relations.insertEdge(u9, u1, 1.0);
        small.relations.insertEdge(u14, u1, 1.0);
        small.relations.insertEdge(u20, u1, 1.0);
        small.relations.insertEdge(u32, u1, 1.0);
        small.relations.insertEdge(u3, u2, 1.0);
        small.relations.insertEdge(u4, u2, 1.0);
        small.relations.insertEdge(u14, u2, 1.0);
        small.relations.insertEdge(u20, u2, 1.0);
        small.relations.insertEdge(u31, u2, 1.0);
        small.relations.insertEdge(u4, u3, 1.0);
        small.relations.insertEdge(u9, u3, 1.0);
        small.relations.insertEdge(u10, u3, 1.0);
        small.relations.insertEdge(u14, u3, 1.0);
        small.relations.insertEdge(u28, u3, 1.0);
        small.relations.insertEdge(u29, u3, 1.0);
        small.relations.insertEdge(u33, u3, 1.0);
        small.relations.insertEdge(u14, u4, 1.0);
        small.relations.insertEdge(u7, u5, 1.0);
        small.relations.insertEdge(u7, u6, 1.0);
        small.relations.insertEdge(u31, u9, 1.0);
        small.relations.insertEdge(u33, u9, 1.0);
        small.relations.insertEdge(u33, u15, 1.0);
        small.relations.insertEdge(u33, u16, 1.0);
        small.relations.insertEdge(u33, u19, 1.0);
        small.relations.insertEdge(u33, u21, 1.0);
        small.relations.insertEdge(u33, u23, 1.0);
        small.relations.insertEdge(u26, u24, 1.0);
        small.relations.insertEdge(u28, u24, 1.0);
        small.relations.insertEdge(u30, u24, 1.0);
        small.relations.insertEdge(u33, u24, 1.0);
        small.relations.insertEdge(u26, u25, 1.0);
        small.relations.insertEdge(u28, u25, 1.0);
        small.relations.insertEdge(u32, u25, 1.0);
        small.relations.insertEdge(u32, u26, 1.0);
        small.relations.insertEdge(u30, u27, 1.0);
        small.relations.insertEdge(u32, u29, 1.0);
        small.relations.insertEdge(u33, u30, 1.0);
        small.relations.insertEdge(u33, u31, 1.0);
        small.relations.insertEdge(u33, u32, 1.0);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of readFromFileCountries method, of class RedeSocial.
     */
    @Test
    public void testReadFromFileCountries() throws Exception {
        System.out.println("readFromFileCountries");
        String filename = "scountries.txt";
        RedeSocial instance = new RedeSocial();
        instance.readFromFileCountries(filename);
        assertEquals(instance.citiesCon.vertices(), small.citiesCon.vertices());
    }

    /**
     * Test of readFromFileBorders method, of class RedeSocial.
     */
    @Test
    public void testReadFromFileBorders() throws Exception {
        System.out.println("readFromFileBorders");
        String filename = "scountries.txt";
        String filename1 = "sborders.txt";
        RedeSocial instance = new RedeSocial();
        instance.readFromFileCountries(filename);
        instance.readFromFileBorders(filename1);
        assertEquals(instance.citiesCon.toString(), small.citiesCon.toString());
    }

    /**
     * Test of calculateDistance method, of class RedeSocial.
     */
    @Test
    public void testCalculateDistance() {
        System.out.println("calculateDistance");
        Country a = new Country("argentina", "americasul", 41.67, "buenosaires", -34.6131500, -58.3772300);
        Country b = new Country("bolivia", "americasul", 9.70, "lapaz", -16.5000000, -68.1500000);
        RedeSocial instance = new RedeSocial();
        double expResult = 2236.888589685118;
        double result = instance.calculateDistance(a, b);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of readFromFileUsers method, of class RedeSocial.
     */
    @Test
    public void testReadFromFileUsers() throws Exception {
        System.out.println("readFromFileUsers");
        String filename = "susers.txt";
        RedeSocial instance = new RedeSocial();
        instance.readFromFileUsers(filename);
        assertEquals(instance.relations.vertices(), small.relations.vertices());
    }

    /**
     * Test of readFromFileRelations method, of class RedeSocial.
     */
    @Test
    public void testReadFromFileRelations() throws Exception {
        System.out.println("readFromFileRelations");
        String filename = "susers.txt";
        String filename1 = "srelationships.txt";
        RedeSocial instance = new RedeSocial();
        instance.readFromFileUsers(filename);
        instance.readFromFileRelations(filename1);
        assertEquals(instance.relations.edges(), small.relations.edges());
    }

    /**
     * Test of isConnected method, of class RedeSocial.
     */
    @Test
    public void testIsConnected() throws IOException {
        System.out.println("isConnected");
        //--------Small----------------       
        String filename = "susers.txt";
        String filename1 = "srelationships.txt";
        RedeSocial instance1 = new RedeSocial();
        instance1.readFromFileUsers(filename);
        instance1.readFromFileRelations(filename1);
        boolean expResult = true;
        boolean result = instance1.isConnected();
        assertEquals(expResult, result);

        //--------Big------------------       
        String filename2 = "busers.txt";
        String filename3 = "brelationships.txt";
        RedeSocial instance2 = new RedeSocial();
        instance2.readFromFileUsers(filename2);
        instance2.readFromFileRelations(filename3);
        boolean expResult2 = false;
        boolean result2 = instance2.isConnected();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of amigosComuns method, of class RedeSocial.
     */
    @Test
    public void testAmigosComuns() throws IOException {
        System.out.println("amigosComuns");
        
        int qtdPopulares = -2;
        
        String filename = "susers.txt";
        String filename1 = "srelationships.txt";
        
        RedeSocial instance1 = new RedeSocial();
        
        instance1.readFromFileUsers(filename);
        instance1.readFromFileRelations(filename1);
        
        assertTrue("O número de utilizadores populares não pode ser 0 ou negativo", instance1.amigosComuns(qtdPopulares)==null);
        
        qtdPopulares = 2;
        
        User u3 = new User("u3", 20, "quito");
        User u9 = new User("u9", 12, "lapaz");
        User u32 = new User("u32", 55, "brasilia");
        
        List<User> expResult = new ArrayList<>();
        
        expResult.add(u3);
        expResult.add(u9);
        expResult.add(u32);
        
        List<User> result = instance1.amigosComuns(qtdPopulares);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of utlzMaisPopulares method, of class RedeSocial.
     */
    @Test
    public void testUtlzMaisPopulares() throws IOException {
        System.out.println("utlzMaisPopulares");
        
        String filename = "susers.txt";
        String filename1 = "srelationships.txt";
        
        RedeSocial instance1 = new RedeSocial();
        
        instance1.readFromFileUsers(filename);
        instance1.readFromFileRelations(filename1);
        
        int qtdPopulares = 2;
        
        User u33 = new User("u33", 48, "brasilia");
        User u1 = new User("u1", 27, "brasilia");
        
        List<User> expResult = new ArrayList<>();
        expResult.add(u33);
        expResult.add(u1);
        
        List<User> result = instance1.utlzMaisPopulares(qtdPopulares);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of minConncectionsToReachAllUsers method, of class RedeSocial.
     */
    @Test
    public void testminConncectionsToReachAllUsers() throws IOException {
        System.out.println("floydWarshall");
        String filename1 = "susers.txt";
        String filename2 = "busers.txt";
        String filename11 = "srelationships.txt";
        String filename22 = "brelationships.txt";

        RedeSocial instance1 = new RedeSocial();
        RedeSocial instance2 = new RedeSocial();

        instance1.readFromFileUsers(filename1);
        instance1.readFromFileRelations(filename11);
        instance2.readFromFileUsers(filename2);
        instance2.readFromFileRelations(filename22);

        Double result1 = instance1.minConncectionsToReachAllUsers();
        Double result2 = instance2.minConncectionsToReachAllUsers(); // o ficheiro busers.txt não é conectado

        Double expResult1 = 5.0;
        Double expResult2 = 0.0;

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);

    }

    /**
     * Test of citiesWithMoreCentrality method, of class RedeSocial.
     */
    @Test
    public void testCitiesWithMoreCentrality() throws IOException {
        System.out.println("citiesWithMoreCentrality");

        String filename1 = "susers.txt";
        String filename11 = "srelationships.txt";
        String filename111 = "scountries.txt";
        String filename1111 = "sborders.txt";

        String filename2 = "busers.txt";
        String filename22 = "brelationships.txt";
        String filename222 = "bcountries.txt";
        String filename2222 = "bborders.txt";

        RedeSocial instance1 = new RedeSocial();
        RedeSocial instance2 = new RedeSocial();
        instance1.readFromFileUsers(filename1);
        instance1.readFromFileRelations(filename11);
        instance1.readFromFileCountries(filename111);
        instance1.readFromFileBorders(filename1111);
        instance2.readFromFileUsers(filename2);
        instance2.readFromFileRelations(filename22);
        instance2.readFromFileCountries(filename222);
        instance2.readFromFileBorders(filename2222);

        int nPopular = 4;
        double pLeast = 2.3;

        List<String> expResult1 = new ArrayList<>();
        expResult1.add("santiago");
        expResult1.add("montevideu");
        expResult1.add("buenosaires");
        expResult1.add("caracas");

        List<String> result1 = instance1.citiesWithMoreCentrality(nPopular, pLeast);
        assertEquals(expResult1, result1);

        List<String> expResult2 = new ArrayList<>();
        expResult2.add("oslo");
        expResult2.add("erevan");
        expResult2.add("tbilisi");
        expResult2.add("tirana");

        List<String> result2 = instance2.citiesWithMoreCentrality(nPopular, pLeast);
        assertEquals(expResult2, result2);

        nPopular = 2;
        pLeast = 10;

        List<String> expResult3 = new ArrayList<>();
        expResult3.add("paramaribo");
        expResult3.add("bogota");
        List<String> result3 = instance1.citiesWithMoreCentrality(nPopular, pLeast);
        assertEquals(expResult3, result3);

        List<String> expResult4 = new ArrayList<>();
        List<String> result4 = instance2.citiesWithMoreCentrality(nPopular, pLeast);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of relativeFrequencyUsersPerCity method, of class RedeSocial.
     */
    @Test
    public void testRelativeFrequencyUsersPerCity() throws IOException {
        System.out.println("relativeFrequencyUsersPerCity");

        String filename1 = "susers.txt";
        String filename11 = "srelationships.txt";
        String filename111 = "scountries.txt";
        String filename1111 = "sborders.txt";

        RedeSocial instance1 = new RedeSocial();
        instance1.readFromFileUsers(filename1);
        instance1.readFromFileRelations(filename11);
        instance1.readFromFileCountries(filename111);
        instance1.readFromFileBorders(filename1111);

        String city = "bogota";

        double expResult = 11.538461538461538;
        double result = instance1.relativeFrequencyUsersPerCity(city);
        assertEquals(expResult, result, 0.0);

        city = "";
        expResult = 0.0;
        result = instance1.relativeFrequencyUsersPerCity(city);
        assertEquals(expResult, result, 0.0);

        city = "brasilia";
        expResult = 19.230769230769234;
        result = instance1.relativeFrequencyUsersPerCity(city);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of shortestPathWithIntermediateVertexs method, of class RedeSocial.
     */
    @Test
    public void testShortestPathWithIntermediateVertexs() throws IOException {
        // o algortimo devolve um nested map, em que cada iteração do map principal, corresponde um linkedhashmap com o path de vertices obrigatorios
        // Por exemplo : 1: vertice origem - (...) - intermedio1 ; 2: intermedio1 - (...) - intermedio2; 3: intermedio2 - (...) - vertice destino
        System.out.println("shortestPathWithIntermediateVertexs");

        String filename2 = "busers.txt";
        String filename22 = "brelationships.txt";
        String filename222 = "bcountries.txt";
        String filename2222 = "bborders.txt";

        RedeSocial instance = new RedeSocial();

        instance.readFromFileUsers(filename2);
        instance.readFromFileRelations(filename22);
        instance.readFromFileCountries(filename222);
        instance.readFromFileBorders(filename2222);

        User u1 = new User("u4", 63, "amsterdam");
        User u2 = new User("u16", 31, "budapeste");
        
        User user1 = new User("u4",63,"amsterdam");
        User user2 = new User("u29",74,"belgrado");
        //teste com vertices intermedios definidos pelas cidades em que os dois utilizadores tenham o maior numero de amigos
        LinkedList<String> intm1 = new LinkedList<>();
        Map<Integer, LinkedHashMap<String, Double>> resultMap1 = instance.shortestPathWithIntermediateVertexs(user1, user2, intm1, 2);
        Map<Integer, LinkedHashMap<String, Double>> expResultMap1 = new HashMap<>();
        LinkedHashMap<String, Double> um = new LinkedHashMap<>();
        LinkedHashMap<String, Double> dois = new LinkedHashMap<>();
        LinkedHashMap<String, Double> tres = new LinkedHashMap<>();
        LinkedHashMap<String, Double> quatro = new LinkedHashMap<>();
        LinkedHashMap<String, Double> cinco = new LinkedHashMap<>();
        
        um.put("amsterdam", 0.0);
        um.put("berlim", 577.3384636936879);
        um.put("praga", 279.7545242580826);
        
        dois.put("praga", 0.0);
        dois.put("varsovia", 517.456071712376);
        dois.put("vilnius", 393.1105708019216);
        dois.put("riga", 261.49019874548725);
        dois.put("tallinn", 279.73344802863346);
        
        tres.put("tallinn", 0.0);
        tres.put("riga", 279.73344802863346);
        tres.put("vilnius", 261.49019874548725);
        tres.put("varsovia", 393.1105708019216);
        tres.put("bratislava", 532.0217352313922);
        tres.put("budapeste", 161.4237690324878);
        tres.put("belgrado", 319.2264139482306);
        tres.put("sarajevo", 194.18075036921482);
        
        quatro.put("sarajevo", 0.0);
        quatro.put("podgorica", 171.8392550397922);
        quatro.put("tirana", 132.03210153105016);

        cinco.put("tirana", 0.0);
        cinco.put("podgorica", 132.03210153105016);
        cinco.put("belgrado", 279.52253840783794);

        expResultMap1.put(1, um);
        expResultMap1.put(2, dois);
        expResultMap1.put(3, tres);
        expResultMap1.put(4, quatro);
        expResultMap1.put(5, cinco);
        
        assertEquals(expResultMap1, resultMap1);
        
        //teste com vertices intermedios ja definidos e apenas para o tamanho de caminhos 
        LinkedList<String> intm = new LinkedList<>();
        intm.add("praga");
        intm.add("tallinn");
        int n = 3;

        Map<Integer, LinkedHashMap<String, Double>> resultMap = instance.shortestPathWithIntermediateVertexs(u1, u2, intm, n);
        //vertice de inicio, intermedios e final equivalem a 3 paths diferentes: inicio-intermedio1, intermedio1-intermedio2, intermedio2-final
        int result = resultMap.keySet().size();
        int expResult = 3;
        
        assertEquals(expResult, result);
        
        Double totalSum = 0.0;
        for(Integer i : resultMap.keySet()){
            for(String s : resultMap.get(i).keySet()){
                totalSum += resultMap.get(i).get(s);
            }
        }
        
        Double expResult2 = 3936.662999080111;
        //soma total da distancia do caminho
        assertEquals(expResult2, totalSum);
        
        User u3 = new User("u21",30,"bogota");
        LinkedList<String> intm2 = new LinkedList<>();
        intm2.add("praga");
        n = 4;
        Map<Integer, LinkedHashMap<String, Double>> resultMap2 = instance.shortestPathWithIntermediateVertexs(u1, u3, intm2, n);

        // se nao existir caminho terrestre entre duas cidades, o resultado sera obrigatoriamente null
        assertEquals(resultMap2, null);
    }

    /**
     * Teste do método userCitiesWithMoreFriends, que devolve as n cidades em que o utilizador tem mais amigos
     */
    @Test
    public void testUserCitiesWithMoreFriends() throws IOException {
        System.out.println("userCitiesWithMoreFriends");
        
        String filename2 = "busers.txt";
        String filename22 = "brelationships.txt";
        String filename222 = "bcountries.txt";
        String filename2222 = "bborders.txt";

        RedeSocial instance = new RedeSocial();

        instance.readFromFileUsers(filename2);
        instance.readFromFileRelations(filename22);
        instance.readFromFileCountries(filename222);
        instance.readFromFileBorders(filename2222);
        
        User u1 = new User("u4", 63, "amsterdam");
        
        LinkedList<String> expResult = new LinkedList<>();
        expResult.add("praga");
        expResult.add("tallinn");
        expResult.add("luxemburgo");
        
        LinkedList<String> result = instance.userCitiesWithMoreFriends(u1, 3);
        assertEquals(expResult, result);
        
        //caso o user seja invalido
        User u2 = new User("u1111", 777, "porto");
        LinkedList<String> expResult2 = null;
        LinkedList<String> result2 = instance.userCitiesWithMoreFriends(u2, 1);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of amigosNasProximidades method, of class RedeSocial.
     */
    @Test
    public void testAmigosNasProximidades() throws IOException {
        System.out.println("amigosNasProximidades");

        String filename = "susers.txt";
        String filename1 = "srelationships.txt";
        String filename2 = "scountries.txt";
        String filename3 = "sborders.txt";

        RedeSocial instance = new RedeSocial();
        instance.readFromFileCountries(filename2);
        instance.readFromFileBorders(filename3);
        instance.readFromFileUsers(filename);
        instance.readFromFileRelations(filename1);
        
        int numFronteiras = -2;
        User principal = new User("u1", 27, "brasilia");

        assertTrue("numero de fronteiras não pode ser negativo", instance.amigosNasProximidades(principal, numFronteiras)==null);

        numFronteiras = 2;
        User principalErrado = new User("u43", 27, "cidade do mexico");
        assertTrue("O utilizador não está presente na matriz", instance.amigosNasProximidades(principalErrado, numFronteiras)==null);     
        
        User u2 = new User("u2", 18, "lapaz");
        User u3 = new User("u3", 20, "quito");
        User u4 = new User("u4", 47, "paramaribo");
        User u5 = new User("u5", 59, "quito");
        User u6 = new User("u6", 51, "paramaribo");
        User u7 = new User("u7", 13, "montevideu");
        User u9 = new User("u9", 12, "lapaz");
        User u14 = new User("u14", 22, "paramaribo");
        User u20 = new User("u20", 20, "brasilia");
        User u32 = new User("u32", 55, "brasilia");

        LinkedHashMap<String,String> expResult = new LinkedHashMap<>();
        expResult.put(u20.getUser(), "brasilia");
        expResult.put(u32.getUser(), "brasilia");
        expResult.put(u2.getUser(), "lapaz");
        expResult.put(u9.getUser(), "lapaz");
        expResult.put(u3.getUser(), "quito");
        expResult.put(u5.getUser(), "quito");
        expResult.put(u4.getUser(), "paramaribo");
        expResult.put(u6.getUser(), "paramaribo");
        expResult.put(u14.getUser(), "paramaribo");
        expResult.put(u7.getUser(), "montevideu");
        
        LinkedHashMap<String, String> result = instance.amigosNasProximidades(principal, numFronteiras);

        assertEquals(expResult, result);
    }

}
