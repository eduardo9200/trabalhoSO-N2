/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.threads;

import br.edu.ifce.view.TelaPrincipal;

/**
 *
 * @author Eduardo
 */
public class SegundaChance extends Thread {
    private TelaPrincipal tela;
    private String conteudoArquivo;
    private Long q1;
    private Long q2;
    private Long bitR;
    private int acertos;
    
    public SegundaChance(
            TelaPrincipal tela,
            String conteudoArquivo,
            Long q1,
            Long q2,
            Long bitR
    ){
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.q1 = q1;
        this.q2 = q2;
        this.bitR = bitR;
    };
    
    @Override
    public void run() {
        
        /*
            CÓDIGO SEGUNDA CHANCE AQUI
        */
        
        this.acertos = -1;
        this.tela.setResultado("SEGUNDA_CHANCE", this.acertos);
    }

}
