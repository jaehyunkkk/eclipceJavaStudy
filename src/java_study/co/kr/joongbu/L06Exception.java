package java_study.co.kr.joongbu;

import java.util.Scanner;

public class L06Exception {

	public static void main(String[] args) {

		String arr[] = {"a", "b", "c"};
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		try {
			System.out.println(arr[Integer.parseInt(str)]);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		try {
			System.out.println(arr[Integer.parseInt(str)]);
		} catch(NumberFormatException e) {
			System.out.println("정수 입력");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("0~2 입력");
		} catch(Exception e) {
			System.out.println("오류 발생");
		} finally {
			System.out.println("무조건 실행됨");
		}
		
	}

}
