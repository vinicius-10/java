//netbeans 26
//vinicius Souza dias 2564599


import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author valuc
 */
public class FormAtuLivro extends javax.swing.JFrame{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormAtuLivro.class.getName());

    private Autor editora;
    private Armazenamento armazen;
    private Colecionavel colecionavel;
    private Didatico didatico;
    private Infantil infantil;
    boolean cleaning = false;
    
    private static FormAtuLivro fromAtuLivroUnic;
          
    
    private FormAtuLivro() {
        initComponents();
        armazen = Armazenamento.geraArmazen();
    }

    //singleton
    public static FormAtuLivro gerarFormAtuLivro(){
        if(fromAtuLivroUnic == null){
            fromAtuLivroUnic = new FormAtuLivro();
        }

        return fromAtuLivroUnic;
    }

    //campos para Colecionavel 

    JLabel rtEspeEdit;
    JTextField cxEspeEdit;

    JLabel rtAdicional;
    JTextField cxAdicional;

    JLabel rtNumerado;
    JCheckBox ckNumerado;

    // Didático
    JLabel rtNivel;
    JTextField cxNivel;

    JLabel rtMateria;
    JTextField cxMateria;

    JLabel rtComplexidade;
    JTextField cxComplexidade;

    // Infantil
    JLabel rtFaixaEtaria;
    JTextField cxFaixaEtaria;

    JLabel rtMaterial;
    JTextField cxMaterial;

    JLabel rtInterativo;
    JCheckBox ckInterativo;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtTesteDidatico1 = new javax.swing.JButton();
        rtTituloPagina = new javax.swing.JLabel();
        rtNome = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rtID = new javax.swing.JLabel();
        cxId = new javax.swing.JTextField();
        rtTipo = new javax.swing.JLabel();
        slTipo = new javax.swing.JComboBox<>();
        rtTirulo = new javax.swing.JLabel();
        cxTitulo = new javax.swing.JTextField();
        rtAutor = new javax.swing.JLabel();
        cxAutor = new javax.swing.JTextField();
        rtEditora = new javax.swing.JLabel();
        cxEditora = new javax.swing.JTextField();
        rtSecao = new javax.swing.JLabel();
        cxSecao = new javax.swing.JTextField();
        rtPrateleira = new javax.swing.JLabel();
        cxPrateleira = new javax.swing.JTextField();
        rtLinha = new javax.swing.JLabel();
        cxLinha = new javax.swing.JTextField();
        rtbloqueado = new javax.swing.JLabel();
        ckBloqueado = new javax.swing.JCheckBox();
        pnCampos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btLimpar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        rtTesteDidatico1.setText("Inserir dados de teste didatico");
        rtTesteDidatico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtTesteDidatico1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rtTituloPagina.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        rtTituloPagina.setText("Atualiza Livro");

        rtNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jPanel1.setLayout(new java.awt.GridLayout(9, 2, 50, 10));

        rtID.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtID.setText("ID");
        jPanel1.add(rtID);

        cxId.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cxId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxIdActionPerformed(evt);
            }
        });
        jPanel1.add(cxId);

        rtTipo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtTipo.setText("Tipo");
        jPanel1.add(rtTipo);

        slTipo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        slTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Colecionavel", "Didatico", "Infantil" }));
        slTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slTipoActionPerformed(evt);
            }
        });
        jPanel1.add(slTipo);

        rtTirulo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtTirulo.setText("Titulo");
        jPanel1.add(rtTirulo);

        cxTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cxTitulo.setEnabled(false);
        jPanel1.add(cxTitulo);

        rtAutor.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtAutor.setText("CPF Autor");
        jPanel1.add(rtAutor);

        cxAutor.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cxAutor.setEnabled(false);
        jPanel1.add(cxAutor);

        rtEditora.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtEditora.setText("CNPJ Editora");
        jPanel1.add(rtEditora);

        cxEditora.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cxEditora.setEnabled(false);
        jPanel1.add(cxEditora);

        rtSecao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtSecao.setText("Seção ");
        jPanel1.add(rtSecao);

        cxSecao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cxSecao.setEnabled(false);
        jPanel1.add(cxSecao);

        rtPrateleira.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtPrateleira.setText("Prateleira");
        jPanel1.add(rtPrateleira);

        cxPrateleira.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cxPrateleira.setEnabled(false);
        jPanel1.add(cxPrateleira);

        rtLinha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rtLinha.setText("Linha");
        jPanel1.add(rtLinha);

        cxLinha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cxLinha.setEnabled(false);
        jPanel1.add(cxLinha);

        rtbloqueado.setText("Bloqueado");
        jPanel1.add(rtbloqueado);

        ckBloqueado.setText("Bloqueado");
        ckBloqueado.setEnabled(false);
        jPanel1.add(ckBloqueado);

        pnCampos.setLayout(new java.awt.GridLayout(3, 2, 50, 10));

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        btAtualizar.setText("Atualizar");
        btAtualizar.setEnabled(false);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(Buscar)
                .addGap(30, 30, 30)
                .addComponent(btAtualizar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(Buscar)
                    .addComponent(btAtualizar))
                .addGap(30, 30, 30))
        );

        jLabel1.setText("Digite e selecione um tipo id para buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(rtNome))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(rtTituloPagina)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(rtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(rtTituloPagina)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(pnCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAtuastarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtuastarActionPerformed
        atualizar();
        FormPrincipal.gerarFormPrincipal().listarLivros();
    }//GEN-LAST:event_btAtuastarActionPerformed

    private void cxIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxIdActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        clear();
    }//GEN-LAST:event_btLimparActionPerformed

    private void slTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slTipoActionPerformed
        if(!cleaning)buscar();
        
    }//GEN-LAST:event_slTipoActionPerformed

    private void rtTesteDidatico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtTesteDidatico1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rtTesteDidatico1ActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        buscar();
    }//GEN-LAST:event_BuscarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_btAtualizarActionPerformed
    
    
    public void buscar(){
        int intTempo = getInt(cxId.getText(),rtID.getText());
        if(intTempo == -1) return;

        String tipo = (String)slTipo.getSelectedItem();
        
        if(tipo.equalsIgnoreCase("Selecione...")){
            JOptionPane.showMessageDialog(
                    null,
                    "Selecione um tipo",
                    "Atualizar Livro",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        if (tipo.equalsIgnoreCase("colecionavel")){
            colecionavel = armazen.getColecionavelById(intTempo);

            if(colecionavel != null){
                toggle();
        
                cxId.setEnabled(false);
                slTipo.setEnabled(false);
                
                cxTitulo.setText(colecionavel.getTitulo());
                cxTitulo.setEnabled(true);
                
                btAtualizar.setEnabled(true);
                
                //reflexibilidade
                cxAutor.setText(colecionavel.getAutor().getCpf());
                cxAutor.setEnabled(true);

                //reflexibilidade
                cxEditora.setText(colecionavel.getEditora().getCnpj());
                cxEditora.setEnabled(true);

                //reflexibilidade
                cxSecao.setText(colecionavel.getLocalizacao().getSecao());
                cxSecao.setEnabled(true);

                //reflexibilidade
                cxPrateleira.setText(Integer.toString(colecionavel.getLocalizacao().getPrateleira()));
                cxPrateleira.setEnabled(true);
                
                //reflexibilidade
                cxLinha.setText(Integer.toString(colecionavel.getLocalizacao().getLinha()));
                cxLinha.setEnabled(true);

                ckBloqueado.setSelected(colecionavel.getBloqueado());
                ckBloqueado.setEnabled(true);

                cxEspeEdit.setText(colecionavel.getEdicaoEspecial());
                cxAdicional.setText(colecionavel.getAdicional());
                ckNumerado.setSelected(colecionavel.isNumerado());

                return;
            }
        }else if(tipo.equalsIgnoreCase("didatico")){
            Didatico didatico = armazen.getDidaticoById(intTempo);

            if(didatico != null){
                toggle();

                cxId.setEnabled(false);
                slTipo.setEnabled(false);

                cxTitulo.setText(didatico.getTitulo());
                cxTitulo.setEnabled(true);
                
                btAtualizar.setEnabled(true);

                //reflexibilidade
                cxAutor.setText(didatico.getAutor().getCpf());
                cxAutor.setEnabled(true);

                //reflexibilidade
                cxEditora.setText(didatico.getEditora().getCnpj());
                cxEditora.setEnabled(true);

                //reflexibilidade
                cxSecao.setText(didatico.getLocalizacao().getSecao());
                cxSecao.setEnabled(true);

                //reflexibilidade
                cxPrateleira.setText(Integer.toString(didatico.getLocalizacao().getPrateleira()));
                cxPrateleira.setEnabled(true);

                //reflexibilidade
                cxLinha.setText(Integer.toString(didatico.getLocalizacao().getLinha()));
                cxLinha.setEnabled(true);

                ckBloqueado.setSelected(didatico.getBloqueado());
                ckBloqueado.setEnabled(true);

                cxNivel.setText(didatico.getNivel());
                cxMateria.setText(didatico.getMateria());
                cxComplexidade.setText(didatico.getComplexidade());

            return;
            }
        }else if(tipo.equalsIgnoreCase("infantil")){
           
            Infantil infantil = armazen.getInfantilById(intTempo);
            if(infantil != null){
                toggle();

                cxId.setEnabled(false);
                slTipo.setEnabled(false);

                cxTitulo.setText(infantil.getTitulo());
                cxTitulo.setEnabled(true);
                
                btAtualizar.setEnabled(true);

                //reflexibilidade
                cxAutor.setText(infantil.getAutor().getCpf());
                cxAutor.setEnabled(true);

                //reflexibilidade
                cxEditora.setText(infantil.getEditora().getCnpj());
                cxEditora.setEnabled(true);

                //reflexibilidade
                cxSecao.setText(infantil.getLocalizacao().getSecao());
                cxSecao.setEnabled(true);

                //reflexibilidade
                cxPrateleira.setText(Integer.toString(infantil.getLocalizacao().getPrateleira()));
                cxPrateleira.setEnabled(true);

                //reflexibilidade
                cxLinha.setText(Integer.toString(infantil.getLocalizacao().getLinha()));
                cxLinha.setEnabled(true);

                ckBloqueado.setSelected(infantil.getBloqueado());
                ckBloqueado.setEnabled(true);

                // campos específicos
                cxFaixaEtaria.setText(Integer.toString(infantil.getFaixaEtaria()));
                cxMaterial.setText(infantil.getMaterial());
                ckInterativo.setSelected(infantil.isInterativo());

                return;  
            }
        }
        
        JOptionPane.showMessageDialog(
                null,
                "Id não encontrada.",
                "Atualizar Livro",
                JOptionPane.ERROR_MESSAGE
        );
        
    }
    
    public void toggle(){
        pnCampos.removeAll();
        
        String tipo = (String) slTipo.getSelectedItem();
        
        switch (tipo) {
        case "Colecionavel":
            colecionavel();
            
            break;
        case "Didatico":
            didatico();
            
            break;
        case "Infantil":
            infantil();
            
            break;
        }
        
        pnCampos.revalidate(); // redesenha o painel
        pnCampos.repaint();
        System.gc();
    }
    
    public void colecionavel(){
        rtEspeEdit = new JLabel("Edição especial:");
        cxEspeEdit = new JTextField();

        rtAdicional = new JLabel("Adicional:");
        cxAdicional = new JTextField();

        rtNumerado = new JLabel("Numerado:");
        ckNumerado = new JCheckBox("Sim");
        
        pnCampos.add(rtEspeEdit);
        pnCampos.add(cxEspeEdit);

        pnCampos.add(rtAdicional);
        pnCampos.add(cxAdicional);

        pnCampos.add(rtNumerado);
        pnCampos.add(ckNumerado);
    }
    
    public void didatico(){
        rtNivel = new JLabel("Nível de Ensino:");
        cxNivel = new JTextField();

        rtMateria = new JLabel("Matéria:");
        cxMateria = new JTextField();

        rtComplexidade = new JLabel("Complexidade:");
        cxComplexidade = new JTextField();
        
        pnCampos.add(rtNivel);
        pnCampos.add(cxNivel);

        pnCampos.add(rtMateria);
        pnCampos.add(cxMateria);

        pnCampos.add(rtComplexidade);
        pnCampos.add(cxComplexidade);
    }
    
    public void infantil(){
        rtFaixaEtaria = new JLabel("Faixa Etária:");
        cxFaixaEtaria = new JTextField();

        rtMaterial = new JLabel("Material:");
        cxMaterial = new JTextField();

        rtInterativo = new JLabel("Interativo:");
        ckInterativo = new JCheckBox("Sim");

        pnCampos.add(rtFaixaEtaria);
        pnCampos.add(cxFaixaEtaria);

        pnCampos.add(rtMaterial);
        pnCampos.add(cxMaterial);

        pnCampos.add(rtInterativo);
        pnCampos.add(ckInterativo);
    }
    
    public void clear(){
        cleaning = true; //para ele não tentar buscar Livro durante a limpeza do formulario
        slTipo.setSelectedIndex(0);
        slTipo.setEnabled(true);

        cxId.setText("");
        cxId.setEnabled(true);

        btAtualizar.setEnabled(false);

        cxTitulo.setText("");
        cxTitulo.setEnabled(false);

        cxAutor.setText("");
        cxAutor.setEnabled(false);

        cxEditora.setText("");
        cxEditora.setEnabled(false);

        cxLinha.setText("");
        cxLinha.setEnabled(false);

        cxPrateleira.setText("");
        cxPrateleira.setEnabled(false);

        cxSecao.setText("");
        cxSecao.setEnabled(false);

        ckBloqueado.setSelected(false);
        ckBloqueado.setEnabled(false);
        
        toggle();
        cleaning = false;
    }
    
    public void atualizar(){
        
        String tipo = (String) slTipo.getSelectedItem();
        boolean atualizado;

        switch (tipo) {
        case "Colecionavel":
            atualizado = atuColecionavel();
            
            break;
        case "Didatico":
            atualizado = atuDidatico();
            
            break;
        case "Infantil":
            atualizado = atuInfantil();
            
            break;
        default:
            JOptionPane.showMessageDialog(
                null,
                "Selecione um tipo de livro.",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if(atualizado){
            
            clear();
            JOptionPane.showMessageDialog(
                null,
                "Atualizado com sucesso!",
                "Atualizar de livro",
                JOptionPane.INFORMATION_MESSAGE
            );
            FormPrincipal.gerarFormPrincipal().listarLivros();
        }
    }
    
    public Livro atuLivro(String tipo, Autor autorAntigo, Editora editoraAntiga){
        //polimorfismo por coerção 
        Livro livro = new Colecionavel();  
        int intTempo = -1;
        
        livro.setId(getInt(cxId.getText(),rtID.getText()));
        
        try{
            livro.setTitulo(cxTitulo.getText());            
        }catch (LivroExecption exp) {
            exp.menExecption();
            return null;
        }

        try{
            //reflexividade
            livro.getLocalizacao().setSecao(cxSecao.getText());
        }catch(LivroExecption exp){
            exp.menExecption();
            return null;
        }

        intTempo = getInt(cxPrateleira.getText(),rtPrateleira.getText());
        if(intTempo == -1)  return null;
        //reflexividade
        livro.getLocalizacao().setPrateleira(intTempo);

        intTempo = getInt(cxLinha.getText(),rtLinha.getText());
        if(intTempo == -1) return null;
        //reflexividade
        livro.getLocalizacao().setLinha(intTempo);

        Autor autor = armazen.getAutorByCpf(cxAutor.getText().trim());
        if(autor == null) {
            JOptionPane.showMessageDialog(
                null,
                "Autor não encontrado.",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }

        if(!autor.getCpf().equalsIgnoreCase(autorAntigo.getCpf())){
            if(autor.getBloqueado()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Autor bloqueado.",
                    "Atualizar livro",
                    JOptionPane.ERROR_MESSAGE
                );
                return null;
            }
        }
        livro.setAutor(autor);

        Editora editora = armazen.getEditoraByCnpj(cxEditora.getText().trim());
        if(editora == null){
            JOptionPane.showMessageDialog(
                null,
                "Editora não encontrado.",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
        
        if(!editora.getCnpj().equalsIgnoreCase(editoraAntiga.getCnpj())){
            if(editora.getBloqueado()){
                JOptionPane.showMessageDialog(
                    null,
                    "Editora bloqueada.",
                    "Atualizar livro",
                    JOptionPane.ERROR_MESSAGE
                );
                return null;
            }
        }
        livro.setEditora(editora);
        
        livro.setBloqueado(ckBloqueado.isSelected());
        return livro;
    } 


    public boolean atuColecionavel(){
        colecionavel = new Colecionavel();
        String temp;
        colecionavel.setId(getInt(cxId.getText(),rtID.getText()));
        Colecionavel original = armazen.getColecionavelById(colecionavel.getId());

        //polimorfismo por coerção
        Livro livro = atuLivro("colecionavel",original.getAutor(),original.getEditora());
        if(livro == null) return false;
        colecionavel.setLivroGenerico(livro);

        colecionavel.setNumerado(ckNumerado.isSelected());

        temp = cxAdicional.getText().trim().replaceAll("\\s+", " ");
        if(temp.length() < 3){
            JOptionPane.showMessageDialog(
                null,
                "Adicional não pode ser menor que 3.",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        colecionavel.setAdicional(temp);

        temp = cxEspeEdit.getText().trim().replaceAll("\\s+", " ");
        if(temp.length() < 3){
            JOptionPane.showMessageDialog(
                null,
                "Edição especial não pode ser menor que 3.",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        colecionavel.setEdicaoEspecial(temp);

        
        if(original != null){
            try{
                original.setTitulo(colecionavel.getTitulo());
            }catch(LivroExecption e){} //nunca vai ocorer
            original.setAutor(colecionavel.getAutor());
            original.setEditora(colecionavel.getEditora());
            original.setLocalizacao(colecionavel.getLocalizacao());

            
            original.setEdicaoEspecial(colecionavel.getEdicaoEspecial());
            original.setAdicional(colecionavel.getAdicional());
            original.setNumerado(colecionavel.isNumerado());
        }else{
            JOptionPane.showMessageDialog(
                null,
                "Erro no cadastro",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }

    public boolean atuDidatico(){
        didatico = new Didatico();
        String temp;
        didatico.setId(getInt(cxId.getText(),rtID.getText()));
        Didatico original = armazen.getDidaticoById(didatico.getId());

        //polimorfismo por coerção
        Livro livro = atuLivro("didatico",original.getAutor(),original.getEditora());
        if(livro == null) return false;
        didatico.setLivroGenerico(livro);


        temp = cxNivel.getText().trim().replaceAll("\\s+", " ");
        if(temp.length() < 3){
            JOptionPane.showMessageDialog(
                null,
                "Nivel não pode ser menor que 3.",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        didatico.setNivel(temp);

        temp = cxMateria.getText().trim().replaceAll("\\s+", " ");
        if(temp.length() < 3){
            JOptionPane.showMessageDialog(
                null,
                "Materia não pode ser menor que 3.",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        didatico.setMateria(temp);

        temp = cxComplexidade.getText().trim().replaceAll("\\s+", " ");
        if(temp.length() < 3){
            JOptionPane.showMessageDialog(
                null,
                "Complexidade não pode ser menor que 3.",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        didatico.setComplexidade(temp);

        
        if(original != null){
            try{
                original.setTitulo(colecionavel.getTitulo());
            }catch(LivroExecption e){} //nunca vai ocorer
            original.setAutor(didatico.getAutor());
            original.setEditora(didatico.getEditora());
            original.setLocalizacao(didatico.getLocalizacao());

            original.setNivel(didatico.getNivel());
            original.setMateria(didatico.getMateria());
            original.setComplexidade(didatico.getComplexidade());
        }else{
            JOptionPane.showMessageDialog(
                null,
                "Erro no cadastro",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }

    public boolean atuInfantil(){
        infantil = new Infantil();
        String temp;
        infantil.setId(getInt(cxId.getText(),rtID.getText()));
        Infantil original = armazen.getInfantilById(infantil.getId());

        //polimorfismo por coerção
        Livro livro = atuLivro("infantil",original.getAutor(),original.getEditora());
        if(livro == null) return false;
        infantil.setLivroGenerico(livro);

        int intTemp = getInt(cxFaixaEtaria.getText(),rtFaixaEtaria.getText());
        if(intTemp == -1) return false;
        infantil.setFaixaEtaria(intTemp);

        temp = cxMaterial.getText().trim().replaceAll("\\s+", " ");
        if(temp.length() < 3){
            JOptionPane.showMessageDialog(
                null,
                "Material não pode ser menor que 3.",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        infantil.setMaterial(temp);
        infantil.setInterativo(ckInterativo.isSelected());

        
        if(original != null){
            try{
                original.setTitulo(colecionavel.getTitulo());
            }catch(LivroExecption e){} //nunca vai ocorer
            original.setAutor(infantil.getAutor());
            original.setEditora(infantil.getEditora());
            original.setLocalizacao(infantil.getLocalizacao());

            original.setFaixaEtaria(infantil.getFaixaEtaria());
            original.setMaterial(infantil.getMaterial());
            original.setInterativo(infantil.isInterativo());
        }else{
            JOptionPane.showMessageDialog(
                null,
                "Erro no cadastro",
                "Atualizar livro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }

    public int getInt(String campo, String label){
        try {
            int number = Integer.parseInt(campo.trim().replaceAll("\\s+", " "));
            
            if (number <= 0) {
                JOptionPane.showMessageDialog(
                    null,
                    "O "+label+" não pode ser menor ou igual a zero.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
                return -1; 
            }

            return number; 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                null,
                "O "+label+" deve ser um número inteiro.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            return -1; 
        }
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
        java.awt.EventQueue.invokeLater(() -> new FormAtuLivro().setVisible(true));
    }


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JCheckBox ckBloqueado;
    private javax.swing.JTextField cxAutor;
    private javax.swing.JTextField cxEditora;
    private javax.swing.JTextField cxId;
    private javax.swing.JTextField cxLinha;
    private javax.swing.JTextField cxPrateleira;
    private javax.swing.JTextField cxSecao;
    private javax.swing.JTextField cxTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnCampos;
    private javax.swing.JLabel rtAutor;
    private javax.swing.JLabel rtEditora;
    private javax.swing.JLabel rtID;
    private javax.swing.JLabel rtLinha;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtPrateleira;
    private javax.swing.JLabel rtSecao;
    private javax.swing.JButton rtTesteDidatico1;
    private javax.swing.JLabel rtTipo;
    private javax.swing.JLabel rtTirulo;
    private javax.swing.JLabel rtTituloPagina;
    private javax.swing.JLabel rtbloqueado;
    private javax.swing.JComboBox<String> slTipo;
    // End of variables declaration//GEN-END:variables
}
