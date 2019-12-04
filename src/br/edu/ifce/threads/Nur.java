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
        this.acertos = 0;
    }

    ;
   
   //Se uma página for encontrada, aprimora o bitR do segunda chance para true e marca um acerto
    private boolean verificaAcertos(int x, int arra[],
            boolean[] bit_R, boolean[] bit_M, boolean m_flag, int qFrames, int LRU[]) {

        for (int i = 0; i < qFrames; i++) {

            // Incrementa o valor de todos os ponteiros LRU
            if (arra[i] != -1) {
                LRU[i]++;
            }

        }

        for (int i = 0; i < qFrames; i++) {

            if (arra[i] == x) {

                this.acertos++;

                // Atualiza o ponteiro LRU
                LRU[i] = 1;

                //Marca que o BitR como true, pois a página foi referênciada 
                bit_R[i] = true;

                // Verifica se está recebendo um WRITE e seta o BitM como true
                if (m_flag) {
                    bit_M[i] = true;
                }

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
    static int encontraSubstitui(int x, int classe[], int arra[],
            boolean[] bit_R, boolean[] bit_M, boolean m_flag, int qFrames, int ponteiro, boolean esta_cheio, int LRU[]) {

        int menor = 0;

        if (!esta_cheio) {
            // Modifica a página, inserindo a mesma com bitR true
            arra[ponteiro] = x;
            bit_R[ponteiro] = true;

            // Verifica se está recebendo um WRITE e seta o BitM como true
            if (m_flag) {
                bit_M[ponteiro] = true;
            }

            // Modifica o LRU para 1
            LRU[ponteiro] = 1;

            // Atualiza e retorna o ponteiro 
            ponteiro++;
            return ponteiro;

        } else {

            for (int i = 0; i < qFrames; i++) {

                // Classe 0: não referenciada, não modificada;
                if (!bit_R[i] && !bit_M[i]) {
                    classe[i] = 0;
                }
                // Classe 1: não referenciada, modificada;
                if (!bit_R[i] && bit_M[i]) {
                    classe[i] = 1;
                }
                // Classe 2: referenciada, não modificada;
                if (bit_R[i] && !bit_M[i]) {
                    classe[i] = 2;
                }
                // Classe 3: referenciada, modificada
                if (bit_R[i] && bit_M[i]) {
                    classe[i] = 3;
                }
            }

            int menorClasse = 4;

            for (int i = 0; i < qFrames; i++) {
                if (classe[i] <= menorClasse) {
                    menorClasse = classe[i];
                }
            }

            // Verifica qual oi o Least Recently Used (LRU)
            for (int i = 0; i < qFrames; i++) {
                if (classe[i] == menorClasse) {
                    if (menor < LRU[i]) {
                        menor = LRU[i];

                        // O novo ponteiro é o LRU
                        ponteiro = i;
                    }
                }

            }

            arra[ponteiro] = x;
            bit_R[ponteiro] = true;

            // Modifica o LRU para 
            LRU[ponteiro] = 1;

            // Verifica se está recebendo um WRITE e seta o BitM como true
            if (m_flag) {
                bit_M[ponteiro] = true;
            }

            return ponteiro;

        }
    }

    @Override
    public void run() {

        // Ponteiros de execução
        int ponteiro = 0, i, b, L, x, faltas = 0;
        int reset = Math.toIntExact(bitR);

        // Essa variável define a qual classe cada espaço na memória pertence.
        int classe[] = new int[qFrames];
        Arrays.fill(classe, -1);

        // Cria o array das páginas a serem carregadas e muda o valor das mesmas para -1, para indicar que não estão preenchidas
        int arra[] = new int[qFrames];
        Arrays.fill(arra, -1);

        // Cria o array contador responsável pela lógica LRU
        int LRU[] = new int[qFrames];
        Arrays.fill(arra, -1);

        // Array responsável pelos BitR
        boolean bit_R[] = new boolean[qFrames];
        boolean bit_M[] = new boolean[qFrames];

        // Separando o texto através dos -
        // Também é criada aqui a String que servirá de referência
        String texto_com_W = conteudoArquivo.replaceAll("[^\\d-wW]", "");
        String[] strRef_W = texto_com_W.split("-");

        String texto = conteudoArquivo.replaceAll("[^\\d-]", "");
        String[] strRef = texto.split("-");
        L = strRef.length;

        // Array responsável pelos BitM
        boolean bit_M_flag[] = new boolean[L];

        // Ponteiro para verificar array cheio ou com espaço
        boolean esta_cheio = false;

        for (i = 0; i < L; i++) {
            if (strRef_W[i].contains("W")) {
                bit_M_flag[i] = true;
            }
        }

        for (i = 0; i < L; i++) {

            // Primeiramente, o programa verifica se está na hora de resetar os bitR para false
            if (reset == 0) {

                // Reseta todos os bitR para false
                for (b = 0; b < qFrames; b++) {
                    bit_R[b] = false;
                }

                reset = Math.toIntExact(bitR);

            }

            // x Recebe os valores da String referência em formato Integer
            x = Integer.parseInt(strRef[i]);

            // Verifica se há alguma página a ser substituída
            if (!verificaAcertos(x, arra, bit_R, bit_M, bit_M_flag[i], qFrames, LRU)) {

                // Marca uma falta
                faltas++;

                // Seleciona uma página a ser removida da memória
                ponteiro = encontraSubstitui(x, classe, arra, bit_R, bit_M, bit_M_flag[i], qFrames, ponteiro, esta_cheio, LRU);

            }

            // Verificação de se a memória está cheia
            if (ponteiro == qFrames) {
                ponteiro = ponteiro - 1;
                esta_cheio = true;
            }

            reset--;

        }

        // NUR 69.760
        System.out.println("Frames: " + qFrames + ". NUR: " + this.acertos);
        this.tela.setResultado(TipoAlgoritmo.NUR, this.acertos);
    }

}
