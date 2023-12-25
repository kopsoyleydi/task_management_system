package com.example.taskmanagementsystem.data.repoInter.impl;


import com.example.taskmanagementsystem.data.repo.CommentRepository;
import com.example.taskmanagementsystem.data.repoInter.CommentRepoInter;
import com.example.taskmanagementsystem.models.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
        commentRepository.deleteById(commentId);
    }

    @Override
    public Page<Comment> getAllCommentByTaskId(Long id, int size) {
        Pageable pageable = Pageable.ofSize(size);
        return commentRepository.getAllByTaskId(id, pageable);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findAllById(id);
    }
}
