package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chap02_ReadNumberData {

	public static void main(String[] args) throws IOException {
		//데이터 쓰기
		FileOutputStream fos = new FileOutputStream("C:/Users/dw/Documents/tom/tempFolder/example1344.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeBoolean(true);
		
		dos.writeDouble(35.5);
		
		dos.writeUTF("안녕");
		
		//데이터 읽기
		FileInputStream fis = new FileInputStream("C:/Users/dw/Documents/tom/tempFolder/example1344.txt");
		DataInputStream dis = new DataInputStream(fis);
		
		boolean a = dis.readBoolean();
		System.out.println("boolean a ::: " + a);
		
		double b = dis.readDouble();
		System.out.println("double b ::: " + b);
		
		String c = dis.readUTF();
		System.out.println("String c ::: " + c);
	}
}
