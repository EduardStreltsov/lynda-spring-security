package com.frankmoley.security.app.auth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_user_group")
@Getter
@Setter
public class AuthGroup {
	
	@Id
	private long id;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "auth_group")
	private String authGroup;
}
