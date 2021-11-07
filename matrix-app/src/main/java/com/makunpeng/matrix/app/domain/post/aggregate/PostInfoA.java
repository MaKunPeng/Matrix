package com.makunpeng.matrix.app.domain.post.aggregate;

import lombok.*;

import java.sql.Timestamp;

/**
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostInfoA {
    private PostInfoId postId;
    private Long id;
    private Long uid;
    private String title;
    private String summary;
    private PostBodyA postBody;
    private Timestamp ctime;
    private Timestamp mtime;
}
