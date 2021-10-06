package tp1_esinf;

import java.time.LocalDate;
import java.util.Objects;

public class Data implements Comparable<Data> {

    /**
     * Data dos dados da COVID-19
     */
    private LocalDate date;
    /**
     * Número total de casos desde o início do registo de dados
     */
    private int totalCases;
    /**
     * Número de novos casos de COVID-19 num determinado dia
     */
    private int newCases;
    /**
     * Número total de mortos desde o início do registo de dados
     */
    private int totalDeaths;
    /**
     * Número de novas mortes num determinado dia devido à COVID-19
     */
    private int newDeaths;
    /**
     * Número de testes realizados num determinado dia à COVID-19
     */
    private int newTests;
    /**
     * Número total de testes realizados desde o início do registo dos dados
     */
    private int totalTests;

    private static final int OMISSAO = 0;

    /**
     *
     * @param date Data da dos dados da COVID-19
     * @param totalCases Número total de casos desde o início do registo de
     * dados
     * @param newCases Número de novos casos de COVID-19 na determinada data
     * @param totalDeaths Número total de mortos desde o início do registo de
     * dados
     * @param newDeaths Número de novas mortes numa determinada data relativa à
     * COVID-19
     * @param newTests Número de testes realizados numa determinada data
     * relativa à COVID-19
     * @param totalTests Número total de testes realizados desde o início do
     * registo dos dados
     */
    public Data(String date, int totalCases, int newCases, int totalDeaths, int newDeaths, int newTests, int totalTests) {
        if (date != null) {
            String s[] = date.split("-");
            this.date = LocalDate.of(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.newTests = newTests;
        this.totalTests = totalTests;
    }

    public Data(String date, int newCases, int newDeaths) {
        if (date != null) {
            String s[] = date.split("-");
            this.date = LocalDate.of(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }
        this.totalCases = OMISSAO;
        this.newCases = newCases;
        this.totalDeaths = OMISSAO;
        this.newDeaths = newDeaths;
        this.newTests = OMISSAO;
        this.totalTests = OMISSAO;
    }

    /**
     * Devolve a data dos dados relativa à COVID-19
     *
     * @return data da informação dos dados
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Devolve o número total dos casos desde início do registo da informção
     *
     * @return número total dos dados
     */
    public int getTotalCases() {
        return totalCases;
    }

    /**
     * Devolve o número de novos casos num determinado dia
     *
     * @return novos casos no determinado dia
     */
    public int getNewCases() {
        return newCases;
    }

    /**
     * Devolve o total de mortes devido à COVID-19 desde do início do registo da
     * informação
     *
     * @return total de mortes devido à COVID-19
     */
    public int getTotalDeaths() {
        return totalDeaths;
    }

    /**
     * Devolve o número de novas mortes num determinado dia devido à COVID-19
     *
     * @return número de novas mortes devido à COVID-19
     */
    public int getNewDeaths() {
        return newDeaths;
    }

    /**
     * Devolve o número de novos testes feitos num determinado dia devido à
     * COVID-19
     *
     * @return número de novos testes de COVID-19
     */
    public int getNewTests() {
        return newTests;
    }

    /**
     * Devolve o número total de testes feitos à COVID-19 desde o início do
     * registo dos dados
     *
     * @return número total de testes feitos à COVID-19
     */
    public int getTotalTests() {
        return totalTests;
    }

    /**
     * Método que compara dois objetos e determina se são iguais ou não
     *
     * @param obj objeto a ser comparado
     * @return true se for igual, false se não
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Data o = (Data) obj;

        return o.date.equals(this.date)
                && o.totalCases == this.totalCases
                && o.newCases == this.newCases
                && o.totalDeaths == this.totalDeaths
                && o.newDeaths == this.newDeaths
                && o.newTests == this.newTests
                && o.totalTests == this.totalTests;

    }

    /**
     * String com a informação dos dados
     *
     * @return
     */
    @Override
    public String toString() {
        return "Data{" + "date=" + date + ", totalCases=" + totalCases + ", newCases=" + newCases + ", totalDeaths=" + totalDeaths + ", newDeaths=" + newDeaths + ", newTests=" + newTests + ", totalTests=" + totalTests + '}' + "\n";
    }

    /**
     * Compara duas datas para ser possível uma posterior ordencação
     *
     * @param o data a ser comparada
     * @return a data ordenada
     */
    @Override
    public int compareTo(Data o) {
        return this.date.compareTo(o.getDate());
    }

}
