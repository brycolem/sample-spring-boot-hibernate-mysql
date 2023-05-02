import com.example.demo.models.Article;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.services.ArticleService;
import com.example.demo.services.ArticleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticleServiceImplTest {

    private ArticleRepository articleRepository;
    private ArticleService articleService;

    @BeforeEach
    void setUp() {
        articleRepository = Mockito.mock(ArticleRepository.class);
        articleService = new ArticleServiceImpl(articleRepository);
    }

    @Test
    void createArticle() {
        Article article = new Article(1L, "Text", new Date(), "Title");
        when(articleRepository.save(any(Article.class))).thenReturn(article);

        Optional<Article> createdArticle = articleService.createArticle(article);
        assertTrue(createdArticle.isPresent());
        assertEquals(article, createdArticle.get());
    }

    @Test
    void getArticle() {
        Article article = new Article(1L, "Text", new Date(), "Title");
        when(articleRepository.findById(1L)).thenReturn(Optional.of(article));

        Optional<Article> fetchedArticle = articleService.getArticle(1L);
        assertTrue(fetchedArticle.isPresent());
        assertEquals(article, fetchedArticle.get());
    }

    @Test
    void getAllArticles() {
        Article article1 = new Article(1L, "Text1", new Date(), "Title1");
        Article article2 = new Article(2L, "Text2", new Date(), "Title2");
        when(articleRepository.findAll()).thenReturn(Arrays.asList(article1, article2));

        List<Article> articles = articleService.getAllArticles();
        assertEquals(2, articles.size());
        assertEquals(article1, articles.get(0));
        assertEquals(article2, articles.get(1));
    }

    @Test
    void updateArticle() {
        Article existingArticle = new Article(1L, "Text1", new Date(), "Title1");
        Article updatedArticle = new Article(1L, "Updated Text", new Date(), "Updated Title");
        when(articleRepository.findById(1L)).thenReturn(Optional.of(existingArticle));
        when(articleRepository.save(any(Article.class))).thenReturn(updatedArticle);

        Optional<Article> resultArticle = articleService.updateArticle(1L, updatedArticle);
        assertTrue(resultArticle.isPresent());
        assertEquals(updatedArticle.getTitle(), resultArticle.get().getTitle());
        assertEquals(updatedArticle.getText(), resultArticle.get().getText());
    }

    @Test
    void deleteArticle() {
        Long id = 1L;
        doNothing().when(articleRepository).deleteById(id);

        Optional<Void> result = articleService.deleteArticle(id);
        assertTrue(result.isEmpty());
        verify(articleRepository, times(1)).deleteById(id);
    }
}
