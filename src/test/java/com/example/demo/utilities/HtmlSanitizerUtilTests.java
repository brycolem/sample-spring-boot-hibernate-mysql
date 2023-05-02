package com.example.demo.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HtmlSanitizerUtilTests {

    @Test
    public void testClassDefinition() {
        HtmlSanitizerUtil utilInstance = new HtmlSanitizerUtil();
        assertNotNull(utilInstance);
    }
    
    @Test
    public void testSanitizeNoChange() {
        String inputHtml = "<h1>Test HTML</h1><p><a href=\"#\" rel=\"nofollow\">Test link</a></p>";
        String outputHtml = HtmlSanitizerUtil.sanitize(inputHtml);
        assertEquals(inputHtml, outputHtml);
    }

     @Test
    public void testSanitizeChange() {
        String inputHtml = "<html><head></head><h1>Test HTML</h1><p><a href=\"#\" rel=\"nofollow\">Test link</a></p></html>";
        String outputHtml = HtmlSanitizerUtil.sanitize(inputHtml);
        System.out.println(inputHtml);
        System.out.println(outputHtml);
        assertNotEquals(inputHtml, outputHtml);
    }
}
