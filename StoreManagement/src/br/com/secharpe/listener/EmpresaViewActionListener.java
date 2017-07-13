package br.com.secharpe.listener;

import br.com.secharpe.util.Vars;
import br.com.secharpe.view.Empresa;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener da Empresa
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */

public class EmpresaViewActionListener implements ActionListener {

    private Painel painel;
    private Empresa empresa;

    public EmpresaViewActionListener(Painel painel) {
        this.painel = painel;
        empresa = new Empresa(painel);
    }

    public EmpresaViewActionListener(Empresa empresa) {
        this.empresa = empresa;
        this.painel = empresa.getPainel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(Vars.PROP_SAVECOMPANY)) {
            empresa.editarCampo(false);
            System.out.println(empresa.getEmpresa().toString());
        } else if (action.equals(Vars.PROP_EDIT)) {
            empresa.editarCampo(true);
        } else if (action.equals(Vars.PROP_ERASE)) {
            empresa.clean();
        } else if (action.equals(Vars.PROP_CLOSE)) {
            empresa.dispose();
        }
    }

}
