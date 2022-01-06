package com.makunpeng.matrix.post.domain.post.factory;

import com.makunpeng.matrix.post.domain.post.aggregate.Post;
import com.makunpeng.matrix.post.interfaces.command.PostPublishCommand;

/**
 * @author Aaron Ma
 * @since 1.0
 */
public interface PostFactory {
    public Post createPost(PostPublishCommand command);
}
