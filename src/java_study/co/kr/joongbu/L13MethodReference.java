package java_study.co.kr.joongbu;

import java.util.function.Function;

public class L13MethodReference {

	public static void main(String[] args) {

		//메소드 참조
		Function<String, Integer> parseInt = (s)->{return Integer.parseInt(s);};
		Function<String, Integer> parseInt2 = s -> Integer.parseInt(s);
		Function<String, Integer> parseInt3 = Integer::parseInt;
		
		System.out.println(parseInt3.apply("99")*3);
	}

}
