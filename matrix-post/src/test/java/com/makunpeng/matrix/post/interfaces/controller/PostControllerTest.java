package com.makunpeng.matrix.post.interfaces.controller;

import com.makunpeng.matrix.post.common.api.ResponseResult;
import com.makunpeng.matrix.post.interfaces.command.PostPublishCommand;
import com.makunpeng.matrix.post.interfaces.command.PostUpdateCommand;
import com.makunpeng.matrix.post.interfaces.dto.PostInfoDTO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * PostController 单元测试
 * @author Aaron Ma
 */
@SpringBootTest
class PostControllerTest {
    @Autowired
    private PostController postController;

    private static Logger logger = LoggerFactory.getLogger(PostControllerTest.class);

    @Test
    void publish() {
        PostPublishCommand postPublishCommand = new PostPublishCommand();
        postPublishCommand.setUid(2L);
        postPublishCommand.setTitle("Test");
        postPublishCommand.setSummary("Test publish");
        postPublishCommand.setContent("# Test");
        ResponseResult<PostInfoDTO> result = postController.publish(postPublishCommand);
        logger.info("文章发布成功{}", result);
    }

    @Test
    void update() {
        PostUpdateCommand postUpdateCommand = new PostUpdateCommand();
        postUpdateCommand.setPid(1L);
        postUpdateCommand.setContent("Test update");

        ResponseResult result = postController.update(postUpdateCommand);
        logger.info("文章更新成功");
    }

    @Test
    void getPostDetails() {
        postController.getPostDetails(null);
    }

    @Test
    void listPostInfo() {
        postController.listPostInfo(null);
    }
}