package com.makunpeng.matrix.infra.post.persistence.repository.dao;

import com.makunpeng.matrix.infra.post.persistence.d.PostBodyDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostBodyDO 数据库对象JPA接口
 * @author MaKunPeng
 * @version 1.0
 * @since 1.0
 **/
public interface PostBodyDAO extends JpaRepository<PostBodyDO, Long> {

    PostBodyDO findByPid(Long pid);

    void deleteByPid(Long pid);
}
