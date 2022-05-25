package Chat;

import java.io.IOException;

public class Chap01_ReadCharactersBlock {
	public static void main(String[] args) throws IOException{
		byte[] buffer = new byte[80];
		int data;
		while((data=System.in.read(buffer))>=1){
			System.out.println("data : " + data);
			System.out.write(buffer, 0, data);
		}
	}
}
