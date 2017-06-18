package com.mockito;

import java.util.ArrayList;
import java.util.List;

public class Department {
	public List<String> dept1() throws NullPointerException{
		System.out.println("Calling Department.dept1()");
		List<String> vehicle=new ArrayList<String>();
		vehicle.add("ONE");
		vehicle.add("TWO");
		deptException();
		return vehicle;
	}
	
	public void dept2(){
		System.out.println("Calling Department.dept2()");
	}
	
	private void deptException() throws NullPointerException{
		throw new NullPointerException("Thrown in Department.deptException()");
	}
}
