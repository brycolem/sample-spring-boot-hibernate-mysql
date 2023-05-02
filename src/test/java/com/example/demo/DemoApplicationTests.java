package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private DemoApplication application;

    @Test
    public void contextLoads() {
        assertThat(application).isNotNull();
    }

	@Test
	public void mainLoads() {
		assertThatCode(() -> DemoApplication.main(new String[]{})).doesNotThrowAnyException();
	}
}
