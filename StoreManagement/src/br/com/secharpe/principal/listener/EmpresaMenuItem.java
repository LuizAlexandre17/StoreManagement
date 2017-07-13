package br.com.secharpe.principal.listener;

import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Empresa;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Classe para action listener do item de menu Empresa
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class EmpresaMenuItem implements ActionListener {

    private final Empresa empresa;
    private final Painel painel;

    /**
     *
     * @param painel painel principal
     */
    public EmpresaMenuItem(Painel painel) {
        this.painel = painel;
        this.empresa = new Empresa(painel);
    }

    @Override
    /**
     *
     * @param e evento
     */
    public void actionPerformed(ActionEvent e) {
        if (VerificaFrame.verificaFrame(painel, empresa)) {
            VerificaFrame.exibirFrame(painel, empresa);
        }

    }
}
