/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.controller;

import com.da.twilight.articlenotification.service.ManualTask;
import com.da.twilight.articlenotification.service.RoutineTask;
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
                Controller.this.ui.loadContentChannelList();
            }); 
            
            // run task every 5 minutes - need to run after init UI
            service = Executors.newScheduledThreadPool(1);
            // class ScheduledExecutorService will not throw any error at all (it will stop when got exception). so need to try-catch handler in each task when run use this class
            service.scheduleAtFixedRate(new RoutineTask( Controller.this ) , 0 , 7, TimeUnit.MINUTES);
        }catch(Exception ex){
            logMessage("[Controller] Error: "+ ex.getMessage());
        }
    }
    
    @Override
    public void loadContentChannelData(String channelName){
        new Thread(new ManualTask(this)).start();
    }
    
    private boolean isMainChannelUpdate;
    private boolean isContentChannelUpdate;
    
    @Override
    public boolean mainChannelChapterUpdate( final Chapter chapter ){
        try{
            EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    isMainChannelUpdate = ui.chuangshiQQChapterUpdate( chapter );
                }
            });
        }catch(Exception ex){
            logMessage("[Controller] Error : " +ex.getMessage());
        }
        
        return isMainChannelUpdate;
    }
    
    
    @Override
    public boolean contentChannelChapterUpdate( Chapter chapter ){
        try{
            EventQueue.invokeAndWait(() -> {
                isContentChannelUpdate = ui.shu69ChapterUpdate( chapter );
            });
        }catch(Exception ex){
            logMessage("[Controller] Error : " +ex.getMessage());
        }
        return isContentChannelUpdate;
    }
    
    @Override
    public void refresh() {
        new Thread( new RoutineTask( this )).start();
    }
    
    @Override
    public void logMessage(String msg){
        EventQueue.invokeLater(() -> {
            ui.logMessage(msg);
        });
    }
    
    @Override
    public String getCurrentContentChannel(){
        return ui.getCurrentContentChannel();
    }
}
