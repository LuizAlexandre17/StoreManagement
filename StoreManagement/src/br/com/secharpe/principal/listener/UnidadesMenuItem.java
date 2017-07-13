package br.com.secharpe.principal.listener;

import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Painel;
import br.com.secharpe.view.Unidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener do item de menu Unidades
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class UnidadesMenuItem implements ActionListener {

    private final Unidades unidades;
    private final Painel painel;

    /**
     *
     * @param painel painel principal
     */
    public UnidadesMenuItem(Painel painel) {
        this.painel = painel;
        this.unidades = new Unidades(painel);
    }

    @Override
    /**
     *
     * @param e evento
     */
    public void actionPerformed(ActionEvent e) {
        if (VerificaFrame.verificaFrame(painel, unidades)) {
            VerificaFrame.exibirFrame(painel, unidades);
        }

    }
}
