package br.com.secharpe.listener;

import br.com.secharpe.util.Vars;
import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Clientes;
import br.com.secharpe.view.ClientesCadastro;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/* Classe para action listener de Cidades Cadastro
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */

public class ClienteViewActionListener implements ActionListener {

    private Painel painel;
    private Clientes clientes;

    public ClienteViewActionListener(Clientes cliente) {
        this.clientes = cliente;
        this.painel = clientes.getPainel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(Vars.PROP_NEW)) {
            ClientesCadastro clienteCadastro = new ClientesCadastro();
            if (VerificaFrame.verificaFrame(clientes.getPainel(), clienteCadastro)) {
                VerificaFrame.exibirFrame(clientes.getPainel(), clienteCadastro);
                clientes.addChild(clienteCadastro);
            }
        } else if (action.equals(Vars.PROP_REMOVE)) {
             JTable tabela = clientes.getTable();
           int cod = (int) tabela.getValueAt(tabela.getSelectedRow(), 1);
            br.com.secharpe.dao.ClienteDAO clDAO = new br.com.secharpe.dao.ClienteDAO();
            clDAO.delete(cod);
            clientes.refreshTable();
        } else if (action.equals(Vars.PROP_EDIT)) {
            JOptionPane.showMessageDialog(null, "W.I.P.");
        } else if (action.equals(Vars.PROP_CLOSE)) {
            clientes.dispose();
        }
    }

}
