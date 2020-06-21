/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.da.twilight.articlenotification.service;

import com.da.twilight.articlenotification.controller.IController;
import com.da.twilight.articlenotification.service.pages.Biquge5200;
import com.da.twilight.articlenotification.service.pages.Kanshula;
import com.da.twilight.articlenotification.service.pages.Ptwxz;
import com.da.twilight.articlenotification.service.pages.Shu69;
import com.da.twilight.articlenotification.service.pages.abtract.IStoryWebPage;
import com.da.twilight.articlenotification.utils.BrowserUtil;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import java.util.function.Consumer;

/**
 *
 * @author ShadowWalker
 */
public class ManualTask implements Runnable {

    private final WebClient WC;
    private final IController controller;
    
    public ManualTask(IController controller){
        this.controller = controller;
        
        WC = BrowserUtil.getWebClient();
        WC.setAlertHandler((Page page, String string) -> {
            // UI.appendLog("*** " + string + " *** >> " + page.getUrl().toString()); 
        });
    }
    
    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ActiveTask] Getting content channel data");
        
        Consumer<String> logger = (String msg) -> {
            controller.logMessage(msg);
        };
        
        IStoryWebPage page ;
        try{
            switch( controller.getCurrentContentChannel() ){
                case "Shu69":
                    page = new Shu69(WC);
                    page.setLogger(logger);

                    controller.contentChannelChapterUpdate( page.getNewestChapter() );
                    break;
                case "Kanshula":
                    page = new Kanshula(WC);
                    page.setLogger(logger);

                    controller.contentChannelChapterUpdate( page.getNewestChapter() );
                    break;
                case "Biquge5200":
                    page = new Biquge5200(WC);
                    page.setLogger(logger);

                    controller.contentChannelChapterUpdate( page.getNewestChapter() );
                    break;
                case "Ptwxz":
                    page = new Ptwxz(WC);
                    page.setLogger(logger);

                    controller.contentChannelChapterUpdate( page.getNewestChapter() );
                    break;
                default:
                    break;
            }
        
            sb.append("\t\t[OK]");
        }catch(Exception e){
            sb.append("\t\t[FAILED]")
                    .append("Error: ").append(e.toString());
        }finally{
            controller.logMessage(sb.toString() + "\n-----");
        }
    }
    
}
