package com.makunpeng.matrix.application.post;

import com.makunpeng.matrix.interfaces.post.api.dto.CommonPageResultDTO;
import com.makunpeng.matrix.interfaces.post.api.dto.PostDetailsDTO;
import com.makunpeng.matrix.interfaces.post.api.dto.PostInfoDTO;
import com.makunpeng.matrix.interfaces.post.query.PostInfoListQuery;

import java.util.List;

/**
 * 文章查询服务接口，独立于领域模型
 *
 * @author Aaron Ma
 * @since 1.0
 */
public interface PostQService {
    CommonPageResultDTO<PostInfoDTO> listPostInfo(PostInfoListQuery query);

    PostDetailsDTO getPostDetails(Long pid);
}
