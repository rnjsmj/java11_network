package edu.kh.nettest;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class IOService {

	public static void main(String[] args) {
		output1();
	}
	
	public static void output1() {
//		FileOutputStream fos = null;
		//FileOutputStream 클래스는 바이트 단위 전송이므로
		//2byte인 한글을 write하게 되면 정상적으로 인코딩되지 않고 손상되어 저장된다. (11, 13행)
		//=> FileWriter 클래스로 변경
		FileWriter fw = null;
		try {
//			fos = new FileOutputStream("text.txt");
			fw = new FileWriter("test.txt");
			
			//FileWriter를 사용해야 함
			String str = "안녕하세요!";
			fw.write(str);
			
//			for (int i=0; i<str.length(); i++) {
//				fos.write(str.charAt(i));
//			}
		}catch (IOException e) {
			e.printStackTrace();
		} // 예외발생 유무와 상관 없이 사용한 file 자원은 닫아서 반환해야 하는데,
		// 반환하는 close()구문이 없으므로 반환 의무를 위배함
		// 20행의 뒤에
		finally {
			try {
				fw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
