package com.joggingthoughts.service;

import com.joggingthoughts.repository.MainRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MainServiceTests {

    @MockBean
    private MainRepository mainRepository;

    @Autowired
    private MainService mainService;

    @Test
    void testMessage(){
        String expected = "Hello World";
        when(mainRepository.getHelloMessage()).thenReturn(expected);
        String actual = mainService.returnMessage();
        assertThat(actual).isEqualTo(expected);
    }


}
