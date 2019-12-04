/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.saida;

import br.edu.ifce.tiposAlgoritmos.TipoAlgoritmo;
import br.edu.ifce.view.TelaPrincipal;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Eduardo
 */
public class Grafico {
    
    TelaPrincipal tela;
    DefaultCategoryDataset graficoLinha = new DefaultCategoryDataset();
    
    public Grafico(TelaPrincipal tela) {
        this.tela = tela;
    }
    
    public void criarGrafico() {
        JFreeChart grafico = ChartFactory.createLineChart(
                "Algoritmos de Substituição de Páginas",
                "Quantidade de Frames",
                "Quantidade de Acertos",
                this.graficoLinha,
                PlotOrientation.VERTICAL,
                true, true, true
        );
        
        ChartPanel painel = new ChartPanel(grafico);
        this.tela.setGrafico(painel);
    }
    
    public void adicionarDadoAoGrafico(int numeroFrames, Resultado acertos) {
        this.graficoLinha.addValue(acertos.getAcertosFIFO(),           TipoAlgoritmo.FIFO.getValor(),           Integer.valueOf(numeroFrames));
        this.graficoLinha.addValue(acertos.getAcertosSegundaChance(),  TipoAlgoritmo.SEGUNDA_CHANCE.getValor(), Integer.valueOf(numeroFrames));
        this.graficoLinha.addValue(acertos.getAcertosNUR(),            TipoAlgoritmo.NUR.getValor(),            Integer.valueOf(numeroFrames));
        this.graficoLinha.addValue(acertos.getAcertosMRU(),            TipoAlgoritmo.MRU.getValor(),            Integer.valueOf(numeroFrames));
        this.graficoLinha.addValue(acertos.getAcertosAlgoritmoOtimo(), TipoAlgoritmo.OTIMO.getValor(),          Integer.valueOf(numeroFrames));
    }
}
