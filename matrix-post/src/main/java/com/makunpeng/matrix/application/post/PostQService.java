package com.makunpeng.matrix.application.post;

import com.makunpeng.matrix.interfaces.post.dto.PostInfoDTO;
import com.makunpeng.matrix.interfaces.post.query.PostInfoListQuery;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostQService {
    List<PostInfoDTO> listPostInfo(PostInfoListQuery query);
}
