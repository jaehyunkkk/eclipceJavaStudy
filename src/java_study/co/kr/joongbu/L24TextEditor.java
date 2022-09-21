package java_study.co.kr.joongbu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

class TextEditor extends JFrame{
	JTextArea ta;
	JMenuBar mb;
	JMenu menu;
	JMenuItem miNew;
	JMenuItem miOpen;
	JMenuItem miSave;
	JMenuItem miExit;

	public TextEditor() {
		super("텍스트 편집기");
		ta = new JTextArea();
		mb = new JMenuBar();
		menu = new JMenu("파일");
		miNew = new JMenuItem("새로 만들기");
		miOpen = new JMenuItem("열기");
		miSave = new JMenuItem("저장");
		miExit = new JMenuItem("끝내기");
		
		menu.add(miNew);
		menu.add(miOpen);
		menu.add(miSave);
		menu.add(miExit);
		
		mb.add(menu);
		
		this.setJMenuBar(mb);
		this.add(ta);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//'열기' 구현
		miOpen.addActionListener((e)->{
			JFileChooser fileChooser = new JFileChooser();
			int option = fileChooser.showOpenDialog(this);
			if(option == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					Scanner sc = new Scanner(file);
					while(sc.hasNext()) {
						String line = sc.nextLine();
						System.out.println(line);
						ta.append(line + "\n");
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
	}
}

public class L24TextEditor {

	public static void main(String[] args) {

//		JFrame f = new JFrame();
//		f.setBounds(200,10,400,400);
//		f.setVisible(true);
		
		TextEditor editor = new TextEditor();
		editor.setBounds(200,10,400,400);
		editor.setVisible(true);
	}

}
