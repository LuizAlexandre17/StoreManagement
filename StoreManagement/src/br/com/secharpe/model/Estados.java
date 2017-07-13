package br.com.secharpe.model;

/* Classe de Estados
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Estados {

    private int codigo;
    private String nome;
    private String sigla;

    /**
     *
     * @return código
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
     * @param codigo código do estado
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param nome nome do estado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param sigla sigla do estado
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    /**
     * Converte objeto em String
     */
    public String toString() {
        return "Estados:\n" + "Código: " + codigo + "\nNome: " + nome + "\nSigla: " + sigla;
    }

}
