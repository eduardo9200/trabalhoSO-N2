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
    };
    
    
    //Se uma página for encontrada, marca um acerto
    private boolean verificaAcertos(int x, int arra[],
            int qFrames) {

        for (int i = 0; i < qFrames; i++) {

            if (arra[i] == x) {

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
    static void encontraSubstitui(int x, int arra[],
           int ponteiro) {

        // Modifica a página
        arra[ponteiro] = x;
    }

    static int ponteiroMRU(int x, int arra[],
            int qFrames) {

        while (true) {
            for (int i = 0; i < qFrames; i++) {

                if (arra[i] == x) {
                    // Atualiza e retorna o ponteiro
                    return i;
                }
            }

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

        // Separando o texto através dos -
        // Também é criada aqui a String que servirá de referência
        String texto = conteudoArquivo.replaceAll("[^\\d-]", "");
        String[] strRef = texto.split("-");
        L = strRef.length;

        for (i = 0; i < L; i++) {

            // x Recebe os valores da String referência em formato Integer
            x = Integer.parseInt(strRef[i]);

            // Verifica se há alguma página a ser substituída
            if (!verificaAcertos(x, arra, qFrames)) {

                // Marca uma falta
                faltas++;

                // Caso o array ainda não esteja cheio, ele simplesmente aloca a página no endereço da memória
                if (!esta_cheio) {
                    
                    // Seleciona uma página a ser removida da memória
                    encontraSubstitui(x, arra, ponteiro);
                    
                    // Incrementa o ponteiro
                    ponteiro++;

                    // Verificação de se a memória está cheia
                    if (ponteiro == qFrames) {
                        ponteiro = ponteiro - 1;
                        esta_cheio = true;
                    }

                // Quando a memória estiver cheia, ele apenas irá substituir o usado mais recentemente(MRU)
                } else {
                    encontraSubstitui(x, arra, ponteiro);
                }

            } else {
                
                // Quando houver um acerto e a memória estiver cheia, ele apontará para o acerto, pois este foi o usado mais recentemente(MRU)
                if (esta_cheio) {
                    ponteiro = ponteiroMRU(x, arra, qFrames);
                }
            }

        }

        // Resposta esperada MRU = 69.897
        System.out.println("Frames: " + qFrames + ". MRU: " + this.acertos);
        this.tela.setResultado(TipoAlgoritmo.MRU, this.acertos);
    }

}
