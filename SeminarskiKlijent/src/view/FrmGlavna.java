/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.racun.FrmKreiranjeRacuna;
import view.knjiga.FrmBrisanjeKnjige;
import view.autor.FrmKreiranjeAutora;
import domenn.Radnik;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import view.autor.FrmBrisanjeAutora;
import view.knjiga.FrmDodavanjeKnjige;

/**
 *
 * @author Djordje Vukicevic
 */
public class FrmGlavna extends javax.swing.JFrame {

    private Radnik ulogovaniRadnik;

    /**
     * Creates new form FrmGlavna
     */
    public FrmGlavna() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUlogovaniRadnik = new javax.swing.JLabel();
        jMenuBarGlavniMeni = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemDodavanjeKnjige = new javax.swing.JMenuItem();
        jMenuItemBrisanjeKnjige = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemKreiranjeAutora = new javax.swing.JMenuItem();
        jMenuItemBrisanjeAutora = new javax.swing.JMenuItem();
        jMenuItemIzmenaPodataka = new javax.swing.JMenuItem();
        jMenuRacun = new javax.swing.JMenu();
        jMenuItemUnosRacuna = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelUlogovaniRadnik.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelUlogovaniRadnik.setText("Ulogovani radnik: ");

        jMenu1.setText("Knjige");

        jMenuItemDodavanjeKnjige.setText("Dodavanje knjige");
        jMenuItemDodavanjeKnjige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDodavanjeKnjigeActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemDodavanjeKnjige);

        jMenuItemBrisanjeKnjige.setText("Pretraga i brisanje knjige");
        jMenuItemBrisanjeKnjige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBrisanjeKnjigeActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemBrisanjeKnjige);

        jMenuBarGlavniMeni.add(jMenu1);

        jMenu2.setText("Autori");

        jMenuItemKreiranjeAutora.setText("Kreiranje autora");
        jMenuItemKreiranjeAutora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKreiranjeAutoraActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemKreiranjeAutora);

        jMenuItemBrisanjeAutora.setText("Brisanje autora");
        jMenuItemBrisanjeAutora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBrisanjeAutoraActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemBrisanjeAutora);

        jMenuItemIzmenaPodataka.setText("Izmena podataka");
        jMenuItemIzmenaPodataka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIzmenaPodatakaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemIzmenaPodataka);

        jMenuBarGlavniMeni.add(jMenu2);

        jMenuRacun.setText("Racun");

        jMenuItemUnosRacuna.setText("Unos racuna");
        jMenuItemUnosRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUnosRacunaActionPerformed(evt);
            }
        });
        jMenuRacun.add(jMenuItemUnosRacuna);

        jMenuBarGlavniMeni.add(jMenuRacun);

        setJMenuBar(jMenuBarGlavniMeni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUlogovaniRadnik)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabelUlogovaniRadnik)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemDodavanjeKnjigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDodavanjeKnjigeActionPerformed
        FrmDodavanjeKnjige frmDodajKnjgu = new FrmDodavanjeKnjige();
        frmDodajKnjgu.setTitle("Dodavanje knjige");
        frmDodajKnjgu.setUlogovaniRadnik(ulogovaniRadnik);
        frmDodajKnjgu.setVisible(true);
    }//GEN-LAST:event_jMenuItemDodavanjeKnjigeActionPerformed

    private void jMenuItemBrisanjeKnjigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBrisanjeKnjigeActionPerformed
        FrmBrisanjeKnjige panel = new FrmBrisanjeKnjige();
        panel.setUlogovaniRadnik(ulogovaniRadnik);
        JDialog dialog = new JDialog(this, "Brisanje knjige", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemBrisanjeKnjigeActionPerformed

    private void jMenuItemKreiranjeAutoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKreiranjeAutoraActionPerformed
        FrmKreiranjeAutora panel = new FrmKreiranjeAutora();
        panel.setUlogovaniRadnik(ulogovaniRadnik);
        JDialog dialog = new JDialog(this, "Dodavanje autora", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemKreiranjeAutoraActionPerformed

    private void jMenuItemBrisanjeAutoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBrisanjeAutoraActionPerformed
        FrmBrisanjeAutora panel = new FrmBrisanjeAutora(false);
        panel.setUlogovaniRadnik(ulogovaniRadnik);
        JDialog dialog = new JDialog(this, "Brisanje autora", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemBrisanjeAutoraActionPerformed

    private void jMenuItemIzmenaPodatakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIzmenaPodatakaActionPerformed
        FrmBrisanjeAutora panel = new FrmBrisanjeAutora(true); //IZMENA AUTORA
        panel.setUlogovaniRadnik(ulogovaniRadnik);
        JDialog dialog = new JDialog(this, "Izmena autora", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemIzmenaPodatakaActionPerformed

    private void jMenuItemUnosRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUnosRacunaActionPerformed
        FrmKreiranjeRacuna panel = new FrmKreiranjeRacuna();
        panel.setUlogovaniRadnik(ulogovaniRadnik);
        JDialog dialog = new JDialog(this, "Kreiranje racuna", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemUnosRacunaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGlavna().setVisible(true);
            }
        });
    }

    public Radnik getUlogovaniRadnik() {
        return ulogovaniRadnik;
    }

    public void setUlogovaniRadnik(Radnik ulogovaniRadnik) {
        this.ulogovaniRadnik = ulogovaniRadnik;
        jLabelUlogovaniRadnik.setText("Ulogovani radnik: " + ulogovaniRadnik);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelUlogovaniRadnik;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBarGlavniMeni;
    private javax.swing.JMenuItem jMenuItemBrisanjeAutora;
    private javax.swing.JMenuItem jMenuItemBrisanjeKnjige;
    private javax.swing.JMenuItem jMenuItemDodavanjeKnjige;
    private javax.swing.JMenuItem jMenuItemIzmenaPodataka;
    private javax.swing.JMenuItem jMenuItemKreiranjeAutora;
    private javax.swing.JMenuItem jMenuItemUnosRacuna;
    private javax.swing.JMenu jMenuRacun;
    // End of variables declaration//GEN-END:variables
}