package br.com.secharpe.principal.listener;

import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Clientes;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener do item de menu Clientes
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class ClientesMenuItem implements ActionListener {

    private final Clientes clientes;
    private final Painel painel;

    /**
     *
     * @param painel painel principal
     */
    public ClientesMenuItem(Painel painel) {
        this.painel = painel;
        this.clientes = new Clientes(painel);
    }

    @Override
    /**
     *
     * @param e evento
     */
    public void actionPerformed(ActionEvent e) {
        if (VerificaFrame.verificaFrame(painel, clientes)) {
            VerificaFrame.exibirFrame(painel, clientes);
        }

    }
}
