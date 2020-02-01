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
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.da.twilight.articlenotification.service.model.Chapter;

/**
 *
 * @author ShadowWalker
 */
public class Kanshula extends AbstractStoryWebPage{

    public Kanshula(WebClient wc){
        super(wc);
    }
    
    @Override
    public Chapter getNewChapter() throws Exception{
        Chapter chapter = new Chapter();
        HtmlPage page = WC.getPage("http://vietphrase.info/VietPhrase/Browser?url=https://www.kanshula.com/book/wangushendi/&script=false&t=VP");
        HtmlAnchor storyLink = page.getFirstByXPath(".//div[@id='info']/p[4]/a");
        HtmlPage chapterPage = storyLink.click();

        HtmlHeading1 chapterTitleE = chapterPage.getFirstByXPath(".//div[@class='content_read']//div[@class='bookname']/h1");
        chapter.setTitle(chapterTitleE.asText());

        HtmlDivision chapterContentE = chapterPage.getFirstByXPath(".//div[@id='content']");
        chapter.setContent(chapterContentE.asText());

        return chapter;
    }
}
