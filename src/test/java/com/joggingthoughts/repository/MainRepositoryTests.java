package com.joggingthoughts.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MainRepositoryTests {
    @Autowired
    private MainRepository mainRepository;

    @Test
    void testMessage(){
        String expected = "Hello World";
        String actual = mainRepository.getHelloMessage();
        assertThat(actual).isEqualTo(expected);
    }
}
