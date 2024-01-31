package draft;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Occurence {
	static String s = "is this a this yes this is a this what it may be i do not care about this";
	public static void main(String[] args) {
		Map<String, Long> collect = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect);
		String[] words = s.split(" ");
		for(String word:words) {
			
		}
		
	
	}

}
