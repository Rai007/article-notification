/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.da.twilight.articlenotification.ui;

import com.da.twilight.articlenotification.controller.IController;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.da.backing.manager.ChangeManager.ChangeEvent;
import net.da.backing.manager.ChangeManager;
import com.da.twilight.articlenotification.service.model.Chapter;
import java.io.File;

/**
 *
 * @author ShadowWalker
 */
public class UI extends javax.swing.JFrame implements IUI {
    
    /**
     * Creates new form IUI
     */
    
    private final String appTitle ;
    
    private TrayIcon trayIcon;
    
    private IController controller;
    
    private final ChangeManager changeManager = new ChangeManager();
    
    public UI( IController controller ) {
        super("Notification application");
        appTitle = "Notification application";
        this.controller = controller;
        
        initComponents();
        
        createSystemTray();
        
        changeManager.setListenerForKey("ChangshiQQ::NewestChapterTitle", (ChangeEvent event) -> {
            chuangshiQQTxt.setText( event.getNewValue() );
            onNotify( event.getNewValue() );
        });
        changeManager.setListenerForKey("69Shu::NewestChapterTitle", (ChangeEvent event) -> {
            Shu69Txt.setText( event.getNewValue() );
        });
        changeManager.setListenerForKey("69Shu::NewestChapterContent", (ChangeEvent event) -> {
            Shu69Txtarea.setText( event.getNewValue() );
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Logger = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Shu69Txtarea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        logger = new javax.swing.JTextArea();
        chuangshiQQTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Shu69Txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Shu69Txtarea.setEditable(false);
        Shu69Txtarea.setBackground(new java.awt.Color(255, 255, 204));
        Shu69Txtarea.setColumns(20);
        Shu69Txtarea.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        Shu69Txtarea.setForeground(new java.awt.Color(51, 51, 51));
        Shu69Txtarea.setLineWrap(true);
        Shu69Txtarea.setRows(5);
        jScrollPane1.setViewportView(Shu69Txtarea);

        Logger.addTab("Story", jScrollPane1);

        logger.setBackground(new java.awt.Color(204, 255, 255));
        logger.setColumns(20);
        logger.setRows(5);
        jScrollPane2.setViewportView(logger);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );

        Logger.addTab("Log", jPanel1);

        chuangshiQQTxt.setEditable(false);
        chuangshiQQTxt.setBackground(new java.awt.Color(255, 255, 153));
        chuangshiQQTxt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        chuangshiQQTxt.setForeground(new java.awt.Color(255, 0, 51));
        chuangshiQQTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuangshiQQTxtActionPerformed(evt);
            }
        });

        jLabel1.setText("ChuangShi.QQ");

        jLabel2.setText("69Shu:");

        Shu69Txt.setEditable(false);
        Shu69Txt.setBackground(new java.awt.Color(255, 255, 204));
        Shu69Txt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Shu69Txt.setForeground(new java.awt.Color(51, 51, 255));
        Shu69Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Shu69TxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Logger)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chuangshiQQTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Shu69Txt))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chuangshiQQTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Shu69Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logger, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chuangshiQQTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuangshiQQTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chuangshiQQTxtActionPerformed

    private void Shu69TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Shu69TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Shu69TxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controller.refresh();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void createSystemTray(){
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        this.trayIcon = new TrayIcon(createImage("images" + File.separator+ "logo.png", appTitle + "'s running"));
        trayIcon.setImageAutoSize(true);
        trayIcon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getClickCount() >= 2){
                    setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {}

            @Override
            public void mouseExited(MouseEvent me) {}

        });
        final SystemTray tray = SystemTray.getSystemTray();
        
        // Create a pop-up menu components
        MenuItem aboutItem = new MenuItem("About");
        MenuItem cb1 = new MenuItem("Window");
        cb1.addActionListener((ActionEvent ae) -> {
            UI.this.setVisible(true);
        });
        
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
       
        //Add components to pop-up menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(cb1);
        
        popup.addSeparator();
        
        popup.add(exitItem);
       
        trayIcon.setPopupMenu(popup);
       
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
        trayIcon.displayMessage("Tuyencv-reader","Truyencv-reader started...", TrayIcon.MessageType.INFO);
        // default windows already have notify sound so we don't need add another sound
        // playSound("sound/slow-spring-board-longer-tail.wav");
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    protected static Image createImage(String path, String description) {
        URL imageURL = UI.class.getResource(path);
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
    
    @Override
    public void onNotify(String msg){
        playSound("sound/accomplished.wav");
        trayIcon.displayMessage(this.appTitle, msg , TrayIcon.MessageType.WARNING);
        
        chuangshiQQTxt.setText(msg);
    }
    
    
    @Override
    public void onLoadInfo(Map<String, String> data){
        String title = data.get("StoryTracking::vancothande::title");
        chuangshiQQTxt.setText(title);
    }
    
    public void playSound(String sound){
        try {
            InputStream is = getClass().getResourceAsStream(sound);
            InputStream bufferedIn = new BufferedInputStream(is);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
         } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } catch (LineUnavailableException e) {
            e.printStackTrace();
         }
    }
    
    
    @Override
    public boolean chuangshiQQChapterUpdate( Chapter chapter ){
        return changeManager.setParam("ChangshiQQ::NewestChapterTitle", chapter.getTitle());
    }
    
    @Override
    public boolean shu69ChapterUpdate( Chapter chapter ){
        changeManager.setParam("69Shu::NewestChapterTitle", chapter.getTitle());
        return changeManager.setParam("69Shu::NewestChapterContent", chapter.getContent());
    }
    
    @Override
    public void logMessage(String msg){
        logger.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date()) + " : " + msg + "\n" );
    }
    
    @Override
    public void run() {
        System.out.println(">>> Initiated UI ...");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Logger;
    private javax.swing.JTextField Shu69Txt;
    private javax.swing.JTextArea Shu69Txtarea;
    private javax.swing.JTextField chuangshiQQTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea logger;
    // End of variables declaration//GEN-END:variables
}
