package IO;

import java.io.*;

public class ReadWrite {
	public static void main(String[] args) throws Exception{
		FileInputStream fin = new FileInputStream("abc.txt");
		FileOutputStream fout = new FileOutputStream("def.txt");
		int i;
		while((i = fin.read())!= -1){
			fout.write((byte)i);
			
			
			
		}
		fin.close();
	}

}
