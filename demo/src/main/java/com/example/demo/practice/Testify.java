package com.example.demo.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Testify {
	static int[] numbers= {4,56,76,32,41,70,90,001};
	static String str="itsmemaulee";
	public static void main(String[] args) {
				
		System.out.println(Testify.SecondHighestNumber(numbers));
		System.out.println("Count of alphabets in given String: "+Testify.countingAlphabets(str));
		System.out.println("NonRepeated Letters: "+Testify.getNonRepeatedLetters(str));
		System.out.println(" "+Testify.rotateElemets(numbers));
		System.out.println("Duplicate chars :"+Testify.countDuplicateChars(str));
		System.out.println("First NonRepeat Elements: "+Testify.firstNonRepeatElements(str));
		
	}																			
	
	//problem 01: Finding Second Highest number in given array using stream/java 8
	public static Integer SecondHighestNumber(int[] arr) {
		
		Integer secondHighest = 0;
		secondHighest= Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		return secondHighest;
		
	}
	
	
	//Problem 02: Non repeated  letters
	public static List<String> getNonRepeatedLetters(String s){
		
		return Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(sit->sit.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList());
		
		
	}
	
	
	
	//problem 03: Counting ocurrence of alphabets in a string
	public static Map countingAlphabets(String stringSequence) {
		
		Map map = null;
		Map<String, Long> collect = Arrays.stream(stringSequence.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		return collect;
		
	}
	
	//Problem : Rotate Elements in the array
	//need fix
	public static  int [] rotateElemets(int[] arr) {
		
		int startIndex=arr[0];
		int lastIndex;
		int times=1;
		for(int i=1;i<startIndex;i++) {
			arr[i]=arr[i++];
			
		}
		return arr;
	}
	
	
	//Problem 05: Duplicate 
	public static List countDuplicateChars(String str) {
		List<String> val = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(p->p.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
        return val;
	}
	
	//find first non repeat element from string
	public static String firstNonRepeatElements(String str) {
		String val = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(p->p.getValue()==1).findFirst().get().getKey();
		return val;
	}
	
	//recursive functions
	
	

}
