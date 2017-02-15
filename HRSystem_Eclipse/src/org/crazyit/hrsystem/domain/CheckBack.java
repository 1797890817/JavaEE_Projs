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
@Table(name = "checkback_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter@Setter
public class CheckBack implements Serializable {
	private static final long serialVersionUID = 48L;
	// ��ʶ����
	@Id
	@Column(name = "check_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// �Ƿ�ͬ������
	@Column(name = "check_result", nullable = false)
	private boolean result;
	// ��������
	@Column(name = "check_reason", length = 255)
	private String reason;

	// ��������Ӧ������
	@OneToOne(targetEntity = Application.class)
	@JoinColumn(name = "app_id", nullable = false, unique = true)
	private Application app;
	// �����ľ���
	@ManyToOne(targetEntity = Manager.class)
	@JoinColumn(name = "mgr_id", nullable = false)
	private Manager manager;

	// �޲����Ĺ�����
	public CheckBack() {
	}

	// ��ʼ��ȫ����Ա�����Ĺ�����
	public CheckBack(Integer id, boolean result, String reason, Application app, Manager manager) {
		this.id = id;
		this.result = result;
		this.reason = reason;
		this.app = app;
		this.manager = manager;
	}

}