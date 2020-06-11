/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.da.twilight.articlenotification.service.pages;

import com.da.twilight.articlenotification.service.model.Chapter;
import com.da.twilight.articlenotification.service.pages.abtract.AbstractStoryWebPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 *
 * @author ShadowWalker
 */
public class Qidian extends AbstractStoryWebPage{
    public Qidian(WebClient wc){
        super(wc);
    }
    
    @Override
    public Chapter getNewChapter() throws Exception{
        Chapter chapter = new Chapter();
        HtmlPage page = WC.getPage("https://book.qidian.com/info/3546912");

        HtmlAnchor chapterTitleE = page.getFirstByXPath(".//div[@class='book-state']//li[@class='update']//div[@class='detail']//a[@class='blue']");
        chapter.setTitle(chapterTitleE.asText());

        return chapter;
    }
}
