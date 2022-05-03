package com.dg3.forum.forum.dto;

import com.dg3.forum.forum.entity.Image;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// image in comment
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentImagedto {
	private Long image_pk;
	private Long thread_pk;
	private Long comment_pk;
	private String image_comment;
	
	public CommentImagedto(Image image)
	{
		this.image_pk = image.getImage_pk();
		this.thread_pk= image.getThread_pk();
		this.comment_pk = image.getComment_pk();
		this.image_comment= image.getImage_comment();
				
	}
}
