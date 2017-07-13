package br.com.secharpe.util;

import br.com.secharpe.view.Painel;
import javax.swing.JInternalFrame;

/**
 * Esta é uma classe que irá verificar se existe frame no Desktop
 *
 * @author (dsfextreme@pop.com.br)
 */
public abstract class VerificaFrame {

    public static void exibirFrame(Painel painel, JInternalFrame frame) {
        painel.getDesktopPane().add(frame);
        frame.setVisible(true);
        frame.toFront();
        centralizar(painel, frame);

    }

    /**
     * Creates a new instance of VerificaFrame
     *
     * @param painel Painel - main desktop
     * @param frame JInternalFrame - frame
     */
    public static boolean verificaFrame(Painel painel, JInternalFrame frame) {
        for (java.awt.Component c : painel.getDesktopPane().getAllFrames()) {
            JInternalFrame fr = (JInternalFrame) c;
            if (fr.getTitle().equals(frame.getTitle())) {
                return false;
            }
        }
        return true;
    }

    public static void centralizar(Painel painel, JInternalFrame frame) {
        frame.setLocation((painel.getWidth() - frame.getWidth()) / 2, (painel.getHeight() - frame.getHeight()) / 2);
    }
}
