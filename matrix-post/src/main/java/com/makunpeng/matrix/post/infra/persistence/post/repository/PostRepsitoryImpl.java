package com.makunpeng.matrix.post.infra.persistence.post.repository;

import com.makunpeng.matrix.post.domain.post.aggregate.Post;
import com.makunpeng.matrix.post.domain.post.aggregate.PostBody;
import com.makunpeng.matrix.post.domain.post.aggregate.PostInfo;
import com.makunpeng.matrix.post.domain.post.repository.PostRepository;
import com.makunpeng.matrix.post.infra.persistence.post.assembler.PostAssembler;
import com.makunpeng.matrix.post.infra.persistence.post.assembler.PostBodyAssembler;
import com.makunpeng.matrix.post.infra.persistence.post.assembler.PostInfoAssembler;
import com.makunpeng.matrix.post.infra.persistence.post.d.PostBodyDO;
import com.makunpeng.matrix.post.infra.persistence.post.d.PostInfoDO;
import com.makunpeng.matrix.post.infra.persistence.post.repository.dao.PostBodyDAO;
import com.makunpeng.matrix.post.infra.persistence.post.repository.dao.PostInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
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

    @Autowired
    public PostRepsitoryImpl(PostInfoDAO postInfoDAO, PostBodyDAO postBodyDAO, PostAssembler postAssembler, PostInfoAssembler postInfoAssembler, PostBodyAssembler postBodyAssembler) {
        this.postInfoDAO = postInfoDAO;
        this.postBodyDAO = postBodyDAO;
        this.postAssembler = postAssembler;
        this.postInfoAssembler = postInfoAssembler;
        this.postBodyAssembler = postBodyAssembler;
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
        // 设置文章编码
        if (Objects.isNull(postInfo.getPid())) {
            String value = String.valueOf(System.currentTimeMillis());
            String substring = value.substring(value.length() - 8);
            long nextLong = Long.valueOf(substring);
            postInfo.setPid(nextLong);
            postBody.setPid(nextLong);
        }
        PostInfoDO postInfoDO = postInfoAssembler.entityToPostInfoDO(postInfo);
        PostBodyDO postBodyDO = postBodyAssembler.entityToPostBodyDO(postBody);
        PostInfoDO savedPostInfoDO = postInfoDAO.save(postInfoDO);
        PostBodyDO savedPostBodyDO = postBodyDAO.save(postBodyDO);
        return postAssembler.doToPost(savedPostInfoDO, savedPostBodyDO);
    }
}
