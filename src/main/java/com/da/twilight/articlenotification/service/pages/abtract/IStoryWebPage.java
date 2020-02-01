/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.service.pages.abtract;

import java.util.function.Consumer;
import com.da.twilight.articlenotification.service.model.Chapter;

/**
 *
 * @author ShadowWalker
 */
public interface IStoryWebPage {
    public Chapter getNewestChapter();
    
    public void setLogger(Consumer<String> logger);
}
