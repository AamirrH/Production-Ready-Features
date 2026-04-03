package com.code.prodapp.productionreadyfeatures.service;

import com.code.prodapp.productionreadyfeatures.dtos.PostDTO;
import com.code.prodapp.productionreadyfeatures.entities.PostEntity;
import com.code.prodapp.productionreadyfeatures.exceptions.PostNotFoundException;
import com.code.prodapp.productionreadyfeatures.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostDTO create(PostDTO postDTO) {
        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostDTO.class);
    }

    public List<PostDTO> findAll() {
        List<PostEntity> postEntities = postRepository.findAll();
        return postEntities.stream().map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }

    public PostDTO getPostById(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post " +
                "with id "+id+" not found"));
        return modelMapper.map(postEntity, PostDTO.class);
    }



}
