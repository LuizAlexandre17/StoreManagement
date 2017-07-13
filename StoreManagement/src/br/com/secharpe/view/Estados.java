package br.com.secharpe.view;

import br.com.secharpe.dao.EstadoDAO;
import br.com.secharpe.listener.EstadosViewActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Estados extends javax.swing.JInternalFrame {

    private ArrayList<JInternalFrame> childs;
    private EstadosViewActionListener handlerEstados = new EstadosViewActionListener(this);
    private Painel painel;
    private String[] columnNames = {"Nome", "Sigla"};
    private DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form Cidades
     */
    public Estados(Painel painel) {
        new br.com.secharpe.util.Log().put("Estados", "Abrindo janela");
        childs = new ArrayList<>();
        this.painel = painel;
        initComponents();
        btNovo.addActionListener(handlerEstados);
        btFechar.addActionListener(handlerEstados);
        btRemover.addActionListener(handlerEstados);
        model.setColumnIdentifiers(columnNames);
        jtEstados.setModel(model);
        jtEstados.setSelectionMode(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNovo = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEstados = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Estados");
        setToolTipText("");
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

        btNovo.setText(br.com.secharpe.util.Propriedades.getProp("form.new"));

        btRemover.setText(br.com.secharpe.util.Propriedades.getProp("form.remove"));

        btFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        jtEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtEstados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
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
                    .addComponent(btFechar))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        refreshTable();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        closeChilds();
    }//GEN-LAST:event_btFecharActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        closeChilds();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtEstados;
    // End of variables declaration//GEN-END:variables

    public Painel getPainel() {
        return this.painel;
    }
    private static Estados instance;

    public static Estados getInstance(Painel painel) {
        if (instance == null) {
            instance = new Estados(painel);
        }
        return instance;
    }

    /**
     * Atualiza vamores da tabela
     */
    public void refreshTable() {
        model.setRowCount(0);
        EstadoDAO estado = new EstadoDAO();
        List<br.com.secharpe.model.Estados> listEstados = estado.getAll();
        for (br.com.secharpe.model.Estados est : listEstados) {
            model.addRow(new Object[]{est.getNome(), est.getSigla()});
        }
    }

    public void addChild(JInternalFrame esCad) {
        childs.add(esCad);
    }

    public void closeChilds() {
        for (JInternalFrame janela : childs) {
            janela.dispose();
        }
    }

    public void childRemove(JInternalFrame cdCad) {
        childs.remove(cdCad);
    }

    public JTable getTable() {
        return this.jtEstados;
    }
}
