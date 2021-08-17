package com.makunpeng.matrix.app.persistence.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "post_info")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostInfoDO {
    @Id
    private Long id;
    private Long pid;
    private Long uid;
    private String title;
    private String summary;
    private Integer commentCounts;
    private Integer likesCounts;
    private Timestamp ctime;
    private Timestamp mtime;
}
