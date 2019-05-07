package archioo;

public class Calculator {

	public static float execute(char sign, float left, float right) throws NullPointerException, ArithmeticException {
		Operation op = CalculatorConf.getOperation(sign);
		if (op == null) {
			throw new NullPointerException("Opération non supportée");
		}
		return op.calculate(left, right);
	}
	
}
