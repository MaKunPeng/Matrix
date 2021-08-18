package com.makunpeng.matrix.app.infra.persistence.sql.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * post_info 表数据接口
 * @author MaKunPeng
 */
public interface PostInfoDAO extends JpaRepository<PostInfoDO, Long> {
    List<PostInfoDO> findByUid(Long uid);
    PostInfoDO findByPid(Long pid);
}
