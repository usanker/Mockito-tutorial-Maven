package com.in28minutes.powermock;

public class UtilityClass {
	static long staticMethod(long value) {
		// Some complex logic is done here...
		//throw new RuntimeException(
			//	"I dont want to be executed. I will anyway be mocked out.");
		System.out.println("UtilityClass.staticMethod()=>"+value);
		return value;
	}
}
