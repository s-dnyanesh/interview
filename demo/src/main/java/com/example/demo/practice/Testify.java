package com.example.demo.practice;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.example.demo.models.City;
import com.example.demo.models.Employee;
import com.example.demo.models.Student;

@Component
public class Testify {
	static DecimalFormat df=new DecimalFormat("#.##");
	static int[] numbers= {99,4,56,76,32,41,70,90,001,91,0,97,113,30};
	static String str="itsmemaulee";
	static public List cities= Arrays.asList("Pune","mumbai","kolhapur","Solapur");
	static public List students= new ArrayList();
	static int[] arr1= {2,3};
	static int [] arr2 = {4,2,7};
	static int [] arr3 = {1};
	static int[][] fullarray= {arr1,arr2,arr3};
	static List<Employee> emplist=Arrays.asList(
			new Employee("1", "Rohit","male", "IT",12,12000,2010),
			new Employee("2", "Mohini","female", "Mech",16,34000,2013),
			new Employee("3", "Gauri","female", "IT",43,78000,2018),
			new Employee("3", "SHONA","male", "Mech",57,10000,2017),
			new Employee("3", "Tarun","male", "Mech",34,8000,2023)
			);
	// [1, [2, 3], 8, [6, 1]]

	
	   
	
	
	public static void main(String[] args) {
		HashMap<String, List<String>> mp= new HashMap<>();
		mp.put("Maharashtra", Arrays.asList("Pune","Mumbai"));
		mp.put("Bihar", Arrays.asList("Patna","gaya"));
		mp.put("Andhra pradesh", Arrays.asList("Hyderabad"));
		mp.put("UP", Arrays.asList("Ayodhya","sangam"));
		students.add(new Student("Soham","pune","IT"));	
		System.out.println("countEmployeesinDept  "+countEmployeesinDept(emplist));
		System.out.println("sort and merge 2 d array  "+ Arrays.toString(sortAndMerge2dimArray(fullarray)) );
		System.out.println("SecondHighestNumber  "+Testify.SecondHighestNumber(numbers));
		System.out.println("Count of alphabets in given String: "+Testify.countingAlphabets(str));
		System.out.println("NonRepeated Letters: "+Testify.getNonRepeatedLetters(str));
		System.out.println("rotateElemets: "+ Arrays.toString(Testify.rotateElemets(numbers,3)) );
		System.out.println("Duplicate chars :"+Testify.countDuplicateChars(str));
		System.out.println("First NonRepeat Elements: "+Testify.firstNonRepeatElements(str));
		ArrayList<String> st= new ArrayList<>();
		System.out.println("State neame is :"+Testify.getStatename(mp, "Pune"));
		System.out.println("getItReverse  :"+getReverseString("abca"));
		System.out.println("getItReverse of "+str+" is : "+getItReverse(str));
		System.out.println("Sum of elemeenst in array :"+IntStream.of(numbers).sum());
		System.out.println("averageSalaryofDepartment: "+ averageSalaryofDepartment(emplist, "Mech"));
		System.out.println("getAverageSalaryOfDepartment :"+getAverageSalaryOfDepartment(emplist));
		System.out.println("groupbyDept :"+groupbyDept(emplist));
		System.out.println("employeeListByDept :"+employeeListByDept(emplist));
	    System.out.println("getNamesBeforeYear :"+getNamesBeforeYear(emplist, 2017));
		System.out.println("avgAgeOfGengers :"+avgAgeOfGengers(emplist));
		System.out.println("findSecondLargest :"+findSecondLargest(numbers));
		System.out.println("getsumOfSalary :"+getsumOfSalary(emplist));
		System.out.println("getPrimeNumber :"+ Arrays.toString(getPrimeNumber(numbers)));
		System.out.println("sumofElemensfrom2dArray : "+ sumofElemensfrom2dArray(numbers));
		 
	}	
	
	
	//finding prime number from a array of integers
	static int[] getPrimeNumber(int[] intarray){
		return Arrays.stream(intarray).filter( Testify::isPrime).toArray();
	}
	
	static boolean isPrime(int a ){
		if(a<=1){
			return false;
		}else
		{
		return IntStream.rangeClosed(2, (int) Math.sqrt(a)).noneMatch(i->a%i==0);
		}
	}
	//get sum of salary from a list of employees
	static double getsumOfSalary(List<Employee> emplist) {
		double sumofSalary = emplist.stream().mapToDouble(Employee::getSalary)
		.reduce(0,Double::sum);
		return sumofSalary;
	}
	
	
	// What is the average age of male and female employees?
	static Map<String, Double> avgAgeOfGengers(List emplList){
       return 		emplist.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
		
	}

	
	// Get the names of all employees who have joined after 2015?
	static List<Employee> getNamesBeforeYear(List emplist,int year) {
		return (List<Employee>) emplist.stream().filter(a->((Employee) a).getYearOfJoining()<year).collect(Collectors.toList());	
	}
			
