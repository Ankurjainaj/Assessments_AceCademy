//Java-Method-Overriding-2-Super-Keyword
//Question link: https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword/problem

import java.util.*;
import java.io.*;

class BiCycle{
	String define_me(){
		return "a vehicle with pedals.";
	}
}

class MotorCycle extends BiCycle{
	String define_me(){
		return "a cycle with an engine.";
	}
	
	MotorCycle(){
		System.out.println("Hello I am a motorcycle, I am "+ define_me());
        
		String temp=super.define_me(); 
        
		System.out.println("My ancestor is a cycle who is "+ temp );
	}
	
}
class Q6{
	public static void main(String []args){
		MotorCycle M=new MotorCycle();
	}
}