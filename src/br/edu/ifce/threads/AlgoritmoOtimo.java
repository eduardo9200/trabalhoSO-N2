/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.threads;

import br.edu.ifce.saida.Resultado;
import br.edu.ifce.view.TelaPrincipal;

/**
 *
 * @author Eduardo
 */
public class AlgoritmoOtimo extends Thread {
    private TelaPrincipal tela;
    private String conteudoArquivo;
    private int qFrames;
    private int acertos;
    
    public AlgoritmoOtimo(
            TelaPrincipal tela,
            String conteudoArquivo,
            int qFrames
    ){
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.qFrames = qFrames;
    };
    
    @Override
    public void run() {
        
        /*
            CÓDIGO ALGORITMO ÓTIMO AQUI
        */
        
        this.acertos = -1;
        this.tela.setResultado("OTIMO", this.acertos);
    }
    
}
