package com.makunpeng.matrix.domain.post.factory.impl;

import com.makunpeng.matrix.domain.post.aggregate.Post;
import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.domain.post.factory.PostFactory;
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
