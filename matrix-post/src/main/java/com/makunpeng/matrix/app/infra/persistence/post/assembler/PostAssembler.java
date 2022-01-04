package com.makunpeng.matrix.app.infra.persistence.post.assembler;

import com.makunpeng.matrix.app.domain.post.aggregate.Post;
import com.makunpeng.matrix.app.domain.post.aggregate.PostBody;
import com.makunpeng.matrix.app.domain.post.aggregate.PostInfo;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostBodyDO;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostInfoDO;
import com.makunpeng.matrix.app.interfaces.post.command.PostPublishCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Aaron Ma
 * @since 1.0
 */
@Component
public class PostAssembler {
    private PostInfoAssembler postInfoAssembler;
    private PostBodyAssembler postBodyAssembler;

    @Autowired
    public PostAssembler(PostInfoAssembler postInfoAssembler, PostBodyAssembler postBodyAssembler) {
        this.postInfoAssembler = postInfoAssembler;
        this.postBodyAssembler = postBodyAssembler;
    }

    public Post dtoToPost(PostPublishCommand command) {
        PostInfo postInfo = new PostInfo();
        postInfo.setTitle(command.getTitle());
        postInfo.setSummary(command.getSummary());

        PostBody postBody = new PostBody();
        postBody.setContent(command.getContent());

        Post post = new Post();
        post.setPostInfo(postInfo);
        post.setPostBody(postBody);
        return post;
    }

    public Post doToPost(PostInfoDO postInfoDO, PostBodyDO postBodyDO) {
        PostInfo postInfo = postInfoAssembler.doToEntity(postInfoDO);
        PostBody postBody = postBodyAssembler.doToEntity(postBodyDO);
        Post post = new Post();
        post.setPostBody(postBody);
        post.setPostInfo(postInfo);
        post.setId(postInfo.getPostId());
        return post;
    }
}
