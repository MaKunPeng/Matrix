package com.makunpeng.matrix.infra.post.persistence.repository.dao;

import com.makunpeng.matrix.infra.post.persistence.d.PostInfoDO;
import com.makunpeng.matrix.interfaces.post.dto.PostInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * PostInfo 数据库对象JPA接口
 * @author MaKunPeng
 * @version 1.0
 * @since 1.0
 **/
public interface PostInfoDAO extends JpaRepository<PostInfoDO, Long> {

    PostInfoDO findByPid(Long pid);

    void deleteByPid(Long pid);
}
