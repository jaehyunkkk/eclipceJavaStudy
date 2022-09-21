package java_study.co.kr.joongbu;

import java.io.IOException;

public class L20InputOutputStream {

	public static void main(String[] args) {

		//입출력의 기본은 1바이트 기준인 아스키코드
		
		try {
			int a = System.in.read();
			System.out.println(a-'0');
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}