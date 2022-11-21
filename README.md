# MongoDBArticlesAdder

## Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

##How project works
This project uses the functionalities of Spring MongoDB to populate a Mongo database with json created using java object. In particular, this project creates mock Articles, created starting from existing articles published in [DBLP.org](https://dblp.org/), forming structured Json with Authors, Sections and the corresponding Journal where the article is published.

###API exposed
When starting the project, it tries to open a port on localhost at 8095, so please be sure it is free and accessible. When you want to access the API, the first part is `http://localhost:8095/rest/users/`:
* POST METHODS:
    * `/addArticles`: add to the app a json array with malformed json of mock articles
    * `/addAuthors`: add to the app a json array with malformed json of mock authors
    * `/addMetadata`: add to the app a json array with malformed json of scientific words
    * `/addSections`: add to the app a json array with malformed json of possible sections of an articles
* GET METHODS:
    * `/articles`: return the list of malformed articles
    * `/authors`: return the list of malformed authors
    * `/metadata`: return the list of scientific words
    * `/sections`: return the list of malformed sections
    * `/postOne/{id}`: it takes the _{id}_ element of the articles list and create a new json document with mock elements or previously inserted data and saves it on the MONGODB database.
    * `/postAll`: it takes the whole list of articles and create json documents with mock elements or previously inserted data and saves them all on the MONGODB database.
