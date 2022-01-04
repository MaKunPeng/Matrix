package com.makunpeng.matrix.app.domain.post.factory;

import com.makunpeng.matrix.app.domain.post.aggregate.Post;
import com.makunpeng.matrix.app.interfaces.post.command.PostPublishCommand;

/**
 * @author Aaron Ma
 * @since 1.0
 */
public interface PostFactory {
    public Post createPost(PostPublishCommand command);
}
