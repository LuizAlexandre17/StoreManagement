package br.com.secharpe.listener;

import br.com.secharpe.dao.ClienteDAO;
import br.com.secharpe.exception.SistemaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.secharpe.model.Clientes;
import br.com.secharpe.util.MessageCtrl;
import br.com.secharpe.util.Vars;
import br.com.secharpe.view.ClientesCadastro;

/* Classe para action listener de Cidades Cadastro
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class ClienteCadastroViewActionListener implements ActionListener {

    private ClientesCadastro cad;

    public ClienteCadastroViewActionListener(ClientesCadastro c) {
        this.cad = c;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals(Vars.PROP_REMOVE)) {
            Clientes cr = new Clientes();
            try {
                ClienteDAO clientedao = new ClienteDAO();
                cr = cad.getCliente();
                clientedao.delete(cr.getCodigo()); 
            } catch (SistemaException ex) {
                MessageCtrl.callMessage(ex.getMessage(), Vars.TITLE_MESSAGE_DEFAULT, 8);
            }
        } else if (action.equals(Vars.PROP_NEW)) {
            

        } else if (action.equals(Vars.PROP_SAVE)) {
            Clientes cr = new Clientes();
            try {
                ClienteDAO clientedao = new ClienteDAO();
                cr = cad.getCliente();
                if (cr != null) {
                    System.out.println(cr.toString());
                    clientedao.insert(cr);
                    cad.getClienteView().refreshTable();
                }

            } catch (SistemaException ex) {
                MessageCtrl.callMessage(ex.getMessage(), Vars.TITLE_MESSAGE_DEFAULT, 8);
            }
        } else if (action.equals(Vars.PROP_CLOSE)) {
            cad.dispose();
        }

    }

}
