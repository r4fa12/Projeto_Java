/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Controle;
import Model.Bitcoin;
import Model.Ethereum;
import Model.Investidor;
import Model.Ripple;
import java.text.DecimalFormat;

/**
 *
 * @author rafae
 */
public class VenderCriptoMoedas extends javax.swing.JFrame {

    /**
     * Creates new form Vender
     */
    
    Investidor usuario;
    Controle controle;
    public VenderCriptoMoedas(Investidor usuario) {
        initComponents();
        this.usuario = usuario;
        this.controle = new Controle(usuario);
        DecimalFormat df = new DecimalFormat("#.##");
        this.TxtAreaCotacao.setText("\nCotação bitcoin: " + df.format(usuario.getCarteira().getMoedas().get(1).getCotacao()).replace(',', '.')
                + "\n\nCotação ethereum: " + df.format(usuario.getCarteira().getMoedas().get(2).getCotacao()).replace(',', '.') + 
                "\n\nCotação ripple: " + df.format(usuario.getCarteira().getMoedas().get(3).getCotacao()).replace(',', '.'));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RbtBitcoin = new javax.swing.JRadioButton();
        RbtEthereum = new javax.swing.JRadioButton();
        RbtRipple = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAreaCotacao = new javax.swing.JTextArea();
        LblComprarCriptoMoedas = new javax.swing.JLabel();
        BtVender = new javax.swing.JButton();
        TxtValor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RbtBitcoin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RbtBitcoin.setText("Bitcoin");
        RbtBitcoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtBitcoinActionPerformed(evt);
            }
        });

        RbtEthereum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RbtEthereum.setText("Ethereum");
        RbtEthereum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtEthereumActionPerformed(evt);
            }
        });

        RbtRipple.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RbtRipple.setText("Ripple");
        RbtRipple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtRippleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Selecione qual CriptoMoeda deseja vender");

        TxtAreaCotacao.setColumns(20);
        TxtAreaCotacao.setRows(5);
        jScrollPane1.setViewportView(TxtAreaCotacao);

        LblComprarCriptoMoedas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LblComprarCriptoMoedas.setText("Vender Cripto Moedas");

        BtVender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtVender.setText("Vender");
        BtVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVenderActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Quantidade:");

        jMenu1.setText("Menu");

        jMenuItem1.setText("Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 47, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RbtBitcoin)
                        .addGap(117, 117, 117)
                        .addComponent(RbtEthereum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RbtRipple))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(LblComprarCriptoMoedas))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(BtVender)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblComprarCriptoMoedas)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbtBitcoin)
                    .addComponent(RbtEthereum)
                    .addComponent(RbtRipple))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtVender)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Menu menu = new Menu(usuario);
        menu.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void RbtBitcoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtBitcoinActionPerformed
        this.RbtEthereum.setSelected(false);
        this.RbtRipple.setSelected(false);
        usuario.getExtrato().setNomemoeda("bitcoin");
        Bitcoin bit = (Bitcoin) usuario.getCarteira().getMoedas().get(1);
        usuario.getCarteira().getMoedas().get(1).getCotacao();
    }//GEN-LAST:event_RbtBitcoinActionPerformed

    private void RbtEthereumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtEthereumActionPerformed
        this.RbtBitcoin.setSelected(false);
        this.RbtRipple.setSelected(false);
        usuario.getExtrato().setNomemoeda("ethereum");
        Ethereum ethe = (Ethereum) usuario.getCarteira().getMoedas().get(2);
        usuario.getCarteira().getMoedas().get(2).getCotacao();
    }//GEN-LAST:event_RbtEthereumActionPerformed

    private void RbtRippleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtRippleActionPerformed
        this.RbtBitcoin.setSelected(false);
        this.RbtEthereum.setSelected(false);
        usuario.getExtrato().setNomemoeda("ripple");
        Ripple rip = (Ripple) usuario.getCarteira().getMoedas().get(3);
        usuario.getCarteira().getMoedas().get(3).getCotacao();
    }//GEN-LAST:event_RbtRippleActionPerformed

    private void BtVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVenderActionPerformed
        double valor = Double.parseDouble(this.TxtValor.getText());
        controle.VenderCriptoMoedas(valor);
    }//GEN-LAST:event_BtVenderActionPerformed

   
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VenderCriptoMoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VenderCriptoMoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VenderCriptoMoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VenderCriptoMoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VenderCriptoMoedas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtVender;
    private javax.swing.JLabel LblComprarCriptoMoedas;
    private javax.swing.JRadioButton RbtBitcoin;
    private javax.swing.JRadioButton RbtEthereum;
    private javax.swing.JRadioButton RbtRipple;
    private javax.swing.JTextArea TxtAreaCotacao;
    private javax.swing.JTextField TxtValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
