package com.makunpeng.matrix.post.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.SqlResultSetMapping;
import java.util.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostInfoDTO {
    private Long id;
    private Long pid;
    private Long uid;
    private String title;
    private String summary;
    private Timestamp ctime;
    private Timestamp mtime;
}
