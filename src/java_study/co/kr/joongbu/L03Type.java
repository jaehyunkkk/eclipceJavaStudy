package java_study.co.kr.joongbu;



class A{
	
}

abstract class B{
	//추상메소드 정의 가능
	public abstract void print();
}

@FunctionalInterface
interface C{
	//추상메소드만 정의 가능(static은 내용 정의 가능)
	public void print();
}

enum E{}





public class L03Type {
	
	class InClass extends B{

		@Override
		public void print() {}
	}

	public static void main(String[] args) {

		A a = new A();
		B b = new B() {
			//생성하며 추상메소드를 구현하면 가능
			//이떄 이너 클래스가 생송되는데 숫자로 정의된 익명 클래스가 만들어진다.
			@Override
			public void print() {
				
			}
		};
		C c = new C() {        
			@Override
			public void print() {
				
			}
		};
		
		B b2 = new L03Type().new InClass();
		
//		B b2 = ()->{};
		C c2 = ()->{};//인터페이스에 추상 메소드가 하나면 람다식으로 추상 메소드를 구현을 하여 객체 생성 가능(함수형 언어)
	}

}
