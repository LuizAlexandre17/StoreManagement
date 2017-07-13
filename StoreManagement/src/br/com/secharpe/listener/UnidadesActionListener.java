package br.com.secharpe.listener;

import br.com.secharpe.util.Vars;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener de Unidades
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class UnidadesActionListener implements ActionListener {

    private br.com.secharpe.view.UnidadesCadastro cadastro;
    private br.com.secharpe.view.Unidades view;

    public UnidadesActionListener(br.com.secharpe.view.UnidadesCadastro cadastro) {
        this.cadastro = cadastro;
    }

    public UnidadesActionListener(br.com.secharpe.view.Unidades view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        br.com.secharpe.model.Unidades unidade = new br.com.secharpe.model.Unidades();
        if (action.equals(Vars.PROP_SAVE)) {
            if ((!cadastro.getNome().equals("")) || (!cadastro.getSigla().equals(""))) {
                br.com.secharpe.dao.UnidadeDAO und = new br.com.secharpe.dao.UnidadeDAO();
                System.out.println(cadastro.getUnidade().toString());
                unidade = cadastro.getUnidade();
                und.insert(unidade);
                cadastro.getUnidadeView().refreshTable();
                System.out.println(cadastro.getUnidade().toString());
//                br.com.secharpe.view.Unidades cad = cadastro.getUnidadeView();
                cadastro.dispose();
//                cad.requestFocus();
            } else {
                System.out.println("Insira corretamente as informações!");
            }
        } else if (action.equals(Vars.PROP_CLOSE)) {
            cadastro.dispose();
        }
    }

}
