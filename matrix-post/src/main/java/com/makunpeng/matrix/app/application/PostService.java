package com.makunpeng.matrix.app.application;

import com.makunpeng.matrix.app.domain.post.aggregate.Post;
import com.makunpeng.matrix.app.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.app.interfaces.post.command.PostUpdateCommand;

public interface PostService {
    Post publish(PostPublishCommand command);

    void update(PostUpdateCommand command);
}
