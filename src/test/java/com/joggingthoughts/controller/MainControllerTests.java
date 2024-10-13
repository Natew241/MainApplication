package com.joggingthoughts.controller;

import com.joggingthoughts.MainApplication;
import com.joggingthoughts.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;


@WebMvcTest(controllers = MainController.class)
@Import(MainApplication.class)
public class MainControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MainService mainService;

    @Test
    void home_ShouldReturnHelloWorldAndStatus200() throws Exception {
        String expected = "Hello World";
        when(mainService.returnMessage()).thenReturn(expected);
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(result -> assertThat(result.getResponse().getContentAsString()).isEqualTo(expected));
    }
}

