package com.makunpeng.matrix.app.infra.persistence.post.repository.dao;

import com.makunpeng.matrix.app.infra.persistence.post.d.PostBodyDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
public interface PostBodyDAO extends JpaRepository<PostBodyDO, Long> {
    PostBodyDO findByPid(Long pid);
}
