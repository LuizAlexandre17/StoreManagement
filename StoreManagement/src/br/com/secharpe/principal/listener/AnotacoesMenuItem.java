package br.com.secharpe.principal.listener;

import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Anotacoes;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener do item de menu Anotações
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class AnotacoesMenuItem implements ActionListener {

    private final Anotacoes anotacoes;
    private final Painel painel;

    /**
     *
     * @param painel painel principal
     */
    public AnotacoesMenuItem(Painel painel) {
        this.painel = painel;
        this.anotacoes = new Anotacoes(painel);
    }

    @Override
    /**
     *
     * @param e evento
     */
    public void actionPerformed(ActionEvent e) {
        if (VerificaFrame.verificaFrame(painel, anotacoes)) {
            VerificaFrame.exibirFrame(painel, anotacoes);
        }

    }
}
