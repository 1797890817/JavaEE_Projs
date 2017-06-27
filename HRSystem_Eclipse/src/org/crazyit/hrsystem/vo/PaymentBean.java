package org.crazyit.hrsystem.vo;

import java.io.Serializable;

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
public class PaymentBean implements Serializable
{
	private static final long serialVersionUID = 48L;
	private String payMonth;
	private double amount;

	// 无参数的构造器
	public PaymentBean()
	{
	}
	// 初始化全部成员变量的构造器
	public PaymentBean(String payMonth , double amount)
	{
		this.payMonth = payMonth;
		this.amount = amount;
	}

}