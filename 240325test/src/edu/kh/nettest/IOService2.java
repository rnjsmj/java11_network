package edu.kh.nettest;

import java.io.FileOutputStream;
import java.io.IOException;

public class IOService2 {

	public static void main(String[] args) {
		output1();
	}
	public static void output1() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("text2.txt");
			String str = "점심 뭐먹어?";
			
//			for (int i=0; i<str.length(); i++) {
//				fos.write(str.charAt(i));
				//FileOutputStream은 파일의 내용을 바이트 단위로 쓰기위한 클래스이므로
				//문자 데이터를 통해 쓰면 정상적인 결과가 나오지 않음
				// => str.getBytes()를 이용
//			}
			fos.write(str.getBytes());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
