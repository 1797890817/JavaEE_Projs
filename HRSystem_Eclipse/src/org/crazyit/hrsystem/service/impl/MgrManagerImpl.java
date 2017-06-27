package org.crazyit.hrsystem.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.crazyit.hrsystem.dao.ApplicationDao;
import org.crazyit.hrsystem.dao.AttendDao;
import org.crazyit.hrsystem.dao.AttendTypeDao;
import org.crazyit.hrsystem.dao.CheckBackDao;
import org.crazyit.hrsystem.dao.EmployeeDao;
import org.crazyit.hrsystem.dao.ManagerDao;
import org.crazyit.hrsystem.dao.PaymentDao;
import org.crazyit.hrsystem.domain.Application;
import org.crazyit.hrsystem.domain.Attend;
import org.crazyit.hrsystem.domain.CheckBack;
import org.crazyit.hrsystem.domain.Employee;
import org.crazyit.hrsystem.domain.Manager;
import org.crazyit.hrsystem.domain.Payment;
import org.crazyit.hrsystem.exception.HrException;
import org.crazyit.hrsystem.service.MgrManager;
import org.crazyit.hrsystem.vo.AppBean;
import org.crazyit.hrsystem.vo.EmpBean;
import org.crazyit.hrsystem.vo.SalaryBean;

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
@Setter
public class MgrManagerImpl
	implements MgrManager
{
	private ApplicationDao appDao;
	private AttendDao attendDao;
	private AttendTypeDao typeDao;
	private CheckBackDao checkDao;
	private EmployeeDao empDao;
	private ManagerDao mgrDao;
	private PaymentDao payDao;

	/**
	 * ����Ա��
	 * @param emp ������Ա��
	 * @param mgr Ա�������ľ���
	 */
	public void addEmp(Employee emp , String mgr)throws HrException
	{
		Manager m = mgrDao.findByName(mgr);
		if (m == null)
		{
			throw new HrException("���Ǿ����𣿻��㻹δ��¼��");
		}
		emp.setManager(m);
		empDao.save(emp);
	}

	/**
	 * ���ݾ��������еĲ����ϸ��¹���
	 * @param mgr ������Ա����
	 * @return �����ϸ��¹���
	 */
	public List<SalaryBean> getSalaryByMgr(String mgr)throws HrException
	{
		Manager m = mgrDao.findByName(mgr);
		if (m == null)
		{
			throw new HrException("���Ǿ����𣿻��㻹δ��¼��");
		}
		//��ѯ�þ����Ӧ��ȫ��Ա��
		Set<Employee> emps = m.getEmployees();
		//������Ȼû��Ա��
		if (emps == null || emps.size() < 1)
		{
			throw new HrException("���Ĳ���û��Ա��");
		}
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH , -1);
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM");
		String payMonth = sdf.format(c.getTime());
		List<SalaryBean> result = new ArrayList<SalaryBean>();
		//����������ÿ��Ա��
		for (Employee e : emps)
		{
			Payment p = payDao.findByMonthAndEmp(payMonth , e);
			if (p != null)
			{
				result.add(new SalaryBean(e.getName()
					, p.getAmount()));
			}
		}
		return result;
	}

	/**
	* ���ݾ����ظò��ŵ�ȫ��Ա��
	* @param mgr ������
	* @return �����ȫ������
	*/
	public List<EmpBean> getEmpsByMgr(String mgr)
		throws HrException
	{
		Manager m = mgrDao.findByName(mgr);
		if (m == null)
		{
			throw new HrException("���Ǿ����𣿻��㻹δ��¼��");
		}
		//��ѯ�þ����Ӧ��ȫ��Ա��
		Set<Employee> emps = m.getEmployees();
		//������Ȼû��Ա��
		if (emps == null || emps.size() < 1)
		{
			throw new HrException("���Ĳ���û��Ա��");
		}
		//��װVO��
		List<EmpBean> result = new ArrayList<EmpBean>();
		for (Employee e : emps)
		{
			result.add(new EmpBean(e.getName() ,
				e.getPass() , e.getSalary()));
		}
		return result;
	}

	/**
	 * ���ݾ����ظò��ŵ�û������������
	 * @param mgr ������
	 * @return �ò��ŵ�ȫ������
	 */
	public List<AppBean> getAppsByMgr(String mgr)throws HrException
	{
		Manager m = mgrDao.findByName(mgr);
		if (m == null)
		{
			throw new HrException("���Ǿ����𣿻��㻹δ��¼��");
		}
		//��ѯ�þ����Ӧ��ȫ��Ա��
		Set<Employee> emps = m.getEmployees();
		//������Ȼû��Ա��
		if (emps == null || emps.size() < 1)
		{
			throw new HrException("���Ĳ���û��Ա��");
		}
		//��װVO��
		List<AppBean> result = new ArrayList<AppBean>();
		for (Employee e : emps)
		{
			//�鿴��Ա����ȫ������
			List<Application> apps = appDao.findByEmp(e);
			if (apps != null && apps.size() > 0)
			{
				for (Application app : apps)
				{
					//ֻѡ��δ���������
					if (app.isResult() == false)
					{
						Attend attend = app.getAttend();
						result.add(new AppBean(app.getId() ,
							e.getName(), attend.getType().getName(),
							app.getType().getName(), app.getReason()));
					}
				}
			}
		}
		return result;
	}

	/**
	 * ��������
	 * @param appid ����ID
	 * @param mgrName ��������
	 * @param result �Ƿ�ͨ��
	 */
	public void check(int appid, String mgrName, boolean result)
	{
		Application app = appDao.get(Application.class , appid);
		CheckBack check = new CheckBack();
		check.setApp(app);
		Manager manager = mgrDao.findByName(mgrName);
		if (manager == null)
		{
			throw new HrException("���Ǿ����𣿻��㻹δ��¼��");
		}
		check.setManager(manager);
		//ͬ��ͨ������
		if (result)
		{
			//����ͨ������
			check.setResult(true);

			//�޸�����Ϊ�Ѿ�����
			app.setResult(true);
			appDao.update(app);
			//Ϊ��ʱ������Ҫ�޸ĳ��ڵ�����
			Attend attend = app.getAttend();
			attend.setType(app.getType());
			attendDao.update(attend);
		}
		else
		{
			//û��ͨ������
			check.setResult(false);
			app.setResult(true);
			appDao.update(app);
		}
		//������������
		checkDao.save(check);
	}
}
