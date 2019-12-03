/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.tiposAlgoritmos;

/**
 *
 * @author Eduardo
 */
public enum TipoAlgoritmo {
    FIFO("FIFO"),
    SEGUNDA_CHANCE("SEGUNDA_CHANCE"),
    NUR("NUR"),
    MRU("MRU"),
    OTIMO("OTIMO");
    
    private final String valor;
    
    TipoAlgoritmo(String valor) {
        this.valor = valor;
    }
    
    public String getValor() {
        return this.valor;
    }
}
