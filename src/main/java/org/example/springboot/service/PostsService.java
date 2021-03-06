package org.example.springboot.service;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.post.Posts;
import org.example.springboot.domain.post.PostsRepository;
import org.example.springboot.web.dto.PostsListsResponseDto;
import org.example.springboot.web.dto.PostsResponseDto;
import org.example.springboot.web.dto.PostsSaveRequestsDto;
import org.example.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestsDto requestsDto){
        return postsRepository.save(requestsDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such user, id : "  + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such user, id : " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListsResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListsResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such user, id : " + id));
        postsRepository.delete(posts);
    }
}
