package com.lambdaex;
//더하기 연산 메서드 보유한 인터페이스 정의
@FunctionalInterface
interface MyCal{
	double calc(double x, double y);
}
//위 인터페이스를 메서드의 파람으로 가지고있는 클래스 정의
class Me3{
	public void doSome(MyCal cal) {
		double result = cal.calc(10, 10);
		System.out.println("결과 : " + result);
	}
}
public class ReturnLambdaEx {
	
	public static void main(String[] args) {
		/*
		 * 리턴문이 존재하는 람다 표현식
		 * return이 있을 경우엔 중괄호와 함께 return을 명기만 하시면 됩니다
		 * 하나만 있을땐 생략가능하지만, 그냥 {}쓰세요
		 * 나머진 다 같습니다
		 */
		Me3 me = new Me3();
		me.doSome((x,y)->{
			double result = x + y;
			return result;
		});
		
		me.doSome((x,y) -> sum(x,y));
	}
	
	//아래에 두수를 더한 결과를 리턴하는 메서드 정의합니다.
	public static double sum(double x, double y) {
		return(x+y);
	}
}
