/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.service.pages;

import com.da.twilight.articlenotification.service.pages.abtract.AbstractStoryWebPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.da.twilight.articlenotification.service.model.Chapter;

/**
 *
 * @author ShadowWalker
 */
public class ChuangshiQQ extends AbstractStoryWebPage{

    public ChuangshiQQ( WebClient wc ){
        super(wc);
    }

    @Override
    public Chapter getNewChapter() throws Exception{
        Chapter chapter = new Chapter();
        HtmlPage page = WC.getPage("http://chuangshi.qq.com/bk/xh/648963.html" /* "http://vietphrase.info/VietPhrase/Browser?url=http://chuangshi.qq.com/bk/xh/648963.html&script=false&t=VP" */);
        HtmlElement chapterTitleE = page.getFirstByXPath(".//div[@id='newChapterList']/div[@class='chaptername']");
        chapter.setTitle(chapterTitleE.asText());
        
        return chapter;
    }
}
