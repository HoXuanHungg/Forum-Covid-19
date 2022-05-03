package com.dg3.forum.forum.repository;

import com.dg3.forum.forum.entity.PostTopic;
import com.dg3.forum.forum.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostTopicReposity extends JpaRepository<PostTopic, Long> {
    /**
     * Find by name topic
     * @param name_topic
     * @return
     */
    @Query(value = "select * from post_topic u where u.name_topic = :name_topic", nativeQuery = true)
    List<PostTopic> findByName_topic(@Param("name_topic") String name_topic);

    /**
     * check name topic
     * @param name_topic
     * @return
     */
    @Query("SELECT u from PostTopic u where u.name_topic = :name_topic")
    List<PostTopic> checkByName_topic(String name_topic);
}
