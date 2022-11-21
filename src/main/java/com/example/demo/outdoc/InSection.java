package com.example.demo.outdoc;

import java.net.URL;

public class InSection {

    private String title;
    private URL image_url;

    public InSection(String title, URL image_url) {
        this.title = title;
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URL getImage_url() {
        return image_url;
    }

    public void setImage_url(URL image_url) {
        this.image_url = image_url;
    }
}
