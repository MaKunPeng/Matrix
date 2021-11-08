package com.makunpeng.matrix.app.infra.persistence.post.assembler;

import com.makunpeng.matrix.app.domain.post.aggregate.PostInfoA;
import com.makunpeng.matrix.app.domain.post.aggregate.PostInfoId;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostInfoDO;
import org.springframework.stereotype.Component;

/**
 * 文章信息转换
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Component
public class PostInfoAssembler {
    public PostInfoA dbToPostInfoA(PostInfoDO postInfoDO) {
        return new PostInfoA(
                new PostInfoId(postInfoDO.getId()),
                postInfoDO.getPid(),
                postInfoDO.getUid(),
                postInfoDO.getTitle(),
                postInfoDO.getSummary(),
                postInfoDO.getCtime(),
                postInfoDO.getMtime()
        );
    }

    public PostInfoDO entityToPostInfoDO(PostInfoA postInfoA) {
        return new PostInfoDO(
                postInfoA.getPostId().getId(),
                postInfoA.getPid(),
                postInfoA.getUid(),
                postInfoA.getTitle(),
                postInfoA.getSummary()
        );
    }
}
