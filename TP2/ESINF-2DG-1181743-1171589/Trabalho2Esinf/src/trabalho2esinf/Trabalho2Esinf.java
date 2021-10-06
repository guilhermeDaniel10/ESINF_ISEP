/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2esinf;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class Trabalho2Esinf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner ler = new Scanner(System.in);
        String inf = "";
        boolean valid = false;
        RedeSocial rs = new RedeSocial();

        // EXERCICIO 1
        System.out.println("------------------------------");
        System.out.println("EXERCICIO 1:\n");
        while (valid == false) {
            System.out.println("Carregar informação do ficheiro big ou small (introduza b para big e s para small:");
            inf = ler.next();

            if (inf.equalsIgnoreCase("b")) {
                String filename2 = "busers.txt";
                String filename22 = "brelationships.txt";
                String filename222 = "bcountries.txt";
                String filename2222 = "bborders.txt";

                rs.readFromFileUsers(filename2);
                rs.readFromFileRelations(filename22);
                rs.readFromFileCountries(filename222);
                rs.readFromFileBorders(filename2222);
                valid = true;
                break;
            }
            if (inf.equalsIgnoreCase("s")) {
                String filename1 = "susers.txt";
                String filename11 = "srelationships.txt";
                String filename111 = "scountries.txt";
                String filename1111 = "sborders.txt";

                rs.readFromFileUsers(filename1);
                rs.readFromFileRelations(filename11);
                rs.readFromFileCountries(filename111);
                rs.readFromFileBorders(filename1111);
                valid = true;
                break;
            }
            if (!inf.equalsIgnoreCase("b") || !inf.equalsIgnoreCase("s")) {
                System.out.println("Caracter inválido.");
                valid = false;
            }
        }

        //EXERCICIO 2
        System.out.println("------------------------------");
        System.out.println("EXERCICIO 2:\n");
        int n1;
        System.out.println("Número de utilizadores a serem procurados os amigos comuns:");
        n1 = ler.nextInt();
        List<User> amigosComuns = rs.amigosComuns(n1);

        System.out.println("\nAmigos Comuns: ");
        for (User u : amigosComuns) {
            System.out.println(u.toString() + "\n");
        }

        //EXERCICIO 3
        System.out.println("------------------------------");
        System.out.println("EXERCICIO 3:\n");
        double numeroMinimoLigacoes = rs.minConncectionsToReachAllUsers();
        if (numeroMinimoLigacoes != 0) {
            System.out.println("Número mínimo de ligações necessário para qualquer utilizador conseguir contactar com outro qualquer utilizador: " + numeroMinimoLigacoes);
        } else {
            System.out.println("O grafo não é conectado!");
        }

        //EXERCICIO 4
        System.out.println("------------------------------");
        System.out.println("EXERCICIO 4:\n");
        String us;
        User user = null;
        boolean exists = false;
        while (user == null) {
            System.out.println("Utilizador a procurar os amigos nas proximidades");
            us = ler.next();

            for (User u : rs.relations.vertices()) {
                if (us.equals(u.getUser())) {
                    user = u;
                    break;
                }
            }
            if(user == null){
                System.out.println("\nUtilizador não existe. Insira de novo");
            }
        }
        int n2;
        System.out.println("Número de fronteiras:");
        n2 = ler.nextInt();
        LinkedHashMap<String,String> map = rs.amigosNasProximidades(user, n2);
        
        for(String utlz : map.keySet()){
                System.out.println("User: " + utlz + " pertence a cidade de " + map.get(utlz) + "\n");
        }
        
        
        //EXERCICIO 5
        System.out.println("------------------------------");
        System.out.println("EXERCICIO 5:\n");
        int n3;
        double p;
        System.out.println("Número de cidades com mais centralidade a serem devolvidas:");
        n3 = ler.nextInt();
        System.out.println("p% mínima dos utilizadores:");
        p = ler.nextDouble();
        
        System.out.println("Cidades com mais centralidade:\n");
        List<String> cities = rs.citiesWithMoreCentrality(n3, p);
        for(String s : cities){
            System.out.println(s);
        }
        
        //EXERCICIO 6
        System.out.println("------------------------------");
        System.out.println("EXERCICIO 6:\n");
        String u1;
        String u2;
        User user1 = null;
        User user2 = null;
        
        while (user1 == null) {
            System.out.println("Utilizador origem:");
            u1 = ler.next();

            for (User u : rs.relations.vertices()) {
                if (u1.equals(u.getUser())) {
                    user1 = u;
                    break;
                }
            }
            if(user1 == null){
                System.out.println("\nUtilizador não existe. Insira de novo");
            }
        }
        while (user2 == null) {
            System.out.println("Utilizador destino:");
            u2 = ler.next();

            for (User u : rs.relations.vertices()) {
                if (u2.equals(u.getUser())) {
                    user2 = u;
                    break;
                }
            }
            if(user2 == null){
                System.out.println("\nUtilizador não existe. Insira de novo");
            }
        }
        int n4;
        System.out.println("Número de cidades intermédias em que cada utilizador tenho o maior número de amigos:");
        System.out.println("(n cidades para cada utilizador)");
        n4 = ler.nextInt();
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Caminho terrestre mais curto entre o utilizador origem e o destino, passando pelas n cidades intermédias:");
        System.out.println("(o valor associdado a cada cidade é a distância entre a cidade anterior e a cidade atual)");
        try{
        Map<Integer, LinkedHashMap<String, Double>> m = rs.shortestPathWithIntermediateVertexs(user1, user2, list, n4);
        
        for(Integer i : m.keySet()){
            System.out.println(m.get(i));
        }
        } catch(NullPointerException e){
            System.out.println("Não há caminho terrestre possível!");
        }
    }
}
