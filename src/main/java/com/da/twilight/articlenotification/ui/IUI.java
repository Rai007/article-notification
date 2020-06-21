/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.ui;

import java.util.Map;
import com.da.twilight.articlenotification.service.model.Chapter;

/**
 *
 * @author ShadowWalker
 */
public interface IUI extends Runnable {
    public void onNotify(String msg);
    
    public void onLoadInfo(Map<String, String> data);
    
    public boolean chuangshiQQChapterUpdate(Chapter chapter);
    
    public boolean shu69ChapterUpdate(Chapter chapter);
    
    public void logMessage(String msg);
    
    public String getCurrentContentChannel();
    
    public void loadContentChannelList();
}
