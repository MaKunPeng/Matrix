package com.makunpeng.matrix.app.interfaces.post.dto;

import lombok.Data;

/**
 * @author Aaron Ma
 */
@Data
public class PostDetailDTO {
    private Long pid;
    private PostInfoDTO postInfo;
    private String content;
}
