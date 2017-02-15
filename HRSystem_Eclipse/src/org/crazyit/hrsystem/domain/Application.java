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
@Table(name = "application_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
public class Application implements Serializable {
	private static final long serialVersionUID = 48L;
	// �����ʶ����
	@Id
	@Column(name = "app_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// ��������
	@Column(name = "app_reason", length = 50)
	private String reason;
	// �Ƿ���
	@Column(name = "app_result")
	private boolean result;
	// �����ĳ��ڼ�¼
	@ManyToOne(targetEntity = Attend.class)
	@JoinColumn(name = "attend_id", nullable = false)
	private Attend attend;
	// ϣ����ָ�����ڸ�Ϊ��type����
	@ManyToOne(targetEntity = AttendType.class)
	@JoinColumn(name = "type_id", nullable = false)
	private AttendType type;
	// ����Ľ��
	@OneToOne(targetEntity = CheckBack.class, mappedBy = "app")
	private CheckBack check;

	// �޲����Ĺ�����
	public Application() {
	}

	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Application(Integer id, String reason, boolean result, Attend attend, AttendType type, CheckBack check) {
		this.id = id;
		this.reason = reason;
		this.result = result;
		this.attend = attend;
		this.type = type;
		this.check = check;
	}

}