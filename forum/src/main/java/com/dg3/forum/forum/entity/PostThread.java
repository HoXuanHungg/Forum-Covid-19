package com.dg3.forum.forum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post_thread")
public class PostThread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long thread_pk;
    private String title_thread;
    private Date time_post_thread;
    private String content_of_thread;
    private Long post_topic_pk;
    private Long user_pk;
    private boolean enable_post_thread;
    private boolean approved;

    
}