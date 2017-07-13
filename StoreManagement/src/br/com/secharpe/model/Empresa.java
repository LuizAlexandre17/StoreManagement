package br.com.secharpe.model;

/* Classe de Empresa
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Empresa {

    private int codigo;
    private String nomeEmpresarial;
    private String nomeFantasia;
    private long CNPJ;
    private String logradouro;
    private String bairro;
    private Cidades cidade;
    private int numero;
    private String complemento;
    private String site;
    private String email;
    private long telefone;

    /**
     *
     * @return código
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @return nome empresarial
     */
    public String getNomeEmpresarial() {
        return nomeEmpresarial;
    }

    /**
     *
     * @return nome fantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     *
     * @return CNPJ
     */
    public long getCNPJ() {
        return CNPJ;
    }

    /**
     *
     * @return logradouro
     */
    public String getLogradouro() {
        return logradouro;
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
     * @return cidade
     */
    public Cidades getCidade() {
        return cidade;
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
     * @return site
     */
    public String getSite() {
        return site;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return telefone
     */
    public long getTelefone() {
        return telefone;
    }

    /**
     *
     * @param codigo código da empresa
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param nomeEmpresarial nome empresarial da empresa
     */
    public void setNomeEmpresarial(String nomeEmpresarial) {
        this.nomeEmpresarial = nomeEmpresarial;
    }

    /**
     *
     * @param nomeFantasia nome fantasia da empresa
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     *
     * @param CNPJ CNPJ da empresa
     */
    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    /**
     *
     * @param logradouro logradouro da empresa
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     *
     * @param bairro bairro da empresa
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     *
     * @param cidade cidade da empresa
     */

    public void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @param numero número da empresa
     */

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @param complemento complemento da empresa
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     *
     * @param site site da empresa
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     *
     * @param email e-mail da empresa
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param telefone telefone da empresa
     */

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    @Override
    /**
     * Converte objeto em String
     */
    public String toString() {
        return "Empresa:\n" + "Código: " + codigo + "\nNome Empresarial: " + nomeEmpresarial + "\nNomeFantasia: " + nomeFantasia + "\nCNPJ: " + CNPJ + "\nLogradouro: " + logradouro + "\nBairro: " + bairro + "\nCidade: " + cidade.getNome() + "\nNúmero: " + numero + "\nComplemento: " + complemento + "\nSite: " + site + "\nE-mail: " + email + "\nTelefone: " + telefone;
    }

}
