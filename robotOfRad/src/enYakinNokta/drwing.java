package enYakinNokta;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class drwing extends javax.swing.JFrame {

    public drwing() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    double mouseX=0;
    double mouseY=0;
    Graphics []g;
    
    double nx;
    double ny;
    double uzaklik;
    double [] a = { 6, 4, 3};
    double[] ax = { 0, 0, 0 };
    double[] ax1 = { 0, 0, 0 };
    double[] ax2 = { 0, 0, 0 };
    
    double[] ay = { 0, 0, 0 };
    double[] ay1 = { 0, 0, 0 };
    double[] ay2={ 0, 0, 0 };
    double w,h;
    
    double [] dete={0,0,0};
    double [] dete1={0,0,0};
    double [] dete2={0,0,0};
    
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

        Point yer = evt.getPoint();
        yer(yer);
        g=new Graphics[3];
        g[0]=jPanel1.getGraphics();
        g[1]=jPanel1.getGraphics();
        g[2]=jPanel1.getGraphics();
        nx = mouseX;
        ny = mouseY;
        uzaklik = Math.sqrt(Math.pow(nx, 2) + Math.pow(ny, 2));
            if (uzaklik <= 13)
            {
                if (dene())
                {
                    sil();
                    topla();
                    ciz();
                }
            }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
         w=jPanel1.getWidth();h= jPanel1.getHeight();
        CircleD();
        //Point yer = evt.getPoint();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        Point yer = evt.getPoint();
         jLabel1.setText(toCm(yer.x)+"cm");
         jLabel2.setText(toCm(yer.y)+"cm");
    }//GEN-LAST:event_jPanel1MouseMoved
        
    private void yer(Point yer){
        mouseX = toCm(yer.x);
        mouseY = toCm(yer.y);
    }
    
    private boolean dene() {
        boolean b1=aritirma();
        boolean b2=azalma();
        if((b1&&b2&&(dete1[0]-dete[0])+(dete1[1]-dete[1])+(dete1[2]-dete[2])>(dete[0]-dete2[0])+(dete[1]-dete2[1])+(dete[2]-dete2[2]))||(b1&&!(b2))){
            dete[0]=dete1[0];
            dete[1]=dete1[1];
            dete[2]=dete1[2];
            
            ax[0]=ax1[0];
            ax[1]=ax1[1];
            ax[2]=ax1[2];
            
            ay[0]=ay1[0];
            ay[1]=ay1[1];
            ay[2]=ay1[2];
            return true;
        }
        else if((b1&b2&((dete1[0]-dete[0])+(dete1[1]-dete[1])+(dete1[2]-dete[2])<(dete[0]-dete2[0])+(dete[1]-dete2[1])+(dete[2]-dete2[2]))||(b1&&!(b2))))
        {
            dete[0]=dete2[0];
            dete[1]=dete2[1];
            dete[2]=dete2[2];
            
            ax[0]=ax2[0];
            ax[1]=ax2[1];
            ax[2]=ax2[2];
            
            ay[0]=ay2[0];
            ay[1]=ay2[1];
            ay[2]=ay2[2];
            return true;
        }
        return false;
    }
    
    private boolean aritirma() {
        for (int i = (int) dete1[0]; i <= 180; i++) {
            ax1[0]=x(dete1[0],a[0]);
            ay1[0]=y(dete1[0],a[0]);
            for (int j = (int) dete1[1]; j <= 180; j++){
                ax1[1]=x(dete1[1],a[1]);
                ay1[1]=y(dete1[1],a[1]);
                for (int k = (int) dete1[2]; k <= 180; k++) {
                    ax1[2]=x(dete1[2],a[2]);
                    ay1[2]=y(dete1[2],a[2]);
                    
                    double xu = xUzaklik(ax1);

                    if (xu >= nx - 0.1 && xu <= nx + 0.1)
                    {
                        double yu = yUzaklik(ay1);
                        if (yu >= ny - 0.1 && yu <= ny + 0.1)
                        {
                            return true;
                        }
                    }
                    dete1[2]++;
                }
                dete1[1]++;
                
                if(j>90){
                    dete1[2]=dete1[0]+dete1[1]-90;
                }
                else if(j<90){
                dete1[2]=dete1[1]-90;
                }
                else{
                    dete1[2]=dete1[0]+dete1[1]-90;
                }
            }
            dete1[0]++;
            dete[1]=dete1[0]-90;
        }   
        return false;
    }
    
    private boolean azalma() {
        for (int i = (int) dete2[0]; i >=0; i--) {
            ax2[0]=x(dete2[0],a[0]);
            ay2[0]=y(dete2[0],a[0]);
            for (int j = (int) dete2[1]; j >= 0; j--){
                ax2[1]=x(dete2[1],a[1]);
                ay2[1]=y(dete2[1],a[1]);
                for (int k = (int) dete2[2]; k >= 0; k--) {
                    
                    ax2[2]=x(dete2[2],a[2]);
                    ay2[2]=y(dete2[2],a[2]);
                    double xu = xUzaklik(ax2);

                    if (xu >= nx - 0.1 && xu <= nx + 0.1)
                    {
                        double yu = yUzaklik(ay2);
                        if (yu >= ny - 0.1 && yu <= ny + 0.1)
                        {
                            return true;
                        }
                    }
                    dete2[0]--;
                }
                dete2[1]--;
                
                if(j>90){
                   dete2[2]=dete2[0]+dete2[1]-90;
                }
                else if(j<90){
                   dete2[2]=dete2[1]-90;
                }
                else{
                   dete2[2]=dete2[0]+dete2[1]-90;
                }
            }
            dete2[1]--;
            
            dete[1]=dete2[0]-90;
        }
        dete2[0]=0;dete2[1]=0;dete2[2]=0;
        return false;
    }
    
    private void sil(){
        g[0].clearRect (0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        g[1].clearRect (0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        g[2].clearRect (0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        CircleD();
    }
    
    private void ciz(){
        jTextArea1.setText("a0: (" + ax[0] + "/ " + ay[0] + ")" +
                            "\na1: (" + ax[1] + "/ " + ay[1] + ")" +
                            "\na2: (" + ax[2] + "/ " + ay[2] + ")"
                            +"\ndete0: "+ dete[0]+"\ndete1: "+ dete[1]+"\ndete2: "+ dete[2]);
        
        g[0].drawLine(0, 0, toPx(ax[0]), toPx(ay[0]));
        g[1].drawLine(toPx(ax[0]), toPx(ay[0]), toPx(ax[1]), toPx(ay[1]));
        g[2].drawLine(toPx(ax[1]), toPx(ay[1]), toPx(ax[2]), toPx(ay[2]));
        ax[2] = 0;
        ax[1] = 0;
        ax[0] = 0;
        
    }
     
    private void CircleD(){
        
        Graphics GClass=jPanel1.getGraphics();
        GClass.setColor(Color.BLUE);
        GClass.fillArc((int) (0-h), (int) (0-h), (int) h*2, (int) h*2, 270, 360);
    }
    
    private double  y(double d, double k){
            return k * Math.sin(toRad(d));
        }
        
    private double x(double d, double k){
        return k * Math.cos(toRad(d));
    }

    private double acma(double x, double k){
        double cos = x / k;
        return Math.acos(cos);
    }

    private double xUzaklik(double[] x) {   
        return x[0]+x[1]+x[2];
    }
        
    private double yUzaklik(double[] y){
        return y[0]+y[1]+y[2];
    }
    
    private double toDerece(double r) {
        return r * (180.0 / Math.PI);
    }
    
    private double toRad(double d) {
        return Math.toRadians(d);
    }
    
    private void topla() {
        ax[1]=ax[1]+ax[0];
        ax[2]=ax[2]+ax[1];
        
        ay[1]=ay[1]+ay[0];
        ay[2]=ay[2]+ay[1];
    }
    
    private int toPx(double cm){
        return (int)(cm*39.58);
    }
    
    private double toCm(int p){
        return p/39.58;
    }
    
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
            java.util.logging.Logger.getLogger(drwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(drwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(drwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(drwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new drwing().setVisible(true);
            }
             
        });
        
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}