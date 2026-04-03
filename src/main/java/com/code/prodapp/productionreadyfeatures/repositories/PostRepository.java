package com.code.prodapp.productionreadyfeatures.repositories;

import com.code.prodapp.productionreadyfeatures.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PostRepository extends JpaRepository<PostEntity,Long> {



}
