package com.dg3.forum.forum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg3.forum.forum.entity.Comment;
import com.dg3.forum.forum.repository.CommentRepository;
import com.dg3.forum.forum.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createCommentPosts(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> showAllComment_Posts(Long thread_pk) {
        return commentRepository.showComment_Posts(thread_pk);
    }

    @Override
    public void updateCommnet_Posts(Long comment_pk, String content_comment) {
        commentRepository.updateContent_Comment(content_comment, comment_pk);
    }

    @Override
    public Comment getByComment(Long comment_pk) {
        return commentRepository.getById_Comment(comment_pk);
    }

    @Override
    public void deleteComment(Long comment_pk) {
        commentRepository.deleteId_Comment(comment_pk);
    }

    
//    /**
//     * Get all comments according to thread_pk
//     * @param thread_pk
//     * @return list all comments according to thread_pk
//     */
//	@Override
//	public List<Comment> showAllComments_Posts(Long thread_pk) {
//		return commentRepository.showAllComments_Posts(thread_pk);
//	}

}
