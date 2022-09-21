package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.List;

public class L15StreamAPIEx {

	static int sum;
	
	public static void main(String[] args) {
		
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(500);
		numList.add(5030);
		numList.add(5200);
		numList.add(5);
		numList.add(null);		
		numList.add(50);
		numList.add(100);
		numList.add(-500);
		
		numList.stream()
			.filter(n->n!=null) //검사식에서 true만 stream으로 다시 반환
			.forEach((n)->{sum += n;});
	}
}
