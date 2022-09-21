package java_study.co.kr.joongbu;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class L22FileWriter {

	public static void main(String[] args) {

		FileWriter fw = null;  //문자열을 파일로 출력하는 객체
		BufferedWriter bw = null;  //보조 스트림
		
		try {
			fw = new FileWriter("newFile2.txt");  //상대경로
			bw = new BufferedWriter(fw);
			bw.write("안녕");  //파일에 내용 추가
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw!=null)bw.close();
				if(fw!=null)fw.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}

}
