package com.mysmarthome.dao;


import com.mysmarthome.entities.Department;
import com.mysmarthome.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(11, new Employee(11, "fsk", "123","aa@163.com", 1, new Department(101, "射手")));
		employees.put(12, new Employee(12, "wx","123", "bb@163.com", 1, new Department(102, "上单")));
		employees.put(13, new Employee(13, "yjx","123", "cc@163.com", 0, new Department(103, "中单")));
		employees.put(14, new Employee(14, "ljy","123", "dd@163.com", 0, new Department(104, "辅助")));
		employees.put(15, new Employee(15, "xm", "123","ee@163.com", 1, new Department(105, "打野")));
	}
	
	private static Integer initId = 16;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		if(employee.getPassword()==null){
			employee.setPassword("123");
		}
		
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	//查询所有员工
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}

	public int getActiveUserId(String lastName){

		Collection<Employee> userAll=getAll();
		int userid = 10;
		for(Employee employee:userAll){
			//System.out.println(lastName+" "+employee.getLastName());
			if(lastName.equals(employee.getLastName())){
				userid=employee.getId();
			}
		}
		return userid;
	}

	public String getActiveUserPassword(String lastName){
		Collection<Employee> userAll=getAll();
		String userpassword = "admin";
		for(Employee employee:userAll){
			if(lastName.equals(employee.getLastName())){

				userpassword=employee.getPassword();
				//System.out.println(userpassword);
			}
		}
		return userpassword;
	}
}
