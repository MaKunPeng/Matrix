package com.makunpeng.matrix.app.application;

import com.makunpeng.matrix.app.interfaces.post.dto.PostInfoDTO;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoListQuery;
import org.springframework.data.domain.Page;

public interface PostQService {
    Page<PostInfoDTO> listPostInfo(PostInfoListQuery query);
}
