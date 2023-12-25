package com.example.taskmanagementsystem.data.repo;

import com.example.taskmanagementsystem.models.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment c where c.task.id = :id")
    Page<Comment> getAllByTaskId(Long id, Pageable pageable);
}
