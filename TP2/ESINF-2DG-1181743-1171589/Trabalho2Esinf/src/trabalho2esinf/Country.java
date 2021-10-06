
package trabalho2esinf;

import java.util.Objects;

public class Country {
    
    /**
     * Nome do país
     */
    private String country;
    /**
     * Continente do país
     */
    private String continent;
    /**
     * População do país
     */
    private double population;
    /**
     * Capital do país
     */
    private String capital;
    /**
     * Latitude do país
     */
    private double latitude;
    /**
     * Longitude do pa´si
     */
    private double longitude;

    /**
     * Construtor da classe Country
     * @param country nome do país
     * @param continent continente do país
     * @param population população do país
     * @param capital capital do país
     * @param latitude latitude do país
     * @param longitude longitude do país
     */
    public Country(String country, String continent, double population, String capital, double latitude, double longitude) {
        this.country = country;
        this.continent = continent;
        this.population = population;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Devolve o nome do país
     * @return nome do país
     */
    public String getCountry() {
        return country;
    }

    /**
     * Devolve o continente do país
     * @return continente do país
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Devolve a população do país
     * @return população do país
     */
    public double getPopulation() {
        return population;
    }

    /**
     * Devolve a capital do país
     * @return capital do país
     */
    public String getCapital(){
        return capital;
    }
    
    /**
     * Devolve a latitude do país
     * @return latitude do país
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Devolve a longitude do país
     * @return longitude do país
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Modifica o nome do país
     * @param country nome a ser modificado
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Modifica o continente do país
     * @param continent nome do continente a ser modificado
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Modifica a população de um país
     * @param population população a ser modificada
     */
    public void setPopulation(double population) {
        this.population = population;
    }
    
    /**
     * Modifica a capital de um país
     * @param capital capital a ser modificada
     */
    public void setCapital(String capital){
        this.capital = capital;
    }

    /**
     * Modifica a latitude do país
     * @param latitude latitude a ser modificada
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    /**
     * Modifica a longitude do país
     * @param longitude longitude a ser modificada
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Método equals da classe Country
     * @param obj objeto a ser comparado
     * @return true se for igual, false se não for
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null && getClass() != obj.getClass()) {
            return false;
        }

        final Country o = (Country) obj;

        return o.population == this.population
                && o.latitude == this.latitude
                && o.longitude == this.longitude
                && o.country.contains(this.country)
                && o.continent.contains(this.continent)
                && o.capital.contains(this.capital);
    }
    
    /**
     * Método toString da classe Country
     * @return toString da classe
     */
    @Override
    public String toString() {
        return "Country{" + "country=" + country + ", continent=" + continent + ", population=" + population + ", capital=" + capital + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

   

    

}
