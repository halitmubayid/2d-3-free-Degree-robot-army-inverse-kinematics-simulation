package robotofrad;

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
    
    Graphics []g;//çizmek sınıf nesnesi
    
    double nx;//cm panel üzerinde pastığım yer x'i
    double ny;//panel üzerinde pastığım yer y'i
    
    double [] a = { 6, 4, 3};//kolların uzunları
    double[] ax = { 0, 0, 0 };//koların x'ye işgal edecek 
    double[] ay = { 0, 0, 0 };//koların y'ye işgal edecek 
    double w,h;//panel yüksekliği ve genişliği
    
    double x0 = 0;//robot uygun yeri
    double xb = 0;//robot ilk yeri
    double x = 0;//x0 ve nx arasındaki uzaklık
    double xh = 0;//hareket mikdarı
    
    

    double nAcması;//nokta geni ve x açması 
    double uzaklik;//makina ve nokta arasındaki fark
    
    double [] dete={0,0,0};//kollerin açmaları
    
//mouse teklanıldığında
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

        Point yer = evt.getPoint();//basıldigi yer kordinatı
        yer(yer);//yer ayrlmak ve pixel'den cm'ye cevermek
        
        g=new Graphics[3];//nesne dizisi oluştumak
        
        g[0]=jPanel1.getGraphics();//nesne referance
        g[1]=jPanel1.getGraphics();//nesne referance
        g[2]=jPanel1.getGraphics();//nesne referance
        
        uzaklik = Math.sqrt(Math.pow(nx, 2) + Math.pow(ny, 2));//nokta ve kordinat başının arasındaki uzaklık
        if (uzaklik>12){//uzaklık kolları toplam boyutları birlikte baha büyük ise
            yaklas();//robot uygun yere getiren method
        }
        if (dene())//inverse kinamatics Interative Cycle Coordinat Descent
        {
            sil();//jpanel temizlemek için
            topla();//her kol nereden nereye kordinatı hesplamak için
            ciz();//jpanel üzerinde robot çizmek için
        }
    }//GEN-LAST:event_jPanel1MouseClicked
 
//mouse jpanel'e girdiği zaman
    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
         w=jPanel1.getWidth();h= jPanel1.getHeight();
        CircleD();//sınırın çemberinın çeyreği çizmek için
    }//GEN-LAST:event_jPanel1MouseEntered

//jpanel üzerinde mouse hareket ederken
    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        Point yer = evt.getPoint();//mouse jpanel'a göre kordinat bellirtmek için
         jLabel1.setText(toCm(yer.x)+"cm");//lable'ye kordinat cm cinsinde yazmak için
         jLabel2.setText(toCm(yer.y)+"cm");
    }//GEN-LAST:event_jPanel1MouseMoved
    
//robot uygun yere getirmek için
    private void yaklas() {
        x=Math.sqrt(Math.pow(9, 2)-Math.pow(ny, 2));//Pisagor
        
        if (xb<nx) {//robot yeri istediğimiz yerin solunda ise
            x0=nx-x;
        }
        else if(xb>nx){//robot yeri istediğimiz yerin sağında ise
            x0=nx+x;
        }
        xh=x0-xb;//hareket mikdarı
    }
    
//mouse basıldığı yer cm cinsinde
    private void yer(Point yer){
        nx = toCm(yer.x);
        ny = toCm(yer.y);
    }
    
//inverse kinamatics Interative Cycle Coordinat Descent
    private boolean dene() {
        dete[0]=0;//birinci kolun açması sıfırlamak için
        for (int i = 0 ; i <= 180 ; i++ )//servo moturo 180 derece hareket eiyor 
        {
            ax[0]=x(dete[0],a[0]);//açı heslaptıktan sonra x'e işgal edecek cm
            ay[0]=y(dete[0],a[0]);
            
            dete[1]=dete[0]-90;//
            
            for (int j = 0; j <= 180; j++)
            {
               ax[1]=x(dete[1],a[1]);
               ay[1]=y(dete[1],a[1]);
               if(j>90){
                   dete[2]=dete[0]+dete[1]-90;
               }
               else if(j<90){
                   dete[2]=dete[1]-90;
               }
               else{
                   dete[2]=dete[0]+dete[1]-90;
               }
               for (int k = 0; k <= 180; k++)
               {
                   ax[2]=x(dete[2],a[2]);
                   ay[2]=y(dete[2],a[2]);
                   double xu = xUzaklik();

                    if (xu >= nx - 0.05 && xu <= nx + 0.05)
                    {
                        double yu = yUzaklik();
                        if (yu >= ny - 0.05 && yu <= ny + 0.05)
                        {
                            return true;
                        }
                    }
                    dete[2]+=1;
               }
               dete[1]+=1;
            }
            dete[0]+=1;
        }
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
        
        Graphics GClass1=jPanel1.getGraphics();
        GClass1.setColor(Color.BLUE);
        GClass1.fillArc((int) (0-h), (int) (0-h), (int) h*2, (int) h*2, 270, 360);
        GClass1.setColor(Color.RED);
        GClass1.fillArc((int)0-toPx(5), (int)0-toPx(5), toPx(5),  toPx(5), 270, 360);
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

    private double xUzaklik() {   
        return ax[0]+ax[1]+ax[2];
    }
        
    private double yUzaklik(){
        return ay[0]+ay[1]+ay[2];
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
