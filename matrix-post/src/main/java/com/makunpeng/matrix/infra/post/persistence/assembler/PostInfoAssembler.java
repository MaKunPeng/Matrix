package com.makunpeng.matrix.infra.post.persistence.assembler;

import com.makunpeng.matrix.domain.post.entity.PostInfo;
import com.makunpeng.matrix.domain.post.entity.PostInfoId;
import com.makunpeng.matrix.infra.post.persistence.d.PostInfoDO;
import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.interfaces.post.dto.PostInfoDTO;
import org.springframework.stereotype.Component;

/**
 * 文章信息转换
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Component
public class PostInfoAssembler {
    public PostInfo doToPostInfo(PostInfoDO postInfoDO) {
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

    /**
     * 发布命令DTO转为实体
     * @param command 发布命令
     * @return
     */
    public PostInfo dtoToPostInfo(PostPublishCommand command) {
        return new PostInfo(
                new PostInfoId(null),
                command.getPid(),
                command.getUid(),
                command.getTitle(),
                command.getSummary(),
                null,
                null
        );
    }

    public PostInfoDO entityToPostInfoDO(PostInfo postInfo) {
        PostInfoDO postInfoDO = new PostInfoDO(
                postInfo.getPostId().getId(),
                postInfo.getPid(),
                postInfo.getUid(),
                postInfo.getTitle(),
                postInfo.getSummary()
        );
        return postInfoDO;
    }

    public PostInfoDTO entityToPostInfoDTO(PostInfo postInfo) {
        PostInfoDTO postInfoDTO = new PostInfoDTO();
        postInfoDTO.setUid(postInfo.getUid());
        postInfoDTO.setPid(postInfo.getPid());
        postInfoDTO.setTitle(postInfo.getTitle());
        postInfoDTO.setSummary(postInfo.getSummary());
        postInfoDTO.setCtime(postInfo.getCtime());
        postInfoDTO.setMtime(postInfo.getMtime());
        return postInfoDTO;
    }
}
