package Chat;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Chap03_FileTest extends Frame implements ActionListener{
	private TextField enter;
	private TextArea output;
	public Chap03_FileTest() {
		super("File 클래스 테스트");
		enter = new TextField("파일 및 디렉토리명을 입력하세요");
		enter.addActionListener(this);
		output = new TextArea();
		add(enter, BorderLayout.NORTH);
		add(output, BorderLayout.CENTER);
		addWindowListener(new WinListener());
		setSize(400, 400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		File name = new File(e.getActionCommand());
		if(name.exists()){
			output.setText(name.getName() + "이 존재한다.\n"
					+ (name.isAbsolute() ? "절대 경로이다.":"절대경로가 아니다.")
					+ (name.isFile() ?"파일이다" : "파일이 아니다")
					+ (name.isDirectory() ? "디렉토리다" : "디렉토리가 아니다")
					+ "마지막 수정 날짜는 : " + name.lastModified()
					+ "\n 파일의 길이는 : " + name.length()
					+ "\n 파일의 경로는 : " + name.getPath()
					+ "\n 절대 경로는 : " + name.getAbsolutePath()
					+ "\n 상위 디렉토리는 : " + name.getParent()
					);
		}
		if(name.isFile()){
			try {
				RandomAccessFile r = new RandomAccessFile(name, "r");
				StringBuffer buf = new StringBuffer();
				String text;
				output.append("\n\n");
				while((text = r.readLine())!=null){
					buf.append(text + "\n");
					output.append(buf.toString());
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
			else if(name.isDirectory()){
				String directory[] = name.list(); //이게 제일 궁금함.. 
				output.append("\n\n 디렉토리의 내용은 : \n");
				for(int i=0; i<directory.length; i++){
					output.append(directory[i]+ "\n");
			}
		}else{
			output.setText(e.getActionCommand() + " 은 존재하지 않는다.\n");
		}
	}
	
	class WinListener extends WindowAdapter{
		public void windowClosing(WindowEvent we){
			System.exit(0);
		}
	}
}
