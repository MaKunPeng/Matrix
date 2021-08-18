package com.makunpeng.matrix.app.interfaces.post;

import com.makunpeng.matrix.app.application.dto.PostInfoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MaKunPeng
 * @version 1.0
 * @date 2021/8/17
 **/
@RestController
@RequestMapping(value = "/post")
public class PostController {
    public boolean createPost() {

        return true;
    }

    public List<PostInfoDTO> getPostInfoList() {
        return null;
    }
}
