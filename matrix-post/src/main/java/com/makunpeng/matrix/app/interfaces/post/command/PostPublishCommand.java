package com.makunpeng.matrix.app.interfaces.post.command;

import lombok.Data;

/**
 * 文章发布命令
 * @author Aaron Ma
 * @version 1.0
 * @since 1.0
 **/
@Data
public class PostPublishCommand {
    private Long uid;
    private String title;
    private String summary;
    private String content;
}
