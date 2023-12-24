package com.example.taskmanagementsystem.data.repoInter;

import com.example.taskmanagementsystem.models.Comment;

public interface CommentRepoInter {

    Comment addCommentToTask(Comment comment);

    Comment changeComment(Comment comment);

    void deleteCommentById(Long commentId);
}
