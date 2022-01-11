package com.makunpeng.matrix.domain.post.entity;

import com.makunpeng.matrix.common.ddd.Entity;
import lombok.*;

import java.sql.Timestamp;

/**
 * @author Aaron Ma
 * @version 1.0
 * @since 1.0
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostInfo implements Entity<PostInfoId> {
    private PostInfoId postId;
    private Long pid;
    private Long uid;
    private String title;
    private String summary;
    private Timestamp ctime;
    private Timestamp mtime;
}
