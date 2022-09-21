package java_study.co.kr.joongbu;

import java.time.LocalTime;

public class L10RunnableLamda {

	public static void main(String[] args) {
		
		//익명 함수
//		Thread clockThread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(LocalTime.now());
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			
//		});
		
		//람다
		Thread clockThread = new Thread(()->{
			while(true) {
				System.out.println(LocalTime.now());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		clockThread.start();
	}
}
