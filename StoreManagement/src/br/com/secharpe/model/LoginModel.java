package br.com.secharpe.model;

/* Classe de Login
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class LoginModel {

    private String usuario;
    private String senha;

    /**
     *
     * @param usuario usuário para login
     * @param senha senha para login
     */
    public LoginModel(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     *
     * @return comparação da senha informada com a do usuário
     */
    public boolean Login() {
        return (senha.equals("senha"));
    }

    /**
     *
     * @return usuário
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario nome de usuário
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha senha do usuário
     */

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
