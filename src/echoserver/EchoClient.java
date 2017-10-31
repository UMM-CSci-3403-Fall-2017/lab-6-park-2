package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String [] args) {
		try{
			String ip = "localhost";

			int port = 6013;
			Socket socket = new Socket(ip, port);
			
			InputStream stdIn = System.in;
			OutputStream stdOut = System.out;

			InputStream reader = socket.getInputStream();
			OutputStream output = socket.getOutputStream();

			int NewByte;
			int anotherByte;

			
			while((NewByte = System.in.read()) != -1){
				output.write(NewByte);
				anotherByte = reader.read();
				System.out.write(anotherByte);

			}

			output.flush();
			System.out.flush();
			stdOut.flush();
			stdIn.close();
			socket.close();

		} catch (IOException ioe) {
			System.out.println("ERROR");
			System.out.println(ioe);
		}
	}
}

