package Chat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Chap03_WriteRandom extends Frame implements ActionListener{
	
	private TextField accountField, nameField, balanceField;
	private Button enter, done;
	private RandomAccessFile output;
	private Record data;
	public Chap03_WriteRandom() throws FileNotFoundException {
		super("파일쓰기");
		data = new Record();
		output = new RandomAccessFile("C:/Users/dw/Documents/tom/tempFolder/example1434.txt", "rw");
		setSize(300, 150);
		setLayout(new GridLayout(4,2));
		add(new Label("구좌번호"));
		
		accountField = new TextField();
		add(accountField);
		add(new Label("이름"));
		
		nameField = new TextField(20); //20의 유무에 따라 어떤 변화가 있나 확인하기
		add(nameField);
		add(new Label("잔고"));
		
		balanceField = new TextField(20);
		add(balanceField);
		
		enter = new Button("입력");
		enter.addActionListener(this);
		add(enter);
		
		done = new Button("종료");
		done.addActionListener(this);
		add(done);
		setVisible(true);
	}
	public void addRecord() throws IOException{
		int accountNo= 0;
		Double d;
		
		if(!accountField.getText().equals("")){
			accountNo = Integer.parseInt(accountField.getText());
			if(accountNo > 0 && accountNo <=100){
				data.setAccount(accountNo);
				data.setName(nameField.getText());
				d = new Double(balanceField.getText());
				data.setBalance(d.doubleValue());
				output.seek((long)(accountNo-1)*Record.size());
				data.write(output);
			}
			//텍스트 필드의 내용을 지운다.
			accountField.setText("");
			nameField.setText("");
			balanceField.setText("");
		}
	}
	
	public void ActionPerformed(ActionEvent e) throws IOException{
		addRecord(); // 입력된 데이터를 저장한다.
		if(e.getSource()==done){
			output.close();
			System.exit(0);
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		new Chap03_WriteRandom();
	}

	static class Record
	{
		private int account;
		private String name;
		private double balance;
		//RandomAccssFile로부터 한 레코드를 읽는다.
		public void read(RandomAccessFile file) throws IOException {
			account = file.readInt(); //파일로부터 구좌번호를 읽는다.
			char namearray[] = new char[15];
			for(int i =0; i<namearray.length; i++){
				namearray[i] = file.readChar();
			}
			name = new String(namearray);
			balance = file.readDouble();
		}
		//RandomAccessFile에 한 레코드를 저장한다.
		public void write(RandomAccessFile file) throws IOException{
			StringBuffer buf;
			file.writeInt(account);//file에 구좌번호를 저장한다.
			if(name !=null)
				buf = new StringBuffer(name);
			else
				buf = new StringBuffer(15);
			
			buf.setLength(15);
			file.writeChars(buf.toString());
			file.writeDouble(balance);
			}
		
		public void setAccount(int a ){ account = a;} //구좌번호를 설정한다.
		public int getAccount(){return account;} //구좌번호를 반환한다.
		public void setName(String f){name = f;}
		public String getName(){return name;}
		public void setBalance(double b){balance = b;}
		public double getBalance(){return balance;}
		public static int size(){return 42;} // 한 레코드의 길이
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
