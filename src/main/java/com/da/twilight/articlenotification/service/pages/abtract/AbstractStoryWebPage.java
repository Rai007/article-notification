/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.service.pages.abtract;

import com.gargoylesoftware.htmlunit.WebClient;
import java.util.function.Consumer;
import com.da.twilight.articlenotification.service.model.Chapter;


/**
 *
 * @author ShadowWalker
 */
public class AbstractStoryWebPage implements IStoryWebPage{

    protected final WebClient WC;
    
    protected Consumer<String> logger;
    
    public AbstractStoryWebPage( WebClient wc ){
        this.WC = wc;
    }
    
    @Override
    public Chapter getNewestChapter() {
        Chapter chapter = null;
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(getClass().getSimpleName()).append("] ");
        try{
            sb.append("Retrieving...");
            
            chapter = getNewChapter();
            
            sb.append("\t\t[OK]");
        }catch(Exception ex){
            sb.append("\t\t[FAILED]")
              .append("\nError : ").append(ex.toString());
        }finally{
            logger.accept(sb.toString());
        }
        
        return chapter;
    }
    
    public Chapter getNewChapter() throws Exception{
        return null;
    }

    @Override
    public void setLogger(Consumer<String> logger) {
        this.logger = logger;
    }

}
