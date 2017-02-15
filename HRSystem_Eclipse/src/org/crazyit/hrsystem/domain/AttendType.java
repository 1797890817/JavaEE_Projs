package org.crazyit.hrsystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;

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
@Table(name = "attend_type_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Getter@Setter
public class AttendType implements Serializable {
	private static final long serialVersionUID = 48L;
	// ��ʶ����
	@Id
	@Column(name = "type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// �������͵�����
	@Column(name = "type_name", nullable = false, length = 50)
	private String name;
	// ������ڶ�Ӧ�ķ���
	@Column(name = "amerce_amount", nullable = false)
	private double amerce;

	// �޲����Ĺ�����
	public AttendType() {
	}

	// ��ʼ��ȫ����Ա�����Ĺ�����
	public AttendType(Integer id, String name, double amerce) {
		this.id = id;
		this.name = name;
		this.amerce = amerce;
	}

}