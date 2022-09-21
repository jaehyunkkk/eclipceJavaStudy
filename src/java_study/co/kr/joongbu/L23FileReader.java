package java_study.co.kr.joongbu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class L23FileReader {

	public static void main(String[] args) {

		//AutoCloseable: try()에서 생성된 객체를 자동으로 close 해주는 기능
		
		try (
			FileReader fr = new FileReader("src/java_study/co/kr/joongbu/L01Variable.java");
			BufferedReader br = new BufferedReader(fr);
		){
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
