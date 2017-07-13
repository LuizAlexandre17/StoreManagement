package br.com.secharpe.view;

import br.com.secharpe.dao.UnidadeDAO;
import br.com.secharpe.listener.UnidadesViewActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Darabas
 */
public class Unidades extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private UnidadesViewActionListener handlerUnidades = new UnidadesViewActionListener(this);
    private Painel painel;
    private final ArrayList<JInternalFrame> childs;
    private final String[] columnNames = {"ID", "Nome", "Sigla"};
    private DefaultTableModel model = new DefaultTableModel() {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form Unidades
     */
    public Unidades(Painel painel) {
        new br.com.secharpe.util.Log().put("Unidades", "Abrindo janela");
        this.painel = painel;
        initComponents();
        childs = new ArrayList<>();
        btNovo.addActionListener(handlerUnidades);
        btFechar.addActionListener(handlerUnidades);
        btRemover.addActionListener(handlerUnidades);
        btEditar.addActionListener(handlerUnidades);
        model.setColumnIdentifiers(columnNames);
        jtUnidades.setModel(model);
        jtUnidades.setSelectionMode(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtUnidades = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Unidades");
        setMaximumSize(new java.awt.Dimension(421, 321));
        setMinimumSize(new java.awt.Dimension(421, 321));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jtUnidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sigla"
            }
        ));
        jScrollPane1.setViewportView(jtUnidades);

        btNovo.setText(br.com.secharpe.util.Propriedades.getProp("form.new"));

        btRemover.setText(br.com.secharpe.util.Propriedades.getProp("form.remove"));

        btEditar.setText(br.com.secharpe.util.Propriedades.getProp("form.edit"));

        btFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btRemover)
                    .addComponent(btEditar)
                    .addComponent(btFechar))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        refreshTable();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        closeChilds();
    }//GEN-LAST:event_formInternalFrameClosing

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        closeChilds();
    }//GEN-LAST:event_btFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtUnidades;
    // End of variables declaration//GEN-END:variables
    /**
     * Método para retornar a tabela
     *
     * @return JTable tabela
     */
    public JTable getTable() {
        return this.jtUnidades;
    }

    /**
     * Método para retornar o painel
     *
     * @return painel Painel
     */
    public Painel getPainel() {
        return this.painel;
    }
    private static Unidades instance;

    /**
     * Método para retornar a instancia de view.Unidades
     *
     * @return instance de Unidades
     */
    public static Unidades getInstance(Painel painel) {
        if (instance == null) {
            instance = new Unidades(painel);
        }
        return instance;
    }

    /**
     * Método para atualizar valores da tabela
     */
    public void refreshTable() {
        model.setRowCount(0);
        UnidadeDAO undao = new UnidadeDAO();
        List<br.com.secharpe.model.Unidades> listUnidade = undao.getAll();
        for (br.com.secharpe.model.Unidades un : listUnidade) {
            model.addRow(new Object[]{un.getCodigo(), un.getNome(), un.getSigla()});
        }
    }

    public void childAdd(JInternalFrame cdCad) {
        childs.add(cdCad);
    }

    public void childRemove(JInternalFrame cdCad) {
        childs.remove(cdCad);
    }

    public void closeChilds() {
        for (JInternalFrame janela : childs) {
            janela.dispose();
        }
    }
}
