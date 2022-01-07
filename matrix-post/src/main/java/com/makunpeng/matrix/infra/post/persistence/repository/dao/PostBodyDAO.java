package com.makunpeng.matrix.infra.post.persistence.repository.dao;

import com.makunpeng.matrix.infra.post.persistence.d.PostBodyDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
public interface PostBodyDAO extends JpaRepository<PostBodyDO, Long> {
    PostBodyDO findByPid(Long pid);
}
