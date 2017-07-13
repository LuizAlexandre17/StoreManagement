package br.com.secharpe.view;

import br.com.secharpe.dao.ClienteDAO;
import br.com.secharpe.listener.ClienteViewActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * View para exibir todos os clientes
 *
 * @author Your Name <your.name at your.org>
 */
public class Clientes extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private final ClienteViewActionListener handlerClientes = new ClienteViewActionListener(this);
    private Painel painel;
    private ArrayList<JInternalFrame> childs;
    private String[] columnNames = {"Codigo", "Nome", "CPF", "RG", "Estado", "Cidade", "Bairro", "Telefone", "Celular", "Email"};
    private DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * @param painel Painel
     */
    public Clientes(Painel painel) {
        new br.com.secharpe.util.Log().put("Clientes", "Abrindo janela");
        this.painel = painel;
        childs = new ArrayList<>();
        initComponents();
        btSalvar.addActionListener(handlerClientes);
        btFechar.addActionListener(handlerClientes);
        jtClientes.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSalvar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Clientes");
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

        btSalvar.setText(br.com.secharpe.util.Propriedades.getProp("form.new"));

        btRemover.setText(br.com.secharpe.util.Propriedades.getProp("form.remove"));

        btEditar.setText(br.com.secharpe.util.Propriedades.getProp("form.edit"));

        btFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "RG", "Estado", "Cidade", "Bairro", "Telefone", "Celular", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtClientes.setToolTipText("");
        jScrollPane1.setViewportView(jtClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemover)
                    .addComponent(btEditar)
                    .addComponent(btFechar)
                    .addComponent(btSalvar))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        refreshTable();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtClientes;
    // End of variables declaration//GEN-END:variables
    /**
     * @return Retorna painel
     */
    public Painel getPainel() {
        return this.painel;
    }

    public void refreshTable() {
        model.setRowCount(0);
        ClienteDAO estado = new ClienteDAO();
        List<br.com.secharpe.model.Clientes> listClientes = estado.getAll();
        for (br.com.secharpe.model.Clientes est : listClientes) {
            model.addRow(new Object[]{est.getCodigo(), est.getNome(), est.getCPF(), est.getRG(), est.getEstado(), est.getCidade(), est.getBairro(), est.getTelefone(), est.getCelular(), est.getEmail()});
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
        return this.jtClientes;
    }
}
