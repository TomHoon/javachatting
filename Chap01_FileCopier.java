package Chat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chap01_FileCopier {
	static byte[] buffer = new byte[256];
	static int byteRead;
	
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("C:/Users/dw/Documents/tom/tempFolder/example1_9.txt");
		FileOutputStream fos = new FileOutputStream("C:/Users/dw/Documents/tom/tempFolder/example1_10.txt");
		
		while((byteRead=fis.read(buffer))>=0){
			fos.write(buffer,0,byteRead);
		}
		fis.close();
		fos.close();
	}
}
