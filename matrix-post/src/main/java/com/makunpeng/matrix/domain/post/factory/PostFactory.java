package com.makunpeng.matrix.domain.post.factory;

import com.makunpeng.matrix.domain.post.aggregate.Post;
import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;

/**
 * @author Aaron Ma
 * @since 1.0
 */
public interface PostFactory {
    public Post createPost(PostPublishCommand command);
}
