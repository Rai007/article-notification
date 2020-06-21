/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.controller;

import com.da.twilight.articlenotification.service.model.Chapter;

/**
 *
 * @author ShadowWalker
 */
public interface IController {
    
    public boolean mainChannelChapterUpdate( Chapter chapter );
    
    public boolean contentChannelChapterUpdate( Chapter chapter );
    
    public void refresh();
    
    public void logMessage(String msg);
    
    public String getCurrentContentChannel();
    
    public void loadContentChannelData(String channelName);
}
