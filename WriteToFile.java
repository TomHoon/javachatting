package Chat;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
	static FileOutputStream fout;
	
	public static void main(String[] args){
		int byteRead;
		byte[] buffer = new byte[256];
		try {
			fout = new FileOutputStream("C:/Users/dw/Documents/tom/tempFolder/example1_9.txt");
			while((byteRead = System.in.read(buffer))>=0){
				fout.write(buffer,0,byteRead);
			}
			
		} catch (IOException e) {
			System.err.println("스트림으로부터 데이터를 읽을 수 없습니다.");
		}finally{
			if(fout != null)
				try {
					fout.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				
				}
		}
	}
}
