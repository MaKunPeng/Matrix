package com.makunpeng.matrix.interfaces.post.api.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章详情DTO
 * @author Aaron Ma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailsDTO {
    private Long pid;
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    private PostInfoDTO postInfoDTO;
    private String content;
}
