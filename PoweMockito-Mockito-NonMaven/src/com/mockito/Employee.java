package com.mockito;

import java.util.List;

public class Employee {
	
	private int empId;
	
	public Employee(int id) {
		empId=id;
		// TODO Auto-generated constructor stub
	}

	public void call(){
		System.out.println("Employee.call() Method");
		call2();
		
	}
	public void call2(){
		System.out.println("Employee.call2() Method");
		Department dept=getDepartmentInstance();
		List<String> veh=dept.dept1();
		System.out.println(veh.get(0));
		System.out.println(veh.get(1));
		
	}
	
	public Department getDepartmentInstance(){
		return new Department();
	}
}
