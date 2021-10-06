/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2esinf;

import java.util.Objects;

public class Border {

    /**
     * Primeiro país da fronteira
     */
    private String countryA;
    /**
     * Segundo país da fronteira
     */
    private String countryB;

    /**
     * Construtor da classe Border que representa a fronteira entre dois países
     */
    public Border(String countryA, String countryB) {
        this.countryA = countryA;
        this.countryB = countryB;
    }

    /**
     * Devolvo o primeiro país da fronteira
     * @return primeiro país da fronteira
     */
    public String getCountryA() {
        return countryA;
    }

    /**
     * Devolve o segundo país da fronteira
     * @return segundo país da fronteira
     */
    public String getCountryB() {
        return countryB;
    }

    /**
     * Modifica o primeiro país da fronteira
     * @param countryA dados do país a ser modificar
     */
    public void setCountryA(String countryA) {
        this.countryA = countryA;
    }

    /**
     * Modifica o segundo país da fronteira
     * @param countryB dados do país a modificar
     */
    public void setCountryB(String countryB) {
        this.countryB = countryB;
    }

    /**
     * Método equals da classe border
     * @param obj objeto a ser comparado
     * @return true se for igual, false se não for
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Border other = (Border) obj;
        if (!Objects.equals(this.countryA, other.countryA)) {
            return false;
        }
        if (!Objects.equals(this.countryB, other.countryB)) {
            return false;
        }
        return true;
    }

    /**
     * Método toString da classe 
     * @return String da classe
     */
    @Override
    public String toString() {
        return "Borders{" + "countryA=" + countryA + ", countryB=" + countryB + '}';
    }

}
