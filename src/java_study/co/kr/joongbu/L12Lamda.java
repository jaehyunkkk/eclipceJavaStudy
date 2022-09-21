package java_study.co.kr.joongbu;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Func<T,R>{
	R apply(T t);
}

public class L12Lamda {

	public static void main(String[] args) {
		
		//람다: 클래스처럼 사용하는 함수
		
		Function<Integer, Long> square = (x)->{return (long)x*x;}; //매개변수1, 리턴1
		//BiFunction 매개변수2, 리턴1
		//Consumer //매개변수1, 리턴0
		
		//Predicate: 매개변수와 반환하는 깂이 있는데 반환하는 값의 타입은 무조건 boolean
		Predicate<String> nullCheck=(s)->{return s != null;};
		//Supplier: 반환값만 있는 함수 정의
		Supplier<Integer> randomNum = ()->{return (int)(Math.random()*10)+1;};
		System.out.println(randomNum.get());
		//BinaryOperator(연산하는 함수): 매개변수가 2개이고 반환하는 것이 있으며 매개변수와 반환 값의 타입이 같은 것
		BinaryOperator<Integer> sum = (x,x2)->x+x2;
		System.out.println(sum.apply(45,99));
	}
}
