package test;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import archioo.Substraction;

public class SubstractionTest {
	
	private float a;
	private float b;
	private Substraction s;

	@Before
	public void init() {
		s = new Substraction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir a");
		a = sc.nextFloat();
		System.out.println("Saisir b");
		b = sc.nextFloat();
		sc.close();
	}
	
	@Test
	public void test() {
		assertEquals(a - b, s.calculate(a, b), Float.MIN_VALUE);
	}

}
