package com.dg3.forum.forum.dto;

import java.util.Date;

import com.dg3.forum.forum.customannotation.PasswordMatch;
import com.dg3.forum.forum.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditUserdto {

	private Long user_pk;
	@PasswordMatch
	private String password;
	private String username;
	private String address;
	private Date date_of_birth;
	private String img_avatar;
	private String description;

	public EditUserdto(Users entity) {
		this.user_pk = entity.getUser_pk();
		this.password = entity.getPassword();
		this.username = entity.getUsername();
		this.address = entity.getAddress();
		this.date_of_birth = entity.getDate_of_birth();
		this.img_avatar = entity.getImg_avatar();
		this.description = entity.getDescription();

	}

}
