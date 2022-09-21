package java_study.co.kr.joongbu;

import java.time.LocalTime;

class Clock implements Runnable{

	@Override
	public void run() {

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
	}
	
}

public class L09MultiTread {

	public static void main(String[] args) {
		
		System.out.println("멀티 스레드 입니다");
		
		System.out.println("clock 시작");
		Clock c = new Clock();
		Thread clockT = new Thread(c); //스레드를 run()에 작성된 코드로 생성, 스레드의 매개변수는 Runnable 타입만 가능
		clockT.start();
		
		System.out.println("멀티 스레드 입니다");
	}
}
