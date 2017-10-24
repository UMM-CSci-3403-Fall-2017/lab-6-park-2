package echoserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 10001;
		

		try{
			serverSocket = new ServerSocket(port);
			System.out.println(GetTime() + "server is ready");
			
			Socket socket = serverSocket.accept();
			InetAddress clientAddress = socket.getInetAddress();
			System.out.println(getTime() + clientAddress + "client access from")
			
			OutputSteam out = socket.getOutputStream();
			InputStream in = socket.getInputStream();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedRead br = new BufferedReader(new InputStreamReader(in));

			String recvStr = null;
			while((recvStr = br.readLine()) != null){
				System.out.print.ln(getTime() + "received string from client : " + recvStr);
				pw.println(recvStr);
				pw.flush();
			}

			pw.close();
			br.close();
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static String getTime(){
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}

			















