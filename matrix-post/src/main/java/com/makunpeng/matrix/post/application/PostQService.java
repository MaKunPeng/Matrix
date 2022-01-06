package com.makunpeng.matrix.post.application;

import com.makunpeng.matrix.post.interfaces.dto.PostInfoDTO;
import com.makunpeng.matrix.post.interfaces.query.PostInfoListQuery;
import org.springframework.data.domain.Page;

public interface PostQService {
    Page<PostInfoDTO> listPostInfo(PostInfoListQuery query);
}
