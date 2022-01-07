package com.makunpeng.matrix.application.post.impl;

import com.makunpeng.matrix.infra.post.persistence.d.PostInfoDO;
import com.makunpeng.matrix.infra.post.persistence.d.QPostInfoDO;
import com.makunpeng.matrix.infra.post.persistence.repository.dao.PostInfoDAO;
import com.makunpeng.matrix.interfaces.post.dto.PostInfoDTO;
import com.makunpeng.matrix.interfaces.post.query.PostInfoListQuery;
import com.makunpeng.matrix.application.post.PostQService;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Post DTO 查询服务实现
 *
 * @author Aaron Ma
 *
 */
@Service
public class PostQServiceImpl implements PostQService {
    private PostInfoDAO postInfoDAO;
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    public PostQServiceImpl(PostInfoDAO postInfoDAO, JPAQueryFactory jpaQueryFactory) {
        this.postInfoDAO = postInfoDAO;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<PostInfoDTO> listPostInfo(PostInfoListQuery query) {
        QPostInfoDO postInfoDO = QPostInfoDO.postInfoDO;
        List<PostInfoDTO> postInfoDOS = jpaQueryFactory
                .select(Projections.fields(PostInfoDTO.class, postInfoDO.id, postInfoDO.pid, postInfoDO.uid, postInfoDO.title,
                        postInfoDO.summary, postInfoDO.ctime, postInfoDO.mtime))
                .from(postInfoDO)
                .where(postInfoDO.uid.eq(query.getUid()))
                .orderBy(postInfoDO.ctime.desc())
                .offset((query.getPageNumber() - 1) * query.getPageSize())
                .limit(query.getPageSize())
                .fetch();

        return postInfoDOS;
    }
}
