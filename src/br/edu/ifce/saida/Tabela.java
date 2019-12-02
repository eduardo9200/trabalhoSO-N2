/*
 * 
 */
package br.edu.ifce.saida;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Eduardo
 */
public class Tabela extends AbstractTableModel {
    
    private List<Resultado> resultado = new ArrayList<>();
    private final String[] colunas = {"Qtde. de Frames", "FIFO", "Segunda Chance", "NUR", "MRU", "Ótimo"};
    
    @Override
    public String getColumnName(int coluna){
        return colunas[coluna];
    }
    
    @Override
    public int getRowCount() {
        return resultado.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return resultado.get(linha).getNumeroFrames();
            case 1:
                return resultado.get(linha).getAcertosFIFO();
            case 2:
                return resultado.get(linha).getAcertosSegundaChance();
            case 3:
                return resultado.get(linha).getAcertosNUR();
            case 4:
                return resultado.get(linha).getAcertosMRU();
            case 5:
                return resultado.get(linha).getAcertosAlgoritmoOtimo();
        }
        return null;
    }
    
    public void adicionarLinha(Resultado resultado){
        this.resultado.add(resultado);
        this.fireTableDataChanged();
    }
}
