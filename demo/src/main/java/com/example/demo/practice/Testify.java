package com.example.demo.practice;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Testify {
	public static void main(String[] args) {
		String str="ilovejavatechie";
		//Occurance
		Map<String, Long> collect = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect);
	}

}
