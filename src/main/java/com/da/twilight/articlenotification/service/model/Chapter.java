/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.da.twilight.articlenotification.service.model;

/**
 *
 * @author ShadowWalker
 */
public class Chapter {
    private String title;
    private String content;
    
    public Chapter(){}
    
    public Chapter(String title, String content){
        this.title = title;
        this.content = content;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public void setContent(String content){
        this.content = content;
    }
}
