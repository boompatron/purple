package org.example.springboot.domain.posts;

import org.example.springboot.domain.post.PostsRepository;
import org.example.springboot.domain.post.Posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postRepository;

    @After
    public void cleanUp(){
        postRepository.deleteAll();
    }

    @Test
    public void callPosts(){
        String title = "test title";
        String content = "test content";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("boompatron@test.com")
                .build()
        );

        List<Posts> postsList = postRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_Register_Test(){
        LocalDateTime now = LocalDateTime.of(2022, 6, 21, 0, 0, 0);
        postRepository.save(Posts.builder().title("title").content("content").author("author").build());

        List<Posts> postsList = postRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>> create Date" + posts.getCreatedDate() + " , modify Date : " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
