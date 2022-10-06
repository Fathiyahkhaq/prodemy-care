package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {
	@Id
	@Column(name = "user_name", length = 50)
	private String name;
	
	@Column(name = "user_password", length = 255)
	private String password;
}
