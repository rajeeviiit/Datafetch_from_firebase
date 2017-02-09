package com.example.ravi.image_title_firebase.mData;

/**
 * Created by ravi on 9/2/17.
 */

public class Menus {

    private String p;
    private String url;

    public Menus(){
    }

    public String getName(){

        return p;
    }
   public void setName(String p){
       this.p=p;
   }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url=url;
    }
}
