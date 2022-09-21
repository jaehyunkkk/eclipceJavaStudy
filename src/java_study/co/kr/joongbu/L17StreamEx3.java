package java_study.co.kr.joongbu;

import java.util.Arrays;

public class L17StreamEx3 {

	public static void main(String[] args) {
		
		//***Stream의 목적은 모든 자료형의 반복문을 통일***
		//***일회용***
		
		
		
		//Stream 중간 연산
		
		//sort()
		int numArr[] = {99,-5,1,2,33,-7};
		Arrays.sort(numArr);
		System.out.println(Arrays.toString(numArr));
		
		int numArr2[] = {99,-5,1,2,33,-7};
		Arrays.stream(numArr)
			.sorted()
			.forEach((n)->System.out.println(n));
		
		String strArr[] = {"aaa", "AAA", "BBB", "ddd", "AAA", "aaa"};
		Arrays.stream(strArr)
			.distinct()  //중복 제거
			.sorted()
			.forEach(System.out::println);
		
		int numArr3[] = {0,1,2,3,4,5,6,7,8,9};
		Arrays.stream(numArr)
			.skip(3)  //n만큼 건너뛰는 중간연산
			.limit(3)  //n만큼만 중간연산
			.forEach(System.out::println);
	}
	
}
