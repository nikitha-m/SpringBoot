import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class FileIO {
	public static void main(String args[]) throws FileNotFoundException,IOException{
		char c;
		int i;
		FileInputStream fin = new FileInputStream("/FinalJava/src/Test.txt");
		FileOutputStream fout = new FileOutputStream("/FinalJava/src/Test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			c = (char)br.read();
			if(c != 'q') {
				fout.write(c);
			}
		}while(c!='q');
		do {
			i = fin.read();
			if(i!= -1) {
				System.out.println(i);
			}
		}while(i!=1);
		fin.close();
		fout.close();
	}
}
