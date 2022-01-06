package com.makunpeng.matrix.post.domain.post.aggregate;

import com.makunpeng.matrix.post.common.ddd.Entity;
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
