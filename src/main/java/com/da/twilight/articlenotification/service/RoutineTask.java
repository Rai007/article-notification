/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.service;

import com.da.twilight.articlenotification.controller.IController;
import com.da.twilight.articlenotification.service.pages.Biquge5200;
import com.da.twilight.articlenotification.service.pages.Kanshula;
import com.da.twilight.articlenotification.service.pages.Shu69;
import com.da.twilight.articlenotification.service.pages.abtract.IStoryWebPage;
import com.da.twilight.articlenotification.utils.BrowserUtil;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import java.util.ArrayList;
import java.util.function.Consumer;
import com.da.twilight.articlenotification.service.model.Chapter;
import com.da.twilight.articlenotification.service.pages.Ptwxz;
import com.da.twilight.articlenotification.service.pages.Qidian;


/**
 *
 * @author ShadowWalker
 */
public class RoutineTask implements Runnable{
    private final WebClient WC;
    private final IController controller;
    
    public RoutineTask(IController controller){
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
            
            IStoryWebPage chuangshiQQPage = new Qidian(WC);
                                            //new ChuangshiQQ(WC);
            chuangshiQQPage.setLogger(logger);
            Chapter c1 = chuangshiQQPage.getNewestChapter();
            
            if(c1.getTitle() != null && controller.mainChannelChapterUpdate( c1 )) {
                /* ver 1.0:  Create a list of page adapter . fallback to anothers if first channel not work
                // add a list of website adapters 
                ArrayList<IStoryWebPage> list = new ArrayList<>();
                
                Shu69 s2 = new Shu69(WC);
                s2.setLogger(logger);
                list.add(s2);
                
                Biquge5200 s3 = new Biquge5200(WC);
                s3.setLogger(logger);
                list.add(s3); 
                
                Kanshula s1 = new Kanshula(WC);
                s1.setLogger(logger);
                list.add(s1);
                
                controller.contentChannelChapterUpdate( list
                        .stream()
                        .map((page) -> page.getNewestChapter())
                        .filter((c2) -> (c2.getTitle() != null ))
                        .findFirst()
                        .get() 
                );
                */
                
                // ver 2.0: Get new contentChappter base on current contentChannel name is selecting
                IStoryWebPage page ;
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
