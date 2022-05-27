package Chat;

import java.io.FileWriter;
import java.io.IOException;

//FileWriter 클래스를 이용한 
//파일에 문자 작성하기
public class Chap04_WriteCharacter {
	public static void main(String[] args){
		String text = "안녕하세요";
		try {
			//경로는 정확해야합니다.
			//그러나 파일은 실제로 존재하지 않아도 
			//자동으로 생성됩니다.
			
			FileWriter fw = new FileWriter("C:/Users/dw/Documents/tom/tempFolder/05271301.txt");
			fw.write(text,0,text.length());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.err.println("파일을 찾지 못했습니다.");
		}
	}
}
