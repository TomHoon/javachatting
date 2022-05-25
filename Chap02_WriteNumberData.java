package Chat;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chap02_WriteNumberData {
	public static void main(String[] args) throws IOException{
		try {
			FileOutputStream fos;
			fos = new FileOutputStream("C:/Users/dw/Documents/tom/tempFolder/example0520.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeBoolean(true);
			dos.writeDouble(05.20);
		} catch (FileNotFoundException e) {
			System.err.println("올바른 경로가 아닙니다.");
		} 
	}
}
