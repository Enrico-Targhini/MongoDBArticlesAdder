package com.example.demo.repository;

import com.example.demo.document.Articles;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticlesRepository extends MongoRepository<Articles, Integer> {
}