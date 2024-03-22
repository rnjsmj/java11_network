package kr.or.iei.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		Socket socket = null;
		int port = 8000;//* => 8888
		//밑에서 Socket으로 연결할 port번호는 문제에서 제시한 8888번이므로 틀림
		try {
			socket = new Socket("localhost", port);
//			if(socket == null) {
				// null일 경우 연결 x
			if(socket != null) {
				System.out.println("[Client]");
				System.out.println("서버와 연결 성공!");
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
			// 이하 코드는 중간 생략..
			}
		}catch (IOException e){}
	}

}
