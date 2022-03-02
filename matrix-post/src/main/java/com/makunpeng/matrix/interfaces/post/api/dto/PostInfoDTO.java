package com.makunpeng.matrix.interfaces.post.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.SqlResultSetMapping;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostInfoDTO {
    private Long id;
    private Long pid;
    private Long uid;
    private String title;
    private String summary;
    private List<String> tags;
    private Timestamp ctime;
    private Timestamp mtime;
}
