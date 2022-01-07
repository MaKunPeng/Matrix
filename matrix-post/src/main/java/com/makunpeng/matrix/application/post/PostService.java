package com.makunpeng.matrix.application.post;

import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.interfaces.post.command.PostUpdateCommand;
import com.makunpeng.matrix.domain.post.aggregate.Post;

public interface PostService {
    Post publish(PostPublishCommand command);

    void update(PostUpdateCommand command);
}
