/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.service;

import com.da.twilight.articlenotification.controller.IController;
import com.da.twilight.articlenotification.service.pages.Biquge5200;
import com.da.twilight.articlenotification.service.pages.ChuangshiQQ;
import com.da.twilight.articlenotification.service.pages.Kanshula;
import com.da.twilight.articlenotification.service.pages.Shu69;
import com.da.twilight.articlenotification.service.pages.abtract.IStoryWebPage;
import com.da.twilight.articlenotification.utils.BrowserUtil;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import java.util.ArrayList;
import java.util.function.Consumer;
import com.da.twilight.articlenotification.service.model.Chapter;


/**
 *
 * @author ShadowWalker
 */
public class Task implements Runnable{
    private final WebClient WC;
    private final IController controller;
    
    public Task(IController controller){
        this.controller = controller;
        
        WC = BrowserUtil.getWebClient();
        WC.setAlertHandler((Page page, String string) -> {
            // UI.appendLog("*** " + string + " *** >> " + page.getUrl().toString()); 
        });
        
    }
    
    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("[RoutineTask] ");
        try {
            //controller.logMessage("Routine task's executing... ");
            sb.append("Executing...");
            Consumer<String> logger = (String msg) -> {
                controller.logMessage(msg);
            };
            
            IStoryWebPage chuangshiQQPage = new ChuangshiQQ(WC);
            chuangshiQQPage.setLogger(logger);
            Chapter c1 = chuangshiQQPage.getNewestChapter();
            
            if(c1.getTitle() != null && controller.chuangShiQQChapterUpdate( c1 )) {
                // add a list of website adapters 
                ArrayList<IStoryWebPage> list = new ArrayList<>();
                
                Biquge5200 s3 = new Biquge5200(WC);
                s3.setLogger(logger);
                list.add(s3);
                
                Kanshula s1 = new Kanshula(WC);
                s1.setLogger(logger);
                list.add(s1);
                
                Shu69 s2 = new Shu69(WC);
                s2.setLogger(logger);
                list.add(s2);
                
                controller.shu69ChapterUpdate( list
                        .stream()
                        .map((page) -> page.getNewestChapter())
                        .filter((c2) -> (c2.getTitle() != null ))
                        .findFirst()
                        .get() 
                );
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
