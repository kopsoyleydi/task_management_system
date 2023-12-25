package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.CommentImpl;
import com.example.taskmanagementsystem.dto.response.CommentDto;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.mapper.CommentMapper;
import com.example.taskmanagementsystem.models.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentImpl comment;

    private final CommentMapper commentMapper;

    public CommonResponse addComment(CommentDto commentDto){
        try {
            return CommonResponse.builder()
                    .data(commentMapper.toDto(comment.addCommentToTask(commentMapper.toModel(commentDto))))
                    .message("Comment added success")
                    .status(HttpStatus.CREATED)
                    .build();
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .message("An error occurred while adding a comment")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    public CommonResponse changeComment(CommentDto commentDto){
        try {
            return CommonResponse.builder()
                    .data(commentMapper.toDto(comment.changeComment(commentMapper.toModel(commentDto))))
                    .message("Comment added success")
                    .status(HttpStatus.CREATED)
                    .build();
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .message("An error occurred while updating a comment")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    public Page<Comment> getCommentByTaskId(Long taskId, int size){
        return comment.getAllCommentByTaskId(taskId, size);
    }

    public CommonResponse deleteCommentById(Long commentId){
        try {
            comment.deleteCommentById(commentId);
            return CommonResponse.builder()
                    .message("Success")
                    .build();
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .message("Была проблема при удалении")
                    .status(HttpStatus.NOT_MODIFIED)
                    .build();
        }

    }
}
