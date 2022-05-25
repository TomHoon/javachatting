package Chat;

import java.io.IOException;

public class Chap01_DisplayString {
	public static void main(String[] args) throws IOException{
		byte[] buffer;
		for(int i=0; i<args.length; i++){
			buffer = args[i].getBytes();
			System.out.write(buffer);
			System.out.write('\n');
		}
	}
}
