package edu.kh.nettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			//Socket s = new Socket();
			//*****
			//2.
			// *여러 클래스에서 문제점이 발생한 경우 정확한 클래스명과 행 기제*
			//Socket 객체를 생성하는 과정에서 ServerSocket의 ip 주소와 port 번호가
			// 지정되지 않아 통신을 할 수 없다.
			//*****
			//=> 
			Socket s = new Socket(ip, 3000);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[소켓 연결 오류]");
		} finally {
			
		}
	}

}
