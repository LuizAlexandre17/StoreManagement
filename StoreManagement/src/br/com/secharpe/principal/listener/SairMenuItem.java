package br.com.secharpe.principal.listener;

import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener do item de menu Sair
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class SairMenuItem implements ActionListener {

    private final Painel painel;

    /**
     *
     * @param painel painel principal
     */
    public SairMenuItem(Painel painel) {
        this.painel = painel;
    }

    @Override
    /**
     *
     * @param e evento
     */
    public void actionPerformed(ActionEvent e) {
        //call splash and do user logout
        painel.dispose();
        System.exit(0);
    }
}
