package com.example.demo.sys.entity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;


/**
 *@author linzf
 **/
@Data
public class User implements UserDetails {

	public User(){
		super();
	}

	public User(int id){
		this.id = id;
	}

	private int id;
	private String login;
	private String password;
	private String userName;
	private String address;
	private String job;
	private long groupId;
	private Date birthDate;
	private String city;
	private String district;
	private String province;
	private String streetAddress;
	private String state;
	private String type;
	private Date lastLoginDate;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
