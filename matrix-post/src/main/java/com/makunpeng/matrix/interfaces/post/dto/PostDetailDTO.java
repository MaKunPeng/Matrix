package com.makunpeng.matrix.interfaces.post.dto;

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
