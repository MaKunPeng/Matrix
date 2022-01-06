package com.makunpeng.matrix.post.interfaces.dto;

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
