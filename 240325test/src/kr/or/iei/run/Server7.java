package kr.or.iei.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		int port = 8888;
		ServerSocket server = null;
		try {
//			server = new ServerSocket("localhost", port);
			//port 번호만 입력
			server = new ServerSocket(port); 
			//accept()구문 없음 => 대기모드 불가, socket 생성 안됨
			// => 추가 필요
			//=>
			Socket socket = server.accept();
			System.out.println("[Server]");
			System.out.println("클라이언트의 요청을 기다리고 있습니다...");
			System.out.println(socket.getInetAddress().getHostAddress() + " 가 연결을 요청함...");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter((socket.getOutputStream()));
			// 이하 코드는 중간 생략..
		} catch (IOException e){}
	}

}
