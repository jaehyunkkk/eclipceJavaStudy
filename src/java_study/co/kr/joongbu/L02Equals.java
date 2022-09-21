package java_study.co.kr.joongbu;

import java.util.Objects;

class PersonTest{
	String name;
	int age;
	
	public PersonTest(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonTest other = (PersonTest) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
}

public class L02Equals {
	
	public static void main(String[] args) {
		PersonTest kim1 = new PersonTest("kim", 20);
		PersonTest kim2 = new PersonTest("kim", 20);
		System.out.println(kim1 == kim2);
		System.out.println(kim1.equals(kim2));
	}
}
