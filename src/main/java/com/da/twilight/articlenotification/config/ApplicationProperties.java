/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author ShadowWalker
 */
public class ApplicationProperties {
    private static String homePage;
    private static String loginType;
    private static String facebookLoginLink;
    private static String username;
    private static String password;
    private static boolean upLvWhenFull;
    private static long readingTimeFor1Chap;
    private static String storyUrl;
    
    private static String localUsrInputId;
    private static String localPwdInputId;
    private static String localSubmitBtnId;
    
    private static String fbUsrInputId;
    private static String fbPwdInputId;
    private static String fbSubmitBtnId;
    
    private static final String CONFIG_FILE_NAME = "config.properties";
    private static Properties prop;
    
    public static void boot(){
        prop = new Properties();
        try{
            // config file will locate in root of project
            InputStream is = new FileInputStream(new File(CONFIG_FILE_NAME));
            prop.load(is);
            is.close();
        } catch(IOException ioe) {
            // config file not found. So we need to load default config from package
            try{
                // default config file
                prop.load(ApplicationProperties.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
            }catch(IOException ioe2){
                System.out.println("Error while loading DEFAULT CONFIG FILE: " + ioe2.toString());
            }
        }
        
        // load properties to this model from config file
        homePage = prop.get("net.da.truyencv.homePage").toString();
        loginType = prop.get("net.da.truyencv.loginType").toString();
        facebookLoginLink = prop.get("net.da.truyencv.facebookLoginLink").toString();
        
        localUsrInputId =  prop.get("net.da.truyencv.localLogin.inputUsernameId").toString();
        localPwdInputId =  prop.get("net.da.truyencv.localLogin.inputPasswordId").toString();
        localSubmitBtnId =  prop.get("net.da.truyencv.localLogin.submitButtonId").toString();
        
        fbUsrInputId =  prop.get("net.da.truyencv.facebookLogin.inputUsernameId").toString();
        fbPwdInputId =  prop.get("net.da.truyencv.facebookLogin.inputPasswordId").toString();
        fbSubmitBtnId = prop.get("net.da.truyencv.facebookLogin.submitButtonId").toString();
        
        username = prop.get("net.da.truyencv.username").toString();
        password = prop.get("net.da.truyencv.password").toString();        
        upLvWhenFull = Boolean.parseBoolean(prop.get("net.da.truyencv.upLvWhenFull").toString());
        readingTimeFor1Chap = Long.parseLong(prop.get("net.da.truyencv.readingTimeFor1Chap").toString());
        storyUrl = prop.get("net.da.truyencv.storyUrl").toString();
    }
    
    public static void updateApplicationProperties(){
        try{
            Properties props = new Properties();
            
            props.setProperty("net.da.truyencv.homePage", homePage);
            props.setProperty("net.da.truyencv.loginType", loginType);
            props.setProperty("net.da.truyencv.facebookLoginLink", facebookLoginLink);

            props.setProperty("net.da.truyencv.localLogin.inputUsernameId",localUsrInputId );
            props.setProperty("net.da.truyencv.localLogin.inputPasswordId",localPwdInputId );
            props.setProperty("net.da.truyencv.localLogin.submitButtonId",localSubmitBtnId );

            props.setProperty("net.da.truyencv.facebookLogin.inputUsernameId", fbUsrInputId);
            props.setProperty("net.da.truyencv.facebookLogin.inputPasswordId", fbPwdInputId);
            props.setProperty("net.da.truyencv.facebookLogin.submitButtonId", fbSubmitBtnId);

            props.setProperty("net.da.truyencv.username", username);
            props.setProperty("net.da.truyencv.password", password);
            props.setProperty("net.da.truyencv.upLvWhenFull", String.valueOf(upLvWhenFull));
            props.setProperty("net.da.truyencv.readingTimeFor1Chap", String.valueOf(readingTimeFor1Chap));
            props.setProperty("net.da.truyencv.storyUrl", username);

            OutputStream os = new FileOutputStream(new File(CONFIG_FILE_NAME));
            props.store(os, new Date().toString());
            os.close();
        }catch(Exception ioe){
            System.out.println("Error while save File properties file to application. " + ioe.toString());
        }
    }
    
    public static String getHomePage(){
        return homePage;
    }
    
    /* LOCAL LOGIN */
    public static String getLocalUserInputId(){
        return localUsrInputId;
    }
    
    public static String getLocalPasswordId(){
        return localPwdInputId;
    }
    
    public static String getLocalSubmitBtnId(){
        return localSubmitBtnId;
    }
    
    /* FACEBOOK LOGIN */
    public static String getFbUserInputId(){
        return fbUsrInputId;
    }
    
    public static String getFbPwdInputId(){
        return fbPwdInputId;
    }
    
    public static String getFbSubmitBtnId(){
        return fbSubmitBtnId;
    }
    
    
    public static String getLoginType(){
        return loginType;
    }
    
    public static String getFacebookLoginLink(){
        return facebookLoginLink;
    }
    
    public static String getUsername(){
        return username;
    }
    
    public static String getPassword(){
        return password;
    }
    
    
    public static void setLoginType(String type){
        ApplicationProperties.loginType = type;
    }
    
    public static void setNewLogin(String username, String password){
        ApplicationProperties.username = username;
        ApplicationProperties.password = password;
    }
    
    public static boolean isUpLvWhenFull(){
        return ApplicationProperties.upLvWhenFull;
    }
    
    public static void checkUpLvWhenFull(){
        ApplicationProperties.upLvWhenFull = true;
    }
    
    public static void uncheckUpLvWhenFull(){
        ApplicationProperties.upLvWhenFull = false;
    }
    
    public static long getReadingTimeFor1Chap(){
        return readingTimeFor1Chap;
    }
    
    public static void setReadingTimeFor1Chap(long time){
        ApplicationProperties.readingTimeFor1Chap = time;
    }
    
    public static String getUrlStory(){
        return ApplicationProperties.storyUrl;
    }
    
    public static void setUrlStory(String url){
        ApplicationProperties.storyUrl = url;
    }
}
