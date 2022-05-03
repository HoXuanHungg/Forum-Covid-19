package com.dg3.forum.forum.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg3.forum.forum.entity.Like;
import com.dg3.forum.forum.repository.LikeRepository;
import com.dg3.forum.forum.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Like createLike_Posts(Long thread_pk, Like like){
        return likeRepository.save(like);
    }

    @Override
    public Like createLike_Comments(Long thread_pk, Like like) {
        return likeRepository.save(like);
    }

    @Override
    public Like checkExistLike_Posts(Long thread_pk, Long user_pk){
        return likeRepository.findByThreak_pkAndUser_pk(thread_pk, user_pk);
    }

    @Override
    public Like checkExistLike_Comment(Long thread_pk, Long user_pk, Long comment_pk) {
        return likeRepository.findByThreak_pkAndUser_pkAndComment_pk(thread_pk, user_pk, comment_pk);
    }

    @Override
    public void deleteLike_Posts(Long thread_pk, Long user_pk) {
        likeRepository.deleteByLike_Posts(thread_pk, user_pk);
    }

    @Override
    public void deleteLike_Comment(Long thread_pk, Long user_pk, Long comment_pk) {
        likeRepository.deleteByLike_Comment(thread_pk, user_pk, comment_pk);
    }
}
