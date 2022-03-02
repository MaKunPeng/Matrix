package com.makunpeng.matrix.interfaces.post.api.dto;

import lombok.*;

import java.util.List;

/**
 * 通用分页返回对象
 * @author Aaron Ma
 * @version 1.0
 * @since 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonPageResultDTO<T> {
    private Long totalItems;
    private Integer totalPages;
    private Integer pageSize;
    private Integer currentPage;
    private List<T> pageItems;
}
