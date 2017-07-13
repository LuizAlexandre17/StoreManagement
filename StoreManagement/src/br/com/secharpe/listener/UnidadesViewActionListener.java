package br.com.secharpe.listener;

import br.com.secharpe.util.Vars;
import br.com.secharpe.view.Painel;
import br.com.secharpe.view.Unidades;
import br.com.secharpe.view.UnidadesCadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/* Classe para action listener de Unidades
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class UnidadesViewActionListener implements ActionListener {

    private Painel painel;
    private Unidades unidades;

    public UnidadesViewActionListener(Unidades unidades) {
        this.unidades = unidades;
        this.painel = unidades.getPainel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(Vars.PROP_NEW)) {
            UnidadesCadastro unidadesCadastro = new UnidadesCadastro(unidades);
            unidades.getPainel().getDesktopPane().add(unidadesCadastro);
            unidadesCadastro.setVisible(true);
            unidadesCadastro.toFront();
            unidadesCadastro.setLocation((unidades.getPainel().getWidth() - unidadesCadastro.getWidth()) / 2, (unidades.getPainel().getHeight() - unidadesCadastro.getHeight()) / 2);
            unidades.childAdd(unidadesCadastro);
        } else if (action.equals(Vars.PROP_REMOVE)) {
            JTable tabela = unidades.getTable();
            int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
            br.com.secharpe.dao.UnidadeDAO cidDAO = new br.com.secharpe.dao.UnidadeDAO();
            cidDAO.delete(id);
            unidades.refreshTable();
        } else if (action.equals(Vars.PROP_EDIT)) {
            JOptionPane.showMessageDialog(null, "W.I.P.");
        } else if (action.equals(Vars.PROP_CLOSE)) {
            unidades.dispose();
        }
    }

}
