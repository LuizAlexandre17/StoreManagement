package br.com.secharpe.listener;

import br.com.secharpe.dao.AnotacoesDAO;
import br.com.secharpe.util.Vars;
import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Anotacoes;
import br.com.secharpe.view.AnotacoesCadastro;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/* Classe para action listener de Anotações
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class AnotacoesViewActionListener implements ActionListener {

    private Painel painel;
    private Anotacoes anotacoes;

    public AnotacoesViewActionListener(Painel painel) {
        this.painel = painel;
        anotacoes = new Anotacoes(painel);
    }

    public AnotacoesViewActionListener(Anotacoes anotacoes) {
        this.anotacoes = anotacoes;
        this.painel = anotacoes.getPainel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(Vars.PROP_NEW)) {
            AnotacoesCadastro anotacoesCadastro = new AnotacoesCadastro(anotacoes);
            if (VerificaFrame.verificaFrame(anotacoes.getPainel(), anotacoesCadastro)) {
                VerificaFrame.exibirFrame(anotacoes.getPainel(), anotacoesCadastro);
            }
        } else if (action.equals(Vars.PROP_VIEW)) {
            AnotacoesDAO ano = new AnotacoesDAO();
            br.com.secharpe.model.Anotacoes an = ano.getAnotacao((int) anotacoes.getTable().getValueAt(anotacoes.getTable().getSelectedRow(), 0));
            javax.swing.JOptionPane.showMessageDialog(null, "Título" + an.getTitulo() + "\nDescrição: " + an.getDescricao() + "\nAnotação: " + an.getAnotacao() + "\nCriado em: " + an.getDataRegistro());
        } else if (action.equals(Vars.PROP_REMOVE)) {
            AnotacoesDAO ano = new AnotacoesDAO();
            ano.delete((int) anotacoes.getTable().getValueAt(anotacoes.getTable().getSelectedRow(), 0));
            anotacoes.refreshTable();
        } else if (action.equals(Vars.PROP_CLOSE)) {
            anotacoes.dispose();
        }
    }

}
