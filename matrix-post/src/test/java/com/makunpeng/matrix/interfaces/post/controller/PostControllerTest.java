package com.makunpeng.matrix.interfaces.post.controller;

import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.interfaces.post.command.PostUpdateCommand;
import org.junit.Ignore;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * PostController 单元测试
 * @author Aaron Ma
 */
@SpringBootTest
@AutoConfigureMockMvc
@Rollback
class PostControllerTest {
    @Autowired
    private PostController postController;
    @Autowired
    private MockMvc mockMvc;

    private static final Logger logger = LoggerFactory.getLogger(PostControllerTest.class);

    @Test
    void publish() {
        PostPublishCommand postPublishCommand = new PostPublishCommand();
        postPublishCommand.setUid(2L);
        postPublishCommand.setTitle("Test");
        postPublishCommand.setSummary("Test publish");
        postPublishCommand.setContent("# Test");
        postController.publish(postPublishCommand);
        logger.info("文章发布成功");
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/post/update")
                .content("{\"pid\":11,\"title\":10,\"summary\":1}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info("文章更新成功");
    }

    @Test
    void getPostDetails() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/post/details/72601489"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void listPostInfo() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/post/list")
                .content("{\"uid\":1,\"pageSize\":10,\"pageNumber\":1}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info(mvcResult.getResponse().getContentAsString());
    }
}