package br.com.secharpe.model;

/* Classe de Cidades
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Cidades {

    private int codigo;
    private String nome;
    private Estados estado;

    /**
     *
     * @return código
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @return estado
     */
    public Estados getEstado() {
        return estado;
    }

    /**
     *
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     *
     * @param codigo código da cidade
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param nome nome da cidade
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param estado estado que a cidade pertence
     */
    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    @Override
    /**
     * Converte objeto em String
     */
    public String toString() {
        return "Cidades:\n" + "Código: " + codigo + "\nNome: " + nome + "\nEstado: " + estado.getNome();
    }

}
