package com.makunpeng.matrix.app.domain.post.aggregate;

import java.sql.Timestamp;

/**
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
public class PostBodyA {
    private PostBodyId postId;
    private PostInfoId postInfoId;
    private Long id;
    private Long pid;
    private String title;
    private String summary;
    private PostBodyA postBody;
    private Timestamp ctime;
    private Timestamp mtime;
}
