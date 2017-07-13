package br.com.secharpe.view;

import br.com.secharpe.dao.ProdutoDAO;
import br.com.secharpe.dao.UnidadeDAO;
import br.com.secharpe.exception.SistemaException;
import br.com.secharpe.model.Produtos;
import br.com.secharpe.listener.ProdutoCadastroViewActionListener;
import br.com.secharpe.util.Log;
import br.com.secharpe.util.MessageCtrl;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class ProdutosCadastro extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private final ProdutoCadastroViewActionListener hadlerProdutos = new ProdutoCadastroViewActionListener(this);
    private final Log logimp = new Log();
    public br.com.secharpe.view.Produtos est = null;
    private UnidadeDAO daouni = new UnidadeDAO();
    private ArrayList<br.com.secharpe.model.Unidades> uniList = daouni.getAll();
    private Produtos produto;

    /**
     * Creates new form CadastroProduto
     */
    public ProdutosCadastro(br.com.secharpe.view.Produtos produtos) {
        init(produtos);
    }

    public ProdutosCadastro(br.com.secharpe.view.Produtos produtos, Produtos p) {
        init(produtos);
        this.produto = p;
        pDescricao.setText(p.getDescricao());
        pEstoqueAtual.setText(String.valueOf(p.getEstoque()));
        pEstoqueMinimo.setText(String.valueOf(p.getEstoque()));
        pFabricante.setSelectedItem((p.getFabricante()));
        pNome.setText(p.getNome());
        pPrecoCusto.setText(String.valueOf(p.getCusto()));
        pPrecoVenda.setText(String.valueOf(p.getValorVenda()));
        pTipo.setSelectedItem(p.getTipo());
        pUnidade.setSelectedItem(p.getUnidade().getNome());
        pSalvar.setActionCommand("edit");
    }

    private void init(br.com.secharpe.view.Produtos produtos) {
        new br.com.secharpe.util.Log().put("ProdutosCadastro", "Abrindo janela");
        initComponents();
        est = produtos;
        setSize(640, 190);
        pSalvar.addActionListener(hadlerProdutos);
        pFechar.addActionListener(hadlerProdutos);
    }

    public Produtos getProduto() throws NullPointerException, SistemaException {
        if (pDescricao.getText().trim().equals("")) {
            throw new SistemaException("Insira a Descrição");
        }
        if (pEstoqueAtual.getText().trim().equals("") || pEstoqueAtual.getText().trim().equals("0")) {
            throw new SistemaException("Insira o Estoque Atual");
        }
        if (pEstoqueMinimo.getText().trim().equals("") || pEstoqueMinimo.getText().trim().equals("0")) {
            throw new SistemaException("Insira o Estoque Minimo");
        }

        try {
            Produtos p = new Produtos();
            p.setNome(pNome.getText());
            p.setDescricao(pDescricao.getText());
            if (pEstoqueAtual.getText() != null && !pEstoqueAtual.getText().trim().equals("")) {
                p.setEstoque(Integer.parseInt(pEstoqueAtual.getText()));
            }
            if (pEstoqueMinimo.getText() != null && !pEstoqueMinimo.getText().trim().equals("")) {
                p.setEstoqueMin(Integer.parseInt(pEstoqueMinimo.getText()));
            }
            if (pPrecoCusto.getText() != null && !pPrecoCusto.getText().trim().equals("")) {
                p.setCusto(Float.parseFloat(pPrecoCusto.getText()));

            }
            if (pPrecoVenda.getText() != null && !pPrecoVenda.getText().trim().equals("")) {
                p.setValorVenda(Float.parseFloat(pPrecoVenda.getText()));
            }

            p.setFabricante((String) pFabricante.getSelectedItem());

            p.setTipo(pTipo.getSelectedItem().toString());
            p.setUnidade(daouni.getUnidade((String) pUnidade.getSelectedItem()));
            logimp.put("Cadastro", "Produto Cadastrado");
            return p;
        } catch (NumberFormatException nfe) {
            MessageCtrl.callMessage("A String digitado não corresponde a informação", "Ops, um erro ocorreu", 8);
            System.out.println("A String digitado não corresponde a informação");
            StringWriter sw = new StringWriter();
            nfe.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            logimp.put("ERRO", exceptionAsString);
            logimp.put("ProdutosCadastro", "getProduto", exceptionAsString);
        } catch (NullPointerException x) {

            System.out.println("Null Pointer");
            StringWriter sw = new StringWriter();
            x.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            logimp.put("ERRO", exceptionAsString);
            logimp.put("ProdutosCadastro", "getProduto", exceptionAsString);
        }
        return null;
    }

    public br.com.secharpe.view.Produtos getProdutoView() {
        return this.est;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pNome = new javax.swing.JTextField();
        pDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pEstoqueAtual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pEstoqueMinimo = new javax.swing.JTextField();
        pTipo = new javax.swing.JComboBox<>();
        pFabricante = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pPrecoCusto = new javax.swing.JTextField();
        pPrecoVenda = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pUnidade = new javax.swing.JComboBox<>();
        pFechar = new javax.swing.JButton();
        pSalvar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cadastrar Produto");
        setMaximumSize(new java.awt.Dimension(640, 190));
        setMinimumSize(new java.awt.Dimension(640, 190));
        setPreferredSize(new java.awt.Dimension(640, 190));
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

        jLabel2.setText("Nome:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Descrição:");

        jLabel5.setText("Fabricante:");

        jLabel6.setText("Estoque Atual:");

        jLabel7.setText("Estoque Minimo:");

        pTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serviço", "Peça", "Acessório", "Cabos" }));

        pFabricante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Honda", "VW", "GM", "Yamaha", "Toyota" }));
        pFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFabricanteActionPerformed(evt);
            }
        });

        jLabel8.setText("Preço Custo:");

        jLabel9.setText("Preço Venda:");

        jLabel10.setText("Unidade:");

        pUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Kilos", "Metro" }));

        pFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));

        pSalvar.setText(br.com.secharpe.util.Propriedades.getProp("form.save"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pDescricao)
                                    .addComponent(pNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(jLabel5))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pEstoqueAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(pEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pFabricante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(pPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(pSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(pDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(pEstoqueAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(pEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(pTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(pPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pSalvar)
                    .addComponent(pFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pFabricanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pFabricanteActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        ArrayList<String> list = new ArrayList();
        for (br.com.secharpe.model.Unidades u : uniList) {
            list.add(u.getNome());
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel<>(list.toArray());
        pUnidade.setModel(model);
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField pDescricao;
    private javax.swing.JTextField pEstoqueAtual;
    private javax.swing.JTextField pEstoqueMinimo;
    private javax.swing.JComboBox<String> pFabricante;
    private javax.swing.JButton pFechar;
    private javax.swing.JTextField pNome;
    private javax.swing.JTextField pPrecoCusto;
    private javax.swing.JTextField pPrecoVenda;
    private javax.swing.JButton pSalvar;
    private javax.swing.JComboBox<String> pTipo;
    private javax.swing.JComboBox<String> pUnidade;
    // End of variables declaration//GEN-END:variables
}
