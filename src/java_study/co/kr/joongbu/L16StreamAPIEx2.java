package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class L16StreamAPIEx2 {

//	enum Cate{
//		식품,의류,가구,문구,침구
//	}
	
	interface Cate{
		public static int 식품 = 0;
		public static int 의류 = 1;
		public static int 가구 = 2;
		public static int 문구 = 3;
		public static int 침구 = 4;
		
	}
	
	//Variable Object, Data Transfer Object
	class Product{
		
		String name;
		int price;
		int category; //0:식품, 1:의류, 2:가구, 3:문구, 4:침구
		int quantity = 10;
		
		public Product(String name, int price, int category) {
			this.name = name;
			this.price = price;
			this.category = category;
		}
		public Product(String name, int price, int category, int quantity) {
			this.name = name;
			this.price = price;
			this.category = category;
			this.quantity = quantity;
		}
		@Override
		public String toString() {
			return "Product [name=" + name + ", price=" + price + ", category=" + category + ", quantity=" + quantity
					+ "]";
		}
	}
	
	public static void main(String[] args) {
	
		L16StreamAPIEx2 ex2 = new L16StreamAPIEx2();
		List<Product> products = new ArrayList<Product>();
		products.add(ex2.new Product("허쉬", 1000, Cate.식품));
		products.add(ex2.new Product("우유", 2200, Cate.식품, 5));
		products.add(ex2.new Product("바나나 우유", 5500, Cate.식품, 3));
		products.add(ex2.new Product("돼지바", 2000, Cate.식품, 15));
		products.add(ex2.new Product("돼지바", 2000, Cate.가구, 15));
		products.add(ex2.new Product("돼지바", 50000, Cate.가구, 15));
		products.add(ex2.new Product("돼지바", 100, Cate.가구, 15));
		products.add(ex2.new Product("돼지바", 3000, Cate.가구, 15));
		products.add(ex2.new Product("돼지바", 20000, Cate.가구, 15));
		
//		System.out.println(products.toString());
		
		//식품 중 2000언이 넘는 것들 출력
		Optional<String> pd = products.stream()
			.filter((p)->p.category == Cate.식품)  //if와 같으 역할   //중간 연산(stream을 다시 반환)
			.filter((p)->p.price >= 2000)
			.map((p)->p.name) //map: 원하는 반환값으로 변경
			.reduce((p1, p2)->p1+", "+p2);   //BiOperator : (s1,s2)->{return s3};
//			.forEach((p)->System.out.println(p));  //forEach(Sysout.out::println);

		System.out.println(pd.get());
			
			
			
		
		//가구들의 가격 총합 출력
		//1.
		Optional<Integer> sum = products.stream()
			.filter((p)->p.category == Cate.가구)
			.map((p)->p.price * p.quantity)
			.reduce((i1,i2)->i1+i2);
		
		System.out.println(sum.get());
		
		//2.
		int sum2 = products.stream()
				.filter((p)->p.category == Cate.가구)
				.mapToInt((p)->p.price * p.quantity)
				.sum();
			
		System.out.println(sum);
		
		
		
		
		
		
		
		
		
		//Optional(data가 null일 수 있으니 처리하도록 명시하는 타입
		Optional<Integer> i = Optional.empty();  //Optional 선언법
		i = Optional.ofNullable(99);  //Optional 데이터 참조
//		System.out.println(i+10);   type error
//		System.out.println(i.get()+10);   null error
		
		//isPresent()는 값이 있을 때만  True 리턴, isEmpty()는 null일 때만 True 리턴
		if(i.isPresent()) {
			System.out.println(i.get()+20);
		}
		else {
			System.out.println("null입니다.");
		}
		
		
		i.ifPresent((num)->{
			System.out.println("값이 있을 때만 실행되는 함수");
		});
		i.ifPresentOrElse((num)->{System.out.println("값이 있을 때");}, ()->{System.out.println("null일 때");});
		
		
		
		
		
		//grouping
		Map<Integer, List<Product>> groupingList = products.stream()
			.collect(Collectors.groupingBy(p->p.category));
		System.out.println(groupingList);
		System.out.println(groupingList.get(Cate.의류));
	}
}
