package archioo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
	
	private static final Logger LOGGER = Logger.getLogger(Exception.class.getName());
	
	public static void main(String[] args) {
		try {
			CalculatorConf.init();
			int port = 5000;
			new Thread(new Runnable() {
				public void run() {
					try {
						Server.launch(port);
					} catch (ClassNotFoundException | IOException e) {
						e.printStackTrace();
						LOGGER.log(Level.WARNING, "An error occured");
					}
				}
			}).start();
			IHM ihm = new Command();
			ihm.lancer(port);
			System.exit(0);
		} catch (IOException | NullPointerException e) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING, "An error occured");
			System.exit(1);
		}
	}

}
