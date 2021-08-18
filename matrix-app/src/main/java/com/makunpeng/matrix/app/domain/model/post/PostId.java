package com.makunpeng.matrix.app.domain.model.post;

import com.makunpeng.matrix.common.ddd.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public final class PostId implements ValueObject<PostId> {
    private Long id;
}
