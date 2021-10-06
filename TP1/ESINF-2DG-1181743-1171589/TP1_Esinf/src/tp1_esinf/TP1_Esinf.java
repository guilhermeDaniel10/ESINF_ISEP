package tp1_esinf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TP1_Esinf {

    public static void main(String[] args) throws IOException, Exception {

        BufferedReader reader = new BufferedReader(new FileReader("owid-covid-data.csv"));
        List<String> result = new ArrayList<>();

        reader.readLine();
        String line1 = null;

        CovidInfo instance = new CovidInfo();
        instance = new CovidInfo();

        while ((line1 = reader.readLine()) != null) {
            result.add(line1);
        }

        instance.readCountries(result);
        
        print50mil(instance.ordem50Mil());
        printContinenteMes(instance.continenteMes());
        printNovosCasos(instance.novosCasos(9, "Europe"));
        printFumadoresNovasMortes(instance.novasMortes());
        

    }
    
    
    public static void print50mil(List<CovidInfo.Sorter> l){
        String header = String.format("%s%15s%20s%23s%20s%10s", "iso_code", "continent", "location", "date", "total_cases", "mindays");
        System.out.println(header);
        for (CovidInfo.Sorter s : l) {
            System.out.println(s.toString());
        }
    }
    
    public static void printContinenteMes(Map<String, Map<Integer, Data>> continenteMes){
        String str = String.format("\n%-16s%-13s%-15s%-10s", "continent", "month", "new_cases", "new_deaths");
        String x = "";
        for (String s : continenteMes.keySet()) {
            for (int in : continenteMes.get(s).keySet()) {
                str = str + "\n" + String.format("%-20s%-12s%-15s%-10s", s, in, continenteMes.get(s).get(in).getNewCases(), continenteMes.get(s).get(in).getNewDeaths());

            }
            str = str + "\n";
            x = str.replaceAll("\"", "");
        }
        System.out.println(x);
    }
    
    public static void printNovosCasos(Map<Integer, LinkedHashMap<String, Integer>> novosCasos) {
        String x = "";
        String s = "";
        for (int in : novosCasos.keySet()) {
            if (novosCasos.get(in).isEmpty()) {
                break;
            }
            s = s + "\n\nDay--> " + in + "\n";
            for (String sr : novosCasos.get(in).keySet()) {
                s = s + sr + " (" + novosCasos.get(in).get(sr) + ")" + "\n";
            }
        }
        x = s.replaceAll("\"", "");
        System.out.println(x);

    }
    
    public static void printFumadoresNovasMortes(List<CovidInfo.SortNewDeaths> novasMortes) {

        System.out.println("Países com mais de 70% de fumadores, ordenados por\n"
                + "ordem decrescente do número de novas mortes: \n");

        for (CovidInfo.SortNewDeaths sN : novasMortes) {
            System.out.println(sN.toString());
        }
    }

}
