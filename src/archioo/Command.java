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
		int stop;
		do {
			try {
				System.out.println("Saisir a");
				float a = sc.nextFloat();
				System.out.println("Saisir b");
				float b = sc.nextFloat();
				System.out.println("Saisir l'opérator");
				char sign = sc.next().charAt(0);
				float res = Controller.execute(sign, a, b);
				System.out.println(res);
			} catch (InputMismatchException e) {
				System.out.println("Mauvaise saisie");
			}
			System.out.println("Saisir \"1\" pour arrêter le programme, autre chose pour faire un nouveau calcul");
			stop = sc.nextInt();
		} while (stop != 1);
		sc.close();
	}

}
