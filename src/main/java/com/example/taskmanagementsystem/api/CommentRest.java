package com.example.taskmanagementsystem.api;


import com.example.taskmanagementsystem.dto.request.PageComment;
import com.example.taskmanagementsystem.dto.response.CommentDto;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.models.Comment;
import com.example.taskmanagementsystem.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/comment")
public class CommentRest {

    private final CommentService commentService;

    @PostMapping(value = "/addComment")
    public CommonResponse addNewComment(@RequestBody CommentDto commentDto){
        return commentService.addComment(commentDto);
    }

    @PutMapping(value = "/updateComment")
    public CommonResponse updateComment(@RequestBody CommentDto commentDto, @RequestHeader("Authorization") String token){
        return commentService.changeComment(commentDto, token);
    }

    @DeleteMapping(value = "/deleteComment/{commentId}")
    public CommonResponse deleteComment(@PathVariable Long commentId, @RequestHeader("Authorization") String token){
        return commentService.deleteCommentById(commentId, token);
    }

    @GetMapping(value = "/getAllCommentByTask")
    public Page<Comment> getAllCommentByTask(@RequestBody PageComment pageComment){
        return commentService.getCommentByTaskId(pageComment.getTaskId(), pageComment.getSize());
    }

}
