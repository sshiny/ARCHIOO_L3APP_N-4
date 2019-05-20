package archioo;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Command implements IHM {
	
	private Scanner sc;
	private static final Logger LOGGER = Logger.getLogger(Exception.class.getName());
	
	public Command() {
		sc = new Scanner(System.in);
	}

	@Override
	public void lancer() {
		String stop;
		do {
			try {
				System.out.println(MyProperties.readProperty("FIRST_DIGIT"));
				float a = sc.nextFloat();
				System.out.println(MyProperties.readProperty("SECOND_DIGIT"));
				float b = sc.nextFloat();
				System.out.println(MyProperties.readProperty("OPERATION"));
				char sign = sc.next().charAt(0);
				float res = Calculator.execute(sign, a, b);
				System.out.println(res);
			} catch (Exception e) {
				if (e instanceof ArithmeticException || e instanceof UnsupportedOperationException) {
					System.out.println(e.getMessage());
					LOGGER.log(Level.INFO, e.getMessage());
				} else if (e instanceof InputMismatchException) {
					System.out.println(MyProperties.readProperty("BAD_INPUT"));
					LOGGER.log(Level.INFO, MyProperties.readProperty("BAD_INPUT"));
				}
			} finally {
				sc = new Scanner(System.in);
				System.out.println(MyProperties.readProperty("STOP"));
				stop = sc.next();
			}
		} while (!stop.equals("1"));
		sc.close();
	}

}
