package com.makunpeng.matrix.app.infra.persistence.sql.post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * post_body 数据表访问接口
 * @author MaKunPeng
 */
public interface PostBodyDAO extends JpaRepository<PostBodyDO, Long> {
    PostBodyDO findByPid(Long pid);
}
