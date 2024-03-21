package sec2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) {
		Socket socket = null; //클라이언트용 소켓
		Scanner sc = new Scanner(System.in);
		
		BufferedReader in = null; //메시지 읽기
		PrintWriter out = null; //메시지 보내기
		
		try {
			socket = new Socket("127.0.0.1", 6000); //서버 연결
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			//읽기, 보내기 반복
			while(true) {
				// 서버로 보낼 메시지 output
				System.out.print("[From Client] : ");
				String outMessage = sc.nextLine();
				out.println(outMessage); //outMessage를 Stream에 저장
				out.flush(); //Stream에 저장된 메시지를 전달
				if("quit".equalsIgnoreCase(outMessage)) break;
				
				//서버로부터 들어온 input 읽어오기
				String inMessage = in.readLine(); //Stream에 있는  메시지 읽어오기
				System.out.println("[From Server] : " + inMessage);
				if("quit".equalsIgnoreCase(inMessage)) break;	
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[클라이언트 통신 오류]");
		} finally {
			try {
				sc.close();
				socket.close();
				System.out.println("[클라이언트 소켓 연결 종료]");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("[클라이언트 소켓 연결 종료 오류]");
			}

		}
	}
}
