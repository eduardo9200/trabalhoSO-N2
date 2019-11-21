/*
 * https://www.geeksforgeeks.org/second-chance-or-clock-page-replacement-policy/
 */
package br.edu.ifce.threads;

import br.edu.ifce.view.TelaPrincipal;
import java.util.Arrays;

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
    ) {
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.qFrames = qFrames;
        this.bitR = bitR;

    }

    ;
    
    //Se uma página for encontrada, aprimora o bitR do segunda chance para true e marca um acerto
    static boolean verificaAcertos(int x, int arra[],
            boolean segunda_chance[], int qFrames) {

        for (int i = 0; i < qFrames; i++) {

            if (arra[i] == x) {
                //Marca que a página merece uma segunda chance 
                segunda_chance[i] = true;

                //Retorna verdadeiro, significando que houve um acerto  
                //Sendo assim, não será necessário substituir nenhuma página 
                return true;
            }
        }

        //Retorna falso para que a página possa ser selecionada para ser substituída
        return false;

    }

    // Encontra uma página na memória e retorna o ponteiro 
    static int encontraSubstitui(int x, int arra[],
            boolean segunda_chance[], int qFrames, int ponteiro) {
        while (true) {

            // Se a página a ser modificada for encontrada 
            if (!segunda_chance[ponteiro]) {
                // Modifica a página 
                arra[ponteiro] = x;

                // Retorna e atualiza o ponteiro 
                return (ponteiro + 1) % qFrames;
            }

            // Marca o ponteiro como falso e dá a ele uma segunda chance  
            // ele será substituído a menos que seja acessado novamente
            segunda_chance[ponteiro] = false;

            // O ponteiro é atualizado, utilizando o escalonamento Round Robin
            // O método foi escolhido devido a sua simplicidade
            // https://pt.wikipedia.org/wiki/Round-robin
            ponteiro = (ponteiro + 1) % qFrames;
        }
    }

    @Override
    public void run() {

        // Ponteiros de execução
        int ponteiro = 0, i, l, x, faltas = 0;

        // Cria o array das páginas a serem carregadas e muda o valor das mesmas para -1, para indicar que não estão preenchidas
        int arra[] = new int[qFrames];
        Arrays.fill(arra, -1);

        // Array responsável pela Segunda Chance
        boolean segunda_chance[] = new boolean[qFrames];

        // Separando o texto através dos -
        // Também é criada aqui a String que servirá de referência
        String texto = conteudoArquivo;
        String[] strRef = texto.split("-");
        l = strRef.length;

        for (i = 0; i < l; i++) {
            // x Recebe os valores da String referência em formato Integer
            x = Integer.parseInt(strRef[i]);

            // Verifica se há alguma página a ser substituída
            if (!verificaAcertos(x, arra, segunda_chance, qFrames)) {

                // Seleciona uma página a ser removida da memória
                ponteiro = encontraSubstitui(x, arra, segunda_chance, qFrames, ponteiro);
                
                // Marca uma falta
                faltas++;
            }
        }

        this.acertos = l - faltas;


        this.tela.setResultado("SEGUNDA_CHANCE", this.acertos);

    }

}
