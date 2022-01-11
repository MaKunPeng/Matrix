package com.makunpeng.matrix.infra.post.persistence.repository;

import com.makunpeng.matrix.domain.post.aggregate.Post;
import com.makunpeng.matrix.domain.post.entity.PostBody;
import com.makunpeng.matrix.domain.post.entity.PostInfo;
import com.makunpeng.matrix.domain.post.repository.PostRepository;
import com.makunpeng.matrix.infra.post.persistence.assembler.PostAssembler;
import com.makunpeng.matrix.infra.post.persistence.assembler.PostBodyAssembler;
import com.makunpeng.matrix.infra.post.persistence.assembler.PostInfoAssembler;
import com.makunpeng.matrix.infra.post.persistence.d.PostBodyDO;
import com.makunpeng.matrix.infra.post.persistence.d.PostInfoDO;
import com.makunpeng.matrix.infra.post.persistence.repository.dao.PostBodyDAO;
import com.makunpeng.matrix.infra.post.persistence.repository.dao.PostInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Post 领域仓储服务实现
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Repository
public class PostRepsitoryImpl implements PostRepository {
    private PostInfoDAO postInfoDAO;
    private PostBodyDAO postBodyDAO;
    private PostAssembler postAssembler;
    private PostInfoAssembler postInfoAssembler;
    private PostBodyAssembler postBodyAssembler;
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public PostRepsitoryImpl(PostInfoDAO postInfoDAO, PostBodyDAO postBodyDAO, PostAssembler postAssembler, PostInfoAssembler postInfoAssembler, PostBodyAssembler postBodyAssembler, RedisTemplate redisTemplate) {
        this.postInfoDAO = postInfoDAO;
        this.postBodyDAO = postBodyDAO;
        this.postAssembler = postAssembler;
        this.postInfoAssembler = postInfoAssembler;
        this.postBodyAssembler = postBodyAssembler;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Post findPost(Long pid) {
        PostInfoDO postInfoDO = postInfoDAO.findByPid(pid);
        PostBodyDO postBodyDO = postBodyDAO.findByPid(pid);
        return postAssembler.doToPost(postInfoDO, postBodyDO);
    }

    @Override
    @Transactional
    public Post savePost(Post post) {
        PostInfo postInfo = post.getPostInfo();
        PostBody postBody = post.getPostBody();
        PostInfoDO postInfoDO = postInfoAssembler.entityToPostInfoDO(postInfo);
        PostBodyDO postBodyDO = postBodyAssembler.entityToPostBodyDO(postBody);
        PostInfoDO savedPostInfoDO = postInfoDAO.save(postInfoDO);
        PostBodyDO savedPostBodyDO = postBodyDAO.save(postBodyDO);
        return postAssembler.doToPost(savedPostInfoDO, savedPostBodyDO);
    }

    @Override
    @Transactional
    public void deletePost(Long pid) {
        Objects.requireNonNull(pid);
        postInfoDAO.deleteByPid(pid);
        postBodyDAO.deleteByPid(pid);
        redisTemplate.delete("post:details:" + pid);
    }
}
