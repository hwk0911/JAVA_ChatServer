package echoServer;

import java.net.*;
import java.io.*;

public class echoServer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket serverSock = null;
		try {
			serverSock = new ServerSocket(8899);
		}catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		Socket clinetSock = null;
		System.out.println("Listening for connection...");
		
		try {
			clinetSock = serverSock.accept();
		}catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println("[+]Connection successful.");
		System.out.println("[+]Listening for input.");
		
		PrintWriter output = new PrintWriter(clinetSock.getOutputStream(), true);
		BufferedReader br = new BufferedReader(new InputStreamReader(clinetSock.getInputStream()));
		
		String inputLine;
		
		while((inputLine = br.readLine()) != null) {
			System.out.println("Server : " + inputLine);
			output.println(inputLine);
			
			if(inputLine.contentEquals("bye")) {
				break;
			}
		}
		
		output.close();
		br.close();
		clinetSock.close();
		serverSock.close();
	}

}
