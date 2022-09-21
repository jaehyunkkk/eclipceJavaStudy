package java_study.co.kr.joongbu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class L11Swing {

	static boolean start = true;
	
	public static void main(String[] args) {

		//Frame awt -> JFrame Swing
		//JFrame Swing: GUI 제공 객체
//		JFrame frame = new JFrame("swing frame");
//		JButton btn1 = new JButton("버튼1 component");
//		JButton btn2 = new JButton("버튼2 component");
//		
////		frame.add(btn1,BorderLayout.CENTER);
////		frame.add(btn2,BorderLayout.NORTH);
//		
//		frame.setLayout(null); //레이아웃을 없에면 위치나 크기로 컴포넌트의 위치 조정 가능
//		btn1.setBounds(0,0,150,100);
//		btn2.setBounds(150,0,150,100);
//		frame.add(btn1);
//		frame.add(btn2);
//		
//		frame.setBounds(100,100,300,200);
//		frame.setVisible(true);
		
		
		
		JFrame frame = new JFrame("swing frame");
		JButton btn1 = new JButton("시간 출력");
		JButton btn2 = new JButton("멈춤");
		JLabel label = new JLabel("현재 시간 출력");
		label.setFont(new Font("Serif", Font.BOLD, 20));
		
		
		Thread clockThread = new Thread(()->{
			while(start) {
				label.setText(LocalTime.now().toString());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!start) start = true;
				else clockThread.start();
			}
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start = false;
			}
			
		});
		
		frame.setLayout(null);
		btn1.setBounds(0,0,100,80);
		btn2.setBounds(150,0,100,80);
		label.setBounds(0,100,300,100);
		
		frame.add(btn1);
		frame.add(btn2);
		frame.add(label);
		frame.setBounds(100,100,300,200);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //화면 종료 시 콘솔 종료
		frame.setVisible(true);
		
	}
}
