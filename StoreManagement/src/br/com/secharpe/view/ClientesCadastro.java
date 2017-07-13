package br.com.secharpe.view;

import br.com.secharpe.exception.SistemaException;
import br.com.secharpe.listener.ClienteCadastroViewActionListener;
import br.com.secharpe.model.Clientes;
import br.com.secharpe.util.Log;
import br.com.secharpe.util.MessageCtrl;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * View para adicionar novos clientes
 *
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class ClientesCadastro extends javax.swing.JInternalFrame {

    private final ClienteCadastroViewActionListener clienteAl = new ClienteCadastroViewActionListener(this);
    private final Log logimp = new Log();
    private Painel painel;
    public br.com.secharpe.view.Clientes est = null;

    public ClientesCadastro() {
        new br.com.secharpe.util.Log().put("ClientesCadastro", "Abrindo janela");
        this.painel = painel;
        initComponents();
        /* GAMBIARRA PQ ESSA BOSTA NAO QUER EXIBIR DIREITO */
        setSize(600, 300);
        btSalvarCliente.addActionListener(clienteAl);
        btSairCliente.addActionListener(clienteAl);

    }

    /**
     * @return Retorna cliente
     */
    public Clientes getCliente() throws SistemaException {
        Clientes cl = new Clientes();

        if (cNome.getText().trim().equals("")) {
            throw new SistemaException("Insira o Nome");

        }
        if (cCPF.getText().trim().equals("")) {
            throw new SistemaException("Insira o CPF");
        }
        if (cCelular.getText().trim().equals("") && cTelefone.getText().trim().equals("")) {
            throw new SistemaException("Insira Telefone ou Celular");
        }

        if (cNome.getText() != null) {
            try {
                br.com.secharpe.model.Estados estado = new br.com.secharpe.model.Estados();
                br.com.secharpe.model.Cidades cidade = new br.com.secharpe.model.Cidades();
                cl.setNome(cNome.getText());
//                if (cCPF.getText() != null && !cCPF.getText().trim().equals("")) {
//                    cl.setCPF(Integer.parseInt((cCPF.getText())));
//                }
                if (cRG.getText() != null && !cRG.getText().trim().equals("")) {
                    cl.setRG(Integer.parseInt(cRG.getText()));
                }
                if (cCelular.getText() != null && !cCelular.getText().trim().equals("")) {
                    cl.setCelular(Integer.parseInt(cCelular.getText()));
                }
//                if (cTelefone.getText() != null && !cTelefone.getText().trim().equals("")) {
//                    cl.setTelefone(Integer.parseInt(cTelefone.getText()));
//                }
                if (cNumero.getText() != null && !cNumero.getText().trim().equals("")) {
                    cl.setNumero(Integer.parseInt(cNumero.getText()));
                }

                estado.setCodigo(cEstado.getSelectedIndex());//implementar com o banco
                estado.setNome("Nome"); //implementar futuramente com o banco de dados
                estado.setSigla("Sigla"); //implementar futuramente com o banco de dados
                cidade.setCodigo(cCidade.getSelectedIndex()); //implementar futuramente com o banco de dados
                cidade.setEstado(estado); //implementar futuramente com o banco de dados
                cidade.setNome("Nome"); //implementar futuramente com o banco de dados
                cl.setCidade(cidade); //implementar futuramente com o banco de dados
                cl.setEstado(estado);
                cl.setCodigo(0);
                cl.setComplemento(cComplemento.getText());
                cl.setEmail(cEmail.getText());
                cl.setBairro(cBairro.getText());
                cl.setEndereco(cEndereço.getText());
                logimp.put("Cadastro", "Cliente Cadastrado");
                return cl;
            } catch (NumberFormatException nfe) {
                MessageCtrl.callMessage("A String digitado não corresponde a informação", "Ops, um erro ocorreu", 8);
                StringWriter sw = new StringWriter();
                nfe.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                System.out.println();
                logimp.put("ERRO", exceptionAsString);
                logimp.put("ClientesCadastro", "getCliente", exceptionAsString);

            } catch (NullPointerException nf) {
                System.out.println("ERRO Null Pointer");
                StringWriter sw = new StringWriter();
                nf.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                System.out.println();
                logimp.put("ERRO", exceptionAsString);
                logimp.put("ClientesCadastro", "getCliente", exceptionAsString);
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cEstado = new javax.swing.JComboBox<>();
        cCidade = new javax.swing.JComboBox<>();
        cTelefone = new javax.swing.JTextField();
        cCelular = new javax.swing.JTextField();
        cEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btSalvarCliente = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btSairCliente = new javax.swing.JButton();
        cNome = new javax.swing.JTextField();
        cCPF = new javax.swing.JTextField();
        cRG = new javax.swing.JTextField();
        cEndereço = new javax.swing.JTextField();
        cNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cBairro = new javax.swing.JTextField();
        cComplemento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cCodInterno = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastrar Clientes");
        setMaximumSize(new java.awt.Dimension(557, 257));
        setMinimumSize(new java.awt.Dimension(557, 257));
        setPreferredSize(new java.awt.Dimension(557, 257));

        cEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Bairro");

        jLabel11.setText("Telefone:");

        jLabel12.setText("Celular:");

        btSalvarCliente.setText(br.com.secharpe.util.Propriedades.getProp("form.save"));

        jLabel13.setText("Email:");

        btSairCliente.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        jLabel3.setText("RG:");

        jLabel4.setText("Endereço:");

        jLabel5.setText("Numero:");

        jLabel6.setText("Complemento:");

        jLabel7.setText("Estado");

        jLabel8.setText("Cidade");

        jLabel17.setText("Codigo Interno:");

        cCodInterno.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cComplemento)
                            .addComponent(cBairro)
                            .addComponent(cTelefone)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cNome)
                                    .addComponent(cCPF)
                                    .addComponent(cEndereço, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(cEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(12, 12, 12)
                            .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cRG)
                                .addComponent(cNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cCodInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSalvarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSairCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cCodInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(cEndereço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(cBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSairCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvarCliente))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(cCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSairCliente;
    private javax.swing.JButton btSalvarCliente;
    private javax.swing.JTextField cBairro;
    private javax.swing.JTextField cCPF;
    private javax.swing.JTextField cCelular;
    private javax.swing.JComboBox<String> cCidade;
    private javax.swing.JTextField cCodInterno;
    private javax.swing.JTextField cComplemento;
    private javax.swing.JTextField cEmail;
    private javax.swing.JTextField cEndereço;
    private javax.swing.JComboBox<String> cEstado;
    private javax.swing.JTextField cNome;
    private javax.swing.JTextField cNumero;
    private javax.swing.JTextField cRG;
    private javax.swing.JTextField cTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
    /**
     * @return Retorna painel
     */
    public Painel getPainel() {
        return this.painel;
    }

    public br.com.secharpe.view.Clientes getClienteView() {
        return this.est;
    }

}
