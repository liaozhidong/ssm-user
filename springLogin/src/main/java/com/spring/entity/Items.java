package com.spring.entity;

import lombok.Data;

import java.util.Date;
/**
 * 
 * @Title:Items
 * @Description:	商品
 * @author:lzd
 * @Date 2017年12月14日 下午6:58:55
 */
@Data
public class Items {

	private int id;
	private String name;
	private float price;
	private String detail;
	private String pic;
	private Date createtime;
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price
				+ ", detail=" + detail + ", pic=" + pic + ", createtime="
				+ createtime + "]";
	}
}
