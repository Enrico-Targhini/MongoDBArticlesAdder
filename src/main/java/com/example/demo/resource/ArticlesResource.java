package com.example.demo.resource;

import com.example.demo.document.Articles;
import com.example.demo.document.Author;
import com.example.demo.document.Journal;
import com.example.demo.document.Section;
import com.example.demo.outdoc.InArticles;
import com.example.demo.outdoc.InAuthors;
import com.example.demo.outdoc.InMetadata;
import com.example.demo.outdoc.InSection;
import com.example.demo.repository.ArticlesRepository;
import com.thedeanda.lorem.LoremIpsum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/rest/mongoDB")
public class ArticlesResource {

    Logger log = LoggerFactory.getLogger(ArticlesResource.class);

    private ArticlesRepository articlesRepository;

    private List<InArticles> inArticles = new ArrayList<>();

    private List<InAuthors> inAuthors = new ArrayList<>();

    private List<InSection> inSections = new ArrayList<>();

    private List<InMetadata> inMetadata = new ArrayList<>();

    public ArticlesResource(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    @GetMapping("/articles")
    public List<InArticles> getAllArticles() {
        return inArticles;
    }

    @GetMapping("/authors")
    public List<InAuthors> getAllAuthors() {
        return inAuthors;
    }

    @GetMapping("/sections")
    public List<InSection> getAllSections() {
        return inSections;
    }

    @GetMapping("/metadata")
    public List<InMetadata> getAllMetadata() {
        return inMetadata;
    }

    @GetMapping("/sizeArticles")
    public int getSizeArticles() {
        return inArticles.size();
    }

    @GetMapping("/sizeAuthors")
    public int getSizeAuthors() {
        return inAuthors.size();
    }

    @GetMapping("/sizeSections")
    public int getSizeSections() {
        return inSections.size();
    }

    @GetMapping("/sizeMetadata")
    public int getSizeMetadata() {
        return inMetadata.size();
    }

    @PostMapping("/addArticles")
    public void addArticles(@RequestBody List<InArticles> inArticle) {
        inArticles.clear();
        inArticles.addAll(inArticle);
        log.info(String.valueOf(inArticles.size()));
    }

    @PostMapping("/addAuthors")
    public void addAuthors(@RequestBody List<InAuthors> inAuthor) {
        inAuthors.clear();
        inAuthors.addAll(inAuthor);
        log.info(String.valueOf(inAuthors.size()));
    }

    @PostMapping("/addSections")
    public void addSections(@RequestBody List<InSection> inSection) {
        inSections.clear();
        inSections.addAll(inSection);
        log.info(String.valueOf(inSections.size()));
    }

    @PostMapping("/addMetadata")
    public void addMetadata(@RequestBody List<InMetadata> inData) {
        inMetadata.clear();
        inMetadata.addAll(inData);
        log.info(String.valueOf(inMetadata.size()));
    }

    @GetMapping("/postAll")
    public void saveAll() throws ParseException {
        for(int i = 0; i < inArticles.size(); i++){
            saveOne(i);
        }
    }

    @GetMapping("/postOne/{id}")
    public void saveOne(@PathVariable(value="id") Integer id) throws ParseException {

        Articles article;
        List<Author> authors = new ArrayList<>();
        Journal journal;
        List<Section> sections = new ArrayList<>();
        int random;
        Random ran = new Random();

        journal = createJournal(id);

        random = ran.nextInt(100) + 1;
        log.info("I create " + random + " authors");
        authors.add(createAuthor(authors));
        if (random < 50)
            authors.add(createAuthor(authors));
        if (random < 22)
            authors.add(createAuthor(authors));
        if (random < 7)
            authors.add(createAuthor(authors));

        random = ran.nextInt(100) + 1;
        log.info("I create " + random + " sections");
        sections.add(createSection(sections, true, new ArrayList<>()));
        if (random < 80)
            sections.add(createSection(sections, true, new ArrayList<>()));
        if (random < 50)
            sections.add(createSection(sections, true, new ArrayList<>()));
        if (random < 20)
            sections.add(createSection(sections, true, new ArrayList<>()));
        if (random < 5)
            sections.add(createSection(sections, true, new ArrayList<>()));

        article = createArticles(id, journal, authors, sections);

        articlesRepository.save(article);

    }

    private Journal createJournal(int i) throws ParseException {

        long beginTime = Timestamp.valueOf("1980-01-01 00:00:00").getTime();
        long endTime = Timestamp.valueOf("2010-12-31 00:58:00").getTime();

        String title = inArticles.get(i).getJournal();
        Integer volume = inArticles.get(i).getVolume();
        Integer number = inArticles.get(i).getNumber();
        Date date = new Date(beginTime + (long) (Math.random() * (endTime - beginTime + 1)));
        Integer pages = inArticles.get(i).getPages();
        return new Journal(title, volume, number, pages, date);
    }

    private Author createAuthor(List<Author> alreadyIn) {

        Random ran = new Random();
        int random = ran.nextInt(inAuthors.size());
        String name;
        String surname;
        String orcid;
        String email;
        String bio;
        String affiliation;


        if (alreadyIn.size() != 0) {
            for (int i = 0; i < alreadyIn.size(); i++) {
                if (alreadyIn.get(i).getName().equals(inAuthors.get(random).getName()) && alreadyIn.get(i).getSurname().equals(inAuthors.get(random).getSurname())) {
                    random = ran.nextInt(inAuthors.size());
                    i = -1;
                }
            }
        }

        name = inAuthors.get(random).getName();
        surname = inAuthors.get(random).getSurname();
        orcid = inAuthors.get(random).getOrcid();
        email = inAuthors.get(random).getEmail();
        bio = LoremIpsum.getInstance().getWords(30, 70);
        affiliation = inAuthors.get(random).getAffiliation();
        return new Author(orcid, name, surname, affiliation, email, bio);
    }

    private Section createSection(List<Section> alreadyIn, boolean value, List<Section> others) {

        Random ran = new Random();
        int random = 0;
        int random1;
        boolean toGo = false;
        String title;
        List<String> text = new ArrayList<>();
        List<Section> subsections = new ArrayList<>();
        URL image_url;
        String image_caption;

        while (!toGo){
            random = ran.nextInt(inSections.size());
            toGo = checkRandomValue(random, alreadyIn);
            if (toGo)
                toGo = checkRandomValue(random, others);
        }

        title = inSections.get(random).getTitle();

        random1 = ran.nextInt(100) + 1;
        text.add(LoremIpsum.getInstance().getWords(40, 100));
        if (random1 < 80)
            text.add(LoremIpsum.getInstance().getWords(40,100));
        if (random1 < 50)
            text.add(LoremIpsum.getInstance().getWords(40, 100));
        if (random1 < 20)
            text.add(LoremIpsum.getInstance().getWords(40, 100));
        if (random1 < 5)
            text.add(LoremIpsum.getInstance().getWords(40, 100));

        random1 = ran.nextInt(100) + 1;
        if (value) {
            if (random1 < 80) {
                subsections.add(createSection(alreadyIn, false, subsections));
                if (random1 < 40)
                    subsections.add(createSection(alreadyIn, false, subsections));
                if (random1 < 10)
                    subsections.add(createSection(alreadyIn, false, subsections));
            } else {
                subsections = null;
            }
        } else {
            subsections = null;
        }

        image_url = inSections.get(random).getImage_url();
        image_caption = LoremIpsum.getInstance().getWords(10, 20);

        return new Section(title, text, subsections, image_url, image_caption);
    }

    private boolean checkRandomValue(int random, List<Section> alreadyIn){

        if (alreadyIn.size() != 0) {
            for (Section section : alreadyIn) {
                if (section.getTitle().equals(inSections.get(random).getTitle()) && section.getImage_url().equals(inSections.get(random).getImage_url())) {
                    return false;
                }
            }
        }
        return true;
    }

    private Articles createArticles(int i, Journal journal, List<Author> authors, List<Section> sections){

        String id = inArticles.get(i).getKey();
        String title = inArticles.get(i).getTitle();
        String article_abstract = LoremIpsum.getInstance().getWords(40,100);
        List<String> metadata = new ArrayList<>();
        List<String> bibliography = new ArrayList<>();
        Random ran = new Random();

        int random = ran.nextInt(inMetadata.size());
        for(int random1 = ran.nextInt( 5) + 1; random1 > 0; random1--){
            while (random == i) {
                random = ran.nextInt(inMetadata.size());
            }
            metadata.add(inMetadata.get(random).getWord());
            random = ran.nextInt(inMetadata.size());
        }

        random = ran.nextInt(inArticles.size());
        for(int random1 = ran.nextInt( 5) + 1; random1 > 0; random1--){
            while (random == i) {
                random = ran.nextInt(inArticles.size());
            }
            bibliography.add(inArticles.get(random).getKey());
            random = ran.nextInt(inArticles.size());
        }

        return new Articles(id, title, article_abstract, authors, metadata, journal, sections, bibliography);
    }
}