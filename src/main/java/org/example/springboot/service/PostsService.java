package org.example.springboot.service;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.post.PostsRepository;
import org.example.springboot.web.dto.PostsSaveRequestsDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestsDto requestsDto){
        return postsRepository.save(requestsDto.toEntity()).getId();
    }
}
