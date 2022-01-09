package com.numble.carrotmarket.posts.web.DTO;

import com.numble.carrotmarket.posts.service.PostsService;
import com.numble.carrotmarket.posts.web.DTO.DTO.PostsResponseDTO;
import com.numble.carrotmarket.posts.web.DTO.DTO.PostsSaveReqeustDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // insert
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveReqeustDTO reqeustDTO){
        return postsService.save(reqeustDTO);
    }

    // update
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveReqeustDTO reqeustDTO){
        return postsService.update(id, reqeustDTO);
    }

    // select one
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDTO findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
