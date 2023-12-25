package com.example.taskmanagementsystem.data.repoInter;

import com.example.taskmanagementsystem.models.Comment;
import org.springframework.data.domain.Page;


public interface CommentRepoInter {

    Comment addCommentToTask(Comment comment);

    Comment changeComment(Comment comment);

    void deleteCommentById(Long commentId);

    Page<Comment> getAllCommentByTaskId(Long id, int size);

    Comment getCommentById(Long id);
}
