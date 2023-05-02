package com.example.demo.controllers;

import com.example.demo.models.Article;
import com.example.demo.services.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    ArticleController articleController;

    @MockBean
    private ArticleService articleService;

    @Test
    public void testGetAllArticles() throws Exception {
        Article article = new Article(1L, "Text", new Date(), "Title");
        when(articleService.getAllArticles()).thenReturn(Arrays.asList(article));

        mockMvc.perform(get("/api/v1/article"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(article))));

        verify(articleService, times(1)).getAllArticles();
    }

    @Test
    public void testGetArticle() throws Exception {
        Article article = new Article(1L, "Text", new Date(), "Title");
        when(articleService.getArticle(1L)).thenReturn(Optional.of(article));

        mockMvc.perform(get("/api/v1/article/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(article)));

        verify(articleService, times(1)).getArticle(1L);
    }

    @Test
    public void testGetArticleNotFound() throws Exception {
        when(articleService.getArticle(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/article/1"))
                .andExpect(status().isNotFound());

        verify(articleService, times(1)).getArticle(1L);
    }

    @Test
    public void testCreateArticle() throws Exception {
        Article article = new Article(1L, "Text", new Date(), "Title");
        when(articleService.createArticle(any(Article.class))).thenReturn(Optional.of(article));

        mockMvc.perform(post("/api/v1/article")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(article)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(article)));

        verify(articleService, times(1)).createArticle(any(Article.class));
    }

    @Test
    public void testCreateArticleFailure() throws Exception {
        Article inputArticle = new Article();
        inputArticle.setTitle("Test Title");
        inputArticle.setText("Test Text");

        when(articleService.createArticle(any(Article.class))).thenReturn(Optional.empty());

        mockMvc.perform(post("/api/v1/article")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputArticle)))
                .andExpect(status().isInternalServerError());

        verify(articleService, times(1)).createArticle(eq(inputArticle));
    }

    @Test
    public void testUpdateArticle() throws Exception {
        Article originalArticle = new Article(1L, "Text", new Date(), "Title");
        Article updatedArticle = new Article(1L, "Updated Text", new Date(), "Updated Title");
        when(articleService.updateArticle(eq(1L), any(Article.class))).thenReturn(Optional.of(updatedArticle));

        mockMvc.perform(put("/api/v1/article/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedArticle)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedArticle)));

        verify(articleService, times(1)).updateArticle(eq(1L), any(Article.class));
    }

    @Test
    public void testUpdateArticleNotFound() throws Exception {
        Article updatedArticle = new Article(1L, "Updated Text", new Date(), "Updated Title");
        when(articleService.updateArticle(eq(1L), any(Article.class))).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/v1/article/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedArticle)))
                .andExpect(status().isNotFound());

        verify(articleService, times(1)).updateArticle(eq(1L), any(Article.class));
    }

    @Test
    public void testDeleteArticle() throws Exception {
        doReturn(null).when(articleService).deleteArticle(1L);

        mockMvc.perform(delete("/api/v1/article/1"))
                .andExpect(status().isNoContent());

        verify(articleService, times(1)).deleteArticle(1L);
    }

}
