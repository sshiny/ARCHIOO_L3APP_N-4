package archioo;

public class Calculator {

	public static float execute(char sign, float left, float right) throws UnsupportedOperationException, ArithmeticException {
		Operation op = CalculatorConf.getOperation(sign);
		if (op == null) {
			throw new UnsupportedOperationException(MyProperties.readProperty("UNSUPPORTED_OPERATION"));
		}
		return op.calculate(left, right);
	}
	
}
