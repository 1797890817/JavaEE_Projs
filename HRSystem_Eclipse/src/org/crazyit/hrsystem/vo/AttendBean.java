package org.crazyit.hrsystem.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
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

	// �޲����Ĺ�����
	public AttendBean()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public AttendBean(int id , String dutyDay
		, String unType , Date time)
	{
		this.id = id;
		this.dutyDay = dutyDay;
		this.unType = unType;
		this.time = time;
	}

}