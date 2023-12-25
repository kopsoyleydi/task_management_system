package com.example.taskmanagementsystem.mapper;

import com.example.taskmanagementsystem.dto.response.CommentDto;
import com.example.taskmanagementsystem.models.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    private final UserMapper userMapper;

    private final TaskMapper taskMapper;


    public CommentDto toCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setMessage(comment.getMessage());
        commentDto.setTask(taskMapper.toTaskDto(comment.getTask()));
        commentDto.setUser(userMapper.toUserDto(comment.getUser_id()));
        commentDto.setCreatedAt(comment.getCreatedAt());
        return commentDto;
    }

    public Comment toComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setMessage(commentDto.getMessage());
        comment.setTask(taskMapper.toTask(commentDto.getTask()));
        comment.setUser_id(userMapper.toUser(commentDto.getUser()));
        comment.setCreatedAt(commentDto.getCreatedAt());
        return comment;
    }

    public List<CommentDto> toCommentDtoList(List<Comment> commentList) {
        return commentList.stream()
                .map(this::toCommentDto)
                .collect(Collectors.toList());
    }

    public List<Comment> toCommentList(List<CommentDto> commentDtoList) {
        return commentDtoList.stream()
                .map(this::toComment)
                .collect(Collectors.toList());
    }
}
