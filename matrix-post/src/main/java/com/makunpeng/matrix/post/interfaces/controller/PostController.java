package com.makunpeng.matrix.post.interfaces.controller;

import com.makunpeng.matrix.post.application.PostService;
import com.makunpeng.matrix.post.application.PostQService;
import com.makunpeng.matrix.post.domain.post.aggregate.Post;
import com.makunpeng.matrix.post.infra.persistence.post.assembler.PostInfoAssembler;
import com.makunpeng.matrix.post.interfaces.dto.PostDetailDTO;
import com.makunpeng.matrix.post.interfaces.command.PostPublishCommand;
import com.makunpeng.matrix.post.interfaces.command.PostUpdateCommand;
import com.makunpeng.matrix.post.interfaces.dto.PostInfoDTO;
import com.makunpeng.matrix.post.interfaces.query.PostInfoListQuery;
import com.makunpeng.matrix.post.common.api.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 文章请求控制器
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

    /**
     * 发布文章
     * @param postPublishCommand 请求参数
     * @return null
     */
    @PostMapping(value = "/publish")
    public ResponseResult<PostInfoDTO> publish(@RequestBody PostPublishCommand postPublishCommand) {
        Post post = postService.publish(postPublishCommand);
        return ResponseResult.ok().of(postInfoAssembler.entityToPostInfoDTO(post.getPostInfo()));
    }

    /**
     * 更新文章
     * @param postUpdateCommand 请求参数
     */
    @PutMapping(value = "/publish")
    public ResponseResult update(@RequestBody PostUpdateCommand postUpdateCommand) {
        postService.update(postUpdateCommand);
        return ResponseResult.ok().of(null);
    }

    /**
     * 获取文章详细内容
     * @param pid 文章id
     * @return 文章详情
     */
    @GetMapping(value = "/details/{pid}")
    public ResponseResult<PostDetailDTO> getPostDetails(@PathVariable("pid") String pid) {
        PostDetailDTO postDetailDTO = new PostDetailDTO();
        return ResponseResult.ok().of(postDetailDTO);
    }

    /**
     * 获取文章信息列表
     * @param postInfoListQuery 请求参数，含分页信息
     * @return 文章分页列表
     */
    @GetMapping(value = "/list")
    public ResponseResult<Page<PostInfoDTO>> listPostInfo(PostInfoListQuery postInfoListQuery) {
        Page<PostInfoDTO> postInfoDTOS = postQService.listPostInfo(postInfoListQuery);
        return ResponseResult.ok().of(postInfoDTOS);
    }
}
