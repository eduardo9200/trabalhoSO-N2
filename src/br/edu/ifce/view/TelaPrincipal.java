/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.view;

import br.edu.ifce.saida.Resultado;
import br.edu.ifce.saida.Tabela;
import br.edu.ifce.threads.AlgoritmoOtimo;
import br.edu.ifce.threads.Fifo;
import br.edu.ifce.threads.Mru;
import br.edu.ifce.threads.Nur;
import br.edu.ifce.threads.SegundaChance;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private int resultadoFifo = 0;
    private int resultadoSegundaChance = 0;
    private int resultadoNur = 0;
    private int resultadoMru = 0;
    private int resultadoOtimo = 0;
    
    Tabela tabelaResultado = new Tabela();
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        
        this.jTable_saida.setModel(tabelaResultado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_telaPrincipal = new javax.swing.JPanel();
        jPanel_entrada_de_dados = new javax.swing.JPanel();
        jButton_procurar = new javax.swing.JButton();
        jTextField_caminho_do_arquivo = new javax.swing.JTextField();
        jLabel_q1 = new javax.swing.JLabel();
        jTextField_q1 = new javax.swing.JTextField();
        jLabel_q2 = new javax.swing.JLabel();
        jTextField_q2 = new javax.swing.JTextField();
        jLabel_bitR = new javax.swing.JLabel();
        jTextField_bitR = new javax.swing.JTextField();
        jPanel_execucao = new javax.swing.JPanel();
        jButton_executar = new javax.swing.JButton();
        jTextField_campos_obrigatorios = new javax.swing.JTextField();
        jTabbedPane_saida = new javax.swing.JTabbedPane();
        jPanel_grafico = new javax.swing.JPanel();
        jPanel_tabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_saida = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_conteudo_do_arquivo = new javax.swing.JTextArea();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu_descricao = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_sobre = new javax.swing.JMenuItem();
        jMenu_sair = new javax.swing.JMenu();
        jMenuItem_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmos de Substituição de Páginas");
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));

        jPanel_telaPrincipal.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel_telaPrincipal.setMinimumSize(new java.awt.Dimension(900, 600));
        jPanel_telaPrincipal.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel_entrada_de_dados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_procurar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_procurar.setText("Procurar arquivo");
        jButton_procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_procurarActionPerformed(evt);
            }
        });

        jTextField_caminho_do_arquivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel_q1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_q1.setText("Q1");

        jTextField_q1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel_q2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_q2.setText("Q2");

        jTextField_q2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel_bitR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_bitR.setText("BIT R");

        jTextField_bitR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel_entrada_de_dadosLayout = new javax.swing.GroupLayout(jPanel_entrada_de_dados);
        jPanel_entrada_de_dados.setLayout(jPanel_entrada_de_dadosLayout);
        jPanel_entrada_de_dadosLayout.setHorizontalGroup(
            jPanel_entrada_de_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_entrada_de_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_procurar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_caminho_do_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_entrada_de_dadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_q1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_q1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_q2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_q2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_bitR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_bitR, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanel_entrada_de_dadosLayout.setVerticalGroup(
            jPanel_entrada_de_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_entrada_de_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_entrada_de_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_procurar)
                    .addComponent(jTextField_caminho_do_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_entrada_de_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_q1)
                    .addComponent(jTextField_q1)
                    .addComponent(jLabel_q2)
                    .addComponent(jTextField_q2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_bitR)
                    .addComponent(jTextField_bitR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel_execucao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_executar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_executar.setText("Executar");
        jButton_executar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_executarActionPerformed(evt);
            }
        });

        jTextField_campos_obrigatorios.setEditable(false);
        jTextField_campos_obrigatorios.setBackground(new java.awt.Color(240, 240, 240));
        jTextField_campos_obrigatorios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_campos_obrigatorios.setForeground(new java.awt.Color(255, 0, 0));
        jTextField_campos_obrigatorios.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_campos_obrigatorios.setBorder(null);

        javax.swing.GroupLayout jPanel_execucaoLayout = new javax.swing.GroupLayout(jPanel_execucao);
        jPanel_execucao.setLayout(jPanel_execucaoLayout);
        jPanel_execucaoLayout.setHorizontalGroup(
            jPanel_execucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_execucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_campos_obrigatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_execucaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_executar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel_execucaoLayout.setVerticalGroup(
            jPanel_execucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_execucaoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jButton_executar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_campos_obrigatorios)
                .addContainerGap())
        );

        jTabbedPane_saida.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel_graficoLayout = new javax.swing.GroupLayout(jPanel_grafico);
        jPanel_grafico.setLayout(jPanel_graficoLayout);
        jPanel_graficoLayout.setHorizontalGroup(
            jPanel_graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
        );
        jPanel_graficoLayout.setVerticalGroup(
            jPanel_graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jTabbedPane_saida.addTab("GRÁFICO", jPanel_grafico);

        jTable_saida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_saida);

        javax.swing.GroupLayout jPanel_tabelaLayout = new javax.swing.GroupLayout(jPanel_tabela);
        jPanel_tabela.setLayout(jPanel_tabelaLayout);
        jPanel_tabelaLayout.setHorizontalGroup(
            jPanel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_tabelaLayout.setVerticalGroup(
            jPanel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tabelaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane_saida.addTab("TABELA", jPanel_tabela);

        jTextArea_conteudo_do_arquivo.setEditable(false);
        jTextArea_conteudo_do_arquivo.setColumns(20);
        jTextArea_conteudo_do_arquivo.setRows(5);
        jScrollPane2.setViewportView(jTextArea_conteudo_do_arquivo);

        javax.swing.GroupLayout jPanel_telaPrincipalLayout = new javax.swing.GroupLayout(jPanel_telaPrincipal);
        jPanel_telaPrincipal.setLayout(jPanel_telaPrincipalLayout);
        jPanel_telaPrincipalLayout.setHorizontalGroup(
            jPanel_telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_telaPrincipalLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel_telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane_saida, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_telaPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel_entrada_de_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_execucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(38, 38, 38))
        );
        jPanel_telaPrincipalLayout.setVerticalGroup(
            jPanel_telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_telaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_entrada_de_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_execucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane_saida, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu_descricao.setText("Descrição");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Descrição do Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu_descricao.add(jMenuItem1);

        jMenuBar.add(jMenu_descricao);

        jMenu2.setText("Sobre");

        jMenuItem_sobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem_sobre.setText("Sobre o Sistema");
        jMenuItem_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_sobreActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_sobre);

        jMenuBar.add(jMenu2);

        jMenu_sair.setText("Sair");

        jMenuItem_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem_sair.setText("Sair do Sistema");
        jMenuItem_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_sairActionPerformed(evt);
            }
        });
        jMenu_sair.add(jMenuItem_sair);

        jMenuBar.add(jMenu_sair);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_telaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_telaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 567, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reinicializarCamposDeEntrada() {
        java.awt.Color corCinza = new java.awt.Color(153,153,153);
        
        this.jTextField_caminho_do_arquivo.setBorder(BorderFactory.createLineBorder(corCinza, 1));
        this.jTextField_q1.setBorder(BorderFactory.createLineBorder(corCinza, 1));
        this.jTextField_q2.setBorder(BorderFactory.createLineBorder(corCinza, 1));
        this.jTextField_bitR.setBorder(BorderFactory.createLineBorder(corCinza, 1));
    }
    
    private void limparCamposDeEntrada() {
        this.jTextField_caminho_do_arquivo.setText("");
        this.jTextField_q1.setText("");
        this.jTextField_q2.setText("");
        this.jTextField_bitR.setText("");
    }
    
    private boolean validarCamposDeEntrada() {
        int aux = 0;
        
        this.jTextField_campos_obrigatorios.setForeground(Color.RED);
        
        if(this.jTextField_caminho_do_arquivo.getText().equals("")) {
            this.jTextField_caminho_do_arquivo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            //this.jButton_procurar.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            aux++;
        }
        
        if(this.jTextField_q1.getText().equals("")) {
            this.jTextField_q1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            aux++;
        }
        
        if(this.jTextField_q2.getText().equals("")) {
            this.jTextField_q2.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            aux++;
        }
        
        if(this.jTextField_bitR.getText().equals("")) {
            this.jTextField_bitR.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            aux++;
        }
        
        if(aux > 0) {
            this.jTextField_campos_obrigatorios.setText(aux + " campos obrigatórios vazios");
            return false;
        } else {
            this.jTextField_campos_obrigatorios.setForeground(Color.BLUE);
            return true;
        }
    }
    
    private int getValorQ1() {
        int q1;
        
        int q2 = Integer.valueOf(this.jTextField_q2.getText());
        
        try {
            q1 = Integer.valueOf(this.jTextField_q1.getText());
            
            if (q1 < 1 && q2 > 0) {
                this.jTextField_q1.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
                this.jTextField_campos_obrigatorios.setText("Campo(s) inválido(s)");
                this.jTextField_campos_obrigatorios.setForeground(Color.RED);
                System.out.println("NumberException: valor Q1 inválido.");
                JOptionPane.showMessageDialog(this, "Campo Q1 não pode ser menor que 1", "ERRO", JOptionPane.ERROR_MESSAGE);
                return -1;
            }else if (q1 > q2 && q2 > 0) {
                this.jTextField_q1.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
                this.jTextField_campos_obrigatorios.setText("Campo(s) inválido(s)");
                this.jTextField_campos_obrigatorios.setForeground(Color.RED);
                System.out.println("NumberException: valor Q1 inválido");
                JOptionPane.showMessageDialog(this, "Campo Q1 deve ser menor ou igual ao campo Q2", "ERRO", JOptionPane.ERROR_MESSAGE);
                return -1;
            }else {
                return q1;
            }
                        
        } catch(NumberFormatException e) {
            this.jTextField_q1.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
            this.jTextField_campos_obrigatorios.setText("Campo(s) inválido(s)");
            this.jTextField_campos_obrigatorios.setForeground(Color.RED);
            System.out.println("NumberFormatException: falha na conversão de valores do campo Q1.");
            JOptionPane.showMessageDialog(this, "Campo Q1 só aceita números. Verifique se há espaços ou outro caractere que não seja um número", "ERRO", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    private int getValorQ2() {
        int q2;
        
        try {
            q2 = Integer.valueOf(this.jTextField_q2.getText());
            
            if (q2 < 1) {
                this.jTextField_q2.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
                this.jTextField_campos_obrigatorios.setText("Campo(s) inválido(s)");
                this.jTextField_campos_obrigatorios.setForeground(Color.RED);
                System.out.println("NumberException: valor Q2 inválido.");
                JOptionPane.showMessageDialog(this, "Campo Q2 não pode ser menor que 1", "ERRO", JOptionPane.ERROR_MESSAGE);
                return -1;
            }else {
                return q2;
            }
            
            
        } catch(NumberFormatException e) {
            this.jTextField_q2.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
            this.jTextField_campos_obrigatorios.setText("Campo(s) inválido(s)");
            this.jTextField_campos_obrigatorios.setForeground(Color.RED);
            System.out.println("NumberFormatException: falha na conversão de valores do campo Q2.");
            JOptionPane.showMessageDialog(this, "Campo Q2 só aceita números. Verifique se há espaços ou outro caractere que não seja um número", "ERRO", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    private int getValorBitR() {
        int bit_R;
        
        try {
            bit_R = Integer.valueOf(this.jTextField_bitR.getText());
            
            if (bit_R < 1) {
                this.jTextField_bitR.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
                this.jTextField_campos_obrigatorios.setText("Campo(s) inválido(s)");
                this.jTextField_campos_obrigatorios.setForeground(Color.RED);
                System.out.println("NumberException: valor BitR inválido.");
                JOptionPane.showMessageDialog(this, "Campo BitR não pode ser menor que 1", "ERRO", JOptionPane.ERROR_MESSAGE);
                return -1;
            }else {
                return bit_R;
            }
                        
        } catch(NumberFormatException e) {
            this.jTextField_bitR.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
            this.jTextField_campos_obrigatorios.setText("Campo(s) inválido(s)");
            this.jTextField_campos_obrigatorios.setForeground(Color.RED);
            System.out.println("NumberFormatException: falha na conversão de valores do campo BIT R.");
            JOptionPane.showMessageDialog(this, "Campo BIT R só aceita números. Verifique se há espaços ou outro caractere que não seja um número", "ERRO", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    private String getConteudoArquivo(String caminhoArquivo) {
        Path arquivo = Paths.get(caminhoArquivo);
        try {
            byte[] bytesArquivo = Files.readAllBytes(arquivo);
            String texto = new String(bytesArquivo).replaceAll("[^\\d-wW]", "");
            
            return texto;
            
        } catch(IOException e) {
            System.out.println(e);
            this.jTextField_campos_obrigatorios.setText("Falha na leitura do arquivo");
            this.jTextField_campos_obrigatorios.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, "Falha na leitura. Verifique se há algum arquivo selecionado, revise sua URL ou tente novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void setResultado(String algoritmo, int resultado) {
        if(algoritmo.equals("FIFO")) {
            this.resultadoFifo = resultado;
        } else if(algoritmo.equals("SEGUNDA_CHANCE")) {
            this.resultadoSegundaChance = resultado;
        } else if(algoritmo.equals("NUR")) {
            this.resultadoNur = resultado;
        } else if(algoritmo.equals("MRU")) {
            this.resultadoMru = resultado;
        } else if(algoritmo.equals("OTIMO")) {
            this.resultadoOtimo = resultado;
        } 
    }
    
    private void executarThreads(String conteudoArquivo, int qFrames, int bitR) {
  
        Thread fifo           = new Fifo(this, conteudoArquivo, qFrames);
        Thread segundaChance  = new SegundaChance(this, conteudoArquivo, qFrames, bitR);
        Thread nur            = new Nur(this, conteudoArquivo, qFrames, bitR);
        Thread mru            = new Mru(this, conteudoArquivo, qFrames);
        Thread algoritmoOtimo = new AlgoritmoOtimo(this, conteudoArquivo, qFrames);
        
        this.jTextField_campos_obrigatorios.setText("Executando");
        this.jTextField_campos_obrigatorios.setForeground(Color.BLUE);
        
        fifo.start();
        segundaChance.start();
        nur.start();
        mru.start();
        algoritmoOtimo.start();
        
        this.jTextField_campos_obrigatorios.setText("Finalizado");
    }
    
    private void executarPrograma(String caminhoArquivo, int Q1, int Q2, int bitR) {
        
        String conteudoArquivo = this.getConteudoArquivo(caminhoArquivo);
        this.jTextArea_conteudo_do_arquivo.append(conteudoArquivo);
        
        if(conteudoArquivo != null){
            
                 
            for (int i = Q1; i <= Q2; i++ ) {
                this.executarThreads(conteudoArquivo, i, bitR);
                Resultado resultado = new Resultado(i, resultadoFifo, resultadoSegundaChance, resultadoNur, resultadoMru, resultadoOtimo);
                resultado = new Resultado(i, resultadoFifo, resultadoSegundaChance, resultadoNur, resultadoMru, resultadoOtimo);
                this.tabelaResultado.adicionarLinha(resultado);
            }
            
        }
        
    }
    
    private void jMenuItem_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_sobreActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(
                this,
                "Algoritmos de Substituição de Páginas\n\n"
                        + "Equipe:\n * Eduardo Maia Santos\n * Carlos Augusto Benevides\n * Rômulo Alberto\n * Rodrigo Viana Castelo Branco\n\n"
                        + "Instituto Federal do Ceará - Campus Fortaleza\n"
                        + "Disciplina: Sistemas Operacionais 2019.2\nProfessor: Fernando Parente Garcia",
                "Sobre",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_jMenuItem_sobreActionPerformed

    private void jButton_procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_procurarActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);
        
        File f = fileChooser.getSelectedFile();
        
        try{
            this.jTextField_caminho_do_arquivo.setText(f.getPath());
        } catch(NullPointerException e) {
            System.out.println("NullPointerException: falha na captura do caminho do arquivo.");
            JOptionPane.showMessageDialog(this, "Falha na captura do caminho do arquivo. Tente novamente ou reinicie este software", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_jButton_procurarActionPerformed

    private void jButton_executarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_executarActionPerformed
        // TODO add your handling code here:
        this.reinicializarCamposDeEntrada();
        
        if(this.validarCamposDeEntrada()) {
            String arquivo = this.jTextField_caminho_do_arquivo.getText();
            int Q1   = this.getValorQ1();
            int Q2   = this.getValorQ2();
            int bitR = this.getValorBitR();
            
            if(Q1 == -1L || Q2 == -1L || bitR == -1L) return; //Falha na leitura dos campos Q1, Q2 ou bitR;
            
            this.executarPrograma(arquivo, Q1, Q2, bitR);
            
            this.reinicializarCamposDeEntrada();
            this.limparCamposDeEntrada();
                    
        }
    }//GEN-LAST:event_jButton_executarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(
                this,
                "Projeto II - Algoritmos de Substituição de Páginas\n\n"
                + "Este software simula os algoritmos de substituição de páginas FIFO, Segunda Chance, NUR, MRU\n"
                + "e o algoritmo Ótimo, gerando um gráfico que mostra a quantidade de acertos para cada um deles,\n"
                + "quando a quantidade de frames da memória real varia.\n\n"
                + "Na prática, o algoritmo Ótimo não é realizável, porém pode ser utilizado como parâmetro de\n"
                + "comparação com os demais algoritmos.\n\n"
                + "O sistema possui como entradas o nome do arquivo contendo o padrão de referências no formato\n"
                + "7W-2W-7R-4W-...; a quantidade de frames da memória real (Q1 e Q2); e a quantidade de referências\n"
                + "em que o SO zera o bit R de todas as páginas.\n\n"
                + "Possui como saídas um gráfico comparativo com os resultados dos algoritmos e uma tabela contendo\n"
                + "a quantidade de acertos dos algoritmos acima citados.",
                "Descrição do Sistema",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_sairActionPerformed
        // TODO add your handling code here:
        int opcao = JOptionPane.showConfirmDialog(this, "Desejas realmente sair?", "Confirmação", JOptionPane.WARNING_MESSAGE);
        if(opcao==0) System.exit(0);
    }//GEN-LAST:event_jMenuItem_sairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_executar;
    private javax.swing.JButton jButton_procurar;
    private javax.swing.JLabel jLabel_bitR;
    private javax.swing.JLabel jLabel_q1;
    private javax.swing.JLabel jLabel_q2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_sair;
    private javax.swing.JMenuItem jMenuItem_sobre;
    private javax.swing.JMenu jMenu_descricao;
    private javax.swing.JMenu jMenu_sair;
    private javax.swing.JPanel jPanel_entrada_de_dados;
    private javax.swing.JPanel jPanel_execucao;
    private javax.swing.JPanel jPanel_grafico;
    private javax.swing.JPanel jPanel_tabela;
    private javax.swing.JPanel jPanel_telaPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane_saida;
    private javax.swing.JTable jTable_saida;
    private javax.swing.JTextArea jTextArea_conteudo_do_arquivo;
    private javax.swing.JTextField jTextField_bitR;
    private javax.swing.JTextField jTextField_caminho_do_arquivo;
    private javax.swing.JTextField jTextField_campos_obrigatorios;
    private javax.swing.JTextField jTextField_q1;
    private javax.swing.JTextField jTextField_q2;
    // End of variables declaration//GEN-END:variables
}
