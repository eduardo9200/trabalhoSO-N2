/*
 * 
 */
package br.edu.ifce.threads;

import br.edu.ifce.tiposAlgoritmos.TipoAlgoritmo;
import br.edu.ifce.view.TelaPrincipal;
import java.util.Arrays;

/**
 *
 * @author Rodrigo
 */
public class Mru extends Thread {

    private TelaPrincipal tela;
    private String conteudoArquivo;
    private int qFrames;
    private int acertos;

    public Mru(
            TelaPrincipal tela,
            String conteudoArquivo,
            int qFrames
    ) {
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.qFrames = qFrames;
    }

    ;
    
    
    
    private boolean verificaAcertos(int x, int arra[],
            int qFrames, int LRU[]) {

        for (int i = 0; i < qFrames; i++) {
            
            // Incrementa o valor de todos os ponteiros LRU
            if (arra[i] != -1) {
                LRU[i]++;
            }
        }

        for (int i = 0; i < qFrames; i++) {
            
            if (arra[i] == x) {
                
                // Atualiza o ponteiro LRU
                LRU[i] = 1;
                
                //Se uma página for encontrada, marca um acerto
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

        //Retorna falso para que uma página possa ser selecionada para ser substituída
        return false;

    }

    // Encontra uma página na memória e retorna o ponteiro 
    static int encontraSubstitui(int x, int arra[],
            int ponteiro, int qFrames, boolean esta_cheio, int LRU[]) {

        // Ponteiro para verificar o LRU
        int menor = 0;

        if (!esta_cheio) {
            // Modifica a página
            arra[ponteiro] = x;
            
            // Modifica o LRU para 1
            LRU[ponteiro] = 1;
            ponteiro++;

            // Retorna o ponteiro atual
            return ponteiro;

        } else {

            // Verifica qual oi o Least Recently Used (LRU)
            for (int i = 0; i < qFrames; i++) {
                if (menor < LRU[i]) {
                    menor = LRU[i];
                    
                    // O novo ponteiro é o LRU
                    ponteiro = i;
                }
            }

            // Modifica a página
            arra[ponteiro] = x;
            
            // Modifica o LRU para 
            LRU[ponteiro] = 1;

            return ponteiro;

        }

    }

    @Override
    public void run() {

        // Ponteiros de execução
        int i, b, L, x;
        int ponteiro = 0;
        int faltas = 0;
        boolean esta_cheio = false;

        // Cria o array das páginas a serem carregadas e muda o valor das mesmas para -1, para indicar que não estão preenchidas
        int arra[] = new int[qFrames];
        Arrays.fill(arra, -1);

        // Cria o array contador responsável pela lógica LRU
        int LRU[] = new int[qFrames];
        Arrays.fill(arra, -1);

        // Separando o texto através dos -
        // Também é criada aqui a String que servirá de referência
        String texto = conteudoArquivo.replaceAll("[^\\d-]", "");
        String[] strRef = texto.split("-");
        L = strRef.length;

        for (i = 0; i < L; i++) {

            // x Recebe os valores da String referência em formato Integer
            x = Integer.parseInt(strRef[i]);

            // Verifica se há alguma página a ser substituída
            if (!verificaAcertos(x, arra, qFrames, LRU)) {

                // Marca uma falta
                faltas++;

                // Seleciona uma página a ser removida da memória
                ponteiro = encontraSubstitui(x, arra, ponteiro, qFrames, esta_cheio, LRU);

            }

            // Verificação de se a memória está cheia
            if (ponteiro == qFrames) {
                ponteiro = ponteiro - 1;
                esta_cheio = true;
            }

        }

        // Apesar do nome MRU em português, o algoritmo é conhecido como LRU(Least Used Recently), deve se tomar cuidado, porque
        // existe um algoritmo MRU que significa algo totalmente diferente.
        System.out.println("Frames: " + qFrames + ". MRU: " + this.acertos);
        this.tela.setResultado(TipoAlgoritmo.MRU, this.acertos);
    }

}
