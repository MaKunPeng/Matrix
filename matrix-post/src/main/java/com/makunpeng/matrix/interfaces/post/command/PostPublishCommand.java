package com.makunpeng.matrix.interfaces.post.command;

import lombok.Data;

import javax.annotation.Nullable;

/**
 * 文章发布命令
 * @author Aaron Ma
 * @version 1.0
 * @since 1.0
 **/
@Data
public class PostPublishCommand {
    private Long uid;
    @Nullable
    private Long pid;
    private String title;
    private String summary;
    private String content;
}
