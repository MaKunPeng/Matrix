package com.makunpeng.matrix.post.infra.persistence.post.assembler;

import com.makunpeng.matrix.post.domain.post.aggregate.Post;
import com.makunpeng.matrix.post.domain.post.aggregate.PostBody;
import com.makunpeng.matrix.post.domain.post.aggregate.PostInfo;
import com.makunpeng.matrix.post.infra.persistence.post.d.PostBodyDO;
import com.makunpeng.matrix.post.infra.persistence.post.d.PostInfoDO;
import com.makunpeng.matrix.post.interfaces.command.PostPublishCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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
        Post post = new Post();
        post.setPostInfo(postInfoAssembler.dtoToPostInfo(command));
        post.setPostBody(postBodyAssembler.dtoToPostBody(command));
        return post;
    }

    public Post doToPost(@NotNull PostInfoDO postInfoDO, @NotNull PostBodyDO postBodyDO) {
        Objects.requireNonNull(postInfoDO, "文章信息不存在");
        Objects.requireNonNull(postBodyDO, "文章内容不存在");

        PostInfo postInfo = postInfoAssembler.doToPostInfo(postInfoDO);
        PostBody postBody = postBodyAssembler.doToPostBody(postBodyDO);
        Post post = new Post();
        post.setPostBody(postBody);
        post.setPostInfo(postInfo);
        post.setPid(postInfo.getPid());
        return post;
    }
}
