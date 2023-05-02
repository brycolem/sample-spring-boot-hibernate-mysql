package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.demo.models.Article;
import com.example.demo.services.ArticleService;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable("id") Long id) {
        Optional<Article> article = articleService.getArticle(id);
        if (article.isPresent()) {
            return new ResponseEntity<>(article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@Valid @RequestBody Article article) {
        Optional<Article> createdArticle = articleService.createArticle(article);
        return createdArticle.map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long id, @RequestBody Article updatedArticle) {
        Optional<Article> article = articleService.updateArticle(id, updatedArticle);
        if (article.isPresent()) {
            return new ResponseEntity<>(article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
