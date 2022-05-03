package com.dg3.forum.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rep_comment")
public class RepComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_rep_pk;
    private String content_comment_rep;
    private Long user_pk;
    private Long comment_pk;
    private boolean enable_rep_comment;
}
