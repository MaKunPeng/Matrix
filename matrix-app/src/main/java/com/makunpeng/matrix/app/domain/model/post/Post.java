package com.makunpeng.matrix.app.domain.model.post;

import com.makunpeng.matrix.common.ddd.AggregateRoot;
import com.makunpeng.matrix.common.ddd.Entity;
import lombok.*;

/**
 * Post 领域聚合根
 * @author MaKunPeng
 * @since 1.0
 * @date 2021/8/16
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post implements AggregateRoot<PostId> {
    private PostId postId;
    private Long uid;
    private String title;
    private String summary;
    private String content;
    private Integer commentCounts;
    private Integer likesCounts;

}