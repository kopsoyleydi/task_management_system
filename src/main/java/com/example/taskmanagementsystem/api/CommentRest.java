package com.example.taskmanagementsystem.api;


import com.example.taskmanagementsystem.dto.request.PageComment;
import com.example.taskmanagementsystem.dto.response.CommentDto;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.models.Comment;
import com.example.taskmanagementsystem.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public CommonResponse updateComment(@RequestBody CommentDto commentDto){
        return commentService.changeComment(commentDto);
    }

    @DeleteMapping(value = "/deleteComment/{commentId}")
    public CommonResponse deleteComment(@PathVariable Long commentId){
        return commentService.deleteCommentById(commentId);
    }

    @GetMapping(value = "/getAllCommentByTask")
    public Page<Comment> getAllCommentByTask(@RequestBody PageComment pageComment){
        return commentService.getCommentByTaskId(pageComment.getTaskId(), pageComment.getSize());
    }

}
