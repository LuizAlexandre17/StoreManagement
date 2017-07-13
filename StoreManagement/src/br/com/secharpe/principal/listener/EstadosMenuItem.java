package br.com.secharpe.principal.listener;

import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Estados;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener do item de menu Estado
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class EstadosMenuItem implements ActionListener {

    private final Estados estados;
    private final Painel painel;

    /**
     *
     * @param painel painel principal
     */
    public EstadosMenuItem(Painel painel) {
        this.painel = painel;
        this.estados = new Estados(painel);
    }

    @Override
    /**
     *
     * @param e evento
     */
    public void actionPerformed(ActionEvent e) {
        if (VerificaFrame.verificaFrame(painel, estados)) {
            VerificaFrame.exibirFrame(painel, estados);
        }

    }
}
