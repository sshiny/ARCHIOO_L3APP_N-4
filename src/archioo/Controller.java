package archioo;

public class Controller {

	public static float execute(char sign, float left, float right) throws ArithmeticException {
		switch (sign) {
			case '+':
				return new Sum(left, right).calculate();
			case '/':
				return new Division(left, right).calculate();
			default:
				throw new ArithmeticException();
		}
	}
	
}
