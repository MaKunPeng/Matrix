package com.makunpeng.matrix.app.persistence.post;

import com.makunpeng.matrix.app.domain.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * post_info 表数据接口
 * @author MaKunPeng
 */
public interface PostInfoDAO extends JpaRepository<PostInfoDO, Long> {
    List<PostInfoDO> findByUid();
    List<Post> findByPid();
}
