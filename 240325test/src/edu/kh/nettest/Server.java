package edu.kh.nettest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			ServerSocket server = new ServerSocket(3000); //포트 번호로 서버 시작
			Socket socket = server.accept(); //클라이언트 연결 대기
			
			while(true) {
				InetAddress add = socket.getInetAddress();
				System.out.println(add);
				if (sc.next().equalsIgnoreCase("quit")) {
					sc.close();
					socket.close();
					server.close();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
//		try {
//			sc.close();
//			socket.close();
//			server.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}


