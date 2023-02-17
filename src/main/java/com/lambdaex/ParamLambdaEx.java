package com.lambdaex;

@FunctionalInterface
interface Workable2{
	void working(String name,String job);
}

@FunctionalInterface
interface SaySomething{
	void says(String content);
}
class Me2{
	public void doSome1(Workable2 work2) {
		work2.working("심지석", "수업");
	}
	public void doSome2(SaySomething say) {
		say.says("오늘 하루도 즐겁게 수업해요");
	}
}
	
public class ParamLambdaEx {

	/*
	 * 파라미터가 있는 람다식 문법입니다
	 * 파라미터의 타입을 생략가능하며, 넣을 수도 있습니다
	 * 그리고 var(얘는 타입을 생략, 즉 구체적 타입을 생략할때 씁니다.)라는 애도 사용가능한데, 일반적으로는 파라미터 생략해서 씁니다.
	 * 아래는 문법입니다.
	 * 
	 * (타입 Param, 타입 Param..)->{
	 * 		구현부
	 * }
	 * (var Param, var Param...)->{
	 * 		구현부
	 * }
	 * (param, param)->{              <------제일 많이 쓰는 문법
	 * 		구현부
	 * }
	 * 또한 파라미터가 하나만 존재할때는 괄호를 생략할 수 있습니다.
	 * 
	 * param->{} or param -> 실행문(하나만 존재할 경우)
	 */
	public static void main(String[] args) {
		Me2 me = new Me2();
		
		me.doSome1((name,job)->{
			System.out.println(name + "학생이 " + job + "를 합니다");
		});
		me.doSome2((say)->{
			System.out.println(say);
		});
	}
	
}
