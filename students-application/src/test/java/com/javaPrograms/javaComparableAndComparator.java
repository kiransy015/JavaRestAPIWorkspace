package com.javaPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.laptop.laptopdetail;

public class javaComparableAndComparator {

	public static void main(String[] args) {
		
		ArrayList<laptopdetail> lst = new ArrayList();
		lst.add(new laptopdetail("Dell", 16, 800));
		lst.add(new laptopdetail("Apple", 8, 1200));
		lst.add(new laptopdetail("Acer", 12, 700));
		
		System.out.println("Before Sorting :"+lst);
		
		//In Comparable we need to implement Comparable interface and need to override compareTo method
		//Need to have Constructor , getter and setters and override toString method
		Collections.sort(lst);
		System.out.println("After Sorting using Comparable :"+lst);

		
		//Comparator we can use if the class has not implemented any Comparable interface / Comparator we can also use when class has implemented Comparable interface but you want to sort values on different attribute
		//Instantiate the Comparator Interface using ananymous class as shown below , implement the compare method
		//Call Collections.sort method with Comparator object
		Comparator<laptopdetail> cp = new Comparator<laptopdetail>(){

			public int compare(laptopdetail o1, laptopdetail o2) {
				if(o1.getPrice()>o2.getPrice()){
					return 1;
				}else if(o1.getPrice()<o2.getPrice()){
					return -1;
				}
				return 0;
			}
			
		};
		
		Collections.sort(lst,cp);
		System.out.println("Before Sorting using Comparator :"+lst);
		
		
	}

}
