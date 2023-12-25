package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.CommentImpl;
import com.example.taskmanagementsystem.dto.response.CommentDto;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.mapper.CommentMapper;
import com.example.taskmanagementsystem.models.Comment;
import com.example.taskmanagementsystem.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentImpl comment;

    private final JwtTokenUtils jwtTokenUtils;

    private final CommentMapper commentMapper;

    public CommonResponse addComment(CommentDto commentDto){
        try {
            return CommonResponse.builder()
                    .data(commentMapper.toCommentDto(comment.addCommentToTask(commentMapper.toComment(commentDto))))
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

    public CommonResponse changeComment(CommentDto commentDto, String token){
        String initEmail = commentDto.getUser().getEmail();
        String email = jwtTokenUtils.extractUsername(token);
        try {
            if(initEmail.equals(email)){
                return CommonResponse.builder()
                        .data(commentMapper.toCommentDto(comment.changeComment(commentMapper.toComment(commentDto))))
                        .message("Comment added success")
                        .status(HttpStatus.CREATED)
                        .build();
            }
            else {
                return CommonResponse.builder()
                        .message("You dont change this comment")
                        .status(HttpStatus.CREATED)
                        .build();
            }

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

    public CommonResponse deleteCommentById(Long commentId, String token){
        String initEmail = comment.getCommentById(commentId).getUser().getEmail();
        String email = jwtTokenUtils.extractUsername(token);
        try {
            if(initEmail.equals(email)){
                comment.deleteCommentById(commentId);
                return CommonResponse.builder()
                        .message("Success")
                        .build();
            }
            else {
                return CommonResponse.builder()
                        .message("You dont delete this comment")
                        .build();
            }
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .message("Была проблема при удалении")
                    .status(HttpStatus.NOT_MODIFIED)
                    .build();
        }

    }
}
