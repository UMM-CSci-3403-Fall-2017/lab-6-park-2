package echoclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) {
		try{
			String ip = "localhost";
			int port = 10001;
			Socket socket = new Socket(ip, port);

			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String myMsg = null;
			String echo = null;

			while((myMsg = input.readLine()) != null) {
				if(myMsg.equals("/q")) {
					break;

				}

				pw.println(myMsg);
				pw.flush();
				
				echo = br.readLine();
				System.out.println("Server: " + echo);

			}

			pw.close();
			br.close();
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
	}

}

}
