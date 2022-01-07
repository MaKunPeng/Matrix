package com.makunpeng.matrix.application.post.impl;

import com.makunpeng.matrix.domain.post.aggregate.PostBody;
import com.makunpeng.matrix.domain.post.aggregate.PostInfo;
import com.makunpeng.matrix.domain.post.repository.PostRepository;
import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.interfaces.post.command.PostUpdateCommand;
import com.makunpeng.matrix.application.post.PostService;
import com.makunpeng.matrix.domain.post.aggregate.Post;
import com.makunpeng.matrix.infra.post.persistence.assembler.PostAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostAssembler postAssembler;

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
}