	static Map employeeListByDept(List< Employee> emplList) {
		Set<Entry<String, List<Employee>>> set= emplList.stream().collect(Collectors.groupingBy(Employee::getDeptId)).entrySet();
		for(Entry<String, List<Employee>> entry:set) {
			System.out.println("Employee in "+entry.getKey());
			List<Employee>emp= entry.getValue();
			emp.forEach(a->System.out.println(a.getEmpname()));
		}
		return null;
		
	}
	static Map groupbyDept(List<Employee> emplist) {
		return emplist.stream().collect(Collectors.groupingBy(Employee::getDeptId));
		
	}
	static Double averageSalaryofDepartment(List<Employee> emplist, String dept) {
		//df.format(12.78988);
		return  emplist.stream().filter(a->(((Employee) a).getDeptId()).equals(dept))				
				.collect(Collectors.averagingInt(p->p.getSalary()));	
	}
	static Map<String, Double> getAverageSalaryOfDepartment(List<Employee> emplist) {
		return emplist.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.averagingDouble(Employee::getSalary)));
		
	}
	
	static int[] sortAndMerge2dimArray(int [][] intputarray) {
		int[] flattened= Arrays.stream(intputarray).flatMapToInt(Arrays::stream).sorted().toArray();
		return flattened;	
	}
	
	//count number of employees on each dept
	static Map<String, Long> countEmployeesinDept(List<Employee> emplist) {
		return emplist.stream().map(a->a.getDeptId()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
			
	}
	
	
	
	
	//To Print employee details base on dept
	static List<Employee>  getEmplyeeDetailsbyDeptID(List<Employee> empList, String deptID) {
		
		return empList.stream().filter(p->p.getEmpId().equals(deptID)).collect(Collectors.toList());
	
		
	}
	

	
	//Sum of elements from 2d array
	
	static double sumofElemensfrom2dArray(int[] intarray) {
		return IntStream.of(intarray).asDoubleStream().sum();
	}
	
	// input stream 
	static String getItReverse(String input) {
		return IntStream.range(0,input.length()).map(p->input.charAt(input.length()-p-1)).mapToObj(Character::toString).collect(Collectors.joining());
		
		
	}
	
	//Reverse of STring
	static boolean getReverseString(String str) {
		String str2= new StringBuilder(str).reverse().toString();
		System.out.println("input is :"+str+"  and output is  "+str2);
		
		return Optional.of(str.equals(str2)).orElse(false);
	}
	
	//problem 01: Finding Second Highest number in given array using stream/java 8
	public static Integer SecondHighestNumber(int[] arr) {
		
		Integer secondHighest = 0;
		secondHighest= Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		return secondHighest;
		
	}
	
	public static Integer findSecondLargest(int[] arr) {
	return	Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();	
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
	public static  int [] rotateElemets(int[] arr,int times) {
		//	static int[] numbers= {4,56,76,32,41,70,90,001};

		if(times>0) {
			times=times-1;
			int startIndex=arr[0];
			int lastIndex =arr.length-1;
			for(int i=0;i<lastIndex;i++) {
				arr[i]=arr[i+1];
			}
			arr[lastIndex]=startIndex;
			rotateElemets(arr, times);
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
	//find only pune city
	
	/*
	 * public static String findPuneCity() { List<City> citie=
	 * students.stream().forEach(a->if(a.equ)); .filter(ap->ap.
	 * getCity().equals("pune"))
	 * .map(Student::getCity).collect(Collectors.toList()); return citie;
	 * 
	 * }
	 */
	
	//recursive functions
	
	
	//Builder Design Pattern
	
	//Sum in Array of arrays
	
	static int sumArrayOfArrays(int [][] arr) {
		
		//int [][] arr={{1,2,3},{3,4,5},{6,8}};
		
		return Arrays.stream(arr).flatMapToInt(Arrays::stream).sum();
		
		
	}
	
	//get state from city name
	
	static String getStatename(HashMap<String, List<String>> mp, String city) {
		String state = null;
		 mp.entrySet().iterator().next().equals(city);
		 Iterator<Entry<String, List<String>>> itr= mp.entrySet().iterator();
		 while(itr.hasNext()) {
			 Entry<String, List<String>> getval = itr.next();
			 if(getval.getValue().contains(city)) {
				 state= getval.getKey();
				 break;
				 
			 }
		 }
		
		return state;
	}
	
	//getStatename using stream
	static String getStatenameUsingStream(HashMap<String, List<String>> mp, String city) {
		
		return mp.entrySet().stream().filter(p->p.getValue().contains(city)).map(Map.Entry::getKey).findFirst().orElse("");	
	}
}
