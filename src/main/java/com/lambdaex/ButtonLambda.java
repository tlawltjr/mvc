package com.lambdaex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Button {
	
	//정적메서드처럼 사용되는 인터페이스 구현합니다
	@FunctionalInterface
	static interface ClickListener{
		//추상메서드
		void onClick();//클릭이벤트 발생마다 일을 표현
	}
	
	private ClickListener clicklistener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clicklistener = clickListener;
	}
	
	public void click() {
		this.clicklistener.onClick();
	}
}

public class ButtonLambda {
	
	public static void main(String[] args) {
		Button okBtn = new Button();
		//ok버튼에 람다식으로 클릭리스너 익명 구현 객체를 주입합니다
		okBtn.setClickListener(()->{
			System.out.println("ok버튼을 클릭했어요.");
		});	
		
		okBtn.click();
		
		Button canBtn = new Button();
		
		canBtn.setClickListener(()->{
			System.out.println("캔슬을 하셨네요.");
		});
		canBtn.click();
		
		java.awt.Button btn = new java.awt.Button("ok");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btn.addActionListener((a)->{
			
			
		});
	}
	
}