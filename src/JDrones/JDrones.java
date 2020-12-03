//Javier Enrique Luna Díaz
package JDrones;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JDrones extends javax.swing.JFrame {
    private DibujaDrones panel;
    private NumDron n;
    private BufferedImage ima;
    private ArrayList<Dron> drones;
    private int iter = 0;
    private int algoritmo;
    private RCompartido rc;
    
    public JDrones() {
        rc = new RCompartido();
        initComponents();
        try{                                        
            ima = ImageIO.read(new File("C:\\Users\\javie\\OneDrive\\Documentos\\NetBeansProjects\\DronesBeta\\src\\JDrones\\mapaCU.png"));
        }catch(IOException e){e.printStackTrace();}
        drones = new ArrayList<Dron>();
        panel= new DibujaDrones(ima);
        panel.setBounds(0, 0, 1200, 700);
        add(panel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuD = new javax.swing.JMenu();
        jMenuItemNuevo = new javax.swing.JMenuItem();
        jMenuSync = new javax.swing.JMenu();
        jMenuItemMutex = new javax.swing.JRadioButtonMenuItem();
        jMenuItemSem = new javax.swing.JRadioButtonMenuItem();
        jMenuItemMon = new javax.swing.JRadioButtonMenuItem();
        jMenuItemVC = new javax.swing.JRadioButtonMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Concurrente");
        setPreferredSize(new java.awt.Dimension(1215, 765));
        setResizable(false);

        jMenuD.setText("Drones");
        jMenuD.setEnabled(false);

        jMenuItemNuevo.setText("Nuevo");
        jMenuItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoActionPerformed(evt);
            }
        });
        jMenuD.add(jMenuItemNuevo);

        jMenuBar1.add(jMenuD);

        jMenuSync.setText("Sincronización");

        jMenuItemMutex.setSelected(true);
        jMenuItemMutex.setText("Mutex");
        jMenuItemMutex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMutexActionPerformed(evt);
            }
        });
        jMenuSync.add(jMenuItemMutex);

        jMenuItemSem.setSelected(true);
        jMenuItemSem.setText("Semáforo");
        jMenuItemSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSemActionPerformed(evt);
            }
        });
        jMenuSync.add(jMenuItemSem);

        jMenuItemMon.setSelected(true);
        jMenuItemMon.setText("Monitores");
        jMenuItemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMonActionPerformed(evt);
            }
        });
        jMenuSync.add(jMenuItemMon);

        jMenuItemVC.setSelected(true);
        jMenuItemVC.setText("Variable de Condición");
        jMenuItemVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVCActionPerformed(evt);
            }
        });
        jMenuSync.add(jMenuItemVC);

        jMenuBar1.add(jMenuSync);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1514, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoActionPerformed
        if(drones.isEmpty()){
            n = new NumDron();            
            drones.add(new Dron(new MiX(1),new MiY(1),panel, rc));
            drones.get(0).setyMax(682);
            drones.get(0).setyMin(0);
            drones.get(0).setxMax(1182);
            drones.get(0).setxMin(0);
            drones.get(0).setAlgoritmo(this.algoritmo);
            panel.CreaCirculo();
            iter++;
        }else{
            switch(iter)
            {
                case 1: //Poner dron 1 en posicion inicial, crear dron 2 en posicion inicial y poner limites
                    n.aumentaDron();//2 drones
                    drones.get(0).getX().setMiX(1);
                    drones.get(0).getY().setMiY(1);
                    drones.get(0).setyMax(682);
                    drones.get(0).setxMax(591);
                    drones.add(new Dron(new MiX(592),new MiY(1),panel, rc));
                    drones.get(1).setyMax(682);
                    drones.get(1).setyMin(0);
                    drones.get(1).setxMax(1182);
                    drones.get(1).setxMin(591);
                    drones.get(1).setAlgoritmo(this.algoritmo);
                    panel.CreaCirculo();
                    iter++;
                    break;
                case 2: //Poner dron 1, 2 en posicion inicial, crear dron 3 y 4 en inicial y poner limites
                    n.aumentaDron();//3 drones
                    n.aumentaDron();//4 drones
                    drones.get(0).getX().setMiX(1);
                    drones.get(0).getY().setMiY(1);
                    drones.get(0).setyMax(341);
                    drones.get(1).getX().setMiX(592);
                    drones.get(1).getY().setMiY(1);
                    drones.get(1).setyMax(341);
                    drones.add(new Dron(new MiX(1),new MiY(342),panel, rc));
                    drones.get(2).setyMax(682);
                    drones.get(2).setyMin(341);
                    drones.get(2).setxMax(591);
                    drones.get(2).setxMin(0);
                    drones.get(2).setAlgoritmo(this.algoritmo);
                    panel.CreaCirculo();
                    drones.add(new Dron(new MiX(592),new MiY(342),panel, rc));
                    drones.get(3).setyMax(682);
                    drones.get(3).setyMin(341);
                    drones.get(3).setxMax(1182);
                    drones.get(3).setxMin(591);
                    drones.get(3).setAlgoritmo(this.algoritmo);
                    panel.CreaCirculo();
                    iter++;
                    break;
                case 3: //Poner dron 1, 2, 3, 4 en posicion inicial, crear dron 5 y 6 en inicial y poner limites
                    n.aumentaDron();//5 drones
                    n.aumentaDron();//6 drones
                    drones.get(0).getX().setMiX(1);
                    drones.get(0).getY().setMiY(1);
                    drones.get(0).setyMax(227);
                    drones.get(1).getX().setMiX(592);
                    drones.get(1).getY().setMiY(1);
                    drones.get(1).setyMax(227);
                    drones.get(2).getX().setMiX(1);
                    drones.get(2).getY().setMiY(228);
                    drones.get(2).setyMax(454);
                    drones.get(2).setyMin(227);
                    drones.get(3).getX().setMiX(592);
                    drones.get(3).getY().setMiY(228);
                    drones.get(3).setyMax(454);
                    drones.get(3).setyMin(227);
                    drones.add(new Dron(new MiX(1),new MiY(455),panel, rc));
                    drones.get(4).setyMax(681);
                    drones.get(4).setyMin(454);
                    drones.get(4).setxMax(591);
                    drones.get(4).setxMin(0);
                    drones.get(4).setAlgoritmo(this.algoritmo);
                    panel.CreaCirculo();
                    drones.add(new Dron(new MiX(592),new MiY(455),panel, rc));
                    drones.get(5).setyMax(681);
                    drones.get(5).setyMin(454);
                    drones.get(5).setxMax(1182);
                    drones.get(5).setxMin(591);
                    drones.get(5).setAlgoritmo(this.algoritmo);
                    panel.CreaCirculo();
                    iter++;
                    break;    
                case 4: //Poner dron 1, 2, 3, 4, 5, 6 en posicion inicial, crear dron 7 y 8 en inicial y poner limites
                    n.aumentaDron();//7 drones
                    n.aumentaDron();//8 drones
                    drones.get(0).getX().setMiX(1);
                    drones.get(0).getY().setMiY(1);
                    drones.get(0).setyMax(171);
                    drones.get(1).getX().setMiX(592);
                    drones.get(1).getY().setMiY(1);
                    drones.get(1).setyMax(171);
                    drones.get(2).getX().setMiX(1);
                    drones.get(2).getY().setMiY(172);
                    drones.get(2).setyMax(342);
                    drones.get(2).setyMin(171);
                    drones.get(3).getX().setMiX(592);
                    drones.get(3).getY().setMiY(172);
                    drones.get(3).setyMax(342);
                    drones.get(3).setyMin(171);
                    drones.get(4).getX().setMiX(1);
                    drones.get(4).getY().setMiY(343);
                    drones.get(4).setyMax(513);
                    drones.get(4).setyMin(342);
                    drones.get(5).getX().setMiX(592);
                    drones.get(5).getY().setMiY(343);
                    drones.get(5).setyMax(513);
                    drones.get(5).setyMin(342);
                    drones.add(new Dron(new MiX(1),new MiY(514),panel, rc));
                    drones.get(6).setyMax(684);
                    drones.get(6).setyMin(513);
                    drones.get(6).setxMax(591);
                    drones.get(6).setxMin(0);
                    drones.get(6).setAlgoritmo(this.algoritmo);
                    panel.CreaCirculo();
                    drones.add(new Dron(new MiX(592),new MiY(514),panel, rc));
                    drones.get(7).setyMax(684);
                    drones.get(7).setyMin(513);
                    drones.get(7).setxMax(1182);
                    drones.get(7).setxMin(591);
                    drones.get(7).setAlgoritmo(this.algoritmo);
                    panel.CreaCirculo();
                    iter++;
                    break;
                case 5: //Poner dron 1, 2, 3, 4, 5, 6, 7, 8 en posicion inicial, crear dron 9 y 10 en inicial y poner limites
                    n.aumentaDron();//8 drones
                    n.aumentaDron();//10 drones
                    drones.get(0).getX().setMiX(1);
                    drones.get(0).getY().setMiY(1);
                    drones.get(0).setyMax(136);
                    drones.get(1).getX().setMiX(592);
                    drones.get(1).getY().setMiY(1);
                    drones.get(1).setyMax(136);
                    drones.get(2).getX().setMiX(1);
                    drones.get(2).getY().setMiY(137);
                    drones.get(2).setyMax(272);
                    drones.get(2).setyMin(136);
                    drones.get(3).getX().setMiX(592);
                    drones.get(3).getY().setMiY(137);
                    drones.get(3).setyMax(272);
                    drones.get(3).setyMin(136);
                    drones.get(4).getX().setMiX(1);
                    drones.get(4).getY().setMiY(273);
                    drones.get(4).setyMax(408);
                    drones.get(4).setyMin(272);
                    drones.get(5).getX().setMiX(592);
                    drones.get(5).getY().setMiY(273);
                    drones.get(5).setyMax(408);
                    drones.get(5).setyMin(272);
                    drones.get(6).getX().setMiX(1);
                    drones.get(6).getY().setMiY(409);
                    drones.get(6).setyMax(544);
                    drones.get(6).setyMin(408);
                    drones.get(7).getX().setMiX(592);
                    drones.get(7).getY().setMiY(409);
                    drones.get(7).setyMax(544);
                    drones.get(7).setyMin(408);
                    drones.add(new Dron(new MiX(1),new MiY(545),panel, rc));
                    drones.get(8).setyMax(680);
                    drones.get(8).setyMin(544);
                    drones.get(8).setxMax(591);
                    drones.get(8).setxMin(0);
                    drones.get(8).setAlgoritmo(this.algoritmo);
                    panel.CreaCirculo();
                    drones.add(new Dron(new MiX(592),new MiY(545),panel, rc));
                    drones.get(9).setyMax(680);
                    drones.get(9).setyMin(544);
                    drones.get(9).setxMax(1182);
                    drones.get(9).setxMin(591);
                    drones.get(9).setAlgoritmo(this.algoritmo);
                    panel.CreaCirculo();
                    iter++;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Límite de drones.");
                    break;
            }
        }
        panel.setN(n);
        panel.setDrones(drones);
        for(Dron d: drones){
            if(!d.isAlive()){
                try{
                    d.start();
                }catch(IllegalThreadStateException ex){
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jMenuItemNuevoActionPerformed

    private void jMenuItemMutexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMutexActionPerformed
        this.algoritmo = 1;
        jMenuD.setEnabled(true);
        
    }//GEN-LAST:event_jMenuItemMutexActionPerformed

    private void jMenuItemSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSemActionPerformed
        this.algoritmo = 2;
        jMenuD.setEnabled(true);
    }//GEN-LAST:event_jMenuItemSemActionPerformed

    private void jMenuItemVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVCActionPerformed
        this.algoritmo = 4;
        jMenuD.setEnabled(true);
    }//GEN-LAST:event_jMenuItemVCActionPerformed

    private void jMenuItemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMonActionPerformed
        this.algoritmo = 3;
        jMenuD.setEnabled(true);
    }//GEN-LAST:event_jMenuItemMonActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDrones jd = new JDrones();
                jd.setVisible(true);
                jd.setLocationRelativeTo(null);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuD;
    private javax.swing.JRadioButtonMenuItem jMenuItemMon;
    private javax.swing.JRadioButtonMenuItem jMenuItemMutex;
    private javax.swing.JMenuItem jMenuItemNuevo;
    private javax.swing.JRadioButtonMenuItem jMenuItemSem;
    private javax.swing.JRadioButtonMenuItem jMenuItemVC;
    private javax.swing.JMenu jMenuSync;
    // End of variables declaration//GEN-END:variables
}
