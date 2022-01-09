package com.numble.carrotmarket.posts.service;

import com.numble.carrotmarket.posts.domain.Posts;
import com.numble.carrotmarket.posts.domain.PostsRepository;
import com.numble.carrotmarket.posts.web.DTO.DTO.PostsListResponseDTO;
import com.numble.carrotmarket.posts.web.DTO.DTO.PostsResponseDTO;
import com.numble.carrotmarket.posts.web.DTO.DTO.PostsSaveReqeustDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveReqeustDTO reqeustDTO) {
        return postsRepository.save(reqeustDTO.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveReqeustDTO reqeustDTO) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        posts.update(reqeustDTO.getTitle(), reqeustDTO.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDTO findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        return new PostsResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDTO> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDTO::new).collect(Collectors.toList());
    }
}
