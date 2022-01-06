package com.makunpeng.matrix.post.application;

import com.makunpeng.matrix.post.domain.post.aggregate.Post;
import com.makunpeng.matrix.post.interfaces.command.PostPublishCommand;
import com.makunpeng.matrix.post.interfaces.command.PostUpdateCommand;

public interface PostService {
    Post publish(PostPublishCommand command);

    void update(PostUpdateCommand command);
}
