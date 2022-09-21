package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L18StreamAPIEx4 {

	public static void main(String[] args) {
		
		//80미만 점수가 있다면 장학금 지급 불가
		int scoreArrKim[] = {88,50,70,100,30,90};
		int scoreArrLee[] = {90,100,99,100,58,92};
		
		//1.
		long cnt = Arrays.stream(scoreArrKim)
			.filter((s)->s<80)
			.count();
		System.out.println(cnt);
		
		//2.
		boolean b = Arrays.stream(scoreArrKim)
			.allMatch(s->s>=80);  //모두 참인지 확인
//			.anyMatch()  //하나라도 있는지 확인
		if(b) {
			System.out.println("장학금 획득");
		}
		else {
			System.out.println("장학금 획득 실패");
		}
		
		
		
		
		Stream st = Stream.of("A",1,2,"a");
		Stream<String> st2 = Stream.of("12","1","2","21");
		ArrayList<Integer> strList = 
				st2
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayList<Integer>::new));
		System.out.println(strList);
		
		
		
		
		Stream<String> st3 = Stream.of("12","1","2","21");
//		int sum = st3.collect(Collectors.summingInt((str)->Integer.parseInt(str)));
		int sum = st3.mapToInt(Integer::parseInt).sum();
		System.out.println(sum);
	}
}
