package archioo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Command implements IHM {
	
	private Scanner sc;
	
	public Command() {
		sc = new Scanner(System.in);
	}

	@Override
	public void lancer(int port) {
		String stop;
		do {
			Socket socket = null;
			try {
				socket = new Socket(InetAddress.getLocalHost().getHostName(), port);
				System.out.println(MyProperties.readProperty("FIRST_DIGIT"));
				float a = sc.nextFloat();
				System.out.println(MyProperties.readProperty("SECOND_DIGIT"));
				float b = sc.nextFloat();
				System.out.println(MyProperties.readProperty("OPERATION"));
				char sign = sc.next().charAt(0);
				Node n = new Node(a, b, sign);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(n);
				System.out.println("Sent " + n.toString());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				System.out.println(ois.readObject());
			} catch (InputMismatchException e) {
				System.out.println(MyProperties.readProperty("BAD_INPUT"));
			} catch (ClassNotFoundException | IOException e){
				System.out.println("Catch client " + e.getMessage());
			} finally {
				sc = new Scanner(System.in);
				System.out.println(MyProperties.readProperty("STOP"));
				stop = sc.next();
			}
		} while (!stop.equals("1"));
	}

}
