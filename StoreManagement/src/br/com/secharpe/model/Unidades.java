package br.com.secharpe.model;

/* Classe de Unidades
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Unidades {

    private int codigo;
    private String nome;
    private String sigla;

    /**
     *
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     *
     * @param codigo codigo da unidade
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * param nome nome da unidade
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param sigla sigla da unidade
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    /**
     * Converte objeto em String
     */
    public String toString() {
        return "Unidades:\n" + "Código: " + codigo + "\nNome: " + nome + "\nSigla: " + sigla;
    }

}
