/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.threads;

import br.edu.ifce.view.TelaPrincipal;
import java.util.Vector;

/**
 *
 * @author Rodrigo
 */
public class SegundaChance extends Thread {
    private TelaPrincipal tela;
    private String conteudoArquivo;
    private int qFrames;
    private Long bitR;
    private int acertos;
    
    public SegundaChance(
            TelaPrincipal tela,
            String conteudoArquivo,
            int qFrames,
            Long bitR
    ){
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.qFrames = qFrames;
        this.bitR = bitR;
    };
    
  
    @Override
    public void run() {
       
        String texto = conteudoArquivo;
        String[] numerosTexto = texto.split("-");
        Vector<Integer> numeros = new Vector<>();
        for (int i = 0; i < numerosTexto.length; i++) {
            numeros.add(Integer.parseInt(numerosTexto[i]));
        }
         

        this.acertos = numeros.size();
        this.tela.setResultado("SEGUNDA_CHANCE", this.acertos);
    }
    

    

}
