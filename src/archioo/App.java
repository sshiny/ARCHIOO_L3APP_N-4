package archioo;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		try {
			CalculatorConf.init();
			new Command().lancer();
			System.exit(0);
		} catch (IOException | NullPointerException e) {
			System.out.println("An error occured");
			System.exit(1);
		}
	}

}
