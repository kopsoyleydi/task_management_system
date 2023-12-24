package com.example.taskmanagementsystem.data.repoInter.impl;


import com.example.taskmanagementsystem.data.repo.CommentRepository;
import com.example.taskmanagementsystem.data.repoInter.CommentRepoInter;
import com.example.taskmanagementsystem.models.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentImpl implements CommentRepoInter {

    private final CommentRepository commentRepository;
    @Override
    public Comment addCommentToTask(Comment comment) {
        return null;
    }

    @Override
    public Comment changeComment(Comment comment) {
        return null;
    }

    @Override
    public void deleteCommentById(Long commentId) {

    }

    @Override
    public List<Comment> getAllCommentByTaskId(Long id) {
        return null;
    }
}
