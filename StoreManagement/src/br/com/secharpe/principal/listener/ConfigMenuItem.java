package br.com.secharpe.principal.listener;

import br.com.secharpe.view.Config;
import br.com.secharpe.view.Sobre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener do item de menu Sobre
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class ConfigMenuItem implements ActionListener {

    private Sobre sobre;

    @Override
    /**
     *
     * @param e evento
     */
    public void actionPerformed(ActionEvent e) {
        Config c = new Config();
        c.setVisible(true);
    }
}
