package com.makunpeng.matrix.app.infra.persistence.post.assembler;

import com.makunpeng.matrix.app.domain.post.aggregate.PostInfo;
import com.makunpeng.matrix.app.domain.post.aggregate.PostInfoId;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostInfoDO;
import com.makunpeng.matrix.app.interfaces.post.dto.PostInfoDTO;
import org.springframework.stereotype.Component;

/**
 * 文章信息转换
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Component
public class PostInfoAssembler {
    public PostInfo doToEntity(PostInfoDO postInfoDO) {
        return new PostInfo(
                new PostInfoId(postInfoDO.getId()),
                postInfoDO.getPid(),
                postInfoDO.getUid(),
                postInfoDO.getTitle(),
                postInfoDO.getSummary(),
                postInfoDO.getCtime(),
                postInfoDO.getMtime()
        );
    }

    public PostInfoDO entityToPostInfoDO(PostInfo postInfo) {
        return new PostInfoDO(
                postInfo.getPostId().getId(),
                postInfo.getPid(),
                postInfo.getUid(),
                postInfo.getTitle(),
                postInfo.getSummary()
        );
    }

    public PostInfoDTO entityToPostInfoDTO(PostInfo postInfo) {
        PostInfoDTO postInfoDTO = new PostInfoDTO();
        postInfoDTO.setPid(postInfo.getPid());
        postInfoDTO.setTitle(postInfo.getTitle());
        postInfoDTO.setSummary(postInfo.getSummary());
        postInfoDTO.setCtime(postInfo.getCtime());
        postInfoDTO.setMtime(postInfo.getMtime());
        return postInfoDTO;
    }
}
