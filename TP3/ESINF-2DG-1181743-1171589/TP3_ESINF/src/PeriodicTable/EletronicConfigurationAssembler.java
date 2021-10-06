/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeriodicTable;

/**
 *
 * @author Guilherme
 */
public class EletronicConfigurationAssembler implements Comparable<EletronicConfigurationAssembler> {
    private String eletronicConfiguration;
    private int ocorrences;
    
    public EletronicConfigurationAssembler(String eletronicConfiguration, int ocorrences){
        this.eletronicConfiguration = eletronicConfiguration;
        this.ocorrences = ocorrences;
    }
    
    public EletronicConfigurationAssembler(EletronicConfigurationAssembler ela){
        this.eletronicConfiguration = ela.eletronicConfiguration;
        this.ocorrences = ela.ocorrences;
    }

    public String getEletronicConfiguration() {
        return eletronicConfiguration;
    }

    public int getOcorrences() {
        return ocorrences;
    }
    
    public void incOcorrences(){
        ocorrences++;
    }

    @Override
    public String toString() {
        return "<" + eletronicConfiguration +">" + ":" + ocorrences;
    }

    @Override
    public int compareTo(EletronicConfigurationAssembler t) {

        return this.getEletronicConfiguration().compareTo(t.getEletronicConfiguration());
    }
    
    
}
