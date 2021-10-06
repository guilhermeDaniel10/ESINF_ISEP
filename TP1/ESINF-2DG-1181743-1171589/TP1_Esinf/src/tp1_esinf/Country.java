/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_esinf;

import java.util.Objects;

/**
 *
 * @author guilhermedaniel
 */
public class Country {

    
    /**
     * ISO code do país
     */
    private String isoCode;
    /**
     * Continente do país
     */
    private String continent;
    /**
     * Nome do país
     */
    private String name;
    /**
     * População do país
     */
    private int population;
    /**
     * 65 ou mais anos
     */
    private double aged65Older;
    /**
     * Indíce de mortalidade devido a doenças cardiovasculares
     */
    private double cardiovascularDeathRate;
    /**
     * Prevalência de diabetes
     */
    private double diabetesPrevelance;
    /**
     * Fumadoras
     */
    private double femaleSmokers;
    /**
     * Fumadores
     */
    private double maleSmokers;
    /**
     * Camas por hospital
     */
    private double hospitalThousand;
    /**
     * Esperança média de vida
     */
    private double lifeExpectancy;

    /**
     * Construtor da classe Country
     * @param isoCode
     * @param continent
     * @param name
     * @param population
     * @param aged65Older
     * @param cardiovascularDeathRate
     * @param diabetesPrevelance
     * @param femaleSmokers
     * @param maleSmokers
     * @param hospitalThousand
     * @param lifeExpectancy 
     */
    public Country(String isoCode, String continent, String name, int population, double aged65Older, 
            double cardiovascularDeathRate, double diabetesPrevelance, double femaleSmokers, double maleSmokers, 
            double hospitalThousand, double lifeExpectancy) {
        this.isoCode = isoCode;
        this.continent = continent;
        this.name = name;
        this.population = population;
        this.aged65Older = aged65Older;
        this.cardiovascularDeathRate = cardiovascularDeathRate;
        this.diabetesPrevelance = diabetesPrevelance;
        this.femaleSmokers = femaleSmokers;
        this.maleSmokers = maleSmokers;
        this.hospitalThousand = hospitalThousand;
        this.lifeExpectancy = lifeExpectancy;
    }

    /**
     * Devolve os dados da classe Country
     * @return addos da classe Country
     */
    @Override
    public String toString() {
        return "Country{" + "isoCode=" + isoCode + ", continent=" + continent + ", name=" + name + ", population=" + population + ", aged65Older=" + aged65Older + ", cardiovascularDeathRate=" + cardiovascularDeathRate + ", diabetesPrevelance=" + diabetesPrevelance + ", femaleSmokers=" + femaleSmokers + ", maleSmokers=" + maleSmokers + ", hospitalThousand=" + hospitalThousand + ", lifeExpectancy=" + lifeExpectancy + '}';
    }

    /**
     * Devolve o nome do país
     * @return nome do país
     */
    public String getName() {
        return name;
    }

    /**
     * Devolve o ISO code do país
     * @return ISO code do país
     */
    public String getIsoCode() {
        return isoCode;
    }

    /**
     * Devolve a população do país
     * @return população do país
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Devolve o continente onde o país está inserido
     * @return continente onde o país está inserido
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Devolve a percentagem de idosos do país
     * @return percentagem de idosos do país
     */
    public double getAged65Older() {
        return aged65Older;
    }

    /**
     * Devolve o número de camas de hospital por 1000 pessoas
     * @return número de camas de hospital por 1000 pessoas
     */
    public double getHospitalThousand() {
        return hospitalThousand;
    }

    /**
     * Índice de mortalidade por doenças cardiovasculares
     * @return indíce de mortalidade por doenças cardiovasculares
     */
    public double getCardiovascularDeathRate() {
        return cardiovascularDeathRate;
    }

    /**
     * Devolve a prevalência de diabetes
     * @return prevalência de diabetes

     */
    public double getDiabetesPrevelance() {
        return diabetesPrevelance;
    }

    /**
     * Devolve a percentagem de mulheres fumadoras
     * @return percentagem de mulheres fumadoras
     */
    public double getFemaleSmokers() {
        return femaleSmokers;
    }

    /**
     * Devolve a percentagem de homens fumadores
     * @return percentagem de homens fumadores
     */
    public double getMaleSmokers() {
        return maleSmokers;
    }

    /**
     * Devolve a esperança média de vida do país
     * @return esperança média de vida do país
     */
    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * HashCode da classe Country
     * @return hashcode da classe
     */
    @Override
    public int hashCode() {
        int hash = 3;

        hash = 29 * hash + Objects.hashCode(this.isoCode);
        return hash;
    }

    /**
     * Método equals do país só precisa de comparar o iso-code
     * @param o objeto a comparar
     * @return true se for igual false se não for
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Country c = (Country) o;

        return c.isoCode.equals(this.isoCode);
    }

}
