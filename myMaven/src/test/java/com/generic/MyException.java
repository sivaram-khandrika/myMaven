package com.generic;

import org.testng.annotations.Test;

class ThrowException extends Exception{
	public ThrowException(String msg) {
		super(msg);
	}
	public void message() {
		System.out.println("My exception method");
	}
}
public class MyException {
	@Test(groups= {"generic"})
	public void OwnErrorMessage() {
		try {
			throw new ThrowException("My Own Exception");
		} catch(ThrowException t) {
			System.out.println(t.getMessage());
			t.message();
		}
	}
}
