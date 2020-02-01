/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.service.pages;

import com.da.twilight.articlenotification.service.pages.abtract.AbstractStoryWebPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.da.twilight.articlenotification.service.model.Chapter;

/**
 *
 * @author ShadowWalker
 */
public class Shu69 extends AbstractStoryWebPage{
    
    public Shu69(WebClient wc){
        super(wc);
    }
    
    @Override
    public Chapter getNewChapter() throws Exception{
        Chapter chapter = new Chapter();
        HtmlPage page = WC.getPage("http://vietphrase.info/VietPhrase/Browser?url=https://www.69shu.com/txt/22350.htm&script=false&t=VP");
        HtmlListItem listItem = page.getFirstByXPath(".//div[@id='detaillist']/ul[@class='listtile']/li");

        HtmlAnchor storyLink = listItem.getFirstByXPath(".//a");
        HtmlPage chapterPage = storyLink.click();

        HtmlHeading1 chapterTitleE = chapterPage.getFirstByXPath(".//table[@class='yd_table']//td[@class='ydleft']//h1");
        chapter.setTitle(chapterTitleE.asText());

        HtmlDivision chapterContentE = chapterPage.getFirstByXPath(".//table[@class='yd_table']//td[@class='ydleft']//div[@class='yd_text2']");
        chapter.setContent(chapterContentE.asText());
        
        return chapter;
    }
}
