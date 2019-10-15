import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	
	public void serverSetting() throws IOException {
		//생성 및 바인딩
		try {
			// localhost, 9110
			serverSocket = new ServerSocket(9110);
			// 리스닝
			clientSocket = serverSocket.accept();
			// 소켓에 접속 완료 된 부분
			System.out.println("클라이언트 소켓 연결 완료");			
		}catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	public void closeAll() {
		serverSocket.close();
		clientSocket.close();
		dataInputStream.close();
		dataOutputStream.close();
	}
	
	public void streamSetting() {
		dataInputStream = new DataInputStream(clientSocket.getInputStream());
		dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());		
	}
	
	public String dataRecv() {
		try {
			return dataInputStream.readUTF();
		}catch (IOException e) {
			
		}
		return null;
	}
	
	public void dataSend(String sendData) {
		try {
			dataOutputStream.writeUTF(sendData);
		}catch (IOException e) {
			
		}
	}
	
	public Server() throws IOException {
		serverSetting();
		dataRecv();
		dataSend("수신 완료");
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
