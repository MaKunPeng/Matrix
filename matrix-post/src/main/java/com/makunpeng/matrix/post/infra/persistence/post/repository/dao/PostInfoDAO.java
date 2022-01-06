package com.makunpeng.matrix.post.infra.persistence.post.repository.dao;

import com.makunpeng.matrix.post.infra.persistence.post.d.PostInfoDO;
import com.makunpeng.matrix.post.interfaces.dto.PostInfoDTO;
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
     * 分页页号是从第0页开始
     * @param uid
     * @param pageable
     * @return
     */
    @Query(value = "select new com.makunpeng.matrix.post.interfaces.dto.PostInfoDTO" +
            "(pi.id, pi.pid, pi.uid, pi.title, pi.summary, pi.ctime, pi.mtime)" +
            " from PostInfoDO pi where pi.uid = :uid",
            countQuery = "select count(pi.id) from post_info pi where pi.uid = :uid")
    Page<PostInfoDTO> findPostInfosByUid(@Param("uid") Long uid, Pageable pageable);
}
