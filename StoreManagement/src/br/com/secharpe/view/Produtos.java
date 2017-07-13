package br.com.secharpe.view;

import br.com.secharpe.dao.ProdutoDAO;
import br.com.secharpe.listener.ProdutoViewActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LuizAlexandre17 <luizalexandre17@unesc.net>
 */
public class Produtos extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private final ProdutoViewActionListener handlerProdutos = new ProdutoViewActionListener(this);
    private Painel painel;
    private ArrayList<JInternalFrame> childs;
    private String[] columnNames = {"Codigo", "Nome", "Descrição", "Custo", "Venda", "Fabricante", "Unidade", "Tipo", "Estoque", "Estoque Min"};
    private DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form Produtos
     *
     * @param painel Painel
     */
    public Produtos(Painel painel) {
        new br.com.secharpe.util.Log().put("Produtos", "Abrindo janela");
        this.painel = painel;
        childs = new ArrayList<>();
        initComponents();
        btNovo.addActionListener(handlerProdutos);
        btEditar.addActionListener(handlerProdutos);
        btFechar.addActionListener(handlerProdutos);
        btRemover.addActionListener(handlerProdutos);
        model.setColumnIdentifiers(columnNames);
        jtProdutos.setModel(model);
        jtProdutos.setSelectionMode(0);
        refreshTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNovo = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Produtos");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
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

        btNovo.setText(br.com.secharpe.util.Propriedades.getProp("form.new"));

        btRemover.setText(br.com.secharpe.util.Propriedades.getProp("form.remove"));

        btEditar.setText(br.com.secharpe.util.Propriedades.getProp("form.edit"));

        btFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtProdutos);
        if (jtProdutos.getColumnModel().getColumnCount() > 0) {
            jtProdutos.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtProdutos.getColumnModel().getColumn(3).setPreferredWidth(55);
            jtProdutos.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtProdutos.getColumnModel().getColumn(8).setPreferredWidth(35);
            jtProdutos.getColumnModel().getColumn(9).setPreferredWidth(35);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btRemover)
                    .addComponent(btEditar)
                    .addComponent(btFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        refreshTable();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        refreshTable();
    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProdutos;
    // End of variables declaration//GEN-END:variables
    /**
     * @return painel Painel
     */
    public Painel getPainel() {
        return this.painel;
    }

    public void refreshTable() {
        model.setRowCount(0);
        ProdutoDAO produto = new ProdutoDAO();
        List<br.com.secharpe.model.Produtos> listProdutos = produto.getAll();
        for (br.com.secharpe.model.Produtos est : listProdutos) {
            model.addRow(new Object[]{est.getCodigo(), est.getNome(), est.getDescricao(), est.getCusto(), est.getValorVenda(), est.getFabricante(), est.getUnidade().getSigla(), est.getEstoque(), est.getEstoqueMin()});
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
        return this.jtProdutos;
    }
}
