package com.gyk.haberapp;

public class NewsSite {
    private String name;
    private String url;
    private String photoUrl;//1.Adım    Bu adımlar her bir değişken için yapılmalı!

    public NewsSite(String name, String url,String photoUrl/*2.Adım */) {
        this.name = name;
        this.url = url;
        this.photoUrl = photoUrl; //3. Adım
    }
    //Start 4.Adım
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    //END 4. Adım
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
