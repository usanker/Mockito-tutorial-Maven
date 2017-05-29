package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyLong;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SystemUnderTest.class,DependencyStatic.class}) 
public class PowerMockitoTestingPrivateMethodTest {

	@Mock
	Dependency dependencyMock;

	//@InjectMocks
	//SystemUnderTest systemUnderTest;

	@Test
	public void powerMockito_CallingAPrivateMethod() throws Exception {
		PowerMockito.mockStatic(DependencyStatic.class);
		PowerMockito.when(DependencyStatic.retrieveAllStats()).thenReturn(
				Arrays.asList(1, 2, 3));
		
		//when(UtilityClass.staticMethod(anyLong())).thenReturn((long)150);
		
		/*when(dependencyMock.retrieveAllStats()).thenReturn(
				Arrays.asList(1, 2, 3));*/
		SystemUnderTest systemUnderTest=new SystemUnderTest();
		long value = (Long) Whitebox.invokeMethod(systemUnderTest,
				"privateMethodUnderTest");
		System.out.println("value=>"+value);
		assertEquals(6, value);
	}
}