package com.makunpeng.matrix.interfaces.post.controller;

import com.makunpeng.matrix.infra.post.persistence.d.PostBodyDO;
import com.makunpeng.matrix.infra.shared.util.JsonUtils;
import com.makunpeng.matrix.interfaces.post.dto.PostInfoDTO;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    public void testJackson() {
        Object[] objs = new Object[5];
        objs[0] = new Object();
        PostInfoDTO postInfoDTO = new PostInfoDTO();
        postInfoDTO.setId(123124L);
        postInfoDTO.setPid(234235235L);
        postInfoDTO.setTitle("asdfasdfasdf");
        objs[1] = postInfoDTO;
        PostBodyDO postBodyDO = new PostBodyDO();
        postBodyDO.setId(213423L);
        postBodyDO.setPid(32345L);
        postBodyDO.setContent("asdfasdfasdgeeeeeeee");
        objs[2] = postBodyDO;
        objs[3] = postInfoDTO;
        objs[4] = postBodyDO;
        String json = JsonUtils.toJsonWithFormat(objs);
        System.out.println(json);
    }
}
