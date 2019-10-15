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
		//���� �� ���ε�
		try {
			// localhost, 9110
			serverSocket = new ServerSocket(9110);
			// ������
			clientSocket = serverSocket.accept();
			// ���Ͽ� ���� �Ϸ� �� �κ�
			System.out.println("Ŭ���̾�Ʈ ���� ���� �Ϸ�");			
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
		dataSend("���� �Ϸ�");
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
