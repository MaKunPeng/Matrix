package com.makunpeng.matrix.app.application.impl;

import com.makunpeng.matrix.app.application.PostService;
import com.makunpeng.matrix.app.domain.post.aggregate.Post;
import com.makunpeng.matrix.app.domain.post.factory.PostFactory;
import com.makunpeng.matrix.app.domain.post.repository.PostRepository;
import com.makunpeng.matrix.app.infra.persistence.post.assembler.PostInfoAssembler;
import com.makunpeng.matrix.app.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.app.interfaces.post.command.PostUpdateCommand;
import com.makunpeng.matrix.app.interfaces.post.dto.PostDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostFactory postFactory;

    @Override
    public Post publish(PostPublishCommand command) {
        Post post = postFactory.createPost(command);
        Post savedPost = postRepository.savePost(post);
        return savedPost;
    }

    @Override
    public void update(PostUpdateCommand command) {

    }
}
