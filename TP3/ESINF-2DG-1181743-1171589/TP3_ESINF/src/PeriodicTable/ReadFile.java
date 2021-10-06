/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeriodicTable;

import Tree.BST;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ReadFile {
    
    /**
     * Lista de elementos
     */
    private List<Element> elementList;
    
    /**
     * Construtor da classe que lê o ficheiro csv
     */
    public ReadFile(){
        elementList = new ArrayList<>();
    }
    

    /**
     * Método que devolve a lista de elementos
     * @return lista de elementos
     */
    public List<Element> getElementsList(){
        return this.elementList;
    }
    
    /**
     * Método que lê informação de um ficheiro de texto para uma lista
     *
     * @param filename ficheiro csv a ser lido
     * @return lista do tipo String com dados de um ficheiro csv
     * @throws java.io.IOException
     */
    private List<String> readFromFile(String filename) throws IOException, FileNotFoundException {
        List<String> information = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                line.trim();
                information.add(line);
            }
        }
        catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                br.close();
            }
        }
        
        return information;
    }
    
    /**
     * Método que atribui os valores de cada linha do ficheiro csv a um elemento
     * @param filename ficheiro csv a ser lido
     * @throws IOException 
     */
    public void readElements(String filename) throws IOException{
        List<String> information = readFromFile(filename);
        
        for(String s : information){
            String data[] = s.split(",");
            for (int i = 0; i < data.length; i++) {
                if(data[i].equals("")){
                    data[i] = "0";
                }
            }
            Element ele = new Element(Integer.parseInt(data[0]), data[1], data[2], Double.parseDouble(data[3]), 
                    Double.parseDouble(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                    data[7], data[8], data[9], Double.parseDouble(data[10]), Double.parseDouble(data[11]),
                    Double.parseDouble(data[12]), Double.parseDouble(data[13]), Double.parseDouble(data[14]),
                    Double.parseDouble(data[15]), Double.parseDouble(data[16]), Integer.parseInt(data[17]),
                    data[18], Integer.parseInt(data[19]), Double.parseDouble(data[20]), data[21], Integer.parseInt(data[22]),
                    Integer.parseInt(data[23]));
                    
            elementList.add(ele);
            
        }
    }
    
    
}
