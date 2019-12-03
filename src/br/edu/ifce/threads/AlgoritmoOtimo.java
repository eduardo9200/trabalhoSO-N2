/*
 * 
 */
package br.edu.ifce.threads;

import br.edu.ifce.saida.Resultado;
import br.edu.ifce.tiposAlgoritmos.TipoAlgoritmo;
import br.edu.ifce.view.TelaPrincipal;
import java.util.Arrays;

/**
 *
 * @author Rodrigo
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
    ) {
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.qFrames = qFrames;
    }

    ;
    
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

        //Retorna falso para que uma página possa ser selecionada para ser substituída
        return false;

    }

    static int encontraSubstitui(int i, int l, String strRef[], int arra[],
            int qFrames, int ponteiro) {

        int y;
        int index[] = new int[qFrames];
        boolean index_flag[] = new boolean[qFrames];

        while (true) {

            // Atualiza o index, verificando quantas vezes o número irá se repetir
            for (int j = i + 1; j < l; j++) {
                y = Integer.parseInt(strRef[j]);
                for (int k = 0; k < qFrames; k++) {
                    if ((y == arra[k]) && (index_flag[k] == false)) {
                        index[k] = j;
                        index_flag[k] = true;
                        break;
                    }
                }
            }

            
            int max = index[0];
            ponteiro = 0;

            // Seta o index máximo possível para o length da String
            if (max == 0) {
                max = l;
            }

            for (int j = 0; j < qFrames; j++) {
                if (index[j] == 0) {
                    index[j] = l;
                }

                if (index[j] > max) {
                    max = index[j];
                    ponteiro = j;
                }
            }

            return ponteiro;

        }
    }

    @Override
    public void run() {


        int x, faltas = 0;

        // Separando o texto através dos -
        // Também é criada aqui a String que servirá de referência
        String texto = conteudoArquivo.replaceAll("[^\\d-]", "");
        String[] strRef = texto.split("-");
        int l = strRef.length;

        int ponteiro = 0;
        boolean esta_cheio = false;

        int arra[] = new int[qFrames];
        Arrays.fill(arra, -1);

        for (int j = 0; j < qFrames; j++) {
            arra[j] = -1;
        }

        for (int i = 0; i < l; i++) {

            x = Integer.parseInt(strRef[i]);

            if (!verificaAcertos(x, arra, qFrames)) {

                if (esta_cheio) {

                    ponteiro = encontraSubstitui(i, l, strRef, arra, qFrames, ponteiro);

                }

                // Após encontrar o local da memória que será substituido, modifica a página
                arra[ponteiro] = x;

                // Marca uma falta
                faltas++;

                // Atualizando o ponteiro para o local de memória correto depois de verificar a capacidade no encontraSubstitui
                if (!esta_cheio) {
                    ponteiro++;
                    if (ponteiro == qFrames) {
                        ponteiro = 0;
                        esta_cheio = true;
                    }
                }
            }

        }

        System.out.println("Frames: " + qFrames + ". Algorítmo Ótimo: " + this.acertos);
        this.tela.setResultado(TipoAlgoritmo.OTIMO, this.acertos);
    }

}
