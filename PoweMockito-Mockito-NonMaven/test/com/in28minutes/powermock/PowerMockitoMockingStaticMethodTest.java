package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ UtilityClass.class,DependencyStatic.class /*The class with static method to be mocked*/})
public class PowerMockitoMockingStaticMethodTest {

	@Mock
	Dependency dependencyMock;

	//@InjectMocks
	//SystemUnderTest systemUnderTest;

	@Test
	public void powerMockito_MockingAStaticMethodCall() {

		/*when(dependencyMock.retrieveAllStats()).thenReturn(
				Arrays.asList(1, 2, 3));*/
		PowerMockito.mockStatic(DependencyStatic.class);
		PowerMockito.when(DependencyStatic.retrieveAllStats()).thenReturn(
				Arrays.asList(1, 2, 3));

		PowerMockito.mockStatic(UtilityClass.class);

		when(UtilityClass.staticMethod(anyLong())).thenReturn((long)150);
        
		SystemUnderTest systemUnderTest=new SystemUnderTest();
		assertEquals((long)150, systemUnderTest.methodCallingAStaticMethod());

		//To verify a specific method call
		//First : Call PowerMockito.verifyStatic() 
		//Second : Call the method to be verified
		//PowerMockito.verifyStatic();
		long value=UtilityClass.staticMethod(1 + 2 + 3);
		System.out.println("value->"+value);

		// verify exact number of calls
		//PowerMockito.verifyStatic(Mockito.times(1));

	}
}