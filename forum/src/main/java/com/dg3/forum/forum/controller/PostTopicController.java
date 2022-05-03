package com.dg3.forum.forum.controller;

import com.dg3.forum.forum.entity.Message;
import com.dg3.forum.forum.entity.PostTopic;
import com.dg3.forum.forum.service.PostTopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
public class PostTopicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private PostTopicService postTopicService;

    /**
     * Show all Topic
     * @return
     */
    @GetMapping
    public ResponseEntity<Message> showAllTopic() {
        LOGGER.error("listAllTopic");
        List<PostTopic> postTopics = postTopicService.listAllTopic();
        return postTopics.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new Message("Thất bại!", "Không thực hiện được!", "")
                )
                : ResponseEntity.status(HttpStatus.OK).body(
                new Message("Thành công!", "Danh sách Topic:", postTopics)
        )
                ;
    }

    /**
     * Find topic by name
     * @param name_topic
     * @return
     */
    @GetMapping("/list/{name_topic}")
    public ResponseEntity<Message> findByNameTopic(@PathVariable String name_topic) {
        LOGGER.error("findByName_topic");
        List<PostTopic> postTopics = postTopicService.findByName_topic(name_topic);
        return postTopics.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new Message("Không tìm thấy!", "Không tìm thấy người dùng"  + name_topic + "này!", "")
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new Message("Tìm thấy!", "Thông tin người dùng với tên " + name_topic +":" , postTopics)
                );
    }

    /**
     * Insert Topic
     * @param postTopic
     * @return
     */
    @PostMapping("/insert")
    ResponseEntity<Message> insertTopic(@RequestBody PostTopic postTopic) {
        //2 topic must not have the same name topic
        List<PostTopic> foundUserTopic = postTopicService.checkName_topic(postTopic.getName_topic().trim());
        if (foundUserTopic.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Message("Thất bại", "Topic này đã tồn tại!", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new Message("Thành công", "Thêm chủ đề thành công!", postTopicService.save(postTopic))
        );
    }

    /**
     * Update Topic
     * @param newPostTopic
     * @param post_topic_pk
     * @return
     */
    @PutMapping("/{post_topic_pk}")
    ResponseEntity<Message> updateTopic(@RequestBody PostTopic newPostTopic, @PathVariable Long post_topic_pk) {
        PostTopic updateTopic = postTopicService.findById(post_topic_pk)
                .map(topic -> {
                    topic.setName_topic(newPostTopic.getName_topic());
                    topic.setEnable_post_topic(newPostTopic.isEnable_post_topic());
                    return postTopicService.save(topic);
                }).orElseGet(() -> {
                    newPostTopic.setPost_topic_pk(post_topic_pk);
                    return postTopicService.save(newPostTopic);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new Message("Thành công!", "Cập nhập thành!", updateTopic)
        );
    }

    /**
     * Delete Topic
     * @param post_topic_pk
     * @return
     */
    @DeleteMapping("/{post_topic_pk}")
    ResponseEntity<Message> deleteTopic(@PathVariable Long post_topic_pk) {
        if (postTopicService.existById(post_topic_pk)) {
            postTopicService.deleteTopic(post_topic_pk);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Message("Thành công!", "Xóa thành công!", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new Message("Thất bại!", "Không tìm thấy người dùng này để xóa!", "")
        );
    }
}
