package com.example.demo.services;

import com.example.demo.models.Article;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.utilities.HtmlSanitizerUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Optional<Article> createArticle(Article article) {
        article.setText(HtmlSanitizerUtil.sanitize(article.getText()));
        return Optional.of(articleRepository.save(article));
    }

    @Override
    public Optional<Article> getArticle(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> updateArticle(Long id, Article article) {
        article.setText(HtmlSanitizerUtil.sanitize(article.getText()));
        return articleRepository.findById(id).map(existingArticle -> {
            existingArticle.setTitle(article.getTitle());
            existingArticle.setText(article.getText());
            return articleRepository.save(existingArticle);
        });
    }

    @Override
    public Optional<Void> deleteArticle(Long id) {
        articleRepository.deleteById(id);
        return Optional.empty();
    }
}
