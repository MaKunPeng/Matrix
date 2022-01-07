package com.makunpeng.matrix.interfaces.post.command;

import lombok.Data;

/**
 * 文章更新命令
 * @author MaKunPeng
 * @version 1.0
 * @since 1.0
 **/
@Data
public class PostUpdateCommand {
    private Long pid;
    private String title;
    private String summary;
    private String content;
}
