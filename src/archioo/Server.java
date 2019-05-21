package archioo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static ServerSocket server;
	
	public static void launch(int port) throws ClassNotFoundException, IOException {
		server = new ServerSocket(port);
		while (true) {
			Socket s = server.accept();
			System.out.println("Connection established");
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Object n = ois.readObject();
			System.out.println("Received " + n.toString());
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			try {
				Node node = (Node)n;
				float res = Calculator.execute(node.getSign(), node.getA(), node.getB());
				oos.writeObject(res);
			} catch (ArithmeticException | UnsupportedOperationException e) {
				System.out.println("Error occured");
				oos.writeObject(null);
			}
		}
	}
}
