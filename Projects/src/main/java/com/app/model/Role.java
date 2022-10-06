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
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "role_id", length = 50)
	private String id;
	
	@Column(name = "role_name", length = 100)
	private String name;
}
