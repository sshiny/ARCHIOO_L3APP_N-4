package archioo;

public class App {

	public static void main(String[] args) {
		CalculatorConf.init();
		new Command().lancer();
		System.exit(0);
	}

}
