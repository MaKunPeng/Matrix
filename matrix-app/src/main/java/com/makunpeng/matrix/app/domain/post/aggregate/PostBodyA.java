package com.makunpeng.matrix.app.domain.post.aggregate;

import com.makunpeng.matrix.common.ddd.AggregateRoot;
import lombok.*;

import java.sql.Timestamp;

/**
 * 文章内容聚合
 * @author MaKunPeng
 * @version 1.0
 * @since 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class PostBodyA implements AggregateRoot<PostBodyId> {
    private PostBodyId postBodyId;
    private PostInfoId postInfoId;
    private String content;
}
