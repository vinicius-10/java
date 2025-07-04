
import javax.swing.JOptionPane;

//netbeans IDe 26
//Vinicius Souza dias 2564599







public class FormCadAutor extends javax.swing.JFrame implements Menus {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCadAutor.class.getName());

    private Autor autor;
    private Armazenamento armazen;
    
    private static FormCadAutor fromCadAutorUnic;
    
    private FormCadAutor() {
        initComponents();
        armazen = Armazenamento.geraArmazen();
    }
    
    //singleton
    public static FormCadAutor gerarFormCadAutor(){
        if(fromCadAutorUnic == null){
            fromCadAutorUnic = new FormCadAutor();
        }
        return fromCadAutorUnic;       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cxNome = new javax.swing.JTextField();
        rtTitulo = new javax.swing.JLabel();
        rtCpf = new javax.swing.JLabel();
        cxCpf = new javax.swing.JTextField();
        btLimpar = new javax.swing.JButton();
        rtNome = new javax.swing.JLabel();
        btCadastar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rtTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        rtTitulo.setText("Cadastrar autor");

        rtCpf.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtCpf.setText("Digite o CPF:");

        cxCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxCpfActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        rtNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtNome.setText("Nome: ");

        btCadastar.setText("Cadastrar");
        btCadastar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rtTitulo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btLimpar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCadastar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rtCpf)
                                .addComponent(rtNome))
                            .addGap(56, 56, 56)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cxCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(cxNome)))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(rtTitulo)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtCpf)
                    .addComponent(cxCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtNome)
                    .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(btCadastar))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cxCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxCpfActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        clear();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btCadastarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btCadastarActionPerformed

    
    
    //polimorfismo por sobrescrita
    @Override
    public void cadastrar(){
        autor = new Autor();
        
       try{
            autor.setNome(cxNome.getText());
        }catch(AutorExecption e) {
 
            autor = e.corTinyNameExecption(autor);
        }

        try{
            autor.setCpf(cxCpf.getText());
        }catch(AutorExecption e) {
 
            autor = e.corTinyCpfExecption(autor);
        }

        if(armazen.getAutorByCpf(autor.getCpf()) != null){
            JOptionPane.showMessageDialog(
                    null,
                    "Autor já cadastrada",
                    "Cadastro de autor",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }  
          
        armazen.getBdAutores().add(autor);
        JOptionPane.showMessageDialog(
            null,
            "Autor cadastrada com sucesso",
            "Cadastro de autor",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        FormConAutor.gerFormAtuAutor().listaAutor();
        clear();
        
    }
    
    public void clear(){
        cxCpf.setText("");
        cxNome.setText("");
        cxCpf.requestFocus();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormCadAutor().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JTextField cxCpf;
    private javax.swing.JTextField cxNome;
    private javax.swing.JLabel rtCpf;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtTitulo;
    // End of variables declaration//GEN-END:variables
}
