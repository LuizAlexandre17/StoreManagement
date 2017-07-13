package br.com.secharpe.listener;

import br.com.secharpe.dao.UnidadeDAO;
import br.com.secharpe.model.Unidades;
import br.com.secharpe.util.Vars;
import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Produtos;
import br.com.secharpe.view.ProdutosCadastro;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/* Classe para action listener de Produtos
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class ProdutoViewActionListener implements ActionListener {

    private Painel painel;
    private Produtos produtos;

    public ProdutoViewActionListener(Produtos produto) {
        this.produtos = produto;
        this.painel = produtos.getPainel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(Vars.PROP_NEW)) {
            ProdutosCadastro produtoCadastro = new ProdutosCadastro(produtos);
            if (VerificaFrame.verificaFrame(produtos.getPainel(), produtoCadastro)) {
                VerificaFrame.exibirFrame(produtos.getPainel(), produtoCadastro);
                produtos.addChild(produtoCadastro);
            }
        } else if (action.equals(Vars.PROP_REMOVE)) {
            JTable tabela = produtos.getTable();
            JOptionPane.showMessageDialog(null, tabela.getValueAt(tabela.getSelectedRow(), 0));
            int cod = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
            br.com.secharpe.dao.ProdutoDAO prodDAO = new br.com.secharpe.dao.ProdutoDAO();
            prodDAO.delete(cod);
            produtos.refreshTable();
        } else if (action.equals(Vars.PROP_EDIT)) {
            JTable tabela = produtos.getTable();
            br.com.secharpe.model.Produtos p = new br.com.secharpe.model.Produtos();
            p.setCodigo((int) tabela.getValueAt(tabela.getSelectedRow(), 0));
            p.setNome((String) tabela.getValueAt(tabela.getSelectedRow(), 1));
            p.setDescricao((String) tabela.getValueAt(tabela.getSelectedRow(), 2));
            p.setCusto((Float) tabela.getValueAt(tabela.getSelectedRow(), 3));
            p.setValorVenda((float) tabela.getValueAt(tabela.getSelectedRow(), 4));
            p.setFabricante((String) tabela.getValueAt(tabela.getSelectedRow(), 5));
            p.setUnidade(new UnidadeDAO().getUnidade((String) tabela.getValueAt(tabela.getSelectedRow(), 6)));
            p.setTipo((String) tabela.getValueAt(tabela.getSelectedRow(), 7).toString());
            p.setEstoque((int) tabela.getValueAt(tabela.getSelectedRow(), 8));
            
            int temp = 0;
            if (tabela.getValueAt(tabela.getSelectedRow(), 8) != null) {
                temp = (int) tabela.getValueAt(tabela.getSelectedRow(), 8);
            }
            p.setEstoqueMin(temp);
            ProdutosCadastro produtoCadastro = new ProdutosCadastro(produtos, p);
            if (VerificaFrame.verificaFrame(produtos.getPainel(), produtoCadastro)) {
                VerificaFrame.exibirFrame(produtos.getPainel(), produtoCadastro);
                produtos.addChild(produtoCadastro);
            }
        } else if (action.equals(Vars.PROP_CLOSE)) {
            produtos.dispose();
        }
    }
}
