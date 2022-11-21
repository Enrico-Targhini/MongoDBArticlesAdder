package com.example.demo.document;

import java.net.URL;
import java.util.List;

public class Section {

    private String title;
    private List<String> text;
    private List<Section> subsections;
    private URL image_url;
    private String image_caption;

    public Section(String title, List<String> text, List<Section> subsections, URL image_url, String image_caption) {
        this.title = title;
        this.text = text;
        this.subsections = subsections;
        this.image_url = image_url;
        this.image_caption = image_caption;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    public List<Section> getSubsections() {
        return subsections;
    }

    public void setSubsections(List<Section> subsections) {
        this.subsections = subsections;
    }

    public URL getImage_url() {
        return image_url;
    }

    public void setImage_url(URL image_url) {
        this.image_url = image_url;
    }

    public String getImage_caption() {
        return image_caption;
    }

    public void setImage_caption(String image_caption) {
        this.image_caption = image_caption;
    }
}
