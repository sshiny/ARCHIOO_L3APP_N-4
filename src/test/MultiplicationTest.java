package test;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import archioo.Multiplication;

public class MultiplicationTest {
		
	private float a;
	private float b;
	private Multiplication m;

	@Before
	public void init() {
		m = new Multiplication();
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir a");
		a = sc.nextFloat();
		System.out.println("Saisir b");
		b = sc.nextFloat();
		sc.close();
	}
	
	@Test
	public void test() {
		System.out.println(a * b);
		assertEquals(a * b, m.calculate(a, b), Float.MIN_VALUE);
	}

}
