package org.crazyit.hrsystem.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Getter@Setter
public class AttendBean implements Serializable
{
	private static final long serialVersionUID = 48L;
	private int id;
	private String dutyDay;
	private String unType;
	private Date time;

	// 无参数的构造器
	public AttendBean()
	{
	}
	// 初始化全部成员变量的构造器
	public AttendBean(int id , String dutyDay
		, String unType , Date time)
	{
		this.id = id;
		this.dutyDay = dutyDay;
		this.unType = unType;
		this.time = time;
	}

}