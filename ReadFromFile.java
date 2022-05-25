package Chat;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromFile {
	static int byteRead;
	static byte[] buffer = new byte[256];
	static FileInputStream fis = null;
	
	public static void main(String[] args){
		try {
			fis = new FileInputStream("C:/Users/dw/Documents/tom/tempFolder/example1_9.txt");
			while((byteRead=fis.read(buffer))>=1){		//파일 -> 메모리
				System.out.write(buffer, 0, byteRead);	//메모리->화면
			}
		} catch (IOException e) {
			System.err.println("스트림으로부터 데이터를 읽을 수 없습니다.");
			
		}
	}
}
