package com.example.demo.document;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Journal {

    private String title;
    private Integer volume;
    private Integer number;
    private Integer pages;
    @DateTimeFormat
    private Date date;

    public Journal(String title, Integer volume, Integer number, Integer pages, Date date) {
        this.title = title;
        this.volume = volume;
        this.number = number;
        this.pages = pages;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
