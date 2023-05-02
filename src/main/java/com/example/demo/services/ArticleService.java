package com.example.demo.services;

import com.example.demo.models.Article;
import java.util.Optional;
import java.util.List;

public interface ArticleService {
    Optional<Article> createArticle(Article article);
    Optional<Article> getArticle(Long id);
    List<Article> getAllArticles();
    Optional<Article> updateArticle(Long id, Article article);
    Optional<Void> deleteArticle(Long id);
}
