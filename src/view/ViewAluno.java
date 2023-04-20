/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerAluno;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelAluno;

/**
 *
 * @author Diego Barbosa
 */
public class ViewAluno extends javax.swing.JFrame {

    ModelAluno modelAluno = new ModelAluno();
    ArrayList<ModelAluno> listaModelAlunos = new ArrayList<>();
    ControllerAluno controllerAluno = new ControllerAluno();
    String editarSalvar;

    /**
     * Creates new form ViewAluno
     */
    public ViewAluno() {
        initComponents();
        this.listarAlunos();
        this.habilitarDesabilitarCampos(false);
        this.jObrigatorio.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNomeAluno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableAluno = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jtfCodigoAluno = new javax.swing.JTextField();
        jObrigatorio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Alunos");
        setLocation(new java.awt.Point(700, 200));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("Código do Aluno:");

        jtfNomeAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Pesquisar:");

        jtfPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jtableAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtableAluno);
        if (jtableAluno.getColumnModel().getColumnCount() > 0) {
            jtableAluno.getColumnModel().getColumn(0).setMinWidth(60);
            jtableAluno.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtableAluno.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        btnPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(0, 153, 51));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 153));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 0, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jtfCodigoAluno.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfCodigoAluno.setEnabled(false);

        jObrigatorio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        jObrigatorio.setText("*");
        jObrigatorio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jtfCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jObrigatorio)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNomeAluno)
                        .addComponent(jObrigatorio))
                    .addComponent(jtfCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar)
                    .addComponent(btnNovo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) this.jtableAluno.getModel();
        final TableRowSorter<TableModel> classifica = new TableRowSorter<>(modelo);
        this.jtableAluno.setRowSorter(classifica);
        String pesquisa = this.jtfPesquisa.getText();
        if (this.testaString(pesquisa) == true) {
            classifica.setRowFilter(RowFilter.regexFilter(pesquisa, 0));
        } else {
            classifica.setRowFilter(RowFilter.regexFilter(pesquisa.toUpperCase(), 1));
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.jObrigatorio.setVisible(false);
        editarSalvar = "editar";
        int linha = this.jtableAluno.getSelectedRow();
        this.habilitarDesabilitarCampos(true);
        try {
            int codigoAluno = (int) this.jtableAluno.getValueAt(linha, 0);
            modelAluno = controllerAluno.retornarAlunoController(codigoAluno);
            this.jtfCodigoAluno.setText(String.valueOf(modelAluno.getCodigoAluno()));
            this.jtfNomeAluno.setText(modelAluno.getNomeAluno());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // A variável vai receber a linha que está selecionado na tabela
        this.jObrigatorio.setVisible(false);
        int linha = this.jtableAluno.getSelectedRow();
        // Nesta é guardado o valor do código do aluno passando o número da linha, e na coluna 0 que é o código do mesmo
        int codigoAluno = (int) this.jtableAluno.getValueAt(linha, 0);
        if (JOptionPane.showConfirmDialog(this, "Excluir Aluno?", "Excluir",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (controllerAluno.excluirAlunoController(codigoAluno)) {
                JOptionPane.showMessageDialog(this, "Aluno excluído", "ATENÇÃO",
                        JOptionPane.WARNING_MESSAGE);
                this.listarAlunos();
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro de exclusão", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.habilitarDesabilitarCampos(false);
        this.limparCampos();
        this.jObrigatorio.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.limparCampos();
        this.habilitarDesabilitarCampos(true);
        editarSalvar = "salvar";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (editarSalvar.equals("salvar")) {
            this.salvarAluno();
        } else if (editarSalvar.equals("editar")) {
            this.editarAluno();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAluno().setVisible(true);
            }
        });
    }

    /**
     * Lista os alunos cadastrados no banco de dados.
     */
    private void listarAlunos() {
        listaModelAlunos = controllerAluno.retornarListarAlunosController();
        DefaultTableModel tabela = (DefaultTableModel) this.jtableAluno.getModel();
        tabela.setNumRows(0);

        int contador = listaModelAlunos.size();
        for (int c = 0; c < contador; c++) {
            tabela.addRow(new Object[]{
                listaModelAlunos.get(c).getCodigoAluno(),
                listaModelAlunos.get(c).getNomeAluno()
            });
        }
    }

    /**
     * Salva o cadastro de dados de um novo aluno no banco de dados.
     */
    private void salvarAluno() {
        if (this.jtfNomeAluno.getText().isEmpty()) {
            this.jObrigatorio.setVisible(true);
            JOptionPane.showMessageDialog(null, "Campo vazio", "ATENÇÃO",
                    JOptionPane.WARNING_MESSAGE);
        } else if (this.jtfNomeAluno.getText().length() >= 51) {
            this.jObrigatorio.setVisible(true);
            JOptionPane.showMessageDialog(null, "Excede o limite de 50 caracteres!!", "ATENÇÃO",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            this.modelAluno.setNomeAluno(this.jtfNomeAluno.getText().toUpperCase());
            if (controllerAluno.salvarAlunoController(modelAluno) > 0) {
                JOptionPane.showMessageDialog(null, "Cadastrado aluno com sucesso", "ATENÇÃO",
                        JOptionPane.INFORMATION_MESSAGE);
                this.listarAlunos();
                this.habilitarDesabilitarCampos(false);
                this.limparCampos();
                this.jObrigatorio.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não cadastrado", "ATENÇÃO",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    /**
     * Edita os dados de um aluno já existente no banco de dados.
     */
    private void editarAluno() {
        if (this.jtfNomeAluno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo vazio", "ATENÇÃO",
                    JOptionPane.WARNING_MESSAGE);
        } else if (this.jtfNomeAluno.getText().length() >= 51) {
            JOptionPane.showMessageDialog(null, "Excede o limite de 50 caracteres!!", "ATENÇÃO",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            modelAluno.setNomeAluno(this.jtfNomeAluno.getText().toUpperCase());
            if (controllerAluno.editarAlunoController(modelAluno)) {
                JOptionPane.showMessageDialog(this, "Editado com sucesso!!", "ATENÇÃO",
                        JOptionPane.INFORMATION_MESSAGE);
                this.listarAlunos();
                this.habilitarDesabilitarCampos(false);
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Não foi aplicado a edição, verifique as informações", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    /**
     * Método para limpar os campos da tela.
     */
    private void limparCampos() {
        this.jtfCodigoAluno.setText("");
        this.jtfNomeAluno.setText("");
    }

    /**
     * Habilitar e desabilitar campos de texto.
     * @param condicao
     */
    private void habilitarDesabilitarCampos(boolean condicao) {
        this.jtfNomeAluno.setEnabled(condicao);
    }

    /**
     * Verifica se uma string possuí números.
     * @param texto
     * @return boolean
     */
    private boolean testaString(String texto) {
        Pattern p = Pattern.compile("[0-9]+");
        String pesquisa;
        pesquisa = texto;
        boolean numerico = (pesquisa != null && p.matcher(pesquisa).find());
        return numerico;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jObrigatorio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableAluno;
    private javax.swing.JTextField jtfCodigoAluno;
    private javax.swing.JTextField jtfNomeAluno;
    private javax.swing.JTextField jtfPesquisa;
    // End of variables declaration//GEN-END:variables
}
