package br.com.secharpe.view;

import br.com.secharpe.listener.UnidadesActionListener;
import br.com.secharpe.listener.key.UnidadesKeyListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Darabas
 */
public class UnidadesCadastro extends javax.swing.JInternalFrame {

    private UnidadesKeyListener keyUnidades = new UnidadesKeyListener(this);
    private UnidadesActionListener handlerUnidades = new UnidadesActionListener(this);

    private Painel painel;
    private Unidades un = null;

    /**
     * Creates new form Unidades
     */
    public UnidadesCadastro(br.com.secharpe.view.Unidades un) {
        init();
        this.un = un;
    }

    public UnidadesCadastro() {
        init();
    }

    private void init() {
        try {
            URL url = new URL("../image/icons/ic_account_balance.png");
            ImageIcon icon = new ImageIcon(url);
            setFrameIcon(icon);
        } catch (MalformedURLException ex) {
            //whatever you want to put here
        }
        new br.com.secharpe.util.Log().put("UnidadesCadastro", "Abrindo janela");
        initComponents();
        btCadastrar.addActionListener(handlerUnidades);
        btFechar.addActionListener(handlerUnidades);
        tfNome.addKeyListener(keyUnidades);
        tfSigla.addKeyListener(keyUnidades);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfSigla = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Cadastrar Unidades");

        jLabel1.setText("Nome");

        jLabel2.setText("Sigla");

        tfNome.setPreferredSize(new java.awt.Dimension(150, 20));

        tfSigla.setPreferredSize(new java.awt.Dimension(150, 20));

        btCadastrar.setText(br.com.secharpe.util.Propriedades.getProp("form.save"));

        btFechar.setText(br.com.secharpe.util.Propriedades.getProp("form.close"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSigla;
    // End of variables declaration//GEN-END:variables

    public Painel getPainel() {
        return painel;
    }

    private static UnidadesCadastro instance;

    public void sendInfo() {
        btCadastrar.doClick();
    }

    public br.com.secharpe.model.Unidades getUnidade() {
        br.com.secharpe.model.Unidades unidade = new br.com.secharpe.model.Unidades();
        unidade.setCodigo(0);//implementar depois com o banco (setar auto increment e remover esta linha)
        unidade.setNome(tfNome.getText());
        unidade.setSigla(tfSigla.getText());
        return unidade;
    }

    public br.com.secharpe.view.Unidades getUnidadeView() {
        return this.un;
    }

    public Object getNome() {
        return this.tfNome.getText();
    }

    public Object getSigla() {
        return this.tfSigla.getText();
    }

}
