/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.secharpe.principal.listener;

/* Classe para action listener do item de menu Produto
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
import br.com.secharpe.util.VerificaFrame;
import br.com.secharpe.view.Produtos;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutosMenuItem implements ActionListener {

    private final Produtos produto;
    private final Painel painel;

    /**
     *
     * @param painel painel principal
     */
    public ProdutosMenuItem(Painel painel) {
        this.painel = painel;
        this.produto = new Produtos(painel);
    }

    @Override
    /**
     *
     * @param e evento
     */
    public void actionPerformed(ActionEvent ae) {
        if (VerificaFrame.verificaFrame(painel, produto)) {
            VerificaFrame.exibirFrame(painel, produto);
        }
    }

}
