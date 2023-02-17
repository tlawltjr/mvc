package com.lambdaex;

@FunctionalInterface
interface Workable{
	void work();
}
class Me{
	//Me 클래스는 나를 표현하는 클래스로 생각하세요
	//action을 호출하면 직업에 관련된 메서드를 출력할 예정입니다
	//즉 work()를 오버라이드 해서 출력할 예정입니다
	public void action(Workable workable) {
		workable.work();
	}
}
public class Person {

	public static void main(String[] args) {
		//()->{}
		Me me = new Me();
		
		me.action(()->{//구현체 or 구현부
			System.out.println("출근을 먼저 합니다..9시까지");
			System.out.println("그 다음 프로그래밍을 일을 시작합니다");
		});
		
		//구현부의 내용이 하나만 존재한다면(리턴문 포함), 구현 body도 생략가능합니다
		me.action(()->
			System.out.println("출근하자마자 퇴근합니다")
		);
		
		
		
		
	}

}
