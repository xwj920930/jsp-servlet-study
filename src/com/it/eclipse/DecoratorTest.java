package com.it.eclipse;

public class DecoratorTest {
	public static void main(String[] args) {
		Component component=new DecoratorEx(new ComponentImpl());
		component.biu();
	}

}
