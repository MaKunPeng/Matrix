package com.makunpeng.matrix.app.infra.persistence.post.assembler;

import com.makunpeng.matrix.app.domain.post.aggregate.PostBodyA;
import com.makunpeng.matrix.app.domain.post.aggregate.PostBodyId;
import com.makunpeng.matrix.app.domain.post.aggregate.PostInfoId;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostBodyDO;
import org.springframework.stereotype.Component;

/**
 * 文章内容转换
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Component
public class PostBodyAssembler {
    public PostBodyA dbToPostBodyA(PostBodyDO postBodyDO) {
        return new PostBodyA(
                new PostBodyId(),
                new PostInfoId(),
                postBodyDO.getContent());
    }

    public PostBodyDO entityToPostBodyDO(PostBodyA postBodyA) {
        return new PostBodyDO(
                postBodyA.getPostBodyId().getId(),
                postBodyA.getPostInfoId().getId(),
                postBodyA.getContent());
    }
}
