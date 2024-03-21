package sec2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket server = null; //서버 소켓
		Socket socket = null; //클라이언트용 소켓
		Scanner sc = new Scanner(System.in);
		
		BufferedReader in = null; //메시지 읽기
		PrintWriter out = null; //메시지 보내기
				
		try {
			server = new ServerSocket(6000); //포트 번호로 서버 시작
			System.out.println("서버 포트 : 6000");
			socket = server.accept(); //클라이언트 연결 대기
			System.out.println("... 연결 대기 중 ...");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			//읽기, 보내기 반복
			while(true) {
				//클라이언트로부터 들어온 input 읽어오기
				String inMessage = in.readLine();
				System.out.println("[From Client] : " + inMessage);
				if("quit".equalsIgnoreCase(inMessage)) break;
				// 클라이언트로 보낼 메시지 output
				System.out.print("[Send to Message] : ");
				String outMessage = sc.nextLine();
				out.println(outMessage); //outMessage를 Stream에 저장
				out.flush(); //Stream에 저장된 메시지를 전달
				if("quit".equalsIgnoreCase(outMessage)) break;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[소켓 연결 오류]");
		} finally {
			try {
				sc.close();
				socket.close();
				server.close();
				System.out.println("[연결 종료]");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("[소켓 연결 종료 오류]");
			}
			
		}
	}
}
