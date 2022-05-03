package com.dg3.forum.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 	
public class Commentsdto {
	private Long comment_pk;
	private String content_comment;
	private Long user_pk;
	private Long thread_pk;
	private boolean enable_comment;
	private String username;
}	
