package com.lambdaex;

@FunctionalInterface //특정 인터페이스를 함수형 인터페이스로 선언하는 어노테이션 입니다
	//이렇게 선언된 인터페이스는 람다식으로 표현 가능합니다
	//단, 주의할 점은 반드시 메서드가 하나만 존재 해야합니다
	//만약 하나이상 존재하면 함수형 인터페이스로 선언 불가능 합니다
interface Calcurable {
	//추상 메서드 하나 보유함
	void calculator(int x, int y);
}
public class LambdaEx1 {

	public static void main(String[] args) {
		
		//람다시 : ([파람1],[파람2])->{구현체}
		
		//익명클래스 구현
//		new calcurable() {
//			
//			@Override
//			public void calculator(int x, int y) {
//				// TODO Auto-generated method stub
//				
//			}
//		};
//		(x,y)->{}
		
		action((x, y)->{
			int result = x + y;
			System.out.println("result = " + result);
		});
		
		
	}
	public static void action(Calcurable calcurable) {
		int x = 10;
		int y = 4;
		
		//여기서 Calcurable의 메서드를 이용해서 데이터 처리를 합니다
		calcurable.calculator(x, y);
	}
}
