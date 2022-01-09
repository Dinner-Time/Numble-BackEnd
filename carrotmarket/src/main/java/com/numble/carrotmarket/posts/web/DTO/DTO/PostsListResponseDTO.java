package com.numble.carrotmarket.posts.web.DTO.DTO;

import com.numble.carrotmarket.posts.domain.Posts;

import java.time.LocalDateTime;

public class PostsListResponseDTO {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDTO(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();;
        this.modifiedDate = entity.getModifiedTime();
    }
}
