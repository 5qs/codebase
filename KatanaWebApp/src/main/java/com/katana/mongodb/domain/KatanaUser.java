/**
 * 
 */
package com.katana.mongodb.domain;

/**
 * @author a486613
 *
 */
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class KatanaUser {

	@Id
	private String id;
	private String username;
	private String password;
	private String status;
	private Boolean enabled;
	private List<KatanaRole> roles;

	public KatanaUser() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<KatanaRole> getRoles() {
		return roles;
	}

	public void setRoles(List<KatanaRole> roles) {
		this.roles = roles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
