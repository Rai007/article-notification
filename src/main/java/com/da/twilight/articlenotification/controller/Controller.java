/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.controller;

import com.da.twilight.articlenotification.service.Task;
import com.da.twilight.articlenotification.ui.IUI;
import com.da.twilight.articlenotification.ui.UI;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.da.twilight.articlenotification.service.model.Chapter;
import java.awt.EventQueue;

/**
 *
 * @author ShadowWalker
 */
public class Controller implements IController{
    private IUI ui;
    
    private ScheduledExecutorService service;
    
    public Controller(){}
    
    public void init(){
        try{
            // For UI
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
                java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            // Entire this block will be block and wait until it end and unwind this task
            EventQueue.invokeAndWait(() -> {  
                Controller.this.ui =  new UI( Controller.this );
            }); 

            // run task every 5 minutes - need to run after init UI
            service = Executors.newScheduledThreadPool(1);
            // class ScheduledExecutorService will not throw any error at all (it will stop when got exception). so need to try-catch handler in each task when run use this class
            service.scheduleAtFixedRate( new Task( Controller.this ) , 0 , 7, TimeUnit.MINUTES);
        }catch(Exception ex){
            logMessage("[Controller] Error: "+ ex.getMessage());
        }
    }
    
    private boolean isChuangShiQQUpdate;
    private boolean is69ShuUpdate;
    
    @Override
    public boolean chuangShiQQChapterUpdate( final Chapter chapter ){
        try{
            EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    isChuangShiQQUpdate = ui.chuangshiQQChapterUpdate( chapter );
                }
            });
        }catch(Exception ex){
            logMessage("[Controller] Error : " +ex.getMessage());
        }
        
        return isChuangShiQQUpdate;
        
    }
    
    
    @Override
    public boolean shu69ChapterUpdate( Chapter chapter ){
        try{
            EventQueue.invokeAndWait(() -> {
                is69ShuUpdate = ui.shu69ChapterUpdate( chapter );
            });
        }catch(Exception ex){
            logMessage("[Controller] Error : " +ex.getMessage());
        }
        return is69ShuUpdate;
    }
    
    @Override
    public void refresh() {
        new Thread( new Task( this )).start();
    }
    
    @Override
    public void logMessage(String msg){
        EventQueue.invokeLater(() -> {
            ui.logMessage(msg);
        });
    }
}
