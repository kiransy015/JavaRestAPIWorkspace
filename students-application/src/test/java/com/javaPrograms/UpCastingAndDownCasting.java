package com.javaPrograms;

import java.util.HashSet;


/*Overrided? or is it Normal Inheritence?
Is it Type Casted or not type casted - to know the listed of method an object can access*/


class A{
	public void disp1(){
		System.out.println("Displaying method A");
	}	
}


class B extends A{
	public void disp2(){
		System.out.println("Displaying method B");
	}
}

class C extends B{
	public void disp3(){
		System.out.println("Displaying method C");
	}
}


public class UpCastingAndDownCasting {
	
	public static void main(String[] args){

		A a1 = new C();
		a1.disp1();	
		C c1 = (C)a1;
		c1.disp1();
		c1.disp2();
		c1.disp3();

		
		
		/*A a1 = new B();
		a1.disp1();
		a1 = new C();
		a1.disp1();*/
		
	}
		
}




/*interface A{
	public void disp1();	
}


class B implements A{
	public void disp1(){
		System.out.println("Displaying method B");
	}
	
	public void disp2(){
		System.out.println("Displaying Disp2 in method B");
	}
}

class C implements A{
	public void disp1(){
		System.out.println("Displaying method C");
	}
	
	public void disp2(){
		System.out.println("Displaying Disp2 in method C");
	}
}


public class UpCastingAndDownCasting {
	
	public static void main(String[] args){
		
		A a1 = new C();		
		a1.disp1();
		C c1 = (C)a1;
		c1.disp1();
		c1.disp2();

		
		A a1 = new B();
		a1.disp1();
		a1 = new C();
		a1.disp1();
	}
		
}*/



