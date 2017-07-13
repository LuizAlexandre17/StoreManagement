package br.com.secharpe.listener;

import br.com.secharpe.util.Vars;
import br.com.secharpe.view.Cidades;
import br.com.secharpe.view.CidadesCadastro;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/* Classe para action listener de Cidades 
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class CidadesViewActionListener implements ActionListener {

    private Painel painel;
    private Cidades cidades;

    public CidadesViewActionListener(Painel painel) {
        this.painel = painel;
        cidades = new Cidades(painel);
    }

    public CidadesViewActionListener(Cidades cidades) {
        this.cidades = cidades;
        this.painel = cidades.getPainel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(Vars.PROP_NEW)) {
            CidadesCadastro cidadeCadastro = new CidadesCadastro(cidades);
            cidades.getPainel().getDesktopPane().add(cidadeCadastro);
            cidadeCadastro.setVisible(true);
            cidadeCadastro.toFront();
            cidadeCadastro.setLocation((cidades.getPainel().getWidth() - cidadeCadastro.getWidth()) / 2, (cidades.getPainel().getHeight() - cidadeCadastro.getHeight()) / 2);
            cidades.addChild(cidadeCadastro);

        } else if (action.equals(Vars.PROP_REMOVE)) {
            JTable tabela = cidades.getTable();
            int nome = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
            br.com.secharpe.dao.CidadeDAO cidDAO = new br.com.secharpe.dao.CidadeDAO();
            cidDAO.delete(nome);
            cidades.refreshTable();
        } else if (action.equals(Vars.PROP_CLOSE)) {
            cidades.dispose();
        }
    }

}
