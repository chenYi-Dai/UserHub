package com.yichen.userhub.tc;

import com.yichen.userhub.TestApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

@SpringBootTest(classes = TestApplication.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class AbstractTC {

    @SpringBootApplication
    static class InnerConfig { }

    @Resource
    protected MockMvc mockMvc;

    protected TestInfo testInfo;

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        this.testInfo = testInfo;
    }


    @BeforeAll
    static void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//        // this must be called for the @Mock annotations above to be processed.
//        MockitoAnnotations.openMocks(getClass());
//        try {
//            Thread.sleep(30 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


}
