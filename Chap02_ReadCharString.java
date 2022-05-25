package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chap02_ReadCharString {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/Users/dw/Documents/tom/tempFolder/example1434.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeChar(65);
		dos.writeUTF("반갑습니다");
		dos.writeUTF("자바 채팅 프로그래밍 교재");
		
		dos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Users/dw/Documents/tom/tempFolder/example1434.txt");
		DataInputStream dis = new DataInputStream(fis);
		char a = dis.readChar();
		System.out.println("a :: " + a);
		
		String b = dis.readUTF();
		System.out.println("b :: " + b);
		
		String c = dis.readUTF();
		System.out.println("c :: " + c);
	}

}
