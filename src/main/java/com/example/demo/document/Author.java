package com.example.demo.document;

import org.springframework.data.annotation.Id;

public class Author {

    @Id
    private String orcid;
    private String name;
    private String surname;
    private String affiliation;
    private String email;
    private String bio;

    public Author(String orcid, String name, String surname, String affiliation, String email, String bio) {
        this.orcid = orcid;
        this.name = name;
        this.surname = surname;
        this.affiliation = affiliation;
        this.email = email;
        this.bio = bio;
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
