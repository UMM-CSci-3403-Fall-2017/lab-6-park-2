import java.net.*;
import java.io.*;

public class DateServer {
  public static void main(String[] args) {
    try {
      ServerSocket sock = new ServerSocket(6013);
      
      while (true) {
        System.out.println("Got a request!");
        Socket client = sock.accept();
        
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        
        writer.println(new java.util.Date().toString());
        
        client.close();
      }
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}


