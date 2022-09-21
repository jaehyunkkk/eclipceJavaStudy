package java_study.co.kr.joongbu;

import java.time.LocalTime;

public class L08Thread {

	public static void main(String[] args) {
		
		//스레드: 실행 단위(일꾼), main 메소드가 1개 가지고 있다.(순차적 언어)
		
		
		boolean start = true;
		while(start) {
			System.out.println(LocalTime.now());
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("끝");
	}
}
