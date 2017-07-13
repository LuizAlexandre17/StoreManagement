package br.com.secharpe.listener;

import br.com.secharpe.dao.ProdutoDAO;
import br.com.secharpe.exception.SistemaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.secharpe.model.Produtos;
import br.com.secharpe.util.MessageCtrl;
import br.com.secharpe.util.Vars;
import br.com.secharpe.view.ProdutosCadastro;

/* Classe para action listener de Produtos
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class ProdutoCadastroViewActionListener implements ActionListener {

    private ProdutosCadastro cad;

    public ProdutoCadastroViewActionListener(ProdutosCadastro p) {
        this.cad = p;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals(Vars.PROP_ERASE)) {
            Produtos cr = new Produtos();
            try {
                cr = cad.getProduto();
                ProdutoDAO proddao = new ProdutoDAO();
                proddao.delete(cr.getCodigo());
            } catch (SistemaException ex) {
                MessageCtrl.callMessage(ex.getMessage(), Vars.TITLE_MESSAGE_DEFAULT, 8);
            }
        }
        if (action.equals(Vars.PROP_SAVE)) {
            Produtos cr = new Produtos();
            try {
                cr = cad.getProduto();
                ProdutoDAO proddao = new ProdutoDAO();
                if (cr != null) {
                    System.out.println(cr.toString());
                    proddao.insert(cr);
                    cad.getProdutoView().refreshTable();
                }

            } catch (SistemaException ex) {
                MessageCtrl.callMessage(ex.getMessage(), Vars.TITLE_MESSAGE_DEFAULT, 8);
            }

        } else if (action.equals(Vars.PROP_CLOSE)) {
            cad.dispose();
        } else {
            ProdutoDAO proddao = new ProdutoDAO();
            try {
                proddao.update(cad.getProduto());
            } catch (NullPointerException ex) {
                MessageCtrl.callMessage("Ooops!", "Contate o admin", 2);
            } catch (SistemaException ex) {
                MessageCtrl.callMessage("Ooops!", "Contate o admin", 2);
            }
        }

    }

}
