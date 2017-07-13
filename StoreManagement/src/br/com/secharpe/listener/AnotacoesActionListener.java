package br.com.secharpe.listener;

import br.com.secharpe.dao.AnotacoesDAO;
import br.com.secharpe.util.MessageCtrl;
import br.com.secharpe.util.Vars;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.secharpe.view.AnotacoesCadastro;
import br.com.secharpe.view.Anotacoes;

/* Classe para action listener de  Anotações
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class AnotacoesActionListener implements ActionListener {

    private AnotacoesCadastro cadastro;
    private Anotacoes view;

    public AnotacoesActionListener(AnotacoesCadastro cadastro) {
        this.cadastro = cadastro;
    }

    public AnotacoesActionListener(Anotacoes view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(Vars.PROP_SAVE)) {
            if (!(cadastro.getAnotacoes().getTitulo().trim().equals("") && cadastro.getAnotacoes().getDescricao().trim().equals("") && cadastro.getAnotacoes().getAnotacao().trim().equals(""))) {
                AnotacoesDAO ano = new AnotacoesDAO();
                ano.insert(cadastro.getAnotacoes());
                cadastro.getCadastroView().refreshTable();
                cadastro.dispose();
            } else {
                MessageCtrl.callMessage("Oops!", "Insira corretamente as informações", 2);
            }
        } else if (action.equals(Vars.PROP_CLOSE)) {
            cadastro.dispose();
        }
        //view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        //  public void valueChanged(ListSelectionEvent event) {
        //    JOptionPane.showMessageDialog(null, view.getTable().getSelectedRow());
        //}
        //});
    }

}
