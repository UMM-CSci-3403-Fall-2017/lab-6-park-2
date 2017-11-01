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

				System.out.println("Accepted connection from Client!");
				Socket clientsocket = socket.accept();
								

				OutputStream out = clientsocket.getOutputStream();
				InputStream reader = clientsocket.getInputStream();

				int newType;

				while((newType = reader.read()) != -1) {
					out.write(newType);

				}
				
				
				out.flush();
				out.close();
				reader.close();
				clientsocket.close();
				
			}

		} catch (IOException ioe) {
			System.out.println("ERROR!");
			System.out.println(ioe);

		}
	}
	
}
