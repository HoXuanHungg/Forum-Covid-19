package com.dg3.forum.forum.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg3.forum.forum.entity.PostTopic;
import com.dg3.forum.forum.repository.PostTopicReposity;
import com.dg3.forum.forum.service.PostTopicService;

@Service
public class PostTopicServiceImpl implements PostTopicService {
    @Autowired
    PostTopicReposity postTopicReposity;

    /**
     * Show all topic
     * @return
     */
    @Override
    public List<PostTopic> listAllTopic() {
        return postTopicReposity.findAll();//findAll() này là phương thức có sẵn của JPA.
    }

    /**
     * Show Topic by name
     * @param name_topic
     * @return
     */
    @Override
    public List<PostTopic> findByName_topic(String name_topic) {
        return postTopicReposity.findByName_topic(name_topic);
    }

    /**
     * check name topic
     * @param name_topic
     * @return
     */
    @Override
    public List<PostTopic> checkName_topic(String name_topic) {
        return postTopicReposity.checkByName_topic(name_topic);
    }

    /**
     * save topic
     * @param postTopic
     * @return
     */
    @Override
    public PostTopic save(PostTopic postTopic) {
        return postTopicReposity.save(postTopic);
    }

    /**
     * Find by id
     * @param post_topic_pk
     * @return
     */
    @Override
    public Optional<PostTopic> findById(Long post_topic_pk) {
        return postTopicReposity.findById(post_topic_pk);
    }

    /**
     * check id để delete
     * @param id
     * @return
     */
    @Override
    public boolean existById(Long id) {
        return postTopicReposity.existsById(id);
    }

    /**
     * delete Topic
     * @param id
     */
    @Override
    public void deleteTopic(Long id) {
        postTopicReposity.deleteById(id);
    }


}
