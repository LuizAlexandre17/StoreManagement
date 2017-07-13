package br.com.secharpe.view;

import br.com.secharpe.model.Anotacoes;
import br.com.secharpe.listener.AnotacoesActionListener;
import br.com.secharpe.util.MessageCtrl;

/**
 *
 * @author luandr<stringigualanull@outlook.com>
 */
public class AnotacoesCadastro extends javax.swing.JInternalFrame {

    private Painel painel;
    private final AnotacoesActionListener handlerCidades = new AnotacoesActionListener(this);
    private br.com.secharpe.view.Anotacoes est = null;

    /**
     * Creates new form CidadesCadastro
     */
    public AnotacoesCadastro(br.com.secharpe.view.Anotacoes est) {
        new br.com.secharpe.util.Log().put("AnotacoesCadastro", "Abrindo janela");
        this.est = est;
        initComponents();
        btCadastrar.addActionListener(handlerCidades);
        btFechar.addActionListener(handlerCidades);
    }

    public AnotacoesCadastro(br.com.secharpe.view.Anotacoes anotacoes, br.com.secharpe.model.Anotacoes ano) {
        if (ano != null) {
            taAnotacao.setText(ano.getAnotacao());
            tfDescricao.setText(ano.getDescricao());
            tfTitulo.setText(ano.getTitulo());
        } else {
            MessageCtrl.callMessage("Ooops!", "Não há resultados!", 2);
            this.dispose();
        }
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        tfDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAnotacao = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Anotação");

        jLabel1.setText("Título");

        jLabel2.setText("Descricao");

        tfTitulo.setPreferredSize(new java.awt.Dimension(6, 22));

        btCadastrar.setText(br.com.secharpe.util.Propriedades.getProp("form.save"));

        btFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));

        jLabel3.setText("Anotação");

        taAnotacao.setColumns(20);
        taAnotacao.setRows(5);
        jScrollPane1.setViewportView(taAnotacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btFechar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescricao)
                            .addComponent(tfTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taAnotacao;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
    /**
     * @return Anotacão
     */
    public Anotacoes getAnotacoes() {
        Anotacoes anotacao = new Anotacoes();
        anotacao.setCodigo(0);
        anotacao.setTitulo(tfTitulo.getText());
        anotacao.setDescricao(tfDescricao.getText());
        anotacao.setAnotacao(taAnotacao.getText());
        return anotacao;
    }

    private static AnotacoesCadastro instance;

    /**
     * @return boolean validação
     * @deprecated
     */
    public boolean validar() {
        return (!tfTitulo.getText().equals("")) || (!tfDescricao.getText().equals("")) || (!taAnotacao.getText().equals(""));
    }

    public br.com.secharpe.view.Anotacoes getCadastroView() {
        return est;
    }
}
