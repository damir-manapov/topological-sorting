package ru.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;
import ru.app.TestConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestConfig.class)
@Test(groups = "units")
@ActiveProfiles("units")
public class TestRestControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext context;

    @Test
    public void testBlankStub() throws Exception {

        MockMvc mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        mockMvc.perform(get("/blank"))
                .andExpect(status().isOk())
                .andExpect(content().string("blank"));

    }

    @Test
    public void testBlankStubWithParam() throws Exception {

        MockMvc mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        mockMvc.perform(get("/blank/testParam/read"))
                .andExpect(status().isOk())
                .andExpect(content().string("testEntity = TestEntity(name=testParam)"));

    }

}