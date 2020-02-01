/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.da.twilight.articlenotification.utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;


public class BrowserUtil {
    public static WebClient getWebClient(){
        //BasicConfigurator.configure();
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
        final WebClient webClient = new WebClient(getBrowser());
        webClient.getOptions().setUseInsecureSSL(false);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.waitForBackgroundJavaScriptStartingBefore(10000); // 10 seconds
        webClient.getOptions().setTimeout(20000); // 10 seconds
        
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        
        // Use in stock to reduce memory leak
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setAppletEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        //webClient.getOptions().setRedirectEnabled(true);
        /*webClient.setCssErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }); */
        return webClient;
    }
    
    private static BrowserVersion getBrowser(){
        String applicationName = "Mozilla/5.0";
        String applicationVersion = "Windows NT 10.0; WOW64; rv:52.0";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0";
        
        BrowserVersion browser = new BrowserVersion.BrowserVersionBuilder(BrowserVersion.FIREFOX_52)
          .setApplicationName(applicationName)
          .setApplicationVersion(applicationVersion)
          .setUserAgent(userAgent)
          .build();
        
        return browser;
    }
}
