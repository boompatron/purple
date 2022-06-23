package org.example.springboot.web.dto;

import lombok.Getter;
import org.example.springboot.domain.post.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsListsResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime modifiedDate;

    public PostsListsResponseDto(Posts entity){
        this.id = entity.getId();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.title = entity.getTitle();
        this.modifiedDate = entity.getModifiedDate();
    }
}
