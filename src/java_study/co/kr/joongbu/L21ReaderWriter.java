package java_study.co.kr.joongbu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L21ReaderWriter {

	public static void main(String[] args) {

//		System.out.println("아스키코드의 문자만 입력 하세요: ");
//		
//		try {
//			int input = -1;
//			while((input = System.in.read()) != 13) {
//				System.out.println("입력값의 번호: " + input);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		
		String inputStream = "";
		try {
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
