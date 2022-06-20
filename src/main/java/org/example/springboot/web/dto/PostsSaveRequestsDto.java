package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.post.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestsDto {
    private String author;
    private String title;
    private String content;

    @Builder
    public PostsSaveRequestsDto(String title, String content, String author){
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
