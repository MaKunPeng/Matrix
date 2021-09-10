package com.makunpeng.matrix.app.infra.persistence.sql.post.impl;

import com.makunpeng.matrix.app.domain.model.post.Post;
import com.makunpeng.matrix.app.domain.repository.PostRepository;
import com.makunpeng.matrix.app.infra.persistence.sql.post.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Post 领域数据服务实现
 *
 * @author MaKunPeng
 * @date 2021-8-17
 */
@Repository
public class PostRepositoryImpl implements PostRepository {
    private PostInfoDAO postInfoDAO;
    private PostBodyDAO postBodyDAO;
    private PostDataConverter converter = PostDataConverter.INSTATNCE;

    @Autowired
    public PostRepositoryImpl(PostInfoDAO postInfoDAO, PostBodyDAO postBodyDAO) {
        this.postInfoDAO = postInfoDAO;
        this.postBodyDAO = postBodyDAO;
    }

    /**
     * 根据文章id查询文章
     *
     * @param pid
     * @return
     */
    @Override
    public Post findPost(Long pid) {
        PostInfoDO postInfoDO = this.postInfoDAO.findByPid(pid);
        if (postInfoDO == null) {
            return null;
        }
        PostBodyDO postBodyDO = this.postBodyDAO.findByPid(pid);

        return converter.toPost(postInfoDO, postBodyDO);
    }

    @Override
    public Post save(Post post) {
        return null;
    }

}
