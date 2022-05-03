package com.dg3.forum.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dg3.forum.forum.entity.PostThread;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface PostThreadRepository extends JpaRepository<PostThread, Long>{
    /*
     * Find all posts of user. Sort in descending order of posting time
     * Request is Long user_pk
     * Respone is List posts by user
     * */
    @Modifying
    @Transactional
    @Query(value = "select post_thread.* from post_thread " +
            "inner join users on users.user_pk = post_thread.user_pk " +
            "where users.user_pk = :user_pk " +
            "order by post_thread.time_post_thread DESC", nativeQuery = true)
    List<PostThread> findAll_User(@Param("user_pk") Long user_pk);

    /*
     * Delete posts
     * Request is Long thread_pk (primary key of table PostDealer)
     * Respone is Posts deleted
     * */
    @Modifying
    @Transactional
    @Query(value = "delete from post_thread where post_thread.thread_pk = :thread_pk", nativeQuery = true)
    void deleteByPosts(@Param("thread_pk") Long thread_pk);

    /*
     * Update posts of dealer
     * Request is String title_thread, String content_of_thread, Long post_topic_pk, boolean enable_post_thread, Long thread_pk
     * Respone is Posts update
     * */
    @Modifying
    @Transactional
    @Query(value = "update post_thread set " +
            "title_thread = :title_thread," +
            "content_of_thread = :content_of_thread," +
            "post_topic_pk = :post_topic_pk " +
            "where thread_pk = :thread_pk", nativeQuery = true)
    void updateByPosts(@Param("title_thread") String title_thread,
                       @Param("content_of_thread") String content_of_thread,
                       @Param("post_topic_pk") Long post_topic_pk,
                       @Param("thread_pk") Long thread_pk);

    /*
     * Check existence of thread_pk
     * Request is Long thread_pk
     * Respone is quantity found
     * */
    @Transactional
    @Query(value = "select * from post_thread where post_thread.thread_pk = :thread_pk", nativeQuery = true)
    PostThread existByThread_pk(@Param("thread_pk") Long thread_pk);

    /*
     * Show all information posts approved
     * */
    @Transactional
    @Query(value = "select * from post_thread " +
            "where approved = 'true'" +
            "order by post_thread.time_post_thread DESC", nativeQuery = true)
    List<PostThread> findByAllPosts();

    /*
     * Update approved
     * */
    @Modifying
    @Transactional
    @Query(value = "update post_thread set " +
            "approved = :approved " +
            "where thread_pk = :thread_pk", nativeQuery = true)
    void updateApproved(@Param("approved") boolean approved, @Param("thread_pk") Long thread_pk);

    /*
     * Update enable_post_thread
     * */
    @Modifying
    @Transactional
    @Query(value = "update post_thread set " +
            "enable_post_thread = :enable_post_thread " +
            "where thread_pk = :thread_pk", nativeQuery = true)
    void updateEnable_post_thread(@Param("enable_post_thread") boolean enable_post_thread, @Param("thread_pk") Long thread_pk);

    /*
     * Show all information posts not approved
     * */
    @Transactional
    @Query(value = "select * from post_thread " +
            "where approved = 'false'" +
            "order by post_thread.time_post_thread DESC", nativeQuery = true)
    List<PostThread> findByAllPosts_NotApproved();
    

    /**
	 * approved post of users
	 * 
	 * @param thread_pk
	 */
    @Modifying
	@Transactional
	@Query(value = "update Post_Thread  set approved = true where thread_pk = :thread_pk", nativeQuery = true)
	int approvedPost(@Param("thread_pk") Long thread_pk);
    
    /**
     * 
     * @param thread_pk
     * @return object postThread
     */
    @Query(value = "select * from post_thread  where thread_pk = :thread_pk", nativeQuery = true)
	PostThread getAnPostThrest(@Param("thread_pk") Long thread_pk);
}
