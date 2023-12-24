package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.CommentImpl;
import com.example.taskmanagementsystem.dto.response.CommentDto;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentImpl comment;

    private final CommentMapper commentMapper;

    public CommentDto addComment(CommentDto commentDto){
        return commentMapper.toDto(comment.addCommentToTask(commentMapper.toModel(commentDto)));
    }

    public CommentDto changeComment(CommentDto commentDto){
        return commentMapper.toDto(comment.changeComment(commentMapper.toModel(commentDto)));
    }

    public List<CommentDto> getCommentByTaskId(Long taskId){
        return commentMapper.toDtoList(comment.getAllCommentByTaskId(taskId));
    }

    public CommonResponse deleteTaskById(Long commentId){
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
