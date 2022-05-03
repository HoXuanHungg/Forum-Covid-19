package com.dg3.forum.forum.entity;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.dg3.forum.forum.dto.CommentImagedto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long image_pk;
	private Long thread_pk;
	private String image_thread;
	private Long comment_pk;
	private String image_comment;
	private boolean enable_image;
	//map commentimagedto to image
	public Image(CommentImagedto commentImagedto)
	{
		this.image_pk = commentImagedto.getImage_pk();
		this.thread_pk = commentImagedto.getThread_pk();
		this.image_comment = commentImagedto.getImage_comment();
		this.comment_pk = commentImagedto.getComment_pk();
	}
}
