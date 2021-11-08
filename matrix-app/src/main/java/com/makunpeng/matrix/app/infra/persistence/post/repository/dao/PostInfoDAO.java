package com.makunpeng.matrix.app.infra.persistence.post.repository.dao;

import com.makunpeng.matrix.app.infra.persistence.post.d.PostInfoDO;
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

    /**
     * 根据用户ID分页查询文章列表
     * @param uid
     * @param pageable
     * @return
     */
    @Query(value = "select pi.* from post_info pi where pi.uid = :uid",
            countQuery = "select count(*) from post_info pi where pi.uid = :uid",
            nativeQuery = true)
    Page<PostInfoDO> findPostInfosByUid(@Param("uid") String uid, Pageable pageable);
}
