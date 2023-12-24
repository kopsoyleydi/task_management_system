package com.example.taskmanagementsystem.mapper;


import com.example.taskmanagementsystem.dto.response.CommentDto;
import com.example.taskmanagementsystem.models.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto toDto(Comment comment);

    Comment toModel(CommentDto commentDto);

    List<CommentDto> toDtoList(List<Comment> list);

    List<Comment> toModelList(List<CommentDto> list);
}
