package archioo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Command implements IHM {
	
	private Scanner sc;
	
	public Command() {
		sc = new Scanner(System.in);
	}

	@Override
	public void lancer() {
		String stop;
		do {
			try {
				System.out.println("Saisir a");
				float a = sc.nextFloat();
				System.out.println("Saisir b");
				float b = sc.nextFloat();
				System.out.println("Saisir l'opérator");
				char sign = sc.next().charAt(0);
				float res = Calculator.execute(sign, a, b);
				System.out.println(res);
			} catch (Exception e) {
				if (e instanceof ArithmeticException || e instanceof NullPointerException) {
					System.out.println(e.getMessage());
				} else if (e instanceof InputMismatchException) {
					System.out.println("Mauvaise saisie");
				}
			} finally {
				sc = new Scanner(System.in);
				System.out.println("Appuyer sur \"1\" pour arrêter le programme ou sur une autre touche pour faire un nouveau calcul");
				stop = sc.next();
			}
		} while (!stop.equals("1"));
		sc.close();
	}

}
