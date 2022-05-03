package com.dg3.forum.forum.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.dg3.forum.forum.customannotation.Email;
import com.dg3.forum.forum.customannotation.PasswordMatch;
import com.dg3.forum.forum.customannotation.Phone;
import com.dg3.forum.forum.dto.EditUserdto;
import com.dg3.forum.forum.dto.UserAdminOrDealerdto;
import com.dg3.forum.forum.dto.UserCreateDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "roles", "authorities" })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_pk;
	@Email
	private String email;
	@PasswordMatch
	private String password;
	private String username;
	private String role;
	@Phone
	private String phone_number;
	private String address;
	private Date date_of_birth;
	private boolean ban_account;
	private String img_avatar;
	private String description;
	private Date created_date;
	private Date expire;
	private boolean enable_users;

	public Users(String email, String password, String username, String role, String phone_number, String address,
			Date date_of_birth, boolean ban_account, String img_avatar, String description, Date created_date,
			Date expire, boolean enable_users) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.role = role;
		this.phone_number = phone_number;
		this.address = address;
		this.date_of_birth = date_of_birth;
		this.ban_account = ban_account;
		this.img_avatar = img_avatar;
		this.description = description;
		this.created_date = created_date;
		this.expire = expire;
		this.enable_users = enable_users;
	}

	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	// mapping UserAdminOrDealerdto to Users
	public Users(UserAdminOrDealerdto userAdminOrDealerdto) {
		this.email = userAdminOrDealerdto.getEmail();
		this.password = userAdminOrDealerdto.getPassword();
		this.username = userAdminOrDealerdto.getUsername();
		this.role = userAdminOrDealerdto.getRole();
		this.phone_number = userAdminOrDealerdto.getPhone_number();
		this.address = userAdminOrDealerdto.getAddress();
		this.date_of_birth = userAdminOrDealerdto.getDate_of_birth();
		this.img_avatar = userAdminOrDealerdto.getImg_avatar();
		this.description = userAdminOrDealerdto.getDescription();
		this.expire = userAdminOrDealerdto.getExpire();
	}

	/**
	 * Mapping UserCreateDTO to Users
	 * @param userCreateDTO
	 */
	public Users(UserCreateDTO userCreateDTO) {
		this.email = userCreateDTO.getEmail();
		this.password = userCreateDTO.getPassword();
		this.username = userCreateDTO.getUsername();
		this.phone_number = userCreateDTO.getPhone_number();
		this.address = userCreateDTO.getAddress();
		this.date_of_birth = userCreateDTO.getDate_of_birth();
		this.description = userCreateDTO.getDescription();
		}
	

	// mapping EditUserdto to Users
	public Users(EditUserdto editUserdto) {
		this.user_pk = editUserdto.getUser_pk();
		this.password = editUserdto.getPassword();
		this.username = editUserdto.getUsername();

		this.address = editUserdto.getAddress();
		this.date_of_birth = editUserdto.getDate_of_birth();
		this.img_avatar = editUserdto.getImg_avatar();
		this.description = editUserdto.getDescription();

	}

}

