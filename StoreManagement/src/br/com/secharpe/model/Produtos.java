package br.com.secharpe.model;

/* Classe de Produtos
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Produtos {

    private int codigo;
    private String nome;
    private String descricao;
    private int estoque;
    private int estoqueMin;
    private float custo;
    private float valorVenda;
    private String tipo;
    private String fabricante;
    private Unidades unidade;

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
     * @return estoque mínimo
     */
    public int getEstoqueMin() {
        return estoqueMin;
    }


    /**
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @return fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     *
     * @return descrição
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @return quantidade em estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     *
     * @return valor de custo
     */
    public float getCusto() {
        return custo;
    }

    /**
     *
     * @return valor de venda
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     *
     * @return unidade de medida
     */
    public Unidades getUnidade() {
        return unidade;
    }

    /**
     *
     * @param codigo codigo do produto
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param nome nome do produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param descricao descrição do produto
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @param estoque quantidade em estoque do produto
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    /**
     *
     * @param estoqueMin estoque mínimo do produto
     */
    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    /**
     *
     * @param custo custo do produto
     */
    public void setCusto(float custo) {
        this.custo = custo;
    }

    /**
     *
     * @param valorVenda valor de venda do produto
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     *
     * @param tipo tipo do produto
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @param fabricante fabricante do produto
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     *
     * @param unidade unidade de medida
     */
    public void setUnidade(Unidades unidade) {
        this.unidade = unidade;
    }

    @Override
    /**
     * Converte objeto em String
     */
    public String toString() {
        return "Produtos:\n" + "Codigo: " + codigo + ", Nome=" + nome + ", Descri\u00e7\u00e3o=" + descricao + ", EstoqueAtual=" + estoque + ", EstoqueMin=" + estoqueMin + ", Pre\u00e7oCusto=" + custo + ", Pre\u00e7oFinal=" + valorVenda + ", Tipo=" + tipo + ", Fabricante=" + fabricante + ", Unidade=" + unidade + '}';
    }

    public void refreshTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
