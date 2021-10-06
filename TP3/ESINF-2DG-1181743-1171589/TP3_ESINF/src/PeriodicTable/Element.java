package PeriodicTable;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Guilherme
 */
public class Element implements Comparable<Element> {

    /**
     * Número atómico do elemento
     */
    private int atomicNumber;

    /**
     * Nome do elemento
     */
    private String elementName;

    /**
     * Simbolo do elemento
     */
    private String symbol;

    /**
     * Peso atomico do elemento
     */
    private double atomicWeight;

    /**
     * Massa atómica do elemento
     */
    private double atomicMass;

    /**
     * Periodo do elemento
     */
    private int period;

    /**
     * Grupo do elemento
     */
    private int group;

    /**
     * Estado do elemento
     */
    private String phase;

    /**
     * Cristal mais estavel
     */
    private String mostStableCrystal;

    /**
     * Tipo do elemento
     */
    private String type;

    /**
     * Raio ionico
     */
    private double ionicRadius;

    /**
     * Raio atomico
     */
    private double atomicRadius;

    /**
     * Eletronegatividade
     */
    private double electronegativity;

    /**
     * Potencial da primeira ionizacao
     */
    private double firstIonizationPotential;

    /**
     * Densidade do elemento
     */
    private double density;

    /**
     * Ponto de fusao
     */
    private double meltingPoint;

    /**
     * Ponto de ebulicao
     */
    private double boilingPoint;

    /**
     * Isotopo
     */
    private int isotope;

    /**
     * Descobridor
     */
    private String discoverer;

    /**
     * Ano de descoberta
     */
    private int yearOfDiscovery;

    /**
     * Capacidade especifica de aquecimento
     */
    private double specificHeatCapacity;

    /**
     * Configuracao eletronica
     */
    private String electronConfiguration;

    /**
     * Linha do display
     */
    private int displayRow;

    /**
     * Coluna do display
     */
    private int displayColumn;

    public Element(int atomicNumber, String elementName, String symbol, double atomicWeight, double atomicMass, int period, int group, String phase, String mostStableCrystal, String type, double ionicRadius, double atomicRadius, double electronegativity, double firstIonizationPotential, double density, double meltingPoint, double boilingPoint, int isotope, String discoverer, int yearOfDiscovery, double specificHeatCapacity, String electronConfiguration, int displayRow, int displayColumn) {

        this.atomicNumber = atomicNumber;
        this.elementName = elementName;
        this.symbol = symbol;
        this.atomicWeight = atomicWeight;
        this.atomicMass = atomicMass;
        this.period = period;
        this.group = group;
        this.phase = phase;
        this.mostStableCrystal = mostStableCrystal;
        this.type = type;
        this.ionicRadius = ionicRadius;
        this.atomicRadius = atomicRadius;
        this.electronegativity = electronegativity;
        this.firstIonizationPotential = firstIonizationPotential;
        this.density = density;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.isotope = isotope;
        this.discoverer = discoverer;
        this.yearOfDiscovery = yearOfDiscovery;
        this.specificHeatCapacity = specificHeatCapacity;
        this.electronConfiguration = electronConfiguration;
        this.displayRow = displayRow;
        this.displayColumn = displayColumn;
    }

