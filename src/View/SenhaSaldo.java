/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Controle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Model.Investidor;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author rafael
 */
public class SenhaSaldo extends javax.swing.JFrame {

    /**
     * Creates new form SenhaSaldo
     */
    
    Controle controle;
    Investidor usuario;
    
    public SenhaSaldo(Investidor usuario) {
        initComponents();
        this.usuario = usuario;
        this.controle = controle;
    }

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public JButton getBtContinuar() {
        return BtContinuar;
    }

    public void setBtContinuar(JButton BtContinuar) {
        this.BtContinuar = BtContinuar;
    }

    public JLabel getLblContinuar() {
        return LblContinuar;
    }

    public void setLblContinuar(JLabel LblContinuar) {
        this.LblContinuar = LblContinuar;
    }

    public JLabel getLblInsira() {
        return LblInsira;
    }

    public void setLblInsira(JLabel LblInsira) {
        this.LblInsira = LblInsira;
    }

    public JLabel getLblSenha() {
        return LblSenha;
    }

    public void setLblSenha(JLabel LblSenha) {
        this.LblSenha = LblSenha;
    }

    public JTextField getTxtSenha() {
        return TxtSenha;
    }

    public void setTxtSenha(JTextField TxtSenha) {
        this.TxtSenha = TxtSenha;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblInsira = new javax.swing.JLabel();
        LblContinuar = new javax.swing.JLabel();
        TxtSenha = new javax.swing.JTextField();
        LblSenha = new javax.swing.JLabel();
        BtContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblInsira.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LblInsira.setText("INSIRA SUA SENHA");

        LblContinuar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LblContinuar.setText("PARA CONTINUAR");

        LblSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LblSenha.setText("Senha:");

        BtContinuar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtContinuar.setText("Continuar");
        BtContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(LblContinuar))
                            .addComponent(LblInsira)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(LblSenha)
                        .addGap(18, 18, 18)
                        .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(BtContinuar)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LblInsira)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblContinuar)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblSenha))
                .addGap(57, 57, 57)
                .addComponent(BtContinuar)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtContinuarActionPerformed
        if(this.getTxtSenha().getText().equals(usuario.getSenha())){
            JOptionPane.showMessageDialog(null,"Senha correta!" , "Concluído!", INFORMATION_MESSAGE);
            ConsultarSaldo saldo = new ConsultarSaldo(usuario);
            saldo.TxtExibirNome.setText(usuario.getNome());
            saldo.TxtExibirCpf.setText(usuario.getCpf());
            saldo.TxtExibirReais.setText(String.valueOf(usuario.getSaldoreal()));
            saldo.TxtExibirBitcoin.setText(String.valueOf(usuario.getSaldobitcoin()));
            saldo.TxtExibirEthereum.setText(String.valueOf(usuario.getSaldoethereum()));
            saldo.TxtExibirRipple.setText(String.valueOf(usuario.getSaldoripple()));
            saldo.setVisible(true);
            this.setVisible(false);
            
        }else{
            JOptionPane.showMessageDialog(null,"Senha incorreta!" , "Erro", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtContinuarActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(SenhaSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SenhaSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SenhaSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SenhaSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SenhaSaldo().setVisible(true);
//            }
//        });
//    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtContinuar;
    private javax.swing.JLabel LblContinuar;
    private javax.swing.JLabel LblInsira;
    private javax.swing.JLabel LblSenha;
    private javax.swing.JTextField TxtSenha;
    // End of variables declaration//GEN-END:variables
}
