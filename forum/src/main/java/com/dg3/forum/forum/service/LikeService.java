package com.dg3.forum.forum.service;

import com.dg3.forum.forum.entity.Like;

public interface LikeService {
    /*
    * Create like posts
    * */
    Like createLike_Posts(Long thread_pk, Like like);

    /*
    * Create like comment
    * */
    Like createLike_Comments(Long thread_pk, Like like);

    /*
    * Check exist by like posts
    * */
    Like checkExistLike_Posts(Long thread_pk, Long user_pk);

    /*
    * Check exist by like comment
    * */
    Like checkExistLike_Comment(Long thread_pk, Long user_pk, Long comment_pk);

    /*
    * Delete like posts
    * */
    void deleteLike_Posts(Long thread_pk, Long user_pk);

    /*
     * Delete like comment posts
     * */
    void deleteLike_Comment(Long thread_pk, Long user_pk, Long comment_pk);
}
