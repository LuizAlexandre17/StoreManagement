package br.com.secharpe.view;

import br.com.secharpe.dao.CidadeDAO;
import br.com.secharpe.listener.CidadesViewActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * View para exibir todas as cidades
 *
 * @author luandr<stringigualanull@outlook.com>
 */
public class Cidades extends javax.swing.JInternalFrame {

    private CidadesViewActionListener handlerCidades = new CidadesViewActionListener(this);
    private Painel painel;
    private ArrayList<JInternalFrame> childs;
    private final String[] columnNames = {"ID", "Nome", "ID_Estado", "Estado", "Sigla"};
    private DefaultTableModel model = new DefaultTableModel() {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form Cidades
     *
     * @param painel Painel
     */
    public Cidades(Painel painel) {
        new br.com.secharpe.util.Log().put("Cidades", "Abrindo janela");
        this.painel = painel;
        childs = new ArrayList<>();
        initComponents();
        btNovo.addActionListener(handlerCidades);
        btFechar.addActionListener(handlerCidades);
        btEditar.addActionListener(handlerCidades);
        btRemover.addActionListener(handlerCidades);
        model.setColumnIdentifiers(columnNames);
        jtCidades.setModel(model);
        jtCidades.setAutoCreateRowSorter(true);
        jtCidades.setSelectionMode(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNovo = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCidades = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cidades");
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

        btEditar.setText(br.com.secharpe.util.Propriedades.getProp("form.edit"));

        btFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        jtCidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jtCidades);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JTable jtCidades;
    // End of variables declaration//GEN-END:variables

    /**
     * Atualiza vamores da tabela
     */
    public void refreshTable() {
        model.setRowCount(0);
        CidadeDAO cidade = new CidadeDAO();
        List<br.com.secharpe.model.Cidades> listCidades = cidade.getAll();
        System.out.println(listCidades);
        listCidades.forEach((est) -> {
            model.addRow(new Object[]{est.getCodigo(), est.getNome(), est.getEstado().getCodigo(), est.getEstado().getNome(), est.getEstado().getSigla()});
        });
    }

    public Painel getPainel() {
        return this.painel;
    }
    private static Cidades instance;

    public static Cidades getInstance(Painel painel) {
        if (instance == null) {
            instance = new Cidades(painel);
        }
        return instance;
    }

    public JTable getTable() {
        return this.jtCidades;
    }

    public void addChild(JInternalFrame cdCad) {
        childs.add(cdCad);
    }

    public void childRemove(JInternalFrame cdCad) {
        childs.remove(cdCad);
    }

    public void closeChilds() {
        for (JInternalFrame janela : childs) {
            if (janela != null) {
                janela.dispose();
            }
        }
    }
}
