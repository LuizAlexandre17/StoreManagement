package br.com.secharpe.listener;

import br.com.secharpe.util.Vars;
import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Estados;
import br.com.secharpe.view.EstadosCadastro;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
/* Classe para action listener de Estados
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class EstadosViewActionListener implements ActionListener {

    private Painel painel;
    private Estados estados;

    public EstadosViewActionListener(Painel painel) {
        this.painel = painel;
        estados = new Estados(painel);
    }

    public EstadosViewActionListener(Estados estados) {
        this.estados = estados;
        this.painel = estados.getPainel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(Vars.PROP_NEW)) {
            EstadosCadastro estadosCadastro = new EstadosCadastro(estados);
            if (VerificaFrame.verificaFrame(estados.getPainel(), estadosCadastro)) {
                VerificaFrame.exibirFrame(estados.getPainel(), estadosCadastro);
                estados.addChild(estadosCadastro);
            }
        } else if (action.equals(Vars.PROP_REMOVE)) {
            JTable tabela = estados.getTable();
            String sigla = tabela.getValueAt(tabela.getSelectedRow(), 1).toString();
            br.com.secharpe.dao.EstadoDAO estDAO = new br.com.secharpe.dao.EstadoDAO();
            estDAO.delete(sigla);
            estados.refreshTable();
        } else if (action.equals(Vars.PROP_CLOSE)) {
            estados.dispose();
        }
    }

}
