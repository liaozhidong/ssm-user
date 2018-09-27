package com.spring.entity;

import lombok.Data;

import java.util.Date;
/**
 * 
 * @Title:User
 * @Description: 用户
 * @author:lzd
 */
@Data
public class User {

	private int id;
	private String username;
	private String password;
	private Date birthday;
	private int sex;
	private String address;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", birthday=" + birthday + ", sex=" + sex
				+ ", address=" + address + "]";
	}
}
