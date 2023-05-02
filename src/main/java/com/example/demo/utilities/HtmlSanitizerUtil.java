package com.example.demo.utilities;

import org.owasp.html.Sanitizers;
import org.owasp.html.PolicyFactory;

public class HtmlSanitizerUtil {

    private static final PolicyFactory POLICY = Sanitizers.FORMATTING.and(Sanitizers.LINKS).and(Sanitizers.STYLES).and(Sanitizers.TABLES).and(Sanitizers.IMAGES).and(Sanitizers.BLOCKS);

    public static String sanitize(String html) {
        return POLICY.sanitize(html);
    }
}
