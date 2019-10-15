package Client;

import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Client clientSock = null;
		
		try {
			clientSock = new Client();
		}catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		
		Socket serverSock = null;
		System.out.println("[+]Listening for connection");
		
		try {
			serverSock = 
		}
	}

}
