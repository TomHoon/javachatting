package Chat;

import java.io.IOException;

public class Chap01_ReadCharacters {
	public static void main(String[] args) throws IOException{
		int data;
		while((data=System.in.read())>=0){
			System.out.write(data);
		}
	}
}
