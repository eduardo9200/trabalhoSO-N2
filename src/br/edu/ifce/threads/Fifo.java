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
public class Fifo extends Thread {
    private TelaPrincipal tela;
    private String conteudoArquivo;
    private int qFrames;
    private int acertos;
    
    //Construtor
    public Fifo(
        TelaPrincipal tela,
        String conteudoArquivo,
        int qFrames
    ){
        this.tela = tela;
        this.conteudoArquivo = conteudoArquivo;
        this.qFrames = qFrames;
    };
    
    /*
     * Se uma página for encontrada, marca um acerto e retorna true;
     * Caso contrário, retorna false
     */
    private boolean verificaAcertos(int x, int array[], int qFrames) {

        //Percorre o array de frames
        for (int i=0; i<qFrames; i++) {
            //Se o valor x já estiver no array, marca um acerto, retorna true e não será necessária substituição
            if (array[i] == x) {
                this.acertos++;
                return true;
                
              //Caso o valor de array[i] seja -1, significa que o espaço está vazio e retorna false, para que seja acrescida uma falta e o espaço seja preenchido
            } else if (array[i] == -1) {
                return false;
            }
        }
        //Caso o array não possua valores iguais a -1, nem tenha havido acertos, então retorna falso para que a página possa ser selecionada para ser substituída
        return false;
    }

    /*
     * Encontra uma página na memória, substitui pelo valor x e retorna um ponteiro,
     * correspondente à próxima posição do array de frames que será substituída.
     */
    private static int encontraSubstitui(int x, int array[], int qFrames, int ponteiro) {
        //Modifica a página
        array[ponteiro] = x;

        //Retorna a posição atualizada do ponteiro
        return (ponteiro + 1) % qFrames;
    }
    
    /*
     * Thread FIFO
     */
    @Override
    public void run() {
        
        int ponteiro = 0; //Ponteiro de execução
        int faltas = 0;   //Quantidade de faltas
        int i, x, b, l;   //Variáveis auxiliares
        
        //Cria o array das páginas a serem carregadas e muda o valor das mesmas para -1, para indicar que não estão preenchidas
        int array[] = new int[qFrames];
        Arrays.fill(array, -1);

        //Separando o texto através dos -
        //Também é criada aqui a String que servirá de referência
        String texto = conteudoArquivo.replaceAll("[^\\d-]", "");
        String[] strRef = texto.split("-");
        //l = strRef.length;
        
        for(i=0; i<strRef.length; i++) {
            //x Recebe os valores inteiros da String referência, em formato Integer
            x = Integer.parseInt(strRef[i]);

            //Verifica se há alguma página a ser substituída
            if (!verificaAcertos(x, array, qFrames)) {
                //Seleciona uma página a ser removida da memória
                ponteiro = encontraSubstitui(x, array, qFrames, ponteiro);

                //Marca uma falta
                faltas++;
            }
        }

        //Ao finalizar a execução, seta o resultado para ser mostrado no gráfico e na tabela
        System.out.println("Frames: " + qFrames + ". FIFO: " + this.acertos);
        this.tela.setResultado(TipoAlgoritmo.FIFO, this.acertos);
    }

}
