/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.threads;

import br.edu.ifce.view.TelaPrincipal;
import java.util.Arrays;

/**
 *
 * @author Rodrigo
 */
public class Fifo extends Thread {
    private TelaPrincipal tela;
    private String conteudoArquivo;
    private int qFrames;
    private int acertos;
    
    public Fifo(
            TelaPrincipal tela,
            String conteudoArquivo,
            int qFrames
    ){
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.qFrames = qFrames;
    };
    
    //Se uma página for encontrada, marca um acerto
    private boolean verificaAcertos(int x, int arra[],
           int qFrames) {

        for (int i = 0; i < qFrames; i++) {

            if (arra[i] == x) {
                //Marca um acerto
                this.acertos++;

                //Retorna verdadeiro, significando que houve um acerto  
                //Sendo assim, não será necessário substituir nenhuma página 
                return true;
            } else if (arra[i] == -1) {
                //Caso o valor de arra[i] seja -1, dali pra frente a memória não estará preenchida
                //então ele corta a verificação retornando falso.
                return false;
            }
            
        }

        //Retorna falso para que a página possa ser selecionada para ser substituída
        return false;

    }

    // Encontra uma página na memória e retorna o ponteiro 
    static int encontraSubstitui(int x, int arra[],
             int qFrames, int ponteiro) {

                // Modifica a página
                arra[ponteiro] = x;

                // Retorna e atualiza o ponteiro 
                return (ponteiro + 1) % qFrames;

    }
    
    @Override
    public void run() {
        
    // Ponteiros de execução
        int ponteiro = 0, i, b, l, x, faltas = 0;

        // Cria o array das páginas a serem carregadas e muda o valor das mesmas para -1, para indicar que não estão preenchidas
        int arra[] = new int[qFrames];
        Arrays.fill(arra, -1);

        // Separando o texto através dos -
        // Também é criada aqui a String que servirá de referência
        String texto = conteudoArquivo;
        String[] strRef = texto.split("-");
        l = strRef.length;

        for (i = 0; i < l; i++) {


                // x Recebe os valores da String referência em formato Integer
                x = Integer.parseInt(strRef[i]);

                // Verifica se há alguma página a ser substituída
                if (!verificaAcertos(x, arra, qFrames)) {

                    // Seleciona uma página a ser removida da memória
                    ponteiro = encontraSubstitui(x, arra, qFrames, ponteiro);

                    // Marca uma falta
                    faltas++;
                }
            

        }

        System.out.println("FIFO: " + this.acertos);
        this.tela.setResultado("FIFO", this.acertos);
    }

}
