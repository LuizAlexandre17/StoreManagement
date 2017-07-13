package br.com.secharpe.listener;

import br.com.secharpe.util.Log;
import br.com.secharpe.view.Painel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Classe para action listener de Login
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class LoginActionListener implements ActionListener {

    br.com.secharpe.util.Util log = new br.com.secharpe.util.Util();

    private final br.com.secharpe.view.Login login;

    File file = new File("user.last");

    public LoginActionListener(br.com.secharpe.view.Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Entrar":
                if (login.getLogin().Login()) {
                    if (!login.getLogin().getUsuario().equals(log.lerArquivo())) {
                        try {
                            log.escrever(login.getLogin().getUsuario());
                        } catch (IOException ex) {
                            Logger.getLogger(LoginActionListener.class.getName()).log(Level.SEVERE, null, ex);
                            Log log = new Log();
                            StringWriter sw = new StringWriter();
                            ex.printStackTrace(new PrintWriter(sw));
                            String exceptionAsString = sw.toString();
                            System.out.println();
                            log.put("ERRO", exceptionAsString);
                            log.put("LoginActionListener", "Entrar", exceptionAsString);
                        }
                    }

                    login.dispose();
                    /* Set the Nimbus look and feel */
                    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
                     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                     */
                    try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                            if ("Nimbus".equals(info.getName())) {
                                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                break;
                            }
                        }
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    //</editor-fold>

                    /* Create and display the form */
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new Painel().setVisible(true);
                        }
                    });
                } else {

                }
                break;
            case "Sair":
                //logout (change user status to offline in db) and exit
                System.exit(0);
                break;
        }
    }
}
