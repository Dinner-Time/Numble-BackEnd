package com.numble.carrotmarket.posts.web.DTO.DTO;

import com.numble.carrotmarket.posts.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveReqeustDTO {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveReqeustDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
