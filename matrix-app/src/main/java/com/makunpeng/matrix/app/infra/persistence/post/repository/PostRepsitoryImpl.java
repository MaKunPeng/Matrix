package com.makunpeng.matrix.app.infra.persistence.post.repository;

import com.makunpeng.matrix.app.domain.model.post.Post;
import com.makunpeng.matrix.app.domain.post.repository.PostRepository;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostBodyDO;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostInfoDO;
import com.makunpeng.matrix.app.infra.persistence.post.repository.dao.PostBodyDAO;
import com.makunpeng.matrix.app.infra.persistence.post.repository.dao.PostInfoDAO;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoListQuery;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoSingleQuery;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Post find(PostInfoSingleQuery query) {
        PostInfoDO postInfo = postInfoDAO.findByPid(query.getPid());
        PostBodyDO postBody = null;
        if (query.getBodyRequired()) {
            postBody = postBodyDAO.findByPid(query.getPid());
        }
        return null;
    }

    @Override
    public List<Post> listPost(PostInfoListQuery query) {
        return null;
    }
}
