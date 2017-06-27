package org.crazyit.hrsystem.vo;

import java.io.Serializable;

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
public class SalaryBean
	implements Serializable
{
	private static final long serialVersionUID = 48L;
	private String empName;
	private double amount;

	// �޲����Ĺ�����
	public SalaryBean()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public SalaryBean(String empName , double amount)
	{
		this.empName = empName;
		this.amount = amount;
	}

}