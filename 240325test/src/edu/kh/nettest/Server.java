package edu.kh.nettest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		//*
//		ServerSocket server = null;
//		Socket socket = null;
		//*/
		try {
//			ServerSocket server = new ServerSocket(); //*
			//**********
			//1. 
			// ServerSocket 객체를 생성하는 과정에서 포트번호가 지정되지 않아
			// 객체가 생성되지 않아 통신을 할 수 없다.
			//************
//			Socket socket = server.accept();//*
			// =>
			ServerSocket server = new ServerSocket(3000);
			Socket socket = server.accept();
			// ServerSocket과 Socket은 예외발생 유무와 상관 없이 사용 후 닫아서 반환해야 하는데
			// try 구문 안에 선언했으므로 try~catch 구문이 끝나고
			// finally 구문에서 server와 socket 객체를 가져올 수 없으므로 해당 ServerSocket과 Socket을 반환할 수 없음
		} catch (IOException e) {
			e.printStackTrace();
//		} finally { //*
//			try {
//				socket.close();
//				server.close();
//			}catch (IOException e) {
//				e.printStackTrace();
//			} 
		}//*/
		
		//
	}

}


