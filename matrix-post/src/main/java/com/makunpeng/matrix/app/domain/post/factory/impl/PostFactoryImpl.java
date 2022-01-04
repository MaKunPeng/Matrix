package com.makunpeng.matrix.app.domain.post.factory.impl;

import com.makunpeng.matrix.app.domain.post.aggregate.*;
import com.makunpeng.matrix.app.domain.post.factory.PostFactory;
import com.makunpeng.matrix.app.infra.persistence.post.assembler.PostAssembler;
import com.makunpeng.matrix.app.infra.persistence.util.SnowflakeKeyGenerator;
import com.makunpeng.matrix.app.interfaces.post.command.PostPublishCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Aaron Ma
 * @since 1.0
 */
@Service
public class PostFactoryImpl implements PostFactory {
    @Autowired
    private PostAssembler postAssembler;
    @Autowired
    private SnowflakeKeyGenerator snowflakeKeyGenerator;

    @Override
    public Post createPost(PostPublishCommand command) {
        Post post = postAssembler.dtoToPost(command);
        Long pid = createPid();
        // 设置主键
        PostInfo postInfo = post.getPostInfo();
        postInfo.setPid(pid);
        postInfo.setPostId(new PostInfoId(snowflakeKeyGenerator.generateKey()));

        PostBody postBody = post.getPostBody();
        postBody.setPostBodyId(new PostBodyId(snowflakeKeyGenerator.generateKey()));
        postBody.setPostInfoId(postInfo.getPostId());
        return post;
    }

    private Long createPid() {
        return 1L;
    }
}
