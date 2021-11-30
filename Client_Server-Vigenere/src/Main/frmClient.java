/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author n18dc
 */
public class frmClient extends javax.swing.JFrame {

    /**
     * Creates new form frmClient
     */
    public frmClient() {
        initComponents();
    }
    
    String handleKey(String str)
    {
        int value = 0;
        String temp = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != ' ')
            {
                if (str.charAt(i) >= 97 && str.charAt(i) <= 122) value = 0;
                else if (str.charAt(i) >= 65 && str.charAt(i) <=122) value = 32;
                
                temp = temp + (char)(str.charAt(i) + value);
            }
        }
        
        return temp;
    }
    
    String enscryptMessage(String message, String key)
    {
        int value = 0;
        int lenght = key.length();
        String res = "";
        
        for (int i = 0; i < message.length(); i++)
        {
            if (isCharacter(message.charAt(i)) && message.charAt(i) != ' ')
            {
                if (message.charAt(i) >= 97 && message.charAt(i) <= 122) value = 0;
                else if (message.charAt(i) >= 65 && message.charAt(i) <=122) value = 32;
                
                res = res + (char)((message.charAt(i) + key.charAt(i%lenght) - 2*97 + value)%26 + 97 - value);
            }
            else res = res + message.charAt(i);
        }
        return res;
    }
    boolean isCharacter(char ch)
    {
        if (ch < 65) return false;
        if (ch > 122) return false;
        if (ch <= 90) return true;
        if (ch >= 97) return true;
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtResult = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPlaintext = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();
        btnSendServer = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCiphertext = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnClearText = new javax.swing.JButton();
        btnReadFile = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        txtResult.setEditable(false);
        txtResult.setBackground(new java.awt.Color(255, 255, 255));
        txtResult.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("TCP WITH VIGENERE ALGORITHM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 26, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Plaintext:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 104, -1, -1));

        txtPlaintext.setColumns(20);
        txtPlaintext.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtPlaintext.setLineWrap(true);
        txtPlaintext.setRows(5);
        txtPlaintext.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtPlaintext);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 476, 238));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 560, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Key:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, -1));

        txtKey.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txtKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 360, 34));

        btnSendServer.setBackground(new java.awt.Color(1, 152, 84));
        btnSendServer.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSendServer.setForeground(new java.awt.Color(255, 255, 255));
        btnSendServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/down-icon.png"))); // NOI18N
        btnSendServer.setText("SEND");
        btnSendServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendServerActionPerformed(evt);
            }
        });
        jPanel1.add(btnSendServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 130, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Arrows-Right-icon.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 60, 50));

        txtCiphertext.setEditable(false);
        txtCiphertext.setColumns(20);
        txtCiphertext.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtCiphertext.setLineWrap(true);
        txtCiphertext.setRows(5);
        jScrollPane2.setViewportView(txtCiphertext);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 476, 240));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Ciphertext:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Result:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, -1, -1));

        btnClearText.setBackground(new java.awt.Color(220, 53, 69));
        btnClearText.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnClearText.setForeground(new java.awt.Color(255, 255, 255));
        btnClearText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Close-Program-icon.png"))); // NOI18N
        btnClearText.setText("Clear");
        btnClearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTextActionPerformed(evt);
            }
        });
        jPanel1.add(btnClearText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 120, 40));

        btnReadFile.setBackground(new java.awt.Color(255, 193, 7));
        btnReadFile.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnReadFile.setForeground(new java.awt.Color(51, 51, 51));
        btnReadFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Documents-icon.png"))); // NOI18N
        btnReadFile.setText("Open");
        btnReadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadFileActionPerformed(evt);
            }
        });
        jPanel1.add(btnReadFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 120, 40));

        btnCheck.setBackground(new java.awt.Color(13, 110, 253));
        btnCheck.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnCheck.setText("CHECK");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        jPanel1.add(btnCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 100, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Arrows-Left-icon.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 60, 50));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnClear.setText("X");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, -1, 30));

        txt.setColumns(20);
        txt.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt.setLineWrap(true);
        txt.setRows(5);
        txt.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txt);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 410, 150));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background - Copy.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTextActionPerformed
        txtPlaintext.setText("");
        txtCiphertext.setText("");

    }//GEN-LAST:event_btnClearTextActionPerformed

    private void btnSendServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendServerActionPerformed
        if(txtPlaintext.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter Plain Text", "Notify", 0);
            return;
        }
        if(txtKey.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter Key", "Notify", 0);
            return;
        }
        
        try ( 
                Socket client = new Socket("localhost",8888)) {
                //tạo đối tượng in,out để lấy dữ liệu hay đẩy dữ liệu lên stream
                DataOutputStream dout=new DataOutputStream(client.getOutputStream());
                DataInputStream dinResult=new DataInputStream(client.getInputStream());
                
                //lấy dự liệu từ input 
                String message=txtPlaintext.getText();
                String key=txtKey.getText();
                
                //Mã hóa plaintext;
                String keyHandle=handleKey(key);
                String cipher=this.enscryptMessage(message, keyHandle);
                txtCiphertext.setText(cipher);
                
                 
                //gửi dữ liệu mã hóa lên server
                dout.writeUTF(key);
                //gửi key lên server
                dout.writeUTF(cipher);
                String result = dinResult.readUTF(); 
                

                //Nhận kết quả trả về
                txt.setText(result);
        } catch (IOException ex) {
            Logger.getLogger(frmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendServerActionPerformed

    private void btnReadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadFileActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String url="";
        JFileChooser fileChooser=new JFileChooser();
        int choose=fileChooser.showDialog(this,"Xác nhận");
        if(choose==JFileChooser.APPROVE_OPTION){
            url=fileChooser.getCurrentDirectory().toString()+"\\"+fileChooser.getSelectedFile().getName();
            File mailTesting = new File(url);
            try {
                String mailData = FileUtils.readFileToString(mailTesting);
                txtPlaintext.setText("");
                txtPlaintext.setText(mailData);
            } catch (Exception ex) {
                Logger.getLogger(frmClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnReadFileActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        if(txtPlaintext.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter Plain Text", "Notify", 0);
            return;
        }
        if(txtKey.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter Key", "Notify", 0);
            return;
        }
        String key=handleKey(txtKey.getText());
        txtCiphertext.setText(this.enscryptMessage(txtPlaintext.getText(), key));
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtKey.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearText;
    private javax.swing.JButton btnReadFile;
    private javax.swing.JButton btnSendServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txt;
    private javax.swing.JTextArea txtCiphertext;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextArea txtPlaintext;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
