package com.code.prodapp.productionreadyfeatures.controllers;


import com.code.prodapp.productionreadyfeatures.entities.PostEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/production/posts")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @GetMapping("/posts/{postId}")
    List<PostEntity> getAllPostRevisions(@PathVariable("postId") Long postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Used to read through all revisions of a particular entity
        AuditReader reader = AuditReaderFactory.get(entityManager);
        // Returns a List of Number of Revisions to a particular entity with an id
        List<Number> revisions = reader.getRevisions(PostEntity.class, postId);
        // Returning PostEntity with that specific revision number and postId.
        return revisions
                .stream()
                .map(revisionNumber -> reader.find(PostEntity.class,postId,revisionNumber))
                .collect(Collectors.toList());


    }




}
