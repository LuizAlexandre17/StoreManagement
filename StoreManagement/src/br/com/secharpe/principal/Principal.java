package br.com.secharpe.principal;


/* Classe Principal
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Principal {

    /**
     * Função principal
     *
     * @param args argumentos
     */
    public static void main(String[] args) {
        new br.com.secharpe.util.Log().put("Principal", "main", "Iniciando programa");
        br.com.secharpe.view.Login login = new br.com.secharpe.view.Login();
        login.setVisible(true);
    }

}
