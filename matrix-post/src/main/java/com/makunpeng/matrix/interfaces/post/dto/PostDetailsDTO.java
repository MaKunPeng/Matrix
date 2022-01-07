package com.makunpeng.matrix.interfaces.post.dto;

import lombok.Data;

/**
 * 文章详情DTO
 * @author Aaron Ma
 */
@Data
public class PostDetailsDTO {
    private Long pid;
    private PostInfoDTO postInfoDTO;
    private String content;
}
