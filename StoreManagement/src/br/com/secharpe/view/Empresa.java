package br.com.secharpe.view;

import br.com.secharpe.exception.SistemaException;
import br.com.secharpe.listener.EmpresaViewActionListener;
import br.com.secharpe.util.Log;

/**
 * Editar dados da empresa
 *
 * @author luandr<stringigualanull@outlook.com>
 */
public class Empresa extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    private final EmpresaViewActionListener handlerEmpresa = new EmpresaViewActionListener(this);
    private Painel painel;
    private final Log log = new Log();

    /**
     * Creates new form Empresa
     *
     * @param painel Painel
     */
    public Empresa(Painel painel) {
        new br.com.secharpe.util.Log().put("Empresa", "Abrindo janela");
        this.painel = painel;
        initComponents();
        btEditar.addActionListener(handlerEmpresa);
        btLimpar.addActionListener(handlerEmpresa);
        btSair.addActionListener(handlerEmpresa);
        btSalvar.addActionListener(handlerEmpresa);
        br.com.secharpe.model.Empresa emp = new br.com.secharpe.model.Empresa();
        br.com.secharpe.dao.EmpresaDAO empresaDAO = new br.com.secharpe.dao.EmpresaDAO();
        try {
            emp = empresaDAO.getAll();
        } catch (SistemaException e) {
            e.printStackTrace();
            new br.com.secharpe.util.Log().put("Empresa", e.getMessage());
        }
        tfBairro.setText(emp.getBairro());
        tfComplemento.setText(emp.getComplemento());
        tfEmail.setText(emp.getEmail());
        tfEmpresarial.setText(emp.getNomeEmpresarial());
        tfFantasia.setText(emp.getNomeFantasia());
        tfLogradouro.setText(emp.getLogradouro());
        tfSite.setText(emp.getSite());
        ftTelefone.setText("" + emp.getTelefone());
        ftCNPJ.setText("" + emp.getCNPJ());
        ftNumero.setText("" + emp.getNumero());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ftCNPJ = new javax.swing.JFormattedTextField();
        tfEmpresarial = new javax.swing.JTextField();
        tfFantasia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfLogradouro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        tfComplemento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ftNumero = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfSite = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        ftTelefone = new javax.swing.JFormattedTextField();
        btSalvar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Empresa");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Jurídicos"));

        jLabel1.setText("Nome Empresarial");

        jLabel2.setText("Nome Fantasia");

        jLabel3.setText("CNPJ");

        ftCNPJ.setFormatterFactory(getFormatoCnpj());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ftCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfEmpresarial)
                    .addComponent(tfFantasia, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfEmpresarial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ftCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel4.setText("Logradouro");

        jLabel5.setText("Estado");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Bairro");

        jLabel7.setText("Cidade");

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Número");

        jLabel9.setText("Complemento");

        ftNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ftNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCidade, 0, 209, Short.MAX_VALUE)
                    .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

        jLabel10.setText("Telefone");

        jLabel11.setText("Site");

        jLabel12.setText("E-mail");

        ftTelefone.setFormatterFactory(getFormatoTelefone());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tfEmail)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(ftTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfSite))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(ftTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btSalvar.setText(br.com.secharpe.util.Propriedades.getProp("form.savecompany"));

        btEditar.setText(br.com.secharpe.util.Propriedades.getProp("form.edit"));

        btLimpar.setText(br.com.secharpe.util.Propriedades.getProp("form.erase"));

        btSair.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar)
                .addGap(18, 18, 18)
                .addComponent(btEditar)
                .addGap(18, 18, 18)
                .addComponent(btLimpar)
                .addGap(18, 18, 18)
                .addComponent(btSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btEditar)
                    .addComponent(btLimpar)
                    .addComponent(btSair))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JFormattedTextField ftCNPJ;
    private javax.swing.JFormattedTextField ftNumero;
    private javax.swing.JFormattedTextField ftTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEmpresarial;
    private javax.swing.JTextField tfFantasia;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JTextField tfSite;
    // End of variables declaration//GEN-END:variables

    /**
     * @return Retorna default format factory do CNPJ
     */
    private javax.swing.text.DefaultFormatterFactory getFormatoCnpj() {
        javax.swing.text.MaskFormatter jTregistro = null;
        try {
            jTregistro = new javax.swing.text.MaskFormatter("##.###.###/####-##");
            jTregistro.setPlaceholderCharacter('_');
            jTregistro.setOverwriteMode(true);
            jTregistro.setValidCharacters("0123456789");
        } catch (Exception pe) {
            System.out.println(pe.getMessage());
        }
        javax.swing.text.DefaultFormatterFactory factory = new javax.swing.text.DefaultFormatterFactory(jTregistro, jTregistro);
        return factory;
    }

    /**
     * @return Retorna default format factory do telefone
     */
    private javax.swing.text.DefaultFormatterFactory getFormatoTelefone() {
        javax.swing.text.MaskFormatter jTregistro = null;
        try {
            jTregistro = new javax.swing.text.MaskFormatter("+55 (##) ####-####");
            jTregistro.setPlaceholderCharacter('_');
            jTregistro.setOverwriteMode(true);
            jTregistro.setValidCharacters("0123456789");
        } catch (Exception pe) {
            System.out.println(pe.getMessage());
        }
        javax.swing.text.DefaultFormatterFactory factory = new javax.swing.text.DefaultFormatterFactory(jTregistro, jTregistro);
        return factory;
    }

    /**
     * @return Retorna painel
     */
    public Painel getPainel() {
        return this.painel;
    }

    /**
     *
     * @param block flag para setar os campos habilitados
     */
    public void editarCampo(boolean block) {
        tfBairro.setEnabled(block);
        tfEmail.setEnabled(block);
        tfEmpresarial.setEnabled(block);
        tfFantasia.setEnabled(block);
        tfLogradouro.setEnabled(block);
        tfSite.setEnabled(block);
        tfComplemento.setEnabled(block);
        cbCidade.setEnabled(block);
        cbEstado.setEnabled(block);
        ftCNPJ.setEnabled(block);
        ftTelefone.setEnabled(block);
        ftNumero.setEnabled(block);
    }

    /**
     * Limpar os campos
     */
    public void clean() {
        tfBairro.setText("");
        tfEmail.setText("");
        tfEmpresarial.setText("");
        tfFantasia.setText("");
        tfLogradouro.setText("");
        tfSite.setText("");
        tfComplemento.setText("");
        cbCidade.setSelectedIndex(0);
        cbEstado.setSelectedIndex(0);
        ftCNPJ.setText("");
        ftTelefone.setText("");
        ftNumero.setText("");
    }

    /**
     * @return Retorna empresa
     */
    public br.com.secharpe.model.Empresa getEmpresa() {
        String cnpj = ftCNPJ.getText();
        cnpj = cnpj.charAt(0) + cnpj.charAt(1) + cnpj.charAt(3) + cnpj.charAt(4) + cnpj.charAt(5) + cnpj.charAt(7) + cnpj.charAt(8) + cnpj.charAt(9) + cnpj.charAt(11) + cnpj.charAt(12) + cnpj.charAt(13) + cnpj.charAt(14) + cnpj.charAt(16) + cnpj.charAt(17) + "";
        String telefone = ftTelefone.getText();
        telefone = "" + telefone.charAt(1) + telefone.charAt(2) + telefone.charAt(5) + telefone.charAt(6) + telefone.charAt(9) + telefone.charAt(10) + telefone.charAt(11) + telefone.charAt(12) + telefone.charAt(14) + telefone.charAt(15) + telefone.charAt(16) + telefone.charAt(17);
        br.com.secharpe.model.Empresa empresa = new br.com.secharpe.model.Empresa();
        empresa.setBairro(tfBairro.getText());
        empresa.setCNPJ(Integer.parseInt(cnpj));
        br.com.secharpe.model.Cidades cidade = new br.com.secharpe.model.Cidades(); //implementar futuramente com o banco de dados
        br.com.secharpe.model.Estados estado = new br.com.secharpe.model.Estados(); //implementar futuramente com o banco de dados
        estado.setCodigo(cbEstado.getSelectedIndex());//implementar com o banco
        estado.setNome("Nome"); //implementar futuramente com o banco de dados
        estado.setSigla("Sigla"); //implementar futuramente com o banco de dados
        cidade.setCodigo(cbCidade.getSelectedIndex()); //implementar futuramente com o banco de dados
        cidade.setEstado(estado); //implementar futuramente com o banco de dados
        cidade.setNome("Nome"); //implementar futuramente com o banco de dados
        empresa.setCidade(cidade); //implementar futuramente com o banco de dados
        empresa.setCodigo(0);
        empresa.setComplemento(tfComplemento.getText());
        empresa.setEmail(tfEmail.getText());
        empresa.setLogradouro(tfLogradouro.getText());
        empresa.setNomeEmpresarial(tfEmpresarial.getText());
        empresa.setNomeFantasia(tfFantasia.getText());
        empresa.setNumero(Integer.parseInt(ftNumero.getText()));
        empresa.setSite(tfSite.getText());
        empresa.setTelefone(Long.valueOf(telefone));
        log.put("Cadastro", "Empresa Cadastrada");

        return empresa;
    }

}
