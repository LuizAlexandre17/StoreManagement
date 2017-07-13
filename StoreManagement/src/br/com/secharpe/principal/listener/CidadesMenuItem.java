package br.com.secharpe.principal.listener;

import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Cidades;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener do item de menu Cidades
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class CidadesMenuItem implements ActionListener {

    private final Cidades cidades;
    private final Painel painel;

    /**
     *
     * @param painel painel principal
     */
    public CidadesMenuItem(Painel painel) {
        this.painel = painel;
        this.cidades = new Cidades(painel);
    }

    @Override
    /**
     *
     * @param e evento
     */
    public void actionPerformed(ActionEvent e) {
        if (VerificaFrame.verificaFrame(painel, cidades)) {
            VerificaFrame.exibirFrame(painel, cidades);
        }

    }
}
