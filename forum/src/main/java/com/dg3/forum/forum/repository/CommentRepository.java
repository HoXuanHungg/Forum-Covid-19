package com.dg3.forum.forum.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dg3.forum.forum.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	/**
	 * Update content comment by posts
	 * 
	 * @param content_comment
	 * @param comment_pk
	 * @return content comment updated
	 */
	@Modifying
	@Transactional
	@Query(value = "update comment set content_comment = :content_comment "
			+ "where comment_pk = :comment_pk", nativeQuery = true)
	void updateContent_Comment(@Param("content_comment") String content_comment, @Param("comment_pk") Long comment_pk);

	/**
	 * Show comment by posts
	 * 
	 * @param thread_pk
	 * @return list Comment of thread
	 */
	@Transactional
	@Query(value = "select * from comment where thread_pk = :thread_pk", nativeQuery = true)
	List<Comment> showComment_Posts(@Param("thread_pk") Long thread_pk);

	/**
	 * Get information comment by posts
	 * 
	 * @param comment_pk
	 * @return get all information comment depend on comment_pk
	 */
	@Transactional
	@Query(value = "select * from comment where comment_pk = :comment_pk", nativeQuery = true)
	Comment getById_Comment(@Param("comment_pk") Long comment_pk);

	/**
	 * Delete comment by posts
	 * 
	 * @param comment_pk
	 * @return information comment deleted
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from comment where comment_pk = :comment_pk", nativeQuery = true)
	void deleteId_Comment(@Param("comment_pk") Long comment_pk);

	/**
	 * List comment_pk by posts
	 * 
	 * @param thread_pk
	 * @return information comment_pk
	 */
	@Transactional
	@Query(value = "select comment_pk from comment where thread_pk = :thread_pk", nativeQuery = true)
	List<Long> sumComment_Posts(@Param("thread_pk") Long thread_pk);
//	
//	/**
//	 * Show comment by posts
//	 * 
//	 * @param thread_pk
//	 * @return list Comment of thread
//	 */
//	@Transactional
//	@Query(value = "SELECT comment_pk, content_comment, users.user_pk, thread_pk, enable_comment"
//			+ "	 from comment, users"
//			+ " where thread_pk = :thread_pk and "
//			+ "users.user_pk= comment.user_pk", nativeQuery = true)
//	List<Comment> showAllComments_Posts(@Param("thread_pk") Long thread_pk);
	
}
