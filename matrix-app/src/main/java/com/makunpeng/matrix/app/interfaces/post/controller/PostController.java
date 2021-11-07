package com.makunpeng.matrix.app.interfaces.post.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
