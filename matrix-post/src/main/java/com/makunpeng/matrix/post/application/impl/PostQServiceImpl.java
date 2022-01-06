package com.makunpeng.matrix.post.application.impl;

import com.makunpeng.matrix.post.application.PostQService;
import com.makunpeng.matrix.post.infra.persistence.post.repository.dao.PostInfoDAO;
import com.makunpeng.matrix.post.interfaces.dto.PostInfoDTO;
import com.makunpeng.matrix.post.interfaces.query.PostInfoListQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Post DTO 查询服务实现
 *
 * @author Aaron Ma
 *
 */
@Service
public class PostQServiceImpl implements PostQService {
    private PostInfoDAO postInfoDAO;

    @Autowired
    public PostQServiceImpl(PostInfoDAO postInfoDAO) {
        this.postInfoDAO = postInfoDAO;
    }

    @Override
    public Page<PostInfoDTO> listPostInfo(PostInfoListQuery query) {
        Page<PostInfoDTO> postInfoPage = postInfoDAO.findPostInfosByUid(
                query.getUid(),
                PageRequest.of(query.getPageNumber(), query.getPageSize(), Sort.Direction.DESC, "ctime"));
        return postInfoPage;
    }
}
