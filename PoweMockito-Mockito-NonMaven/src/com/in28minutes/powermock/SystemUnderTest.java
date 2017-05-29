package com.in28minutes.powermock;

import java.util.ArrayList;
import java.util.List;
import com.in28minutes.powermock.DependencyStatic;

/*interface Dependency {
	List<Integer> retrieveAllStats();
}*/

public class SystemUnderTest {
	private Dependency dependency;

	public int methodUsingAnArrayListConstructor() {
		ArrayList list = new ArrayList();
		return list.size();
	}

	public long methodCallingAStaticMethod() {
		//privateMethodUnderTest calls static method SomeClass.staticMethod
		//List<Integer>   stats = dependency.retrieveAllStats();
		List<Integer> stats = DependencyStatic.retrieveAllStats();
		long sum = 0;
		for (int stat : stats)
			sum += stat;
		return UtilityClass.staticMethod(sum);
	}

	private long privateMethodUnderTest() {
		
		//List<Integer> stats = dependency.retrieveAllStats();
		List<Integer> stats = DependencyStatic.retrieveAllStats();
		long sum = 0;
		for (int stat : stats)
			sum += stat;
		return sum;
	}
}
