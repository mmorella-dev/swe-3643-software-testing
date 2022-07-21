package edu.kennesaw.seclass;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class FibonacciTest {

	@Test
	public void testFib() {
		Fibonacci tester = new Fibonacci();
		assertEquals(0, tester.fib(0), "0");
		assertEquals(1, tester.fib(1), "1");
		assertEquals(1, tester.fib(2), "2");
		assertEquals(2, tester.fib(3), "3");
		assertEquals(3, tester.fib(4), "4");
		assertEquals(5, tester.fib(5), "5");
		assertEquals(8, tester.fib(6), "6");
		assertEquals(13, tester.fib(7), "7");
	}
}
