package com.dg3.forum.forum.dto;

import com.dg3.forum.forum.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {
    private String email;
    private String password;
    private String username;
    private String phone_number;
    private String address;
    private Date date_of_birth;
    private String description;

    /**
     * map từ entity qua dto
     * @param entity
     */
    public UserCreateDTO(Users entity) {
        this.email = entity.getUsername();
        this.password = entity.getPassword();
        this.username = entity.getUsername();
        this.phone_number = entity.getPhone_number();
        this.address = entity.getAddress();
        this.date_of_birth = entity.getDate_of_birth();
        this.description = entity.getDescription();
    }
}
