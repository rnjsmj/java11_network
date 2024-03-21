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
		Scanner sc = new Scanner(System.in);
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			Socket socket = new Socket(ip, 3000);
			System.out.println("연결");
			
			while(true) {
				if (sc.next().equalsIgnoreCase("quit")) {
					sc.close();
					socket.close();
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[소켓 연결 오류]");
		}
	}

}
