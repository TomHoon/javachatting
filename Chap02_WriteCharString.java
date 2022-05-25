package Chat;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Chap02_WriteCharString {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = new FileOutputStream("C:/Users/dw/Documents/tom/tempFolder/example0520_1.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("안녕하세요");
		dos.writeUTF("자바 채팅 프로그래밍 진행 중 ");
	}
}