    public Element(Element e) {
        this.atomicNumber = e.atomicNumber;
        this.elementName = e.elementName;
        this.symbol = e.symbol;
        this.atomicWeight = e.atomicWeight;
        this.atomicMass = e.atomicMass;
        this.period = e.period;
        this.group = e.group;
        this.phase = e.phase;
        this.mostStableCrystal = e.mostStableCrystal;
        this.type = e.type;
        this.ionicRadius = e.ionicRadius;
        this.atomicRadius = e.atomicRadius;
        this.electronegativity = e.electronegativity;
        this.firstIonizationPotential = e.firstIonizationPotential;
        this.density = e.density;
        this.meltingPoint = e.meltingPoint;
        this.boilingPoint = e.boilingPoint;
        this.isotope = e.isotope;
        this.discoverer = e.discoverer;
        this.yearOfDiscovery = e.yearOfDiscovery;
        this.specificHeatCapacity = e.specificHeatCapacity;
        this.electronConfiguration = e.electronConfiguration;
        this.displayRow = e.displayRow;
        this.displayColumn = e.displayColumn;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getElementName() {
        return elementName;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }

    public double getAtomicMass() {
        return atomicMass;
    }

    public int getPeriod() {
        return period;
    }

    public int getGroup() {
        return group;
    }

    public String getPhase() {
        return phase;
    }

    public String getMostStableCrystal() {
        return mostStableCrystal;
    }

    public String getType() {
        return type;
    }

    public double getIonicRadius() {
        return ionicRadius;
    }

    public double getAtomicRadius() {
        return atomicRadius;
    }

    public double getElectronegativity() {
        return electronegativity;
    }

    public double getFirstIonizationPotential() {
        return firstIonizationPotential;
    }

    public double getDensity() {
        return density;
    }

    public double getMeltingPoint() {
        return meltingPoint;
    }

    public double getBoilingPoint() {
        return boilingPoint;
    }

    public int getIsotope() {
        return isotope;
    }

    public String getDiscoverer() {
        return discoverer;
    }

    public int getYearOfDiscovery() {
        return yearOfDiscovery;
    }

    public double getSpecificHeatCapacity() {
        return specificHeatCapacity;
    }

    public String getElectronConfiguration() {
        return electronConfiguration;
    }

    public int getDisplayRow() {
        return displayRow;
    }

    public int getDisplayColumn() {
        return displayColumn;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setAtomicWeight(double atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    public void setAtomicMass(double atomicMass) {
        this.atomicMass = atomicMass;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public void setMostStableCrystal(String mostStableCrystal) {
        this.mostStableCrystal = mostStableCrystal;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIonicRadius(double ionicRadius) {
        this.ionicRadius = ionicRadius;
    }

    public void setAtomicRadius(double atomicRadius) {
        this.atomicRadius = atomicRadius;
    }

    public void setElectronegativity(double electronegativity) {
        this.electronegativity = electronegativity;
    }

    public void setFirstIonizationPotential(double firstIonizationPotential) {
        this.firstIonizationPotential = firstIonizationPotential;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public void setMeltingPoint(double meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    public void setBoilingPoint(double boilingPoint) {
        this.boilingPoint = boilingPoint;
    }

    public void setIsotope(int isotope) {
        this.isotope = isotope;
    }

    public void setDiscoverer(String discoverer) {
        this.discoverer = discoverer;
    }

    public void setYearOfDiscovery(int yearOfDiscovery) {
        this.yearOfDiscovery = yearOfDiscovery;
    }

    public void setSpecificHeatCapacity(double specificHeatCapacity) {
        this.specificHeatCapacity = specificHeatCapacity;
    }

    public void setElectronConfiguration(String electronConfiguration) {
        this.electronConfiguration = electronConfiguration;
    }

    public void setDisplayRow(int displayRow) {
        this.displayRow = displayRow;
    }

    public void setDisplayColumn(int displayColumn) {
        this.displayColumn = displayColumn;
    }

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
        final Element other = (Element) obj;
        if (this.atomicNumber != other.atomicNumber) {
            return false;
        }
        if (Double.doubleToLongBits(this.atomicWeight) != Double.doubleToLongBits(other.atomicWeight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.atomicMass) != Double.doubleToLongBits(other.atomicMass)) {
            return false;
        }
        if (this.period != other.period) {
            return false;
        }
        if (this.group != other.group) {
            return false;
        }
        if (Double.doubleToLongBits(this.ionicRadius) != Double.doubleToLongBits(other.ionicRadius)) {
            return false;
        }
        if (Double.doubleToLongBits(this.atomicRadius) != Double.doubleToLongBits(other.atomicRadius)) {
            return false;
        }
        if (Double.doubleToLongBits(this.electronegativity) != Double.doubleToLongBits(other.electronegativity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.firstIonizationPotential) != Double.doubleToLongBits(other.firstIonizationPotential)) {
            return false;
        }
        if (Double.doubleToLongBits(this.density) != Double.doubleToLongBits(other.density)) {
            return false;
        }
        if (Double.doubleToLongBits(this.meltingPoint) != Double.doubleToLongBits(other.meltingPoint)) {
            return false;
        }
        if (Double.doubleToLongBits(this.boilingPoint) != Double.doubleToLongBits(other.boilingPoint)) {
            return false;
        }
        if (this.isotope != other.isotope) {
            return false;
        }
        if (this.yearOfDiscovery != other.yearOfDiscovery) {
            return false;
        }
        if (Double.doubleToLongBits(this.specificHeatCapacity) != Double.doubleToLongBits(other.specificHeatCapacity)) {
            return false;
        }
        if (this.displayRow != other.displayRow) {
            return false;
        }
        if (this.displayColumn != other.displayColumn) {
            return false;
        }
        if (!Objects.equals(this.elementName, other.elementName)) {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        if (!Objects.equals(this.phase, other.phase)) {
            return false;
        }
        if (!Objects.equals(this.mostStableCrystal, other.mostStableCrystal)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.discoverer, other.discoverer)) {
            return false;
        }
        if (!Objects.equals(this.electronConfiguration, other.electronConfiguration)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Element{" + "atomicNumber=" + atomicNumber + ", elementName=" + elementName + ", symbol=" + symbol + ", atomicWeight=" + atomicWeight + ", atomicMass=" + atomicMass + ", period=" + period + ", group=" + group + ", phase=" + phase + ", mostStableCrystal=" + mostStableCrystal + ", type=" + type + ", ionicRadius=" + ionicRadius + ", atomicRadius=" + atomicRadius + ", electronegativity=" + electronegativity + ", firstIonizationPotential=" + firstIonizationPotential + ", density=" + density + ", meltingPoint=" + meltingPoint + ", boilingPoint=" + boilingPoint + ", isotope=" + isotope + ", discoverer=" + discoverer + ", yearOfDiscovery=" + yearOfDiscovery + ", specificHeatCapacity=" + specificHeatCapacity + ", electronConfiguration=" + electronConfiguration + ", displayRow=" + displayRow + ", displayColumn=" + displayColumn + '}';
    }

    public int compareToAtomicNumber(Element t) {
        if (this.getAtomicNumber() > t.getAtomicNumber()) {
            return 1;
        }
        if (this.getAtomicNumber() < t.getAtomicNumber()) {
            return -1;
        }
        return 0;
    }

    public int compareToElementName(Element t) {
        return this.getElementName().compareTo(t.getElementName());
    }

    public int compareToSymbol(Element t) {
        return this.getSymbol().compareTo(t.getSymbol());
    }

    public int compareToAtomicMass(Element t) {
        if (this.getAtomicMass() > t.getAtomicMass()) {
            return 1;
        }
        if (this.getAtomicMass() < t.getAtomicMass()) {
            return -1;
        }
        return 0;
    }

    @Override
    public int compareTo(Element t) {
        // Compara pelo número atómico
        if (t instanceof ElementAtomicNumber) {
            if (this.getAtomicNumber() > t.getAtomicNumber()) {
                return 1;
            }
            if (this.getAtomicNumber() < t.getAtomicNumber()) {
                return -1;
            }
            return 0;
        } // Compara pelo nome do elemento
        else if (t instanceof ElementName) {
            return this.getElementName().compareTo(t.getElementName());
        } // Compara pelo símbolo
        else if (t instanceof ElementSymbol) {
            return this.getSymbol().compareTo(t.getSymbol());
        } // Compara por massa atómica
        else if (t instanceof ElementAtomicMass) {
            if (this.getAtomicMass() > t.getAtomicMass()) {
                return 1;
            }
            if (this.getAtomicMass() < t.getAtomicMass()) {
                return -1;
            }
            return 0;
        } else {
            return this.getElectronConfiguration().compareTo(t.getElectronConfiguration());
        }

    }

}
