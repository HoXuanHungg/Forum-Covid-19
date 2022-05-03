package com.dg3.forum.forum.controller;

import com.dg3.forum.forum.dto.Like_Comment_Posts;
import com.dg3.forum.forum.entity.Message;
import com.dg3.forum.forum.service.Like_CommentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sum")
public class Like_CommentController {
    @Autowired
    private Like_CommentService like_commentService;

    @GetMapping("/like_comment/{thread_pk}")
    public Like_Comment_Posts sumLike_CommentPosts(@PathVariable("thread_pk") Long thread_pk){
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new Message("OK", "Sum like and comment successfully", like_commentService.sumCommentAndLike(thread_pk))
//        );
        return like_commentService.sumCommentAndLike(thread_pk);
    }
}
