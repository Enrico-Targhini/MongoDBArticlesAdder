package com.example.demo.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Articles {

    @Id
    private String id;
    private String title;
    private String article_abstract;
    private List<Author> authors;
    private List<String> metadata;
    private Journal journal;
    private List<Section> sections;
    private List<String> bibliography;

    public Articles(String id, String title, String article_abstract, List<Author> authors, List<String> metadata, Journal journal, List<Section> sections, List<String> bibliography) {
        this.id = id;
        this.title = title;
        this.article_abstract = article_abstract;
        this.authors = authors;
        this.metadata = metadata;
        this.journal = journal;
        this.sections = sections;
        this.bibliography = bibliography;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle_abstract() {
        return article_abstract;
    }

    public void setArticle_abstract(String article_abstract) {
        this.article_abstract = article_abstract;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<String> metadata) {
        this.metadata = metadata;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<String> getBibliography() {
        return bibliography;
    }

    public void setBibliography(List<String> bibliography) {
        this.bibliography = bibliography;
    }
}
