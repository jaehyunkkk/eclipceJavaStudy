package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L14StreamAPI {

	static int sum;
	
	public static void main(String[] args) {
		
		//StreamAPI: 모든 자료구조를 동일한 방식으로 다루기 위해 존재(흐름이 있는 자료구조)
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(500);
		numList.add(5030);
		numList.add(5200);
		numList.add(5);
		numList.add(50);
		numList.add(100);
		numList.add(-500);
		
		numList.stream().forEach((num)->{sum += num;});
		System.out.println(sum);
		
		int numArr[] = {1,2,3,4,5};
		sum = 0;
		Arrays.stream(numArr).forEach((num)->{sum += num;});
		System.out.println(sum); 
		
	}
}
