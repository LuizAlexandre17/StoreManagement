package br.com.secharpe.model;

import java.sql.Date;

/* Classe de Anotações
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Anotacoes {

    private int codigo;
    private String titulo;
    private String descricao;
    private String anotacao;
    private Date dataRegistro;

    /**
     *
     * @return código
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @return título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }
/**
 * 
 * @return anotação
 */
    public String getAnotacao() {
        return anotacao;
    }
/**
 * 
 * @param codigo código da anotação
 */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
/**
 * 
 * @param titulo título da anotação
 */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
/**
 * 
 * @param descricao texto da descrição
 */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/**
 * 
 * @param anotacao texto da anotação
 */
    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }
/**
 * 
 * @return data de registro
 */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     *
     * @param dataRegistro
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
    /**
     * Converte objeto em String
     */
    public String toString() {
        return "Anotacoes:\n" + "Código: " + codigo + "\nNome: " + titulo + "\nDescricao: " + descricao + "\nAnotacao: " + anotacao;
    }
}
