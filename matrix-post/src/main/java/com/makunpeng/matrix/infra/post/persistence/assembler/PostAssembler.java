package com.makunpeng.matrix.infra.post.persistence.assembler;

import com.makunpeng.matrix.domain.post.aggregate.Post;
import com.makunpeng.matrix.domain.post.entity.PostBody;
import com.makunpeng.matrix.domain.post.entity.PostInfo;
import com.makunpeng.matrix.infra.post.persistence.d.PostBodyDO;
import com.makunpeng.matrix.infra.post.persistence.d.PostInfoDO;
import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    /**
     * 根据发布命令组装领域对象
     * @param command 发布命令
     * @return Post领域对象
     */
    public Post dtoToPost(PostPublishCommand command) {
        Post post = new Post();
        // 设置文章编码
        String value = String.valueOf(System.currentTimeMillis());
        String substring = value.substring(value.length() - 8);
        long nextLong = Long.parseLong(substring);
        command.setPid(nextLong);

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
