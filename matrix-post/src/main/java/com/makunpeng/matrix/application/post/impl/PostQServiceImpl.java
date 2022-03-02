package com.makunpeng.matrix.application.post.impl;

import com.makunpeng.matrix.infra.post.persistence.d.PostInfoDO;
import com.makunpeng.matrix.infra.post.persistence.d.QPostBodyDO;
import com.makunpeng.matrix.infra.post.persistence.d.QPostInfoDO;
import com.makunpeng.matrix.infra.post.persistence.repository.dao.PostInfoDAO;
import com.makunpeng.matrix.interfaces.post.dto.PostDetailsDTO;
import com.makunpeng.matrix.interfaces.post.dto.PostInfoDTO;
import com.makunpeng.matrix.interfaces.post.query.PostInfoListQuery;
import com.makunpeng.matrix.application.post.PostQService;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Post DTO 查询服务实现
 *
 * @author Aaron Ma
 *
 */
@Service
@CacheConfig(cacheNames = "post")
public class PostQServiceImpl implements PostQService {
    private final JPAQueryFactory jpaQueryFactory;
    private final PostInfoDAO postInfoDAO;

    @Autowired
    public PostQServiceImpl(JPAQueryFactory jpaQueryFactory, PostInfoDAO postInfoDAO) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.postInfoDAO = postInfoDAO;
    }

    /**
     * 分页查询文章信息
     * @param query 参数
     * @return 某一页的文章信息列表
     */
    @Override
    public List<PostInfoDTO> listPostInfo(PostInfoListQuery query) {
        QPostInfoDO postInfoDO = QPostInfoDO.postInfoDO;
        List<PostInfoDTO> postInfoDOS = jpaQueryFactory
                .select(Projections.fields(PostInfoDTO.class, postInfoDO.id, postInfoDO.pid, postInfoDO.uid, postInfoDO.title,
                        postInfoDO.summary, postInfoDO.ctime, postInfoDO.mtime))
                .from(postInfoDO)
                .where(postInfoDO.uid.eq(query.getUid()))
                .orderBy(postInfoDO.ctime.desc())
                .offset((long) (query.getPageNumber() - 1) * query.getPageSize())
                .limit(query.getPageSize())
                .fetch();

        return postInfoDOS;
    }

    /**
     * 查询文章详情
     * @param pid 文章id
     * @return 文章详情
     */
    @Override
    @Cacheable(key = "'details:' + #pid", unless = "#result == null")
    public PostDetailsDTO getPostDetails(Long pid) {
        QPostInfoDO postInfoDO = QPostInfoDO.postInfoDO;
        QPostBodyDO postBodyDO = QPostBodyDO.postBodyDO;

        PostDetailsDTO postDetailsDTO = jpaQueryFactory.select(Projections.fields(
                PostDetailsDTO.class,
                postInfoDO.pid,
                Projections.fields(PostInfoDTO.class, postInfoDO.id, postInfoDO.pid, postInfoDO.uid, postInfoDO.title,
                        postInfoDO.summary, postInfoDO.ctime, postInfoDO.mtime).as("postInfoDTO"),
                postBodyDO.content))
                .from(postInfoDO)
                .leftJoin(postBodyDO).on(postInfoDO.pid.eq(postBodyDO.pid))
                .where(postInfoDO.pid.eq(pid))
                .fetchFirst();
        return postDetailsDTO;
    }
}
