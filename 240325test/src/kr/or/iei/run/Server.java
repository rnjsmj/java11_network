package kr.or.iei.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		int port = 3333;
		//1. 포트번호 틀림
		String serverIP = "127.0.0.1";
		ServerSocket server = null;
		try {
//			server = new ServerSocket(serverIP, port);
			//2.
			//ServerSocket은 port번호를 이용하여 생성해야 하므로
			//new Serversocket(serverIp, port)와 같이 매개변수 2개로 생성하면
			//ServerSocket 객체가 생성되지 않는다.
			server = new ServerSocket(port);
			//3.
			//accept() 구문 없음
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