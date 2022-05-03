package com.dg3.forum.forum.controller;

import com.dg3.forum.forum.entity.Message;
import com.dg3.forum.forum.entity.PostThread;
import com.dg3.forum.forum.entity.Users;
import com.dg3.forum.forum.service.PostThreadService;
import com.dg3.forum.forum.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/dealer")
public class DealerControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private PostThreadService postThreadService;

    @Autowired
    private UserService userService;

    /*
     * Showing a list posts by user
     * */
    @GetMapping("/all/{user_pk}")
    public ResponseEntity<Message> showAllPost_User(@PathVariable Long user_pk) {
        List<PostThread> listAllPost = postThreadService.listAllPost_User(user_pk);

        Users users = userService.getUsers(user_pk);

        return listAllPost.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new Message("Fail", "There is no list of posts by" + users.getUsername(), "")
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new Message("OK", "List all posts by " + users.getUsername(), listAllPost)
                );
    }

    /*
     * Create posts
     * */
    @PostMapping("/create/posts")
    public ResponseEntity<Message> createPosts(@RequestBody PostThread postThread){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Users users = userService.findByEmail(userDetails.getUsername());

        /*
         * Set value user_pk by post thread
         * */
        postThread.setUser_pk(users.getUser_pk());

        /*
         * Get the current date and time when the article was posted.
         * */
        Date dateNow = new Date();
        postThread.setTime_post_thread(dateNow);

        return ResponseEntity.status(HttpStatus.OK).body(
                new Message("OK", "Create posts successfully", postThreadService.savePosts(postThread))
        );
    }

    /*
     * Update posts
     * */
    @PutMapping("/update/posts/{thread_pk}")
    public ResponseEntity<Message> updatePosts(@RequestBody PostThread postThread, @PathVariable("thread_pk") Long thread_pk){
        /*
         * Check exist by posts through primary key thread_pk
         * */
        PostThread checkExistsPostThread = postThreadService.checkExistByThread_pk(thread_pk);

        if(checkExistsPostThread != null){
            postThread.setThread_pk(thread_pk);

            postThreadService.updatePosts(postThread);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new Message("OK", "Update posts successfully", "")
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Message("Failed", "Can't find by " + thread_pk, "")
            );
        }


    }

    /*
     * Delete posts
     * */
    @DeleteMapping("/delete/posts/{thread_pk}")
    public ResponseEntity<Message> deletePosts(@PathVariable("thread_pk") Long thread_pk){
        /*
         * Check exist by posts through primary key thread_pk
         * */
        PostThread checkExistsPostsThread = postThreadService.checkExistByThread_pk(thread_pk);

        if(checkExistsPostsThread != null){
            postThreadService.deletePosts(thread_pk);

            if(postThreadService.checkExistByThread_pk(thread_pk) != null){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Message("OK", "Delete posts successfully", "")
                );
            }else {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new Message("Failed", "Delete posts unsuccessfully", "")
                );
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Message("Failed", "Can not find posts to delete", "")
            );
        }
    }

    /*
     * List all posts approved
     * */
    @GetMapping("/all")
    public ResponseEntity<Message> listAllPosts(){
        List<PostThread> list = postThreadService.listAllPosts();

        return list.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new Message("Failed", "List posts not found", "")
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new Message("OK", "List posts found", list)
                );
    }

    @PutMapping("/update_approved/{thread_pk}")
    public ResponseEntity<Message> updateApproved(@PathVariable("thread_pk") Long thread_pk, @Param("approved") String approved){
        PostThread checkExistsPostsThread = postThreadService.checkExistByThread_pk(thread_pk);

        if(checkExistsPostsThread != null){
            postThreadService.updateApproved(Boolean.parseBoolean(approved), thread_pk);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new Message("OK", "Posts approved successfully", "")
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Message("Failed", "Can't find by " + thread_pk, "")
            );
        }
    }

    @PutMapping("/update_enable_post_thread/{thread_pk}")
    public ResponseEntity<Message> updateEnable_post_thread(@PathVariable("thread_pk") Long thread_pk, @Param("enable_post_thread") String enable_post_thread){
        PostThread checkExistsPostsThread = postThreadService.checkExistByThread_pk(thread_pk);

        if(checkExistsPostsThread != null){
            postThreadService.updateEnable_post_thread(Boolean.parseBoolean(enable_post_thread), thread_pk);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new Message("OK", "Posts approved successfully", "")
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Message("Failed", "Can't find by " + thread_pk, "")
            );
        }
    }

    @GetMapping("/showAllPosts_NotApproved")
    public ResponseEntity<Message> showAllPosts_NotApproved(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new Message("OK", "Show all posts not approved", postThreadService.showAllPosts_NotApproved())
        );
    }

}
