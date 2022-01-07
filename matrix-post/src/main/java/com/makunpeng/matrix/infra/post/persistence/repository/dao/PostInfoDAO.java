package com.makunpeng.matrix.infra.post.persistence.repository.dao;

import com.makunpeng.matrix.infra.post.persistence.d.PostInfoDO;
import com.makunpeng.matrix.interfaces.post.dto.PostInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
public interface PostInfoDAO extends JpaRepository<PostInfoDO, Long> {
    PostInfoDO findByPid(Long pid);
}
