package com.fullstack.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	
	//상품목록객체인데 , 상품(Product)를 collection에 저장하고
	//view나 다른 애들에게 주거나 목록을 변경할 로직을 구현합니다
	
	Map<String, Product> products = new HashMap<String, Product>();
	
	//DB를 이용한다는 가정하에 기본 생성자가 호출되는 시점에 
	//몇개의 상품 객체를 생성 후 컬렉션에 put합니다
	public ProductService() {
		Product p = new Product("1", "갤럭시북", "삼성", 1300000, "2023-0214");
		products.put("1", p);
		
		p = new Product("2", "그램", "LG전자", 2000000, "2023-0213");
		products.put("2", p);
		
		p = new Product("3", "젠북", "ASUS", 1000000, "2033-0213");
		products.put("3", p);
		
	}
	//모델은 비즈니스 영역을 담당하고 있기때문에 여기에 보통 View에서 사용자가 요청하는
	//로직처리를 메서드로 표현합니다. 설계에 따라 다양한 메서드를 정의할 수 있지만
	//현재는 목록전체를 리턴, 특정 id에 해당하는 항목을 리턴하는 메서드만 정의합니다
	
	public List<Product> findAll(){
		return new ArrayList<>(products.values());
	}
	
	public Product find(String id) {
		return products.get(id);
	}
	
	
	}
