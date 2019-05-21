package archioo;

import java.io.Serializable;

public class Node implements Serializable {
	private float a;
	private float b;
	private char sign;
	
	public Node(float a, float b, char sign) {
		this.a = a;
		this.b = b;
		this.sign = sign;
	}
	
	public float getA() {
		return a;
	}
	
	public float getB() {
		return b;
	}
	
	public char getSign() {
		return sign;
	}
	
	@Override
	public String toString() {
		return "" + a + " " + sign + " " +  b;
	}
}
