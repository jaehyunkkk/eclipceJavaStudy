package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GenericTest<T>{
	T name; //기본값은 Object
	
	public GenericTest(T name) {
		this.name = name;
	}
}

interface Carable{}
class Car1 implements Carable{

	@Override
	public String toString() {
		return "Car1 []";
	}
}
class Car2 implements Carable{}
class CarInfo<T extends Carable>{
	T car;
	public void print() {
		System.out.println(car.getClass() + ":" + car.toString());
	}
}


public class L07Generic {

	public static void main(String[] args) {
		
		Car1 c1 = new Car1();
		Car2 c2 = new Car2();
		CarInfo carInfo = new CarInfo();
		carInfo.car = c1;
		carInfo.print();
		
		GenericTest gt = new GenericTest("abc");
		System.out.println(gt.name);
		GenericTest<Integer> gt2 = new GenericTest<Integer>(200);
		System.out.println(gt2.name);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(100);
		System.out.println(list);
		
//		Object birthArr[] = {1986, "2000", 1990.0, 2022f, 1900l};
//		int now = 2022;
//		Object[] ageArr = new Object[5];
//		for(int x = 0;x<birthArr.length; x++) {
//			ageArr[x] = now - (int)birthArr[x];
//			System.out.println(ageArr[x]);
//		}
		
		
		
		
		Map<Integer, String> person = new HashMap<Integer, String>();
		person.put(1986, "kim");
		person.put(1987, "lee");
		person.put(1988, "park");
		System.out.println(person);
		
		Set<Integer> set = new HashSet<Integer>();
		
	}
}
