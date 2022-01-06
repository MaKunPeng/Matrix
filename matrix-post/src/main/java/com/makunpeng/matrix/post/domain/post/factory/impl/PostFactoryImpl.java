package com.makunpeng.matrix.post.domain.post.factory.impl;

import com.makunpeng.matrix.post.domain.post.aggregate.Post;
import com.makunpeng.matrix.post.domain.post.factory.PostFactory;
import com.makunpeng.matrix.post.interfaces.command.PostPublishCommand;
import org.springframework.stereotype.Service;

/**
 * @author Aaron Ma
 * @since 1.0
 */
@Service
public class PostFactoryImpl implements PostFactory {

    @Override
    public Post createPost(PostPublishCommand command) {
        return null;
    }
}
