package com.dg3.forum.forum.service;

import com.dg3.forum.forum.entity.PostTopic;
import com.dg3.forum.forum.entity.Users;

import java.util.List;
import java.util.Optional;

public interface PostTopicService {
    /**
     * show all topic
     * @return
     */
    List<PostTopic> listAllTopic();

    /**
     * Show topic by name
     * @param name_topic
     * @return
     */
    List<PostTopic> findByName_topic(String name_topic);

    /**
     * check name topic
     * @param name_topic
     * @return
     */
    List<PostTopic> checkName_topic(String name_topic);

    /**
     * Save
     * @param postTopic
     * @return
     */
    PostTopic save(PostTopic postTopic);

    /**
     * hàm có sẵn jpa find by id
     * @param post_topic_pk
     * @return
     */
    Optional<PostTopic> findById(Long post_topic_pk);

    boolean existById(Long id);
    void deleteTopic(Long id);
}
