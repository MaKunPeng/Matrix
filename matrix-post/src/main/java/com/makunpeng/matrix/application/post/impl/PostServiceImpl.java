package com.makunpeng.matrix.application.post.impl;

import com.makunpeng.matrix.domain.post.entity.PostBody;
import com.makunpeng.matrix.domain.post.entity.PostInfo;
import com.makunpeng.matrix.domain.post.repository.PostRepository;
import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.interfaces.post.command.PostUpdateCommand;
import com.makunpeng.matrix.application.post.PostService;
import com.makunpeng.matrix.domain.post.aggregate.Post;
import com.makunpeng.matrix.infra.post.persistence.assembler.PostAssembler;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * Post 应用层实现
 *
 * @author Aaron Ma
 * @since 1.0
 */
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostAssembler postAssembler;

    public PostServiceImpl(PostRepository postRepository, PostAssembler postAssembler) {
        this.postRepository = postRepository;
        this.postAssembler = postAssembler;
    }

    @Override
    public Post publish(PostPublishCommand command) {
        Post post = postAssembler.dtoToPost(command);
        return postRepository.savePost(post);
    }

    @Override
    public void update(PostUpdateCommand command) {
        Post post = postRepository.findPost(command.getPid());
        PostBody postBody = post.getPostBody();
        PostInfo postInfo = post.getPostInfo();
        postBody.setContent(command.getContent());
        postInfo.setTitle(command.getTitle());
        postInfo.setSummary(command.getSummary());
        postRepository.savePost(post);
    }

    @Override
    public void delete(Long pid) {
        postRepository.deletePost(pid);
    }
}
