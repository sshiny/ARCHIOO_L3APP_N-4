package archioo;

public class Division extends Operation {

	@Override
	public float calculate(float left, float right) throws ArithmeticException {
		if (right == 0) {
			throw new ArithmeticException("Division par 0");
		}
		return left / right;
	}
	
}
