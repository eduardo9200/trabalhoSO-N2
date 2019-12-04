/*
 * 
 */
package br.edu.ifce.threads;

import br.edu.ifce.tiposAlgoritmos.TipoAlgoritmo;
import br.edu.ifce.view.TelaPrincipal;
import java.util.Arrays;

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
    ) {
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.qFrames = qFrames;
        this.bitR = bitR;
    };
   

    @Override
    public void run() {

        // Código NUR
        

        this.acertos = -1;
        System.out.println("Frames: " + qFrames + ". NUR: " + this.acertos);
        this.tela.setResultado(TipoAlgoritmo.NUR, this.acertos);
    }

}
