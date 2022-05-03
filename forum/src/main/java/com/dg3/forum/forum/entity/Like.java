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
@Table(name = "likes")
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long like_pk;
	private Long comment_pk;
	private Long user_pk;
	private Long thread_pk;
	private boolean enable_like;
}
