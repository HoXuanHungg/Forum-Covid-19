package com.dg3.forum.forum.service;

import java.util.List;

import com.dg3.forum.forum.entity.Comment;

public interface CommentService {
    /*
    * Create comment posts
    * */
    Comment createCommentPosts(Comment comment);

    /*
    * Show comment by posts
    * */
    List<Comment> showAllComment_Posts(Long thread_pk);

    /*
    * Update comment by posts
    * */
    void updateCommnet_Posts(Long comment_pk, String content_comment);

    /*
    * Get information comment by posts
    * */
    Comment getByComment(Long comment);

    /*
    * Delete comment by posts
    * */
    void deleteComment(Long comment_pk);
    
//    /**
//     * Get all comments according to thread_pk
//     * @param thread_pk
//     * @return list all comments according to thread_pk
//     */
//    List<Comment> showAllComments_Posts( Long thread_pk);

}
