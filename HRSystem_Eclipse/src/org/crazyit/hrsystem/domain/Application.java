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
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
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
	// 代表标识属性
	@Id
	@Column(name = "app_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 申请理由
	@Column(name = "app_reason", length = 50)
	private String reason;
	// 是否处理
	@Column(name = "app_result")
	private boolean result;
	// 关联的出勤记录
	@ManyToOne(targetEntity = Attend.class)
	@JoinColumn(name = "attend_id", nullable = false)
	private Attend attend;
	// 希望将指定出勤改为的type类型
	@ManyToOne(targetEntity = AttendType.class)
	@JoinColumn(name = "type_id", nullable = false)
	private AttendType type;
	// 申请的结果
	@OneToOne(targetEntity = CheckBack.class, mappedBy = "app")
	private CheckBack check;

	// 无参数的构造器
	public Application() {
	}

	// 初始化全部成员变量的构造器
	public Application(Integer id, String reason, boolean result, Attend attend, AttendType type, CheckBack check) {
		this.id = id;
		this.reason = reason;
		this.result = result;
		this.attend = attend;
		this.type = type;
		this.check = check;
	}

}