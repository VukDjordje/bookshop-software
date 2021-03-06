/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logic.Kontroler;
import model.ModelTabeleKlijenti;
import niti.NitKlijent;
import niti.NitOsvezi;
import niti.NitPokreni;
import niti.NitSat;

/**
 *
 * @author Djordje Vukicevic
 */
public class FrmServerskaForma extends javax.swing.JFrame {

    NitPokreni nitPokreni;

    /**
     * Creates new form FrmServerskaForma
     */
    public FrmServerskaForma() {
        initComponents();
        jButtonZaustavi.setEnabled(false);
        pripremiFormu();
        NitOsvezi nitOsvezi = new NitOsvezi(this);
        nitOsvezi.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelStatus = new javax.swing.JLabel();
        jTextFieldStanjeServera = new javax.swing.JTextField();
        jButtonPokreni = new javax.swing.JButton();
        jButtonZaustavi = new javax.swing.JButton();
        jLabelSat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKlijenti = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelStatus.setText("Status : ");

        jTextFieldStanjeServera.setEditable(false);
        jTextFieldStanjeServera.setText("Server nije pokrenut!");
        jTextFieldStanjeServera.setEnabled(false);

        jButtonPokreni.setText("Pokreni server");
        jButtonPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPokreniActionPerformed(evt);
            }
        });

        jButtonZaustavi.setText("Zaustavi server");
        jButtonZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZaustaviActionPerformed(evt);
            }
        });

        jLabelSat.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelSat.setText("Sat");

        jTableKlijenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableKlijenti);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButtonPokreni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonZaustavi)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelStatus)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldStanjeServera, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabelSat, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelSat)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStanjeServera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPokreni)
                    .addComponent(jButtonZaustavi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPokreniActionPerformed
        nitPokreni = new NitPokreni(this);
        nitPokreni.start();
    }//GEN-LAST:event_jButtonPokreniActionPerformed

    private void jButtonZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZaustaviActionPerformed
        if (Kontroler.getInstance().getListaKlijenata().size() > 0) {
            JOptionPane.showMessageDialog(this, "Broj povezanih klijenata: "
                    + Kontroler.getInstance().getListaKlijenata().size() + ", ne mozete prekinuti server");
            return;
        }
        nitPokreni.interrupt();
    }//GEN-LAST:event_jButtonZaustaviActionPerformed

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
            java.util.logging.Logger.getLogger(FrmServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmServerskaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPokreni;
    private javax.swing.JButton jButtonZaustavi;
    private javax.swing.JLabel jLabelSat;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKlijenti;
    private javax.swing.JTextField jTextFieldStanjeServera;
    // End of variables declaration//GEN-END:variables

    public void serverJePokrenut() {
        jButtonPokreni.setEnabled(false);
        jButtonZaustavi.setEnabled(true);
        jTextFieldStanjeServera.setText("Server je pokrenut!");
    }

    public void serverJeZaustavljen() {
        jButtonPokreni.setEnabled(true);
        jButtonZaustavi.setEnabled(false);
        jTextFieldStanjeServera.setText("Server nije pokrenut!");
    }

    private void pripremiFormu() {
        pokreniSat();
        srediTabelu();
    }

    private void pokreniSat() {
        NitSat ns = new NitSat(jLabelSat);
        ns.start();
    }

    private void srediTabelu() {
        ModelTabeleKlijenti model = new ModelTabeleKlijenti(Kontroler.getInstance().getListaKlijenata());
        jTableKlijenti.setModel(model);
    }

    public void osveziKlijente() {
        ModelTabeleKlijenti model = (ModelTabeleKlijenti) jTableKlijenti.getModel();
        ArrayList<NitKlijent> lista = Kontroler.getInstance().getListaKlijenata();
        model.setListaKlijenata(lista);
        model.srediRB();
    }
}
