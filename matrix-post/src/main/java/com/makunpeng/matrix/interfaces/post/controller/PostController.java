package com.makunpeng.matrix.interfaces.post.controller;

import com.makunpeng.matrix.application.post.PostQService;
import com.makunpeng.matrix.application.post.PostService;
import com.makunpeng.matrix.domain.post.aggregate.Post;
import com.makunpeng.matrix.infra.post.persistence.assembler.PostInfoAssembler;
import com.makunpeng.matrix.interfaces.post.api.ApiResultStatus;
import com.makunpeng.matrix.interfaces.post.api.ResponseResult;
import com.makunpeng.matrix.interfaces.post.command.PostPublishCommand;
import com.makunpeng.matrix.interfaces.post.command.PostUpdateCommand;
import com.makunpeng.matrix.interfaces.post.dto.PostDetailsDTO;
import com.makunpeng.matrix.interfaces.post.dto.PostInfoDTO;
import com.makunpeng.matrix.interfaces.post.query.PostInfoListQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章请求控制器
 * @author Aaron Ma
 **/
@RestController
@RequestMapping(value = "/post")
public class PostController {
    private final PostService postService;
    private final PostQService postQService;
    private final PostInfoAssembler postInfoAssembler;

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
        return ResponseResult.of(ApiResultStatus.SUCCESS, postInfoAssembler.entityToPostInfoDTO(post.getPostInfo()));
    }

    /**
     * 更新文章
     * @param postUpdateCommand 请求参数
     */
    @PutMapping(value = "/publish")
    public ResponseResult<Object> update(@RequestBody PostUpdateCommand postUpdateCommand) {
        postService.update(postUpdateCommand);
        return ResponseResult.of(ApiResultStatus.SUCCESS);
    }

    /**
     * 获取文章详细内容
     * @param pid 文章id
     * @return 文章详情
     */
    @GetMapping(value = "/details/{pid}")
    public ResponseResult<PostDetailsDTO> getPostDetails(@PathVariable("pid") Long pid) {
        PostDetailsDTO postDetails = postQService.getPostDetails(pid);
        return ResponseResult.of(ApiResultStatus.SUCCESS, postDetails);
    }

    /**
     * 获取文章信息列表
     * @param postInfoListQuery 请求参数，含分页信息
     * @return 文章分页列表
     */
    @GetMapping(value = "/list")
    public ResponseResult<List<PostInfoDTO>> listPostInfo(@RequestBody PostInfoListQuery postInfoListQuery) {
        List<PostInfoDTO> postInfoDTOS = postQService.listPostInfo(postInfoListQuery);
        return ResponseResult.of(ApiResultStatus.SUCCESS, postInfoDTOS);
    }
}
