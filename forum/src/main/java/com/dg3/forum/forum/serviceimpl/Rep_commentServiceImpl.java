package com.dg3.forum.forum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg3.forum.forum.entity.RepComment;
import com.dg3.forum.forum.repository.Rep_commentRepository;
import com.dg3.forum.forum.service.Rep_commentService;

@Service
public class Rep_commentServiceImpl implements Rep_commentService {
    @Autowired
    private Rep_commentRepository rep_commentRepository;

    @Override
    public RepComment createRep_Comment(RepComment repComment) {
        return rep_commentRepository.save(repComment);
    }

    @Override
    public void updateRepcomment(String content_comment_rep, Long comment_rep_pk) {
        rep_commentRepository.updateRepcomment(content_comment_rep, comment_rep_pk);
    }

    @Override
    public void deleteRepcomment(Long comment_rep_pk) {
        rep_commentRepository.deleteRepcomment(comment_rep_pk);
    }

    @Override
    public RepComment checkExistRepComment(Long comment_rep_pk) {
        return rep_commentRepository.findByComment_rep_pk(comment_rep_pk);
    }

    @Override
    public List<RepComment> getAllRepComment(Long comment_rep_pk) {
        return rep_commentRepository.getAllByRepcomment(comment_rep_pk);
    }
}
