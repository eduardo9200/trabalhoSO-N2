/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.saida;

/**
 *
 * @author Eduardo
 */
public class Resultado {
    private int numeroFrames;
    private int acertosFIFO;
    private int acertosSegundaChance;
    private int acertosNUR;
    private int acertosMRU;
    private int acertosAlgoritmoOtimo;

    public Resultado(
        int numeroFrames,
        int acertosFIFO,
        int acertosSegundaChance,
        int acertosNUR,
        int acertosMRU,
        int acertosAlgoritmoOtimo
    ){
        this.numeroFrames          = numeroFrames;
        this.acertosFIFO           = acertosFIFO;
        this.acertosSegundaChance  = acertosSegundaChance;
        this.acertosNUR            = acertosNUR;
        this.acertosMRU            = acertosMRU;
        this.acertosAlgoritmoOtimo = acertosAlgoritmoOtimo;
    }

    public void setNumeroFrames(int numeroFrames) {
        this.numeroFrames = numeroFrames;
    }

    public void setAcertosFIFO(int acertosFIFO) {
        this.acertosFIFO = acertosFIFO;
    }

    public void setAcertosSegundaChance(int acertosSegundaChance) {
        this.acertosSegundaChance = acertosSegundaChance;
    }

    public void setAcertosNUR(int acertosNUR) {
        this.acertosNUR = acertosNUR;
    }

    public void setAcertosMRU(int acertosMRU) {
        this.acertosMRU = acertosMRU;
    }

    public void setAcertosAlgoritmoOtimo(int acertosAlgoritmoOtimo) {
        this.acertosAlgoritmoOtimo = acertosAlgoritmoOtimo;
    }
    
    public int getNumeroFrames() {
        return numeroFrames;
    }

    public int getAcertosFIFO() {
        return acertosFIFO;
    }

    public int getAcertosSegundaChance() {
        return acertosSegundaChance;
    }

    public int getAcertosNUR() {
        return acertosNUR;
    }

    public int getAcertosMRU() {
        return acertosMRU;
    }

    public int getAcertosAlgoritmoOtimo() {
        return acertosAlgoritmoOtimo;
    }
    
}
