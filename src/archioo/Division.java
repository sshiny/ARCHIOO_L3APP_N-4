package archioo;

public class Division extends Operation {
	
	public Division(float left, float right) {
		this.operator = '/';
		this.left = left;
		this.right = right;
	}

	@Override
	public float calculate() throws ArithmeticException {
		return this.left / this.right;
	}
	
}
