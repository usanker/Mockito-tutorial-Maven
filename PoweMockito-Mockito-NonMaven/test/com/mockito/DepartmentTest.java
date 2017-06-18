package com.mockito;

import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//@RunWith(MockitoJUnitRunner.class)
public class DepartmentTest {
	
	@Test
	public void DepartmentCallTest(){
		
		List<String> vehicleInNumber=new ArrayList<String>();
		vehicleInNumber.add("1");
		vehicleInNumber.add("2");
		
		Department deptspy=spy(new Department());
		Employee empspy=spy(new Employee(1));
		doReturn(deptspy).when(empspy).getDepartmentInstance();
		doReturn(vehicleInNumber).when(deptspy).dept1();
		
		empspy.call();
		
		
	}

}
