package com.makunpeng.matrix.infra.post.persistence.assembler;

import com.makunpeng.matrix.domain.post.entity.PostBody;
import com.makunpeng.matrix.domain.post.entity.PostBodyId;
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
                command.getPid(),
                command.getContent());
    }

    public PostBodyDO entityToPostBodyDO(PostBody postBody) {
        return new PostBodyDO(
                postBody.getPostBodyId().getId(),
                postBody.getPid(),
                postBody.getContent());
    }
}
