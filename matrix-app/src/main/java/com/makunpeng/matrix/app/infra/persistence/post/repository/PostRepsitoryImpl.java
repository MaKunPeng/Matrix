package com.makunpeng.matrix.app.infra.persistence.post.repository;

import com.makunpeng.matrix.app.domain.post.aggregate.PostBodyA;
import com.makunpeng.matrix.app.domain.post.aggregate.PostInfoA;
import com.makunpeng.matrix.app.domain.post.repository.PostRepository;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostBodyDO;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostInfoDO;
import com.makunpeng.matrix.app.infra.persistence.post.repository.dao.PostBodyDAO;
import com.makunpeng.matrix.app.infra.persistence.post.repository.dao.PostInfoDAO;
import com.makunpeng.matrix.app.interfaces.post.query.PostBodyQuery;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoListQuery;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoSingleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Repository
public class PostRepsitoryImpl implements PostRepository {
    private PostInfoDAO postInfoDAO;
    private PostBodyDAO postBodyDAO;

    @Autowired
    public PostRepsitoryImpl(PostInfoDAO postInfoDAO, PostBodyDAO postBodyDAO) {
        this.postInfoDAO = postInfoDAO;
        this.postBodyDAO = postBodyDAO;
    }

    @Override
    public PostInfoA findPostInfo(PostInfoSingleQuery query) {
        PostInfoDO postInfo = postInfoDAO.findByPid(query.getPid());

        return null;
    }

    @Override
    public Page<PostInfoA> listPostInfo(PostInfoListQuery query) {
        Page<PostInfoDO> postInfoPage = postInfoDAO.findPostInfosByUid(
                query.getUid(),
                PageRequest.of(query.getPageNumber(), query.getPageSize(), Sort.Direction.DESC, "ctime"));
        postInfoPage.getContent()
        return postInfoPage;
    }

    @Override
    public PostBodyA findPostBody(PostBodyQuery query) {
        PostBodyDO postbodyDO = postBodyDAO.findByPid(query.getPid());

        return null;
    }
}
