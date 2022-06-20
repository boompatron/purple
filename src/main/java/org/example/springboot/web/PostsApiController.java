package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.post.Posts;
import org.example.springboot.service.PostsService;
import org.example.springboot.web.dto.PostsSaveRequestsDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestsDto requestsDto){
        return postsService.save(requestsDto);
    }

}
