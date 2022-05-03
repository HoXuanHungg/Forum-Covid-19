package com.dg3.forum.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	 	private String statusCode;
	    private String message;
	    private Object object;
}
