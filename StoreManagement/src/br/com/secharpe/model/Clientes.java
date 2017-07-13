package br.com.secharpe.model;

/* Classe de Clientes
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Clientes {

    private int codigo;
    private String nome;
    private String email;
    private int CPF;
    private int RG;
    private int telefone;
    private int celular;
    private Estados estado;
    private Cidades cidade;
    private String bairro;
    private String endereco;
    private int numero;
    private String complemento;

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
     * @return e-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return CPF
     */
    public int getCPF() {
        return CPF;
    }

    /**
     *
     * @return RG
     */
    public int getRG() {
        return RG;
    }

    /**
     *
     * @return telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     *
     * @return celular
     */
    public int getCelular() {
        return celular;
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
     * @return cidade
     */
    public Cidades getCidade() {
        return cidade;
    }

    /**
     *
     * @return bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     *
     * @return endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     *
     * @return número
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @return complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     *
     * @param codigo código do cliente
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param nome nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param email email do cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param cpf CPF do cliente
     */
    public void setCPF(int cpf) {
        this.CPF = cpf;
    }

    /**
     *
     * @param rg RG do cliente
     */
    public void setRG(int rg) {
        this.RG = rg;
    }

    /**
     *
     * @param telefone telefone do cliente
     */
    public void setTelefone(int telefone) {
        try {
            this.telefone = telefone;
        } catch (NumberFormatException nfe) {
            System.out.println("ERRO");
            nfe.getMessage();
        }
    }

    /**
     *
     * @param celular celular do cliente
     */
    public void setCelular(int celular) {
        this.celular = celular;
    }

    /**
     *
     * @param estado estado de residencia do cliente
     */
    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    /**
     *
     * @param cidade cidade de residencia do cliente
     */
    public void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @param bairro bairro de residência do cliente
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     *
     * @param endereco endereço do cliente
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @param numero número da residência do cliente
     */

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @param complemento complemento da residência do cliente
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    /**
     * Converte objeto em String
     */
    public String toString() {
        return "Clientes:\n" + "Codigo Interno:" + codigo + "\nNome: " + nome + "\nEmail: " + email + "\nCPF: " + CPF + "\nRG: " + RG + "\nTelefone: " + telefone + "\nCelular: " + celular + "\nEstado: " + estado.getNome() + "\nCidade:" + cidade.getNome() + "\nBairro: " + bairro + "\nEndereço: " + endereco + "\nNumero: " + numero + "\nComplemento: " + complemento;
    }

}
