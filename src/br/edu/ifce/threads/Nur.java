/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.threads;

import br.edu.ifce.tiposAlgoritmos.TipoAlgoritmo;
import br.edu.ifce.view.TelaPrincipal;

/**
 *
 * @author Eduardo
 */
public class Nur extends Thread {
    private TelaPrincipal tela;
    private String conteudoArquivo;
    private int qFrames;
    private int bitR;
    private int acertos;
    
    public Nur(
            TelaPrincipal tela,
            String conteudoArquivo,
            int qFrames,
            int bitR
    ){
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.qFrames = qFrames;
        this.bitR = bitR;
    };
    
    @Override
    public void run() {
        
        /*
            CÓDIGO ALGORTIMO NUR AQUI
        */
        
        this.acertos = -1;
        this.tela.setResultado(TipoAlgoritmo.NUR, this.acertos);
    }

}
