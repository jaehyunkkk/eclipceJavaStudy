package java_study.co.kr.joongbu;

class ObjectA{
	String a = "ObjectA.a 입니다.";
}

class ObjectB extends ObjectA{
	String b = "ObjectB.b 입니다.";
}

class ObjectC extends ObjectB{
	String c = "ObjectC.c 입니다.";
}

public class L05ExtendsAndType {

	public static void main(String[] args) {
		
		ObjectC c = new ObjectC();
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c.c);
		
		ObjectB b = c;
		ObjectA a = c;
		Object o = c;
		
		//예외처리
		try {
			String s_o = (String)o;
		} catch(ClassCastException e){
			e.printStackTrace();
		}
	}
}
