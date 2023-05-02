package com.example.demo.models;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArticleTests {
    
    @Test
    public void testNoArgsConstructor() {
        Article article = new Article();
        assertNotNull(article);
    }

    @Test
    public void testAllArgsConstructor() {
        Date timestamp = new Date();
        Article article = new Article(1L, "Text", timestamp, "Title");

        assertNotNull(article);
        assertEquals(1L, article.getId());
        assertEquals("Text", article.getText());
        assertEquals(timestamp, article.getTimestamp());
        assertEquals("Title", article.getTitle());
    }

    @Test
    public void testSettersAndGetters() {
        Date timestamp = new Date();
        Article article = new Article();

        article.setId(1L);
        article.setText("Text");
        article.setTimestamp(timestamp);
        article.setTitle("Title");

        assertEquals(1L, article.getId());
        assertEquals("Text", article.getText());
        assertEquals(timestamp, article.getTimestamp());
        assertEquals("Title", article.getTitle());
    }
}
