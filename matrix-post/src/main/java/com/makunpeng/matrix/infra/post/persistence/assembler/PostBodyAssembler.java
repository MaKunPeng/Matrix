package com.makunpeng.matrix.infra.post.persistence.assembler;

import com.makunpeng.matrix.domain.post.aggregate.PostBody;
import com.makunpeng.matrix.domain.post.aggregate.PostBodyId;
import com.makunpeng.matrix.infra.post.persistence.d.PostBodyDO;
import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;
import org.springframework.stereotype.Component;

/**
 * 文章内容转换
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Component
public class PostBodyAssembler {
    public PostBody doToPostBody(PostBodyDO postBodyDO) {
        return new PostBody(
                new PostBodyId(postBodyDO.getId()),
                postBodyDO.getPid(),
                postBodyDO.getContent());
    }

    public PostBody dtoToPostBody(PostPublishCommand command) {
        return new PostBody(
                new PostBodyId(null),
                null,
                command.getContent());
    }

    public PostBodyDO entityToPostBodyDO(PostBody postBody) {
        return new PostBodyDO(
                postBody.getPostBodyId().getId(),
                postBody.getPid(),
                postBody.getContent());
    }
}
