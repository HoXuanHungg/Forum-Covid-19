package com.dg3.forum.forum.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "post_topic")
public class PostTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_topic_pk;
    private String name_topic;
    private boolean enable_post_topic;

}