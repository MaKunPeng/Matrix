package com.makunpeng.matrix.app.domain.model.post;

import com.makunpeng.matrix.common.ddd.Entity;
import com.makunpeng.matrix.common.ddd.EntityState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 文章内容
 * @author MaKunPeng
 * @since 1.0
 */
@Setter
@Getter
@AllArgsConstructor
public class PostBody implements Entity<PostBody> {
    private Long id;
    private Long pid;
    private String content;
    private EntityState state;
}
