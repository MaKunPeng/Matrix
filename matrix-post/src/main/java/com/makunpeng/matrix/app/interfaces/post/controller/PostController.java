package com.makunpeng.matrix.app.interfaces.post.controller;

import com.makunpeng.matrix.app.application.PostService;
import com.makunpeng.matrix.app.application.PostQService;
import com.makunpeng.matrix.app.domain.post.aggregate.Post;
import com.makunpeng.matrix.app.infra.persistence.post.assembler.PostInfoAssembler;
import com.makunpeng.matrix.app.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.app.interfaces.post.command.PostUpdateCommand;
import com.makunpeng.matrix.app.interfaces.post.dto.PostDetailDTO;
import com.makunpeng.matrix.app.interfaces.post.dto.PostInfoDTO;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoListQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 文章请求 Restful Controller
 * @author Aaron Ma
 **/
@RestController
@RequestMapping(value = "/post")
public class PostController {
    private PostService postService;
    private PostQService postQService;
    private PostInfoAssembler postInfoAssembler;

    @Autowired
    public PostController(PostService postService, PostQService postQService, PostInfoAssembler postInfoAssembler) {
        this.postService = postService;
        this.postQService = postQService;
        this.postInfoAssembler = postInfoAssembler;
    }

    @PostMapping(value = "/details")
    public ResponseEntity<PostInfoDTO> publish(@RequestBody PostPublishCommand postPublishCommand) {
        Post post = postService.publish(postPublishCommand);
        return ResponseEntity.ok().body(postInfoAssembler.entityToPostInfoDTO(post.getPostInfo()));
    }

    @PutMapping
    public void update(@RequestBody PostUpdateCommand postUpdateCommand) {
        postService.update(postUpdateCommand);
    }

    @GetMapping(value = "/details/{pid}")
    public PostDetailDTO getPostDetails(@PathVariable("pid") String pid) {
        return null;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<PostInfoDTO>> listPostInfo(PostInfoListQuery postInfoListQuery) {
        Page<PostInfoDTO> postInfoDTOS = postQService.listPostInfo(postInfoListQuery);
        return ResponseEntity.ok().body(postInfoDTOS);
    }
}
