package com.makunpeng.matrix.app.persistence.post.impl;

import com.makunpeng.matrix.app.domain.model.post.Post;
import com.makunpeng.matrix.app.domain.repository.PostRepository;
import com.makunpeng.matrix.app.persistence.post.PostBodyDAO;
import com.makunpeng.matrix.app.persistence.post.PostInfoDAO;
import com.makunpeng.matrix.app.persistence.post.PostInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Post 领域数据服务实现
 * @author MaKunPeng
 * @date 2021-8-17
 */
@Repository
public class PostRepositoryImpl implements PostRepository {
    private PostInfoDAO postInfoDAO;
    private PostBodyDAO postBodyDAO;

    @Autowired
    public PostRepositoryImpl(PostInfoDAO postInfoDAO, PostBodyDAO postBodyDAO) {
        this.postInfoDAO = postInfoDAO;
        this.postBodyDAO = postBodyDAO;
    }

    /**
     * 查询文章
     * @param pid
     * @return
     */
    @Override
    public Post findPost(Long pid) {
        List<PostInfoDO> postInfoDOs = this.postInfoDAO.findByUid();

        return null;
    }
}
