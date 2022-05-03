package com.dg3.forum.forum.controller;

import com.dg3.forum.forum.entity.Message;
import com.dg3.forum.forum.entity.RepComment;
import com.dg3.forum.forum.entity.Users;
import com.dg3.forum.forum.service.Rep_commentService;
import com.dg3.forum.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repcomment")
public class Rep_commentController {
    @Autowired
    private Rep_commentService rep_commentService;

    @Autowired
    private UserService userService;

    @PostMapping("/create/{comment_pk}")
    public ResponseEntity<Message> createRepComment(@PathVariable("comment_pk") Long comment_pk, @RequestBody RepComment repComment){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Users users = userService.findByEmail(userDetails.getUsername());

        repComment.setUser_pk(users.getUser_pk());
        repComment.setComment_pk(comment_pk);
        repComment.setEnable_rep_comment(true);

        return ResponseEntity.status(HttpStatus.OK).body(
                new Message("OK", "Create repcomment successfully", rep_commentService.createRep_Comment(repComment))
        );

    }

    @PutMapping("/update/{comment_rep_pk}")
    public ResponseEntity<Message> updateRepComment(@PathVariable("comment_rep_pk") Long comment_rep_pk, @RequestBody RepComment repComment){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Users users = userService.findByEmail(userDetails.getUsername());

        RepComment checkRepComment = rep_commentService.checkExistRepComment(comment_rep_pk);

        if(checkRepComment != null) {
            if (checkRepComment.getUser_pk() == users.getUser_pk()) {
                rep_commentService.updateRepcomment(repComment.getContent_comment_rep(), comment_rep_pk);

                return ResponseEntity.status(HttpStatus.OK).body(
                        new Message("OK", "Update this comment successfully", "")
                );
            } else {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new Message("Failed", "Can't edit this comment", "")
                );
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Message("Failed", "Can't find repcomment", "")
            );
        }
    }

    @DeleteMapping("/delete/{comment_rep_pk}")
    public ResponseEntity<Message> deleteRepComment(@PathVariable("comment_rep_pk") Long comment_rep_pk){
        RepComment checkRepComment = rep_commentService.checkExistRepComment(comment_rep_pk);

        if(checkRepComment != null) {
            rep_commentService.deleteRepcomment(comment_rep_pk);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new Message("OK", "Delete this comment successfully", "")
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Message("Failed", "Can't find repcomment", "")
            );
        }
    }

    @GetMapping("/all/{comment_pk}")
    public ResponseEntity<Message> getAllRepComment(@PathVariable("comment_pk") Long comment_pk){
        List<RepComment> list = rep_commentService.getAllRepComment(comment_pk);

        return list.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new Message("Failed", "Can't find list repcomment", "")
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new Message("OK", "List information repcomment", list)
                );
    }
}
