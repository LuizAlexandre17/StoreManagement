package br.com.secharpe.view;

import br.com.secharpe.listener.EstadosActionListener;

/**
 *
 * @author luandr<stringigualanull@outlook.com>
 */
public class EstadosCadastro extends javax.swing.JInternalFrame {

    private Painel painel;
    private EstadosActionListener handlerCidades = new EstadosActionListener(this);
    private Estados est = null;

    /**
     * Creates new form CidadesCadastro
     */
    public EstadosCadastro(br.com.secharpe.view.Estados est) {
        init();
        this.est = est;
    }

    public EstadosCadastro() {
        init();
    }

    private void init() {
        new br.com.secharpe.util.Log().put("EstadosCadastro", "Abrindo janela");
        initComponents();
        btCadastrar.addActionListener(handlerCidades);
        btFechar.addActionListener(handlerCidades);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        tfSigla = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastrar Estado");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Sigla");

        btCadastrar.setText(br.com.secharpe.util.Propriedades.getProp("form.save"));

        btFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        est.childRemove(this);
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSigla;
    // End of variables declaration//GEN-END:variables

    public String getNome() {
        return this.tfNome.getText();
    }

    public String getSigla() {
        return tfSigla.getText();
    }

    public Painel getPainel() {
        return painel;
    }

    private static EstadosCadastro instance;

    public static EstadosCadastro getInstance(Painel painel) {
        if (instance == null) {
            instance = new EstadosCadastro();
        }
        return instance;
    }

    public br.com.secharpe.model.Estados getEstado() {
        br.com.secharpe.model.Estados estado = new br.com.secharpe.model.Estados();
        estado.setNome(tfNome.getText());
        estado.setSigla(tfSigla.getText());
        return estado;
    }

    public br.com.secharpe.view.Estados getEstadoView() {
        return this.est;
    }

    public void setValores(br.com.secharpe.model.Estados es) {
        tfNome.setText(es.getNome());
        tfSigla.setText(es.getSigla());
        btCadastrar.setText(br.com.secharpe.util.Propriedades.getProp("form.edit"));
    }
}
