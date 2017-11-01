package echoserver;

import java.net.*;
import java.io.*;


public class EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 6013;

		try {
			ServerSocket socket  = new ServerSocket(port);

			while (true) {
					
				Socket clientSocket = socket.accept();
				System.out.println("Accepted connection from Client!");
				
				InputStream reader = clientSocket.getInputStream();
				OutputStream output = clientSocket.getOutputStream();

				int newType;

				while((newType = reader.read()) != -1) {
					output.write(newType);

				}
				
				
				output.flush();
				output.close();
				reader.close();
				clientSocket.close();
				
			}

		} catch (IOException ioe) {
			System.out.println("ERROR!");
			System.out.println(ioe);

		}
	}
	
}
