package com.dg3.forum.forum.service;

import com.dg3.forum.forum.entity.RepComment;

import java.util.List;

public interface Rep_commentService {
    /*
     * Create rep comment
     * */
    RepComment createRep_Comment(RepComment repComment);

    /*
     * Update repcomment
     * */
    void updateRepcomment(String content_comment_rep, Long comment_rep_pk);

    /*
    * Delete repcomment
    * */
    void deleteRepcomment(Long comment_rep_pk);

    /*
     * Check exist by repcomment
     * */
    RepComment checkExistRepComment(Long comment_rep_pk);

    /*
    * List information repcomment
    * */
    List<RepComment> getAllRepComment(Long comment_rep_pk);

}
