package com.comment.service.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.comment.service.demo.entity.CommentsEntity;


/**
 * Jpa Repository.
 * 
 * @author yuvaraj
 *
 */
@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {

}
