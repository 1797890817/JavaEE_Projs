package org.crazyit.hrsystem.domain;

import java.io.Serializable;
import java.sql.Date;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Description: <br/>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>
 * Copyright (C), 2001-2016, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "payment_inf")
@Getter@Setter
public class Payment implements Serializable {
	private static final long serialVersionUID = 48L;
	// ��ʶ����
	@Id
	@Column(name = "pay_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "pay_month", nullable = false, length = 50)
	private String payMonth;
	// ��н������
	@Column(name = "pay_amount", nullable = false)
	private double amount;
	// ��н��Ա��
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "emp_id", nullable = false)
	private Employee employee;

	// �޲����Ĺ�����
	public Payment() {
	}

	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Payment(Integer id, String payMonth, double amount, Employee employee) {
		this.id = id;
		this.payMonth = payMonth;
		this.amount = amount;
		this.employee = employee;
	}

}