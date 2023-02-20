import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Me{
	Long age;
	
	public Me(Long age) {
		this.age = age;
	}
}

public class StreamExam {

	//long을 파라미터로 받는 메서드 정의합니다
	public static void doSome(Long lo) {
		
	}
	public static void main(String[] args) {
		int i =10;
		long lo = 10L;
		Long loObj = 10L;
		
		//doSome 호출 가능여부 확인해보세요
		doSome(loObj);
		
		List<String> list = Stream.of(1.0, 2.0)
		.mapToInt(Double::intValue)
		.mapToObj(String::valueOf)
		.collect(Collectors.toList());
		
		System.out.println(list.size());
		list.forEach(System.out::println);
		
		IntStream
		.rangeClosed(((int)(Math.random() * 100) + 1),((int)(Math.random() * 300) + 1))
		.asLongStream()
		.sorted()
		.forEach(ii->{
			System.out.println(ii);
			doSome(ii);
		});
		
		
		List<Me> list2 = IntStream.range(1, 21)
		.asLongStream()
		.mapToObj(j->{
			Me me = new Me(j);
			return me;
		})
		.collect(Collectors.toList());
		
		System.out.println(list2.size());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
