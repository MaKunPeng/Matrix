package com.makunpeng.matrix.app.infra.persistence.post.repository.dao;

import com.makunpeng.matrix.app.infra.persistence.post.d.PostInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
public interface PostInfoDAO extends JpaRepository<PostInfoDO, Long> {
    PostInfoDO findByPid(Long pid);
}
