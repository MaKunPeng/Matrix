package com.makunpeng.matrix.app.domain.model.post;

import com.makunpeng.matrix.common.ddd.ValueObject;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostDesc implements ValueObject<PostDesc> {
    private Long pid;
    private Long uid;
    private String title;
    private String summary;
}
