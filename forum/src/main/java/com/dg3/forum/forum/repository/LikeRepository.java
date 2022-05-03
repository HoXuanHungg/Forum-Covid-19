package com.dg3.forum.forum.repository;

import com.dg3.forum.forum.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    /*
    * Find information like posts
    * Request is threak_pk and user_pk
    * */
    @Transactional
    @Query(value = "select * from likes " +
            "where thread_pk = :thread_pk and user_pk = :user_pk", nativeQuery = true)
    Like findByThreak_pkAndUser_pk(@Param("thread_pk") Long thread_pk, @Param("user_pk") Long user_pk);

    /*
     * Find information like comment posts
     * Request is thread_pk, user_pk and comment_pk
     * */
    @Transactional
    @Query(value = "select * from likes " +
            "where thread_pk = :thread_pk and user_pk = :user_pk and comment_pk = :comment_pk", nativeQuery = true)
    Like findByThreak_pkAndUser_pkAndComment_pk(@Param("thread_pk") Long thread_pk, @Param("user_pk") Long user_pk, @Param("comment_pk") Long comment_pk);

    /*
    * Delete like posts
    * Request is thread_pk, user_pk and comment_pk
    * */
    @Modifying
    @Transactional
    @Query(value = "delete from likes where thread_pk = :thread_pk and user_pk = :user_pk", nativeQuery = true)
    void deleteByLike_Posts(@Param("thread_pk") Long thread_pk, @Param("user_pk") Long user_pk);

    /*
     * Delete like comment posts
     * Request is thread_pk and user_pk
     * */
    @Modifying
    @Transactional
    @Query(value = "delete from likes where thread_pk = :thread_pk and user_pk = :user_pk and comment_pk = :comment_pk", nativeQuery = true)
    void deleteByLike_Comment(@Param("thread_pk") Long thread_pk, @Param("user_pk") Long user_pk, @Param("comment_pk") Long comment_pk);

    /*
    * Sum like by post
    * */
    @Modifying
    @Transactional
    @Query(value = "select users.username from likes " +
                    "inner join users on users.user_pk = likes.user_pk " +
                    "where thread_pk = :thread_pk", nativeQuery = true)
    List<String> inforLike_Posts(@Param("thread_pk") Long thread_pk);

}
