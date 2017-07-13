package br.com.secharpe.view;

import br.com.secharpe.dao.AnotacoesDAO;
import br.com.secharpe.listener.AnotacoesViewActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * View para exibir todas as anotações
 *
 * @author luandr<stringigualanull@outlook.com>
 */
public class Anotacoes extends javax.swing.JInternalFrame {
    
    private final AnotacoesViewActionListener handlerAnotacoes = new AnotacoesViewActionListener(this);
    private Painel painel;
    private ArrayList<JInternalFrame> childs;
    private final String[] columnNames = {"ID", "Título", "Descrição"};
    private DefaultTableModel model = new DefaultTableModel() {
        private static final long serialVersionUID = 1L;
        
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public Anotacoes(Painel painel) {
        new br.com.secharpe.util.Log().put("Anotacoes", "Abrindo janela");
        this.painel = painel;
        initComponents();
        btFechar.addActionListener(handlerAnotacoes);
        btNovo.addActionListener(handlerAnotacoes);
        btRemover.addActionListener(handlerAnotacoes);
        btVer.addActionListener(handlerAnotacoes);
        model.setColumnIdentifiers(columnNames);
        jtAnotacoes.setModel(model);
        jtAnotacoes.setAutoCreateRowSorter(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtAnotacoes = new javax.swing.JTable();
        btVer = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Anotações");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
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

        jtAnotacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtAnotacoes);

        btVer.setText(br.com.secharpe.util.Propriedades.getProp("form.view"));

        btNovo.setText(br.com.secharpe.util.Propriedades.getProp("form.new"));

        btRemover.setText(br.com.secharpe.util.Propriedades.getProp("form.remove"));

        btFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btRemover)
                    .addComponent(btFechar)
                    .addComponent(btVer))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        refreshTable();
    }//GEN-LAST:event_formInternalFrameOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btVer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAnotacoes;
    // End of variables declaration//GEN-END:variables
    /**
     * @return painel
     */
    public Painel getPainel() {
        return this.painel;
    }
    
    public void refreshTable() {
        model.setRowCount(0);
        AnotacoesDAO anotacoes = new AnotacoesDAO();
        List<br.com.secharpe.model.Anotacoes> listAnotacoes = anotacoes.getAll();
        System.out.println(listAnotacoes);
        listAnotacoes.forEach((br.com.secharpe.model.Anotacoes ano) -> {
            model.addRow(new Object[]{ano.getCodigo(), ano.getTitulo(), ano.getDescricao()});
        });
    }
    
    public JTable getTable() {
        return this.jtAnotacoes;
    }
    
    public void addChild(JInternalFrame cdAno) {
        childs.add(cdAno);
    }
    
    public void childRemove(JInternalFrame cdAno) {
        childs.remove(cdAno);
    }
    
    public void closeChilds() {
        for (JInternalFrame janela : childs) {
            janela.dispose();
        }
    }
}
