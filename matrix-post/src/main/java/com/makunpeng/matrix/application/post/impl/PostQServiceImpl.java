package com.makunpeng.matrix.application.post.impl;

import com.makunpeng.matrix.infra.post.persistence.d.PostInfoDO;
import com.makunpeng.matrix.infra.post.persistence.d.QPostBodyDO;
import com.makunpeng.matrix.infra.post.persistence.d.QPostInfoDO;
import com.makunpeng.matrix.infra.post.persistence.repository.dao.PostInfoDAO;
import com.makunpeng.matrix.interfaces.post.api.dto.CommonPageResultDTO;
import com.makunpeng.matrix.interfaces.post.api.dto.PostDetailsDTO;
import com.makunpeng.matrix.interfaces.post.api.dto.PostInfoDTO;
import com.makunpeng.matrix.interfaces.post.query.PostInfoListQuery;
import com.makunpeng.matrix.application.post.PostQService;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
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
    public CommonPageResultDTO<PostInfoDTO> listPostInfo(PostInfoListQuery query) {
        CommonPageResultDTO<PostInfoDTO> result = new CommonPageResultDTO<>();

        QPostInfoDO postInfoDO = QPostInfoDO.postInfoDO;
        Long count = jpaQueryFactory.select(Wildcard.count)
                .from(postInfoDO)
                .fetchOne();

        // 当前页项目
        Integer pageSize = query.getPageSize();
        List<PostInfoDTO> postInfoDOS = jpaQueryFactory
                .select(Projections.fields(PostInfoDTO.class, postInfoDO.id, postInfoDO.pid, postInfoDO.uid, postInfoDO.title,
                        postInfoDO.summary, postInfoDO.ctime, postInfoDO.mtime))
                .from(postInfoDO)
                .where(postInfoDO.uid.eq(query.getUid()))
                .orderBy(postInfoDO.ctime.desc())
                .offset((long) (query.getPageNumber() - 1) * pageSize)
                .limit(pageSize)
                .fetch();

        result.setTotalItems(count);
        result.setTotalPages((int) ((count + pageSize - 1) / pageSize));
        result.setPageSize(pageSize);
        result.setCurrentPage(query.getPageNumber());
        result.setPageItems(postInfoDOS);

        return result;
    }

    /**
     * 查询文章详情
     * @param pid 文章id
     * @return 文章详情
     */
    @Override
    @Cacheable(key = "'detail:' + #pid", unless = "#result == null")
    public PostDetailsDTO getPostDetails(Long pid) {
        QPostInfoDO postInfoDO = QPostInfoDO.postInfoDO;
        QPostBodyDO postBodyDO = QPostBodyDO.postBodyDO;

        PostDetailsDTO postDetailsDTO = jpaQueryFactory.select(Projections.fields(
                PostDetailsDTO.class,
                postInfoDO.pid,
                Projections.fields(PostInfoDTO.class, postInfoDO.id, postInfoDO.pid, postInfoDO.uid, postInfoDO.title,
                        postInfoDO.summary, postInfoDO.tags, postInfoDO.ctime, postInfoDO.mtime).as("postInfoDTO"),
                postBodyDO.content))
                .from(postInfoDO)
                .leftJoin(postBodyDO).on(postInfoDO.pid.eq(postBodyDO.pid))
                .where(postInfoDO.pid.eq(pid))
                .fetchFirst();
        return postDetailsDTO;
    }
}
