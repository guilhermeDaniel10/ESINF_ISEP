package tp1_esinf;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class CovidInfo {

    LinkedHashMap<Country, Set<Data>> m;

    public CovidInfo() {
        m = new LinkedHashMap<>();
    }

    /**
     * Atribui os dados lidos de um ficheiro para o sistema- alínea 1
     *
     * @param l lista com os dados lidos de um ficheiro
     * @throws Exception
     */
    void readCountries(List<String> l) throws Exception {
        Country current = null;

        for (String s : l) {
            String data[] = s.split(",");
            checkNA(data);
            if (current == null || !current.getIsoCode().equals(data[0])) {

                Country c = new Country(data[0], data[1], data[2], Integer.parseInt(data[10]), Double.parseDouble(data[11]),
                        Double.parseDouble(data[12]), Double.parseDouble(data[13]), Double.parseDouble(data[14]),
                        Double.parseDouble(data[15]), Double.parseDouble(data[16]), Double.parseDouble(data[17]));
                current = c;
                m.put(current, new TreeSet<>());

                insertData(c, data);

            } else {
                insertData(current, data);
            }
        }
    }

    /**
     * Insere os dados da classe data no HashMap
     *
     * @param c País que servirá de KeySet do HashMap
     * @param data array com os dados a inserir no HashMap
     */
    void insertData(Country c, String data[]) {
        Data d = new Data(data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]));
        m.get(c).add(d);
    }

    /**
     * Devolve a lista de países ordenados por ordem crescente do número mínimo
     * de dias que foi necessário para atingir os 50.000 casos positivos numa
     * List- alínea 2
     *
     * @return lista de países ordenados por ordem crescente
     */
    public List<Sorter> ordem50Mil() {
        List<Sorter> sort = new ArrayList<>();

        for (Country co : m.keySet()) {
            LocalDate initialDate = LocalDate.of(2020, Month.JANUARY, 1);

            for (Data d : m.get(co)) {
                if (d.getTotalCases() >= 50000) {

                    int dateSub = (int) Duration.between(initialDate.atStartOfDay(), d.getDate().atStartOfDay()).toDays();

                    Sorter s = new Sorter(co, d, dateSub);
                    sort.add(s);

                    break;
                }
            }
        }
        Collections.sort(sort);

        return sort;

    }

    /**
     * Devolve o total de novos_casos/novas_mortes por continente/mês, ordenado
     * por continente/mês- alínea 3
     *
     * @return map de key o continente, que dentro do map há um neste map com
     * key o país para que os novos casos/novas mortes sejas ordenandos
     */
    public Map<String, Map<Integer, Data>> continenteMes() {
        Map<String, Map<Integer, Data>> mCM = new HashMap<>();
        String currentCont = null;
        boolean flag;

        for (Country co : m.keySet()) {
            currentCont = co.getContinent();
            if (!mCM.containsKey(currentCont)) {
                mCM.put(currentCont, new HashMap());
            }
        }

        for (String s : mCM.keySet()) {
            for (int i = 1; i <= 12; i++) {
                int sumNewCases = 0, sumNewDeaths = 0;
                flag = false;
                for (Country co : m.keySet()) {
                    for (Data d : m.get(co)) {
                        if (d.getDate().getMonthValue() == i && co.getContinent().equals(s)) {
                            sumNewCases += d.getNewCases();
                            sumNewDeaths += d.getNewDeaths();
                            flag = true;
                        }
                    }
                }
                if (flag == true) {
                    Data d = new Data(LocalDate.now().toString(), sumNewCases, sumNewDeaths);

                    mCM.get(s).put(i, d);
                }
            }
        }

        return mCM;
    }

    /**
     * Devolver para cada dia de um determinado mês e para um dado continente,
     * os países ordenados por ordem decrescente do número de novos casos
     * positivos - alínea 4
     *
     * @param month mês em que se pretende saber o número de novos casos por dia
     * @param continent continente em que deve ser apresentado o número de novos
     * casos por dia num determinado mês
     *
     * @return map com key o inteiro que é um dia de cada mês, com um neste
     * LinkedHashMap com key uma string que define o país do determinado
     * continente, para que os novos casos positivos de cada país do continente
     * sejam organizados
     */
    public Map<Integer, LinkedHashMap<String, Integer>> novosCasos(int month, String continent) {

        LocalDate date = LocalDate.of(2020, month, 1);
        int nDays = date.lengthOfMonth();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        Map<Integer, LinkedHashMap<String, Integer>> mapDays = new HashMap<>();
        boolean flag;

        for (int i = 1; i <= nDays; i++) {
            map = new LinkedHashMap<>();
            flag = false;
            for (Country co : m.keySet()) {
                for (Data da : m.get(co)) {

                    if (da.getDate().getDayOfMonth() == i && da.getDate().getMonthValue() == month && co.getContinent().contains(continent)) {
                        map.put(co.getName(), da.getNewCases());
                        flag=true;
                    }

                }
            }
            if (flag==true) {
               LinkedHashMap mapSorted = sortMap(map);
                mapDays.put(i, mapSorted); 
            }

        }

        return mapDays;
    }

    /**
     * Devolve todos os países com mais de 70% de fumadores, ordenados por ordem
     * decrescente do número de novas mortes- alínea 5
     *
     * @return lista ordenada da classe SortNewDeaths, que possui o nome do
     * país, a soma das percentagens de fumadores e o número total de mortes
     */
    public List<SortNewDeaths> novasMortes() {
        LocalDate lastDate = LocalDate.of(2020, Month.SEPTEMBER, 29);
        List<SortNewDeaths> list = new ArrayList<>();

        for (Country co : m.keySet()) {
            for (Data da : m.get(co)) {
                double soma = co.getFemaleSmokers() + co.getMaleSmokers();
                
                if (soma > 70 && da.getDate().isEqual(lastDate)) {
                    SortNewDeaths sND = new SortNewDeaths(co.getName(), soma, da.getTotalDeaths());
                    list.add(sND);
                }
            }
        }

        Collections.sort(list);

        return list;
    }

    /**
     * Verifica quais valores são NA num dado array e muda o valor para 0
     *
     * @param data array que representa uma linha da tabela csv com os
     * diferentes dados
     */
    public void checkNA(String data[]) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("NA")) {
                data[i] = "0";

            }
        }

    }

    /**
     * Método usado para ser possível ordenar uma lista para cada dia de um
     * determinado mês e para um dado continente, os países por ordem
     * decrescente do número de novos casos positivos (na alínea 4)
     *
     * @param map LinkedHashMap com o nome do país e o númeor de novos casos
     * @return LinkedHashMap ordenado consoante a explicação do método
     */
    public static LinkedHashMap<String, Integer> sortMap(LinkedHashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> lista = new LinkedList<>(map.entrySet());

        Collections.sort(lista, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<String, Integer> resultado = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : lista) {
            resultado.put(entry.getKey(), entry.getValue());
        }
        return resultado;
    }

    /**
     * Classe que servirá, posteriormente, para ordenar todos os países com mais
     * de 70% de fumadores, por ordem decrescente do número de novas mortes
     * (alínea 5), recorrendo à interafce Comparable
     */
    class SortNewDeaths implements Comparable<SortNewDeaths> {

        String str;
        double dbl;
        int in;

        @Override
        public String toString() {
            String formatDbl = String.format("%.1f", dbl);
            String fmtPoint = formatDbl.replaceAll(",", ".");

            String st = "[" + str + " , " + fmtPoint + " , " + in + "]";
            String x = st.replaceAll("\"", "");
            return x;
        }

        public SortNewDeaths(String str, double dbl, int in) {
            this.str = str;
            this.dbl = dbl;
            this.in = in;
        }

        @Override
        public int compareTo(SortNewDeaths o) {
            return o.in - this.in;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }
            SortNewDeaths s = (SortNewDeaths) o;

            return this.str.equalsIgnoreCase(s.str) &&
                    this.dbl == s.dbl &&
                    this.in == s.in;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 41 * hash + Objects.hashCode(this.str);
            hash = 41 * hash + (int) (Double.doubleToLongBits(this.dbl) ^ (Double.doubleToLongBits(this.dbl) >>> 32));
            hash = 41 * hash + this.in;
            return hash;
        }

    }

    /**
     * Classe que servirá para ordenar a lista de países por ordem crescente do
     * número mínimo de dias que foi necessário para atingir os 50.000 casos
     * positivos, recorrendo à interface comparable (alínea 2)
     */
    public class Sorter implements Comparable<Sorter> {

        private Country country;
        private Data data;
        private int mindays;

        public Sorter(Country c, Data d, int mindays) {
            this.country = c;
            this.data = d;
            this.mindays = mindays;
        }

        @Override
        public String toString() {

            String s = String.format("%-15s%-20s%-30s%-20s%-10s%-15s", country.getIsoCode(), country.getContinent(), country.getName(), data.getDate(), data.getTotalCases(), (mindays + " days"));
            String x = s.replaceAll("\"", "");
            return x;
        }

        @Override
        public int compareTo(Sorter o) {
            return this.mindays - o.mindays;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 29 * hash + Objects.hashCode(this.country);
            hash = 29 * hash + Objects.hashCode(this.data);
            hash = 29 * hash + this.mindays;
            return hash;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }
            Sorter s = (Sorter) o;

            return this.country.equals(s.country) && this.data.equals(s.data) && this.mindays == s.mindays;
        }

    }

}
