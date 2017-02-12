package org.crazyit.hrsystem.domain;

import java.io.Serializable;
import java.util.*;
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
@Table(name = "employee_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "1")
@Getter
@Setter
public class Employee implements Serializable {
	private static final long serialVersionUID = 48L;
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// ��ʶ����
	private Integer id;
	// Ա������
	@Column(name = "emp_name", nullable = false, length = 50, unique = true)
	private String name;
	// Ա������
	@Column(name = "emp_pass", nullable = false, length = 50)
	private String pass;
	// Ա������
	@Column(name = "emp_salary", nullable = false)
	private double salary;
	// Ա����Ӧ�ľ���
	@ManyToOne(targetEntity = Manager.class)
	@JoinColumn(name = "mgr_id")
	private Manager manager;
	// Ա����Ӧ�ĳ��ڼ�¼
	@OneToMany(targetEntity = Attend.class, mappedBy = "employee")
	private Set<Attend> attends = new HashSet<>();
	// Ա����Ӧ�Ĺ���֧����¼
	@OneToMany(targetEntity = Payment.class, mappedBy = "employee")
	private Set<Payment> payments = new HashSet<>();

	// �޲����Ĺ�����
	public Employee() {
	}

	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Employee(Integer id, String name, String pass, double salary, Manager manager, Set<Attend> attends,
			Set<Payment> payments) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.salary = salary;
		this.manager = manager;
		this.attends = attends;
		this.payments = payments;
	}

	// ����name��pass����дhashCode()����
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}

	// ����name��pass����дequals()������ֻҪname��pass��ͬ��Ա������Ϊ��ȡ�
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}
}