/*
 * https://gist.github.com/AidanHak/954871554c8cac3c58b4f87eaa9a54cb
 */
package br.edu.ifce.threads;

import br.edu.ifce.saida.Resultado;
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

        //Retorna falso para que a página possa ser selecionada para ser substituída
        return false;

    }

    @Override
    public void run() {

        int x, y, faltas = 0;

        // Separando o texto através dos -
        // Também é criada aqui a String que servirá de referência
        String texto = conteudoArquivo;
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
                faltas++;
                if (esta_cheio) {
                    
                    int index[] = new int[qFrames];
                    boolean index_flag[] = new boolean[qFrames];
                    
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
                    if (max == 0) {
                        max = 200;
                    }

                    for (int j = 0; j < qFrames; j++) {
                        if (index[j] == 0) {
                            index[j] = 200;
                        }

                        if (index[j] > max) {
                            max = index[j];
                            ponteiro = j;
                        }
                    }
                }

                arra[ponteiro] = x;

                if (!esta_cheio) {
                    ponteiro++;
                    if (ponteiro == qFrames) {
                        ponteiro = 0;
                        esta_cheio = true;
                    }
                }
            }

        }
        
        System.out.println("Ótimo: " + this.acertos);
        this.tela.setResultado("OTIMO", this.acertos);
    }

}
