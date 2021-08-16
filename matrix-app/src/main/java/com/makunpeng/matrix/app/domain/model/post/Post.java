package com.makunpeng.matrix.app.domain.model.post;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MaKunPeng
 * @version 1.0
 * @date 2021/8/16
 * @since
 **/
@Entity
@Table
public class Post {
    @Id
    private Long id;
    private Long postID;
    private Long authorID;
    private String title;
    private String summary;

}
