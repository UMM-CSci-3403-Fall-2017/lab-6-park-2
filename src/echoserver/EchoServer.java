package echoserver;

import java.net.*;
import java.io.*;


public class EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 6013;

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("server is ready!" +port);

			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Accepted connection from Client!");

				OutputStream out = clientSocket.getOutputStream();
				InputStream reader = clientSocket.getInputStream();

				int newType;

				while((newType = reader.read()) != -1) {
					System.out.println(newType);

				}

				out.flush();
				clientSocket.close();

			}

		} catch (IOException ioe) {
			System.out.println("ERROR!");
			System.out.println(ioe);

		}
	}
	
}
